package zest;


public class BetterPower {
    public double myPow(double x, int n) {
        if (x <= -100.0 || x >= 100.0) {
            throw new IllegalArgumentException("Base must be between -100 and 100");
        }

        if (n <= -100 || n >= 100) {
            throw new IllegalArgumentException("Power must be between -100 and 100");
        }

        double result = computePower(x, n);
        if (Math.abs(result) > 1E4) {
            throw new RuntimeException("Computed result too high: " + result);
        }
        return result;
    }

    /**
     * Solution inspired by: https://leetcode.com/problems/powx-n/discuss/336569/Java-solution
     */
    private double computePower(double base, int power) {
        if (power < 0) return 1 / base * computePower(1 / base, -(power + 1));
        if (power == 0) return 1;
        if (power == 2) return base * base;
        if (power % 2 == 0) return computePower(computePower(base, power / 2), 2);
        else return base * computePower(computePower(base, power / 2), 2);
    }
}