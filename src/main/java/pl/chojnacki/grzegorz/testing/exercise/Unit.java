package pl.chojnacki.grzegorz.testing.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Unit {

    private static Random random = new Random();

    private Coordinates coordinates;
    private int fuel;
    private int maxFuel;
    private List<Cargo> cargos;
    private int maxCargoWeight;
    private int currentCargoWeight;

    public Unit(Coordinates coordinates, int maxFuel, int maxCargoWeight) {
        this.coordinates = coordinates;
        this.maxFuel = maxFuel;
        this.maxCargoWeight = maxCargoWeight;
        this.fuel = maxFuel;
        this.currentCargoWeight = 0;
        this.cargos = new ArrayList<>();
    }

    Coordinates move(int x, int y) {
        if (this.fuel - (x + y) < 0){
            throw new IllegalStateException("Unit cannot move that far");
        }

        Coordinates coordinatesAfterMove = Coordinates.copy(this.coordinates,x,y);
        this.coordinates=coordinatesAfterMove;
        this.fuel = this.fuel - (x+y);

        return coordinatesAfterMove;
    }
    void tankUp() {

        int restPoints = random.nextInt(10);

        if (restPoints + this.fuel >= maxFuel) {
            this.fuel = maxFuel;
        } else {
            this.fuel += restPoints;
        }

    }

    void loadCargo(Cargo cargo) {

        if (currentCargoWeight + cargo.getWeight() > maxCargoWeight) {
            throw new IllegalStateException("Can not load any more cargo");
        }

        this.cargos.add(cargo);

        this.currentCargoWeight = calculateCargoWeight();

    }

    void unloadCargo(Cargo cargo) {
        this.cargos.remove(cargo);
        this.currentCargoWeight = calculateCargoWeight();
    }

    void unloadAllCargo() {
        cargos.clear();
        this.currentCargoWeight = 0;
    }


    private int calculateCargoWeight() {
        return cargos.stream().mapToInt(Cargo::getWeight).sum();
    }

    int getFuel() {
        return this.fuel;
    }

    int getLoad() {
        return this.currentCargoWeight;
    }


}
