package com.example.mylibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.ArrayList;
import java.util.List;

public class Gradient extends RelativeLayout {
    private Context context;
    private AttributeSet attrs;
    private int style;
    private View view;

    private ImageView profile_IMG_image;
    private View profile_VI_view;

    private Drawable imageFile, imagePlaceholder, imageError, gradient;

    public Gradient(Context context) {
        super(context);
        this.context = context;
        initViews();
    }

    public Gradient(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        initViews();
    }

    public Gradient(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.attrs = attrs;
        this.style = defStyleAttr;
        initViews();
    }

    public void setScaleType(ImageView.ScaleType scaleType){
        profile_IMG_image.setScaleType(scaleType);
    }

    public void setGradient(Drawable gradient){
        profile_VI_view.setBackground(gradient);
    }

    public void setDrawableImage(Drawable imageFile){
        profile_IMG_image.setImageDrawable(imageFile);
    }

    public void setDrawableImage(int mImageFile, int mImageError, int mImagePlaceholder, ImageView.ScaleType scaleType){
        setScaleType(scaleType);
        Glide
                .with(context)
                .load(mImageFile)
                .placeholder(mImagePlaceholder)
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(mImageError)
                .into(profile_IMG_image);
    }

    public void setUrlImage(String url, int mImageError, int mImagePlaceholder, ImageView.ScaleType scaleType){
        setScaleType(scaleType);
        Glide
                .with(context)
                .load(url)
                .placeholder(mImagePlaceholder)
                .transition(DrawableTransitionOptions.withCrossFade())
                .dontAnimate()
                .error(mImageError)
                .into(profile_IMG_image);
    }

    public void setResImage(int resID, ImageView.ScaleType scaleType){
        setScaleType(scaleType);
        profile_IMG_image.setImageResource(resID);
    }

    public List<PreDefinedGradient> getPredefinedGradients() {
        List<PreDefinedGradient> presets = new ArrayList<>();

        // Define your preset gradients here
        int[] colors1 = {R.color.gradient_pink, R.color.gradient_purple};
        float[] positions1 = {0.0f, 0.75f};
        presets.add(new PreDefinedGradient("Pink-Purple-Linear", colors1, positions1, PreDefinedGradient.GradientType.LINEAR));
        presets.add(new PreDefinedGradient("Pink-Purple-Radial", colors1, positions1, PreDefinedGradient.GradientType.RADIAL));
        presets.add(new PreDefinedGradient("Pink-Purple-Sweep", colors1, positions1, PreDefinedGradient.GradientType.SWEEP));

        int[] colors2 = {R.color.gradient_yellow, R.color.gradient_white};
        float[] positions2 = {0.0f, 1.0f};
        presets.add(new PreDefinedGradient("Yellow-White-Linear", colors2, positions2, PreDefinedGradient.GradientType.LINEAR));
        presets.add(new PreDefinedGradient("Yellow-White-Radial", colors2, positions2, PreDefinedGradient.GradientType.RADIAL));
        presets.add(new PreDefinedGradient("Yellow-White-Sweep", colors2, positions2, PreDefinedGradient.GradientType.SWEEP));

        int[] colors3 = {R.color.gradient_dark_blue, R.color.gradient_light_blue};
        float[] positions3 = {0.0f, 0.75f};
        presets.add(new PreDefinedGradient("Dark-Light Blue-Linear", colors3, positions3, PreDefinedGradient.GradientType.LINEAR));
        presets.add(new PreDefinedGradient("Dark-Light Blue-Radial", colors3, positions3, PreDefinedGradient.GradientType.RADIAL));
        presets.add(new PreDefinedGradient("Dark-Light Blue-Sweep", colors3, positions3, PreDefinedGradient.GradientType.SWEEP));

        int[] colors4 = {R.color.gradient_orange, R.color.gradient_dark_pink};
        float[] positions4 = {0.0f, 1.0f};
        presets.add(new PreDefinedGradient("Orange-Pink-Linear", colors4, positions4, PreDefinedGradient.GradientType.LINEAR));
        presets.add(new PreDefinedGradient("Orange-Pink-Radial", colors4, positions4, PreDefinedGradient.GradientType.RADIAL));
        presets.add(new PreDefinedGradient("Orange-Pink-Sweep", colors4, positions4, PreDefinedGradient.GradientType.SWEEP));

        int[] colors5 = {R.color.gradient_green, R.color.gradient_black};
        float[] positions5 = {0.0f, 1.0f};
        presets.add(new PreDefinedGradient("Green-Black-Linear", colors5, positions5, PreDefinedGradient.GradientType.LINEAR));
        presets.add(new PreDefinedGradient("Green-Black-Radial", colors5, positions5, PreDefinedGradient.GradientType.RADIAL));
        presets.add(new PreDefinedGradient("Green-Black-Sweep", colors5, positions5, PreDefinedGradient.GradientType.SWEEP));

        int[] colors6 = {R.color.gradient_red, R.color.gradient_purple};
        float[] positions6 = {0.0f, 1.0f};
        presets.add(new PreDefinedGradient("Red-Purple-Linear", colors6, positions6, PreDefinedGradient.GradientType.LINEAR));
        presets.add(new PreDefinedGradient("Red-Purple-Radial", colors6, positions6, PreDefinedGradient.GradientType.RADIAL));
        presets.add(new PreDefinedGradient("Red-Purple-Sweep", colors6, positions6, PreDefinedGradient.GradientType.SWEEP));



        return presets;
    }

    public void applyPresetGradient(PreDefinedGradient preset) {
        int[] colors = new int[preset.getColors().length];
        for (int i = 0; i < preset.getColors().length; i++) {
            int colorResId = preset.getColors()[i];
            colors[i] = ContextCompat.getColor(context, colorResId);
        }

        profile_VI_view.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors));
        GradientDrawable drawable = (GradientDrawable) profile_VI_view.getBackground();

        switch (preset.getGradientType()) {
            case LINEAR:
                drawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                break;
            case RADIAL:
                drawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
                break;
            case SWEEP:
                drawable.setGradientType(GradientDrawable.SWEEP_GRADIENT);
                break;

        }

    }

    private void initViews(){
        this.view = this;
        inflate(context, R.layout.image_layout, this);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Profile, style,0);

        imageFile = array.getDrawable(R.styleable.Profile_imageSrc);
        imageError = array.getDrawable(R.styleable.Profile_imageError);
        imagePlaceholder = array.getDrawable(R.styleable.Profile_imagePlaceholder);
        gradient = array.getDrawable(R.styleable.Profile_gradient);

        profile_IMG_image = findViewById(R.id.profile_IMG_image);
        profile_VI_view = findViewById(R.id.profile_VI_view);

        if(imageFile != null){
            setDrawableImage(imageFile);
        }

        if(gradient != null){
            setGradient(gradient);
        }

        array.recycle();

    }
}
