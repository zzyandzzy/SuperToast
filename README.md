# SuperToast

[![MIT License][101]][102]
[![JitPack][103]][104]

## SetUp

### Gradle

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Step 2. Add the dependency

```gradle
dependencies {
	compile 'com.android.support:cardview-v7:26.+'
	compile 'com.github.zzyandzzy:SuperToast:0.0.5'
}
```

### Maven

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```

Step 2. Add the dependency

```xml
<dependency>
    <groupId>com.github.zzyandzzy</groupId>
    <artifactId>SuperToast</artifactId>
    <version>0.0.5</version>
</dependency>
```

## Usage

```java
SuperToast.make(yourContext, text).show();
```

**if you hide image ,you should use** `setImage(-1);`

```java
SuperToast superToast = new SuperToast(yourContext);
superToast.setImage(-1);
superToast.setText("Text");
```

**if you know more , in this** [MainActivity]([400])

## Tips

### duration

if duration > `3000` ,SuperToast only one and this activity no cover !

### image

this api can image gone

```java
setImage(-1);
```

### Run

if this library err,you should add the dependency

```gradle
dependencies {
	compile 'com.android.support:cardview-v7:26.+'
}
```

Screenshots
--------

| Screenshot | Screenshot |  Screenshot | Screenshot|
| --- | --- | --- | ---|
| ![Info Toast][401] | ![Waring Toast][402] | ![Error Toast][403] | ![Elevation Toast][404]|

## Licence
```licence
MIT License

Copyright (c) 2017 

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

[101]: https://img.shields.io/github/license/HeinrichReimer/material-intro.svg
[102]: https://mit-license.org/
[103]: https://img.shields.io/jitpack/v/jitpack/maven-simple.svg
[104]: https://jitpack.io/#zzyandzzy/SuperToast/0.0.5
[400]: https://github.com/zzyandzzy/SuperToast/blob/master/app/src/main/java/xyz/zzyandzzy/utility/supertoastdemo/MainActivity.java
[401]: https://github.com/zzyandzzy/SuperToast/blob/master/art/info.png
[402]: https://github.com/zzyandzzy/SuperToast/blob/master/art/waring.png
[403]: https://github.com/zzyandzzy/SuperToast/blob/master/art/error.png
[404]: https://github.com/zzyandzzy/SuperToast/blob/master/art/elevation.png
