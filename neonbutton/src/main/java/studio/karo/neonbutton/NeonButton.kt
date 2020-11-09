package studio.karo.neonbutton

import android.content.Context
import android.content.res.Resources
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import kotlin.math.roundToInt


class NeonButton : androidx.appcompat.widget.AppCompatButton {

    private var isPressing = false

    private var minimumPadding = 0f

    private var textX = 0
    private var textY = 0

    private var borderPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var fillPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var shadowPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var textPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var borderRect: RectF = RectF()
    private var shadowRect: RectF = RectF()
    private var textRect: Rect = Rect()
    private var borderWidth: Float = 0f
    private var cornerRadius: Float = 0f
    private var isFilled: Boolean = false

    override fun setTextColor(color: Int) {
        super.setTextColor(color)
        textPaint.color = textColors.getColorForState(IntArray(android.R.attr.state_enabled), textColors.defaultColor)
        if (!isFilled)
        textPaint.setShadowLayer(20f, 0f, 0f, textColors.getColorForState(IntArray(android.R.attr.state_enabled), textColors.defaultColor))
        invalidate()
    }
    fun setNeonColor(color: Int) {
        borderPaint.color = color
        shadowPaint.color = color
        fillPaint.color = color
        if (isFilled){
            fillPaint.alpha = 250
        }else{
            fillPaint.alpha = 20
        }
        invalidate()
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        val metrics: DisplayMetrics = Resources.getSystem().displayMetrics
        minimumPadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6f, metrics)

        setupPaint(attrs)
    }

    private fun setupPaint(attrs: AttributeSet?) {
        val a: TypedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.NButton,
            0, 0
        )



        try {
            val wColor = a.getColor(R.styleable.NButton_nb_neon_color, Color.BLACK)
            cornerRadius = a.getDimension(R.styleable.NButton_nb_neon_radius, 0f)
            borderWidth = a.getDimension(R.styleable.NButton_nb_neon_width, 0f)
            isFilled = a.getBoolean(R.styleable.NButton_nb_neon_filled, false)


            borderPaint.style = Paint.Style.STROKE

            borderPaint.color = wColor
            borderPaint.strokeCap = Paint.Cap.ROUND
            borderPaint.strokeWidth = borderWidth
            borderPaint.strokeJoin = Paint.Join.ROUND


            fillPaint.style = Paint.Style.FILL
            fillPaint.color = wColor

            if (isFilled) {
                fillPaint.alpha = 250
            }else{
                fillPaint.alpha = 20
            }
            shadowPaint.style = Paint.Style.STROKE
            shadowPaint.color = wColor
            shadowPaint.strokeCap = Paint.Cap.ROUND
            shadowPaint.strokeWidth = borderWidth
            shadowPaint.strokeJoin = Paint.Join.ROUND
            shadowPaint.maskFilter = BlurMaskFilter(26f, BlurMaskFilter.Blur.NORMAL)


            textPaint.style = Paint.Style.FILL
            textPaint.color = textColors.getColorForState(IntArray(android.R.attr.state_enabled), textColors.defaultColor)
            textPaint.textSize = textSize
            textPaint.textAlign = Paint.Align.CENTER
            textPaint.typeface = typeface
            if (!isFilled)
            textPaint.setShadowLayer(20f, 0f, 0f, textColors.getColorForState(IntArray(android.R.attr.state_enabled), textColors.defaultColor))
            textPaint.getTextBounds(text.toString(), 0, text.length, textRect)



        } finally {
            a.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // Try for a width based on our minimum
        val minw = paddingLeft + paddingRight + suggestedMinimumWidth
        val w = View.resolveSizeAndState(minw, widthMeasureSpec, 1)


        val minh = paddingTop + paddingBottom + suggestedMinimumHeight

        val h = View.resolveSizeAndState(
            minh,
            heightMeasureSpec,
            0
        )


        borderRect.left = paddingLeft.toFloat() + minimumPadding
        borderRect.top = paddingTop.toFloat() + (minimumPadding / 2)
        borderRect.right = (w - (paddingRight + minimumPadding)).toFloat()
        borderRect.bottom = (h - (paddingBottom + (minimumPadding * 1.5))).toFloat()

        shadowRect.left = paddingLeft.toFloat() + minimumPadding
        shadowRect.top = paddingTop.toFloat() + (minimumPadding / 2) + 10
        shadowRect.right = (w - (paddingRight + minimumPadding)).toFloat()
        shadowRect.bottom = (h - (paddingBottom + (minimumPadding * 1.5))).toFloat() + 10


        textX = w / 2
        textY =
            (h / 2 - (textPaint.descent() + textPaint.ascent()) / 2).toInt()

        setMeasuredDimension(w, h)
    }


    override fun performClick(): Boolean {
        return super.performClick()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        isPressing = when (event?.action) {
            MotionEvent.ACTION_DOWN,
            MotionEvent.ACTION_POINTER_DOWN,
            MotionEvent.ACTION_HOVER_ENTER,
            MotionEvent.ACTION_HOVER_MOVE,
            MotionEvent.ACTION_MOVE,
            MotionEvent.ACTION_BUTTON_PRESS -> true
            else -> false
        }
        if (event?.action == MotionEvent.ACTION_UP) {
            if (borderRect.contains(
                    event.x,
                    event.y
                )
            ) {
                performClick()
            }
        }
        invalidate()
        requestLayout()
        if (isPressing) {
            return true
        }
        return super.onTouchEvent(event)

    }


    override fun onDraw(canvas: Canvas?) {

        if (!isPressing) {
            canvas?.drawRoundRect(shadowRect, cornerRadius, cornerRadius, shadowPaint)
            borderPaint.alpha = 250
        } else {
            borderPaint.alpha = 180
        }

        canvas?.drawRoundRect(borderRect, cornerRadius, cornerRadius, borderPaint)


        canvas?.drawRoundRect(borderRect, cornerRadius, cornerRadius, fillPaint)


        canvas?.drawText(text.toString(), textX.toFloat(), textY.toFloat(), textPaint)

    }

}