class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        // Target cannot exceed total capacity
        if (target > (long) x + y) {
            return false;
        }

        // Zero liters is always possible
        if (target == 0) {
            return true;
        }

        // Calculate GCD
        int gcd = findGCD(x, y);

        // Check whether target is divisible by GCD
        return target % gcd == 0;
    }

    public int findGCD(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}