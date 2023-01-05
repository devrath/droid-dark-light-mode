# android-congenial-fortnight-darktheme
![Banner](https://github.com/devrath/android-congenial-fortnight-darktheme/blob/main/assets/banner.png)


<p align="center">
<a><img src="https://img.shields.io/badge/Built%20Using-Kotlin-silver?style=for-the-badge&logo=kotlin"></a>
<a><img src="https://img.shields.io/badge/Built%20By-Android%20Studio-red?style=for-the-badge&logo=android%20studio"></a>  
<a><img src="https://img.shields.io/badge/Feature-Dark%20Mode-black?style=for-the-badge&logo=android"></a>  
</p>

<p align="center"><a><img align="left" src="https://github.com/devrath/devrath/blob/master/images/description.png" width="60" height="60" alt="Description" title="Description"></a></p> 
Supporting dark theme in android . Check wiki tab above to access the documentation 

---

## **`𝙾𝚞𝚝𝚙𝚞𝚝`** 🧿
<p align="center">
<img src="https://github.com/devrath/android-congenial-fortnight-darktheme/blob/main/assets/video.gif" width="220" height="460"/>
</p>

## **`𝙸𝚗𝚝𝚛𝚘𝚍𝚞𝚌𝚝𝚒𝚘𝚗 𝚝𝚘 𝙳𝚊𝚛𝚔 𝚃𝚑𝚎𝚖𝚎`** 🗂️
DarkMode/DarkTheme is a feature in android if supported by the application, we can switch the visual display to dark colors.

## **`𝚂𝚘𝚖𝚎 𝚊𝚍𝚟𝚊𝚗𝚝𝚊𝚐𝚎𝚜 𝚘𝚏 𝚑𝚊𝚟𝚒𝚗𝚐 𝚊 𝚍𝚊𝚛𝚔 𝚝𝚑𝚎𝚖𝚎 𝚒𝚗 𝚊𝚗𝚍𝚛𝚘𝚒𝚍`** 🗂️
* Reduction in battery usage in OLED and AMOLED display panels. In OLED displays every pixel is individually lit. So when the display is light, most of the display pixels are turned on, which in turn consumes a lot of battery power. On the contrary, when the dark mode is turned on and dark pixels are turned on, the battery usage goes down.
* Reduces the emission of the harmful Blue light, which in turn reduces the strain on the eyes.

## **`𝚃𝚢𝚙𝚎𝚜 𝚘𝚏 𝙳𝚊𝚛𝚔 𝙼𝚘𝚍𝚎`** 🗂️
* `Using day-night Theme`
   * It gives more control and helps to support dark mode in pre android 10 devices. 
   * But its bit time consuming to set up
* `Force Dark`
   * It is a quick way to support dark theme on android-10 devices.
   * Google describes force dark being a quick way to transition into a dark theme in existing apps.
   * When you apply force dark, android tries its best to attempt to apply a dark theme to your android app running in android-10.
   * Since force dark is automatic without the input from you as a developer, it is not always perfect.
   * So there is an option to turn off force dark for particular views in your application.

-----

## **`𝙷𝚘𝚠 𝚝𝚘 𝚞𝚜𝚎 𝙵𝚘𝚛𝚌𝚎 𝙳𝚊𝚛𝚔 𝚖𝚘𝚍𝚎 𝚘𝚗 𝚊𝚗𝚍𝚛𝚘𝚒𝚍`** 🗂️
* Make sure you are in `android-10` or `above`
* Use the line below in the the application theme
```xml
<item name="android:forceDarkAllowed">true</item>
```
This is represented as 
```xml
<!-- Base application theme. -->
 <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
 <!-- Customize your theme here. -->
 <item name="colorPrimary">@color/colorPrimary</item>
 <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
 <item name="colorAccent">@color/colorAccent</item>
 <item name="android:forceDarkAllowed">true</item>
</style>
```
* Now once you select the option `Dark Mode` in the taskbar, The dark theme is applied
* If you want to exclude a `view` from the `Dark Mode` add the line below 
```xml
android:forceDarkAllowed="false"
```
This is represented as 
```xml
<Button
android:id="@+id/pressMeButton"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="@string/press_me"
android:forceDarkAllowed="false"/>
```

-----

## **`𝙷𝚘𝚠 𝚝𝚘 𝚞𝚜𝚎 𝚝𝚑𝚎 𝚍𝚊𝚢 𝙽𝚒𝚐𝚑𝚝 𝚃𝚑𝚎𝚖𝚎 𝚘𝚗 𝚊𝚗𝚍𝚛𝚘𝚒𝚍`** 🗂️

### Steps in setting up the day-night theme
If we want to support `dark theme` on `android-10 & above`, `pre android` devices we need to use via `day-night theme`

### We have two options 
* [*`DayNight Theme`*](https://github.com/devrath/android-congenial-fortnight-darktheme/wiki/How-to-use--day-night-Theme-%3F#daynight-theme)
* [*`MaterialComponents DayNight Theme`*](https://github.com/devrath/android-congenial-fortnight-darktheme/wiki/How-to-use--day-night-Theme-%3F#materialcomponents-daynight-theme)

#### **`DayNight Theme`** 
* The `androidX` `AppCompact` library has a `DayNight theme` called `Theme.AppCompat.DayNight`
* In the `res/values/styles.xml`
```xml
<style name="Theme.AppCompat.DayNight" parent="Theme.AppCompat.Light">
```
* In the `res/values-night/styles.xml`
```xml
<style name="Theme.AppCompat.DayNight" parent="Theme.AppCompat">
```
* Styles implemented as 
```xml
<!-- Base application theme. -->
<style name="AppTheme" parent="Theme.AppCompact.DayNight">
  <!-- Customize your theme here. -->
  <item name="colorPrimary">@color/colorPrimary</item>
  <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
  <item name="colorAccent">@color/colorAccent</item>
  <item name="android:forceDarkAllowed">true</item>
</style>
```
#### **`MaterialComponents DayNight Theme`**
* The Material component library also has theme support supporting both day and night types.
* Advantage of using the `MaterialComponents` is the appearance that looks more stylish and modern which users might expect from a modern android application. 
* For this we need to use 
```gradle
implementation 'com.google.android.material:material:1.4.0-beta01'
```
* Styles added as 
```xml
<!-- Base application theme. -->
<style name="AppTheme" parent="Theme.MaterialComponents.DayNight">
  <!-- Customize your theme here. -->
  <item name="colorPrimary">@color/colorPrimary</item>
  <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
  <item name="colorAccent">@color/colorAccent</item>
  <item name="android:forceDarkAllowed">true</item>
</style>
```

-----

## **`𝙲𝚘𝚗𝚝𝚛𝚘𝚕𝚕𝚒𝚗𝚐 𝚠𝚑𝚊𝚝 𝚞𝚜𝚎𝚛𝚜 𝚟𝚒𝚎𝚠 𝚠𝚑𝚎𝚗 𝚞𝚜𝚎𝚛𝚜 𝚜𝚠𝚒𝚝𝚌𝚑 𝚖𝚘𝚍𝚎𝚜`** 🗂️
`Controlling the resources displayed on the screen using the styles using the modes`
* We can achieve this using the styles having two values folder for `normal mode` and `dark mode`
  * *`res/values/styles.xml`*
  * *`res/values-night/styles.xml`*
* To create `values-night` folder 
  * Right-click on the values folder
  * Select `new` from the options.
  * In the available qualifiers select `Night-Mode` and push to right using the middle selection arrows.
  * Then Select `Not Night` mode
  * Give the file name as `styles`
  * Press `ok`
* In the `res/values/styles.xml` add the below entries 
```xml
  <style name="TextStyle" parent="AppTheme">
    <item name="android:text">@string/let_me_out</item>
  </style>

  <style name="ImageStyle" parent="AppTheme">
    <item name="android:src">@drawable/airlock</item>
  </style>
```
* In the `res/values-night/styles.xml` add the below entries 
```xml
  <style name="TextStyle" parent="AppTheme">
    <item name="android:text">@string/let_me_out</item>
  </style>

  <style name="ImageStyle" parent="AppTheme">
    <item name="android:src">@drawable/astronaut</item>
  </style>
```

-----

## **`𝚂𝚠𝚒𝚝𝚌𝚑 𝚖𝚘𝚍𝚎𝚜 𝚙𝚛𝚘𝚐𝚛𝚊𝚖𝚖𝚊𝚝𝚒𝚌𝚊𝚕𝚕𝚢`** 🗂️

### Ways of selecting the View Modes 
There are three modes which we can programmatically select
* *`Dark Mode`*  > Display into dark mode
* *`Light Mode`* - > Display into light mode
* *`System`* -> Default settings from the system

#### Code to change the models programmatically using day-night theme
```kotlin
AppCompatDelegate.setDefaultNightMode(nightMode)
// nightMode = Integer value passed based on selection
```

#### How to persist or save the choice the user has made
* For this, we use shared preferences to save the selection, it will be integer value we are saving 

#### Handling when we close and open the application
Use get the value in `shared preferences` and load it when the application opens

-----

## **`𝚂𝚞𝚙𝚙𝚘𝚛𝚝𝚒𝚗𝚐 𝚝𝚑𝚎 𝚍𝚊𝚛𝚔 𝚝𝚑𝚎𝚖𝚎 𝚝𝚘 𝙿𝚛𝚎 𝙰𝚗𝚍𝚛𝚘𝚒𝚍 𝟷𝟶 𝚍𝚎𝚟𝚒𝚌𝚎𝚜`** 🗂️
* Now we can control the modes in android 10 and above modes easily.
* But in pre android 10 devices there is no system setting since to take default setting.
* So we can check if it is pre android 10 and set it into a battery saver mode.

-----

## **`𝚂𝚞𝚙𝚙𝚘𝚛𝚝`** ☕
If you feel like support me a coffee for my efforts, I would greatly appreciate it.</br>
<a href="https://www.buymeacoffee.com/devrath" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/yellow_img.png" alt="Buy Me A Coffee" style="height: 41px !important;width: 174px !important;box-shadow: 0px 3px 2px 0px rgba(190, 190, 190, 0.5) !important;-webkit-box-shadow: 0px 3px 2px 0px rgba(190, 190, 190, 0.5) !important;" ></a>

## **`𝙲𝚘𝚗𝚝𝚛𝚒𝚋𝚞𝚝𝚎`** 🙋‍♂️
Read [contribution guidelines](CONTRIBUTING.md) for more information regarding contribution.

## **`𝙵𝚎𝚎𝚍𝚋𝚊𝚌𝚔`** ✍️ 
Feature requests are always welcome, [File an issue here](https://github.com/devrath/android-congenial-fortnight-darktheme/issues/new).

## **`𝙵𝚒𝚗𝚍 𝚝𝚑𝚒𝚜 𝚙𝚛𝚘𝚓𝚎𝚌𝚝 𝚞𝚜𝚎𝚏𝚞𝚕`** ? ❤️
Support it by clicking the ⭐ button on the upper right of this page. ✌️

## **`𝙻𝚒𝚌𝚎𝚗𝚜𝚎`** ![Licence](https://img.shields.io/github/license/google/docsy) :credit_card:
This project is licensed under the Apache License 2.0 - see the [LICENSE](https://github.com/devrath/android-congenial-fortnight-darktheme/blob/main/LICENSE) file for details


<p align="center">
<a><img src="https://forthebadge.com/images/badges/built-for-android.svg"></a>
</p>
