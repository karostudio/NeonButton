# Karo Studio Creative Agency

Karo Studio is a digital agency with solid design and development expertise.We build mobile and web applications. Visit us at [karo.studio](https://karo.studio) or  [drop us a line](mailto:dev@karo.studio)

[![Instagram](https://img.shields.io/badge/Instagram-@KaroStudio-red.svg?style=flat)](https://www.instagram.com/karo.studio/)
[![License](https://img.shields.io/badge/license-MIT-lightgrey.svg)](https://github.com/karostudio/neonbutton/blob/master/LICENSE)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.3.72-f9890b)](https://kotlinlang.org/)
[![Bintray](https://img.shields.io/bintray/v/mamady83/NeonButton/studio.karo.neonbutton)](https://dl.bintray.com/mamady83/NeonButton/)

## NEON BUTTON

<img src="https://raw.githubusercontent.com/karostudio/NeonButton/master/screenshots/button.gif" width="531" height="300">


## Example

```xml
<studio.karo.neonbutton.NeonButton
    android:id="@+id/neonButton"
    android:layout_width="match_parent"
    android:layout_height="70dp"
    android:text="Click Me"
    android:textSize="20sp"
    android:layout_marginLeft="50dp"
    android:layout_marginRight="50dp"
    android:textColor="#DDCA25"
    app:nb_neon_width="2dp"
    app:nb_neon_radius="20dp"
    app:nb_neon_color="#DDCA25"
    app:nb_neon_filled="false"
    app:nb_neon_icon="@drawable/ic_banana"
    app:nb_neon_icon_padding="15dp"/>
```
### -----------------------------------
```kotlin
    val nb = findViewById<NeonButton>(R.id.neonButton)
    nb.setNb_neon_icon(ContextCompat.getDrawable(this,R.drawable.ic_banana))
    nb.setNb_neon_icon_padding(15f)
    nb.setNb_neon_filled(false)
    nb.setNb_neon_color(Color.parseColor("#DDCA25"))
    nb.setNb_neon_radius(20f)
    nb.setNb_neon_width(4f)

```

## Requirements

- SDK +17
- Android Studio
- Gradle

## Installation

NeonButton is available through jcenter and bintray. To install
it, simply add the following line to your app level `build.gradle`:

```groovy
api 'com.github.karostudio:NeonButton:1.1.5'
```

if that alone didn't work, add this line to project level `build.gradle`

```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```


## Author

[Mohamad Yeganeh](https://github.com/mohamadyeganeh76)

## License

NeonButton is available under the MIT license. See the LICENSE file for more info.
