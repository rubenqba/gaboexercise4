package com.github.rubenqba.gabo.ex4.histograma;

import java.util.Objects;

public class CMYKColor<T> implements Color {

    private T cyan;
    private T magenta;
    private T yellow;
    private T black;

    public CMYKColor(T cyan, T magenta, T yellow, T black) {
        this.cyan = cyan;
        this.magenta = magenta;
        this.yellow = yellow;
        this.black = black;
    }

    public T getCyan() {
        return cyan;
    }

    public void setCyan(T cyan) {
        this.cyan = cyan;
    }

    public T getMagenta() {
        return magenta;
    }

    public void setMagenta(T magenta) {
        this.magenta = magenta;
    }

    public T getYellow() {
        return yellow;
    }

    public void setYellow(T yellow) {
        this.yellow = yellow;
    }

    public T getBlack() {
        return black;
    }

    public void setBlack(T black) {
        this.black = black;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(CMYKColor.class.isAssignableFrom(o.getClass()))) return false;
        CMYKColor cmykColor = (CMYKColor) o;
        return Objects.equals(getCyan(), cmykColor.getCyan()) &&
                Objects.equals(getMagenta(), cmykColor.getMagenta()) &&
                Objects.equals(getYellow(), cmykColor.getYellow()) &&
                Objects.equals(getBlack(), cmykColor.getBlack());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCyan(), getMagenta(), getYellow(), getBlack());
    }

    @Override
    public String toString() {
        return "CMYKColor{" +
                "cyan=" + cyan +
                ", magenta=" + magenta +
                ", yellow=" + yellow +
                ", black=" + black +
                '}';
    }
}
