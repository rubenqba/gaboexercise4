package com.github.rubenqba.gabo.ex4;

import com.github.rubenqba.gabo.ex4.histograma.Color;

import java.util.List;
import java.util.stream.Stream;

public interface PixelProcessor {

    /**
     * Este metodo es lo que diferencia a los procesadores
     * @param lines
     * @return
     */
    List<List<Color>> readLines(Stream<String> lines);

}
