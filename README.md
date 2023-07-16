# GradientLibrary
The Gradient Library for Android is a powerful and easy-to-use library that allows developers
to create and apply gradient backgrounds to their Android app views.
It provides a collection of predefined gradient presets and the ability to create custom gradients from scratch.
With this library, you can enhance the visual appeal of your app by adding vibrant and eye-catching gradients to various UI elements.

## Features
- Predefined Gradients
- Custom Gradients
- Set a drawable image resource directly
- Load an image from a remote URL

## Setup
Step 1. Add the JitPack repository to your build file
```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency
```java
dependencies {
	        implementation 'com.github.adipink:GradientLibrary:1.0.0'
	}
```

## Usage
1. Create variables:
   ```java
    private Gradient gradient;
    private List<PreDefinedGradient> presets;

   gradient =(Gradient) findViewById(R.id.main_PRO_gradientImage);
        presets = gradient.getPredefinedGradients();
   ```
   the list is to get the predefined gradients that I created

2. Use the selected gradient on the image
   ```java
   gradient.applyPresetGradient(selectedGradient);
   ```

3. Load Photo from drawable folder
   ```java
   gradient.setDrawableImage(R.drawable.family,R.drawable.image_error,R.drawable.image_placeholder,ImageView.ScaleType.CENTER_CROP);
   ```

4. Load Photo from URL
   ```java
   gradient.setUrlImage("https://www.deutschland.de/sites/default/files/media/image/tdt_15052020_wie_familien_in_deutschland_leben_gemeinsam.jpg",R.drawable.image_error,
                         R.drawable.image_placeholder, ImageView.ScaleType.CENTER_CROP);
   ```
