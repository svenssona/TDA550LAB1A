import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Class for testing the possible operations on Saab95.
 */
class Saab95Test {
    private Saab95 car;

    @BeforeEach
    void newCar() {
        car = new Saab95();
    }

    @Test
    void moveTest() {
        car.gas(1);
        car.move();
        assertEquals(1.25, car.position[1]);
    }

    @Test
    void breakTest() {
        car.gas(1);
        car.brake(0);
        assertEquals(1.25, car.getCurrentSpeed());
    }

    @Test
    void doorTest() {
        assertEquals(2, car.getNrDoors());
    }
    @Test
    void colorTest() {
        car.setColor(Color.BLACK);
        assertEquals(Color.BLACK, car.getColor());
    }
    @Test
    void startEngineTest() {
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());
    }
    @Test
    void enginePowerTest() {
        assertEquals(125, car.getEnginePower());
    }
    @Test
    void turnLeftTest() {
        car.turnLeft();
        assertEquals(1, car.direction);
    }

    @Test
    void turnRightTest() {
        car.turnRight();
        assertEquals(3, car.direction);
    }
}
