package com.github.rubenqba.gabo.ex4;

import com.github.rubenqba.gabo.ex4.histograma.Color;
import com.github.rubenqba.gabo.ex4.histograma.ImageProcessor;
import com.github.rubenqba.gabo.ex4.histograma.ImageProcessorImpl;

import java.util.Map;

public class MainApplication {

    public static void main(String ... args) {
        String filename = "/donde/sea/que/este/el/archivo";

        ImageProcessor procesor = new ImageProcessorImpl(filename);

        Map<Color, Integer> histogram = procesor.getImageHistogram();

        histogram.forEach((color, counter) -> System.out.println(String.format("%s: %d", color, counter)));
    }

}
