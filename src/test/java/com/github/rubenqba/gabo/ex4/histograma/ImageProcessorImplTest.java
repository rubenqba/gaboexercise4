package com.github.rubenqba.gabo.ex4.histograma;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class ImageProcessorImplTest {

    @Test
    public void histogram() {
        System.out.println();

        ImageProcessor procesor = new ImageProcessorImpl(Paths.get(System.getProperty("user.dir"), "src/test/resources/histogram.txt").toString());

        Map<Color, Integer> histogram = procesor.getImageHistogram();

        histogram.forEach((color, counter) -> System.out.println(String.format("%s: %d", color, counter)));
    }
}