package com.github.rubenqba.gabo.ex4;

import com.github.rubenqba.gabo.ex4.histograma.RGBColor;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RBGColorTest {

    @Test
    public void key() {
        Map<RGBColor, Integer> map = new HashMap<>();
        RGBColor color = new RGBColor<>(1, 2, 3);

        map.putIfAbsent(color, 1);

        assertThat(map.keySet(), Matchers.hasSize(1));

        // intentando agregar otro
        map.putIfAbsent(color, 1);
        map.computeIfPresent(color, (rgb, count) -> count+1);

        assertThat(map.keySet(), Matchers.hasSize(1));
        assertThat(map.get(color), equalTo(2));

        color = new RGBColor<>(4,5,6);
        map.putIfAbsent(color, 1);

        assertThat(map.keySet(), Matchers.hasSize(2));
        assertThat(map.get(color), equalTo(1));
    }

    @Test
    public void assignable() {
        RGBColor base = new RGBColor<>(1,2,3);

        class Child extends RGBColor<Integer> {

            public Child(Integer red, Integer green, Integer blue) {
                super(red, green, blue);
            }
        }

        Child child = new Child(1,2,3);

        assertThat(child, equalTo(base));
    }
}