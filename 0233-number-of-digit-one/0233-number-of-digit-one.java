class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long i = 1;
        
        while (i <= n) {
            long divider = i * 10;
            count += (int) ((n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i));
            i = divider;
        }
        
        return count;
    }
}