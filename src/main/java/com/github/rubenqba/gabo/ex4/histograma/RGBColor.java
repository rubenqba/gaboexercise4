package com.github.rubenqba.gabo.ex4.histograma;

import java.util.Objects;

public class RGBColor<T> implements Color {
    private T red;
    private T green;
    private T blue;

    public RGBColor(T red, T green, T blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public T getRed() {
        return red;
    }

    public void setRed(T red) {
        this.red = red;
    }

    public T getGreen() {
        return green;
    }

    public void setGreen(T green) {
        this.green = green;
    }

    public T getBlue() {
        return blue;
    }

    public void setBlue(T blue) {
        this.blue = blue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(RGBColor.class.isAssignableFrom(o.getClass()))) return false;
        RGBColor rbgColor = (RGBColor) o;
        return Objects.equals(getRed(), rbgColor.getRed()) &&
                Objects.equals(getBlue(), rbgColor.getBlue()) &&
                Objects.equals(getGreen(), rbgColor.getGreen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRed(), getBlue(), getGreen());
    }

    @Override
    public String toString() {
        return "RGBColor{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
