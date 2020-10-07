package de.telran.shapes.config;

import de.telran.shapes.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Config {

    @Bean
    public Line line1() {
        return new Line(10, '*');
    }

    @Bean
    public Rectangle rectangle() {
        return new Rectangle(7, 5, 'o');
    }

    @Bean
    public Square square() {
        return new Square(5, '.');
    }

    @Bean
    public Triangle triangle() {
        return new Triangle(6, '#');
    }

    @Bean
    public Picture picture(Line line1, Rectangle rectangle, Triangle triangle) {
        return new Picture(Arrays.asList(line1, rectangle, triangle, line1));
    }
}
