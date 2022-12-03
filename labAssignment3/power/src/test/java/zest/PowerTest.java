package zest;
import net.jqwik.api.*;
import net.jqwik.api.arbitraries.IntegerArbitrary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class PowerTest {

    //Power power = new Power();
    BetterPower power = new BetterPower();
    @Property
    void testPower0(@ForAll ("-100 to 100") double base){
        assertEquals(1, this.power.myPow(base, 0));
    }

    @Property
    void testNegativeBasePositivePowerOdd(@ForAll ("-100 to -1") double base, @ForAll ("positive power odd") int power){
        assumeTrue(Math.abs(Math.pow(base, power)) <= 1E4);
        double result = this.power.myPow(base, power);
        assertTrue(result <= 1);
    }

    @Property
    void testNegativeBasePositivePowerEven(@ForAll ("-100 to -1") double base, @ForAll ("positive power even") int power){
        assumeTrue(Math.abs(Math.pow(base, power)) <= 1E4);
        double result = this.power.myPow(base, power);
        assertTrue(result >= 1);
    }

    @Property
    void testBase0To1(@ForAll ("0 to 1") double base, @ForAll ("positive power") int power){
        double result = this.power.myPow(base, power);
        assertTrue(result > 0 && result <= 1);
    }

    @Property
    void testBaseMinus1To0PositivePowerEven(@ForAll ("-1 to 0") double base, @ForAll ("positive power even") int power){
        double result = this.power.myPow(base, power);
        assertTrue(result > 0 && result <= 1);
    }

    @Property
    void testBaseMinus1To0PositivePowerOdd(@ForAll ("-1 to 0") double base, @ForAll ("positive power odd") int power){
        double result = this.power.myPow(base, power);
        assertTrue(result >= -1 && result < 0);
    }

    @Property
    void testNegativePower(@ForAll ("1 to 100") double base, @ForAll ("negative power") int power){
        double result = this.power.myPow(base, power);
        assertTrue(result > 0 && result <= 1);
    }

    // And lets do some spot check tests where we assert the exact result
    @Test
    void testNegativePowerExact() {
        assertEquals(0.04000000000000001, this.power.myPow(5, -2));
        assertEquals(0.008000000000000002, this.power.myPow(5, -3));
        assertEquals(8.0, this.power.myPow(0.5, -3));
    }

    @Test
    void testPositivePowerExact() {
        assertEquals(625.0, this.power.myPow(5, 4));
        assertEquals(-0.0010000000000000002, this.power.myPow(-0.1, 3));
    }

    @ParameterizedTest
    @CsvSource({
            "-100.0, 2",
            "100.0, 2",
            "5.0, -100",
            "5.0, 100",
    })

    void invalidValuesThrowsError(double base, int power) {
        assertThrows(IllegalArgumentException.class, () -> this.power.myPow(base, power));
    }

    @Test
    void tooHighResultThrowsError() {
        // we spy the power object, because we want the computePower method to return a value that is not allowed.
        BetterPower powerMock = Mockito.spy(this.power);
        Mockito.doReturn(1E4+0.1).when(powerMock).computePower(Mockito.anyDouble(), Mockito.anyInt());
        assertThrows(RuntimeException.class, () -> powerMock.myPow(2.0, 3));
    }

    @Test
    void dontThrowErrorFor1E4ThrowsError() {
        // we spy the power object, because we want the computePower method to return a value that is not allowed.
        BetterPower powerMock = Mockito.spy(this.power);
        Mockito.doReturn(1E4).when(powerMock).computePower(Mockito.anyDouble(), Mockito.anyInt());
        assertEquals(1E4, powerMock.myPow(2.0, 3));
    }

    @Provide("positive power odd")
    Arbitrary<Integer> positivePowerOdd() {
        return Arbitraries.of(1,3);
    }

    @Provide("positive power even")
    Arbitrary<Integer> positivePowerEven() {
        return Arbitraries.of(0, 2, 4);

    }

    @Provide("negative power")
    IntegerArbitrary negativePower() {
        return Arbitraries.integers().between(-99, -1);
    }

    @Provide("positive power")
    IntegerArbitrary positivePower() {
        return Arbitraries.integers().between(0, 99);
    }

    @Provide("-100 to 100")
    Arbitrary<Double> allValidBases() {
        return Arbitraries.doubles().between(-100, false, 100, false);
    }
    @Provide("-100 to -1")
    Arbitrary<Double> baseNumbersSmallerMinus1() {
        return Arbitraries.doubles().between(-100, false, -1, true);
    }
    @Provide("1 to 100")
    Arbitrary<Double> BaseNumbersGreater1() {
        return Arbitraries.doubles().between(1, true, 100, false);
    }

    @Provide("-1 to 0")
    Arbitrary<Double> baseNumbersMinus1To0() {
        return Arbitraries.doubles().between(-1, true, 0, false);
    }

    @Provide("0 to 1")
    Arbitrary<Double> baseNumbers1To0() {
        return Arbitraries.doubles().between(0, false, 1, true);
    }
}