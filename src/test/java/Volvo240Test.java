import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the possible operations on Volvo240.
 */
class Volvo240Test {
    private Volvo240 car;

    @BeforeEach
    void newCar() {
        car = new Volvo240();
    }

    @Test
    void moveEastTest() {
        car.gas(1);
        car.turnRight();
        car.move();
        assertEquals(1.25, car.position[0]);
    }

    @Test
    void moveSouthTest() {
        car.gas(1);
        car.turnRight();
        car.turnRight();
        car.move();
        assertEquals(-1.25, car.position[1]);
    }

    @Test
    void moveWestTest() {
        car.gas(1);
        car.turnLeft();
        car.move();
        assertEquals(-1.25, car.position[0]);
    }
    @Test
    void breakTest() {
        car.gas(1);
        car.brake(1);
        assertEquals(0, car.currentSpeed);
    }

    @Test
    void brakeException() {
        Volvo240 car = new Volvo240();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> car.brake(10),
                "Expected break() to throw, but it didn't");
        assertEquals("Argument must be in the interval [0,1].", exception.getMessage());
    }

    @Test
    void gasException() {
        Volvo240 car = new Volvo240();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> car.gas(10),
                "Expected gas() to throw, but it didn't");
        assertEquals("Argument must be in the interval [0,1].", exception.getMessage());
    }

    @Test
    void turnLeftTest() {
        Volvo240 car = new Volvo240();
        car.turnLeft();
        car.turnLeft();
        assertEquals(2, car.direction);
    }

    @Test
    void turnRightTest() {
        Volvo240 car = new Volvo240();
        car.turnRight();
        assertEquals(3, car.direction);
    }
}
