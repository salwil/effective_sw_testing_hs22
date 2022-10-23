package zest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSystemTest {

    @Property
    void testParkingSystemAddCarSuccess(@ForAll @Size(value = 3) List<@IntRange(min = 5, max = 10) Integer> parkingSystem, @ForAll @IntRange(min = 1, max = 3) int car) {
        ParkingSystem ps = new ParkingSystem(parkingSystem.get(0), parkingSystem.get(1), parkingSystem.get(2));
        assertTrue(ps.addCar(car));
    }

    @Property
    void testParkingSystemAddCarValid(@ForAll("largeEnoughParkingSystem") ParkingSystem parkingSystem,
                                      @ForAll("validPlacements") Integer[] placements) {
        for (Integer placement : placements) {
            assertTrue(parkingSystem.addCar(placement));
        }
    }

    @Property
    void testParkingSystemAddCarFail(@ForAll("tooSmallParkingSystem") ParkingSystem parkingSystem,
                                     @ForAll("bigPlacements") Integer[] bigPlacements,
                                     @ForAll("mediumPlacements") Integer[] mediumPlacements,
                                     @ForAll("smallPlacements") Integer[] smallPlacements) {
        Boolean spaceAvailable = true;
        for (Integer placement : bigPlacements) {
            spaceAvailable = parkingSystem.addCar(placement);
        }
        assertFalse(spaceAvailable);
        spaceAvailable = true;
        for (Integer placement : mediumPlacements) {
            spaceAvailable = parkingSystem.addCar(placement);
        }
        assertFalse(spaceAvailable);
        spaceAvailable = true;
        for (Integer placement : smallPlacements) {
            spaceAvailable = parkingSystem.addCar(placement);
        }
        assertFalse(spaceAvailable);
    }

    @Test
    void moreThan999Cars() {
        ParkingSystem parkingSystem = new ParkingSystem(1000, 1000, 1000);
        IntStream.range(0, 500).forEach(__ -> parkingSystem.addCar(1));
        IntStream.range(0, 250).forEach(__ -> parkingSystem.addCar(2));
        IntStream.range(0, 250).forEach(__ -> parkingSystem.addCar(3));
        assertThrows(RuntimeException.class, () -> parkingSystem.addCar(3));
    }

    @Test
    void tooBigParkingSystemThrowsException() {
        assertThrows(RuntimeException.class, () -> new ParkingSystem(1001, 1000, 1000));
        assertThrows(RuntimeException.class, () -> new ParkingSystem(1000, 1001, 1000));
        assertThrows(RuntimeException.class, () -> new ParkingSystem(1000, 1000, 1001));
    }

    @Test
    void wrongCarTypeThrowsException() {
        ParkingSystem ps = new ParkingSystem(1, 2, 3);
        assertThrows(RuntimeException.class, () -> ps.addCar(-1));
        assertThrows(RuntimeException.class, () -> ps.addCar(4));
    }

    @Test
    void tooSmallParkingSystemThrowsException() {
        assertThrows(RuntimeException.class, () -> new ParkingSystem(-1, 1000, 1000));
        assertThrows(RuntimeException.class, () -> new ParkingSystem(1000, -1, 1000));
        assertThrows(RuntimeException.class, () -> new ParkingSystem(1000, 1000, -1));
    }

    @Provide
    static Arbitrary<ParkingSystem> largeEnoughParkingSystem() {
        Arbitrary<Integer> big = Arbitraries.integers().between(400, 1000);
        Arbitrary<Integer> medium = Arbitraries.integers().between(400, 1000);
        Arbitrary<Integer> small = Arbitraries.integers().between(400, 1000);
        return Combinators.combine(big, medium, small)
                .as(ParkingSystem::new);
    }

    @Provide
    Arbitrary<Integer[]> validPlacements() {
        Arbitrary<Integer> integerArbitrary = Arbitraries.integers().between(1, 3);
        return integerArbitrary
                .array(Integer[].class).ofMinSize(0).ofMaxSize(30)
                .map(Function.identity());
    }

    @Provide
    static Arbitrary<ParkingSystem> tooSmallParkingSystem() {
        Arbitrary<Integer> big = Arbitraries.integers().between(0, 10);
        Arbitrary<Integer> medium = Arbitraries.integers().between(0, 10);
        Arbitrary<Integer> small = Arbitraries.integers().between(0, 10);
        return Combinators.combine(big, medium, small)
                .as(ParkingSystem::new);
    }

    @Provide
    Arbitrary<Integer[]> bigPlacements() {
        Arbitrary<Integer> integerArbitrary = Arbitraries.integers().between(1, 1);
        return integerArbitrary
                .array(Integer[].class).ofMinSize(11).ofMaxSize(20)
                .map(Function.identity());
    }

    @Provide
    Arbitrary<Integer[]> mediumPlacements() {
        Arbitrary<Integer> integerArbitrary = Arbitraries.integers().between(2, 2);
        return integerArbitrary
                .array(Integer[].class).ofMinSize(11).ofMaxSize(20)
                .map(Function.identity());
    }

    @Provide
    Arbitrary<Integer[]> smallPlacements() {
        Arbitrary<Integer> integerArbitrary = Arbitraries.integers().between(3, 3);
        return integerArbitrary
                .array(Integer[].class).ofMinSize(11).ofMaxSize(20)
                .map(Function.identity());
    }
}