package pl.chojnacki.grzegorz.testing.exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTest {

    @Test
    void unitShouldNotMoveWithoutFuel()
    {
        //given
        Unit unit = new Unit(new Coordinates(10,10),0,10);

        //when
        //then
        assertThrows(IllegalStateException.class,() -> {
           unit.move(1,1);
        });
    }

    @Test
    void unitShouldLoseFuelWhenMoving() {

        //given
        Unit unit = new Unit(new Coordinates(10,10),30,10);

        //when
        unit.move(2,2);

        //then
        assertThat(unit.getFuel(),equalTo(26));
    }

    @Test
    void movedUnitShouldReturnNewCoordinates()
    {
        //given
        Unit unit = new Unit(new Coordinates(10,10),20,30);

        //when
        Coordinates newCoordinates = unit.move(2,2);

        //then
        assertThat(newCoordinates,equalTo(new Coordinates(12,12)));

    }

    @Test
    void fuelingShouldNotExceedMaxFuelLimit()
    {
        //given
        Unit unit = new Unit(new Coordinates(10,10),30,20);

        //when
        unit.tankUp();

        //then
        assertThat(unit.getFuel(),is(30));
    }

    @Test
    void cargoCanNotExceedMaxWeightLimit()
    {
        //given
        Unit unit = new Unit(new Coordinates(10,10),30,20);

        Cargo cargo1 = new Cargo("a1",12);
        Cargo cargo2 = new Cargo("a2",9);

        //when
        unit.loadCargo(cargo1);
        //then
        assertThrows(IllegalStateException.class,() -> {
            unit.loadCargo(cargo2);});
    }

    @Test
    void unloadingOneCargoShouldReduceWeightUnit()
    {
        //given
        Unit unit = new Unit(new Coordinates(10,10),30,30);

        Cargo cargo = new Cargo("a1",12);
        Cargo cargo1 = new Cargo("a2",15);
        Cargo cargo2 = new Cargo("a3",2);

        unit.loadCargo(cargo);
        unit.loadCargo(cargo1);
        unit.loadCargo(cargo2);

        //when
        unit.unloadCargo(cargo1);

        //then
        assertThat(unit.getLoad(),is(14));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/cargosToLoadToUnit.csv")
    void unloadingAllCargoShouldReduceWeightOnUnitLoadToZero(String name,int weightCargo)
    {
        //given
        Unit unit = new Unit(new Coordinates(10,10),15,100);
        unit.loadCargo(new Cargo(name,weightCargo));
        //when
        unit.unloadAllCargo();

        //then
        assertThat(unit.getLoad(),equalTo(0));



    }

}
