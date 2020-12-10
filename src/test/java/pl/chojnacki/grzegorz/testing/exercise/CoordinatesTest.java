package pl.chojnacki.grzegorz.testing.exercise;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinatesTest {

    @Test
    void constructorShouldBeFailIfAnyCoordinateIsLessThan0()
    {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class,() -> {new Coordinates(-1,4);});
    }

    @Test
    void constructorShouldBeFailIfAnyCoordinateIsGreaterThan100()
    {
        //given
        //when
        //then
        assertAll("Testing Coordinates constructor for any values",
                () -> {assertThrows(IllegalArgumentException.class,() -> {
                    new Coordinates(0,101); });},
                () -> {assertThrows(IllegalArgumentException.class,() -> {
                    new Coordinates(120,213);
                });},
                () -> {assertThrows(IllegalArgumentException.class,() -> {
                    new Coordinates(120,5);
                });});
    }

    @Test
    void copyMethodShouldBeReturnNewObject()
    {
        //given
        Coordinates coordinates = new Coordinates(10,15);

        //when
        Coordinates copy = Coordinates.copy(coordinates,0,0);

        //then
        assertThat(copy,not(sameInstance(coordinates)));
        assertThat(copy,equalTo(coordinates));
    }


    @Test
    void copyMethodShouldBeAddCoordinates()
    {
        //given
        Coordinates coordinates = new Coordinates(20,20);

        //when
        Coordinates copy = Coordinates.copy(coordinates,30,20);

        //then
        assertThat(copy.getX(),equalTo(50));
        assertThat(copy.getY(),equalTo(40));
    }
}
