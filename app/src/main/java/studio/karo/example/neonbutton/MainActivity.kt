package studio.karo.example.neonbutton

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import studio.karo.neonbutton.NeonButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val neonButton = findViewById<NeonButton>(R.id.neonButton);
        neonButton.setNeonColor(Color.WHITE)

    }
}