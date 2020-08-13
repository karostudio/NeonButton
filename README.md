# Karo Studio Creative Agency

Karo Studio is a digital agency with solid design and development expertise.We build mobile and web applications. Visit us at [karo.studio](https://karo.studio) or  [drop us a line](mailto:dev@karo.studio)

[![Instagram](https://img.shields.io/badge/Instagram-@KaroStudio-red.svg?style=flat)](https://www.instagram.com/karo.studio/)



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
    app:nb_neon_width="2dp"
    app:nb_neon_radius="20dp"
    app:nb_neon_color="#DDCA25"/>
```

## Requirements

- SDK +17
- Android Studio
- Gradle

## Installation

NeonButton is available through jcenter and bintray. To install
it, simply add the following line to your app level `build.gradle`:

```groovy
api 'studio.karo.neonbutton:neonbutton:1.0.2'
```

if that alone didn't work, add this line to project level `build.gradle`

```groovy
repositories {
    maven {
         url  "https://dl.bintray.com/mamady83/NeonButton"
    }
}
```


## Author

[Mohamad Yeganeh](https://github.com/mohamadyeganeh76)

## License

NeonButton is available under the MIT license. See the LICENSE file for more info.
