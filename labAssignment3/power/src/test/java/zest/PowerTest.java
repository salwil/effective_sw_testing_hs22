package zest;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PowerTest {

    Power power = new Power();

    @BeforeEach
    void setup() {
        power = new Power();
    }

    @Property
    void testBaseIsGreaterEqual1(@ForAll ("1 to 100") double base, @ForAll ("0 to 4") int power) {
        assertTrue(this.power.myPow(base, power) >= 1.0);
    }

    @Property
    void testBaseIsSmallerEqual1(@ForAll ("0 to 1") double base, @ForAll ("0 to 4") int power) {
        assertTrue(this.power.myPow(base, power) <= 1.0);
    }

    @Property
    void testPowerIsSmaller0(@ForAll ("1 to 100") double base, @ForAll ("-4 to 0") int power) {
        double result = this.power.myPow(base, power);
        assertTrue(result <= 1.0 && result > 0);
    }

    @Provide("1 to 100")
    Arbitrary<Double> baseNumbersGreaterEqual1() {
        return Arbitraries.doubles().between(1.0, 100.0);
    }

    @Provide("0 to 1")
    Arbitrary<Double> baseNumbersSmallerEqual1() {
        return Arbitraries.doubles().between(0.0, 1.0);
    }

    @Provide("0 to 4")
    Arbitrary<Integer> positivePower() {
        return Arbitraries.integers().between(0, 1);
    }

    @Provide("-4 to 0")
    Arbitrary<Integer> negativePower() {
        return Arbitraries.integers().between(-4, -1);
    }

    @Property
    void testNegativeNumbersWithNegativePower(@ForAll ("0 to -100") double negativeBase, @ForAll ("odd power") int power) {
        assertTrue(this.power.myPow(negativeBase, power) <= 0);
    }

    @Provide("odd power")
    Arbitrary<Integer> oddPower() {
        return Arbitraries.of(1,3);
    }

    @Property
    void testNegativeNumbersWithPositivePower(@ForAll ("0 to -100") double negativeBase, @ForAll ("even power") int power) {
        assertTrue(this.power.myPow(negativeBase, power) >= 0.0);
    }

    @Provide("0 to -100")
    Arbitrary<Double> baseNumbersSmaller0() {
        return Arbitraries.doubles().between(-100.0, 0.0);
    }

    @Provide("even power")
    Arbitrary<Integer> evenPower() {
        return Arbitraries.of(0,2,4);
    }
}