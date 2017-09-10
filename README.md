# MaterialColorUtils (for Kotlin Android)


[![](https://jitpack.io/v/moe.feng/MaterialColorUtils.svg)](https://jitpack.io/#moe.feng/MaterialColorUtils)

> Notice: This library is only for Kotlin development. It may be incompatible in Java.

## What's it?

- Get Material colors easily programmatically.
- Use Material colors in your XML

## How to use

### Import from Gradle/Maven

First, add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Add the dependency to your app modules:

```gradle
dependencies {
    compile 'moe.feng:MaterialColorUtils:0.1.0'
}
```

### Initialize in Application

MaterialColorUtils use application context to get color. Please add `MaterialColors.init(this)` in your `Application`'s `onCreate()`.

### Get color value

For example, you can get Material Blue 500's value like this:

```kotlin
val color = MaterialColors[ColorName.Blue][ColorLevel.`500`]
```

or

```kotlin
val color = MaterialColors.getColorInt(ColorName.Blue, ColorLevel.`500`)
```

#### In XML:

Just use `@color/material_blue_500`. There is no need to explain.

### Get color resource id

```kotlin
val colorResId = MaterialColors.getColorId(ColorName.Blue, ColorLevel.`500`)
```

### Get `ColorName` by resource id

```kotlin
val colorName: ColorName = MaterialColors.parseIdToColor(resourceId)
```

## License

MIT

```
MIT License

Copyright (c) 2017 Fung Go (fython)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```