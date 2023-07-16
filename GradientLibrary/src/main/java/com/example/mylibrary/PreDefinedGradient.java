package com.example.mylibrary;

public class PreDefinedGradient {
    public enum GradientType {
        LINEAR,
        RADIAL,
        SWEEP
    }
    private String name;
    private int[] colorResources;
    private float[] positions;
    private GradientType gradientType;

    public PreDefinedGradient(String name, int[] colorResources, float[] positions,GradientType gradientType) {
        this.name = name;
        this.colorResources = colorResources;
        this.positions = positions;
        this.gradientType = gradientType;
    }

    @Override
    public String toString() {
        return name;
    }

    public int[] getColors() {
        return colorResources;
    }

    public float[] getPositions() {
        return positions;
    }

    public GradientType getGradientType() {
        return gradientType;
    }
}
