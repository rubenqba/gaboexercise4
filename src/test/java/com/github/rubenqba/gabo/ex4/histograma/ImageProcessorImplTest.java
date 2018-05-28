package com.github.rubenqba.gabo.ex4.histograma;

import org.junit.Test;

import java.util.Map;

public class ImageProcessorImplTest {

    @Test
    public void histogram() {
        ImageProcessor procesor = new ImageProcessorImpl("/tmp/histogram.txt");

        Map<Color, Integer> histogram = procesor.getImageHistogram();

        histogram.forEach((color, counter) -> System.out.println(String.format("%s: %d", color, counter)));
    }
}