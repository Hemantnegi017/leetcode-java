class Solution {
    public int divide(int dividend, int divisor) {

        // Special overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Convert to long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long ans = 0;

        while (a >= b) {

            long temp = b;
            long multiple = 1;

            // Find the biggest doubled divisor
            while (a >= temp + temp) {
                temp += temp;
                multiple += multiple;
            }

            // Subtract it
            a -= temp;

            // Add its corresponding multiple
            ans += multiple;
        }

        // Determine sign
        if ((dividend < 0) != (divisor < 0)) {
            ans = -ans;
        }

        return (int) ans;
    }
}