package com.github.rubenqba.gabo.ex4.histograma;

import com.github.rubenqba.gabo.ex4.PixelProcessor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.rubenqba.gabo.ex4.histograma.ColorScale.FLOAT;

public class RGBPixelProcessor implements PixelProcessor {

    private ColorScale scale;
    private Integer width;
    private Integer height;

    public RGBPixelProcessor(ColorScale scale, Integer width, Integer height) {
        this.scale = scale;
        this.width = width;
        this.height = height;
    }

    @Override
    public List<List<Color>> readLines(Stream<String> lines) {
        return lines.map(this::parseLine)
                .limit(height)
                .collect(Collectors.toList());
    }

    private List<Color> parseLine(String line) {
        return Stream.of(line.split(";"))
                .map(pixel -> {
                    if (FLOAT == scale) {
                        List<Float> components = Stream.of(pixel.split(","))
                                .map(v -> Float.parseFloat(v.trim()))
                                .map(v -> v < 0 ? 0 : v > 255 ? 255 : v)
                                .collect(Collectors.toList());
                        return new RGBColor<>(components.get(0), components.get(1), components.get(2));
                    }

                    List<Integer> components = Stream.of(pixel.split(","))
                            .map(v -> Integer.parseInt(v.trim()))
                            .map(v -> v < 0 ? 0 : v > 1 ? 1 : v)
                            .collect(Collectors.toList());
                    return new RGBColor<>(components.get(0), components.get(1), components.get(2));
                })
                .limit(width)
                .collect(Collectors.toList());
    }
}
