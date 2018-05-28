package com.github.rubenqba.gabo.ex4.histograma;

import com.github.rubenqba.gabo.ex4.PixelProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.github.rubenqba.gabo.ex4.histograma.ColorCode.RGB;
import static com.github.rubenqba.gabo.ex4.histograma.ColorScale.FLOAT;
import static com.github.rubenqba.gabo.ex4.histograma.ColorScale.INTEGER;

public class ImageProcessorImpl implements ImageProcessor {

    private List<List<Color>> matrix;

    public ImageProcessorImpl(String filename) {
        readImage(filename);
    }

    /**
     * Esto lo que hace es calcular el histograma, la cantidad de veces que aparece un color en los datos
     * @return
     */
    @Override
    public Map<Color, Integer> getImageHistogram() {
        return matrix.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Function.identity(), color -> 1, (u1, u2) -> u1 + u2));
    }

    public void readImage(String filename) {

        /*
        First line: color code (RGB|CMYK)
        Second line: Value scale (either 01, or 0256).
        Third line: Width (in number of pixels)
        Fourth line: Height (in number of pixels)
        Rest of the lines: Each line will contain the information of all pixels in one image row. Each
        pixel will be separated by a semicolon (;). Inside each pixel, each individual color value will
        be separated by a comma (,).
        */

        // primero leo las configuraciones en las primeras lineas
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {

            //br returns as stream and convert it into a List
            ColorCode code = ColorCode.valueOf(br.readLine());
            ColorScale scale = br.readLine().contentEquals("01") ? FLOAT : INTEGER;
             Integer width = Integer.parseInt(br.readLine());
            Integer height = Integer.parseInt(br.readLine());

            PixelProcessor dataProcessor = buildProcessor(code, scale, width, height);

            matrix = dataProcessor.readLines(br.lines());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo con taron de diseño factory, dependiendo del tipo de color crea un procesador especifico
     * @param code
     * @param scale
     * @param width
     * @param height
     * @return
     */
    public static PixelProcessor buildProcessor(ColorCode code, ColorScale scale, Integer width, Integer height) {
        return RGB == code ? new RGBPixelProcessor(scale, width, height) : new CMYKPixelProcessor(scale, width, height);
    }

}
