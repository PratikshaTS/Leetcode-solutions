class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, new ArrayList<>(), n, k, result);
        return result;
    }
    
    private void backtrack(int start, List<Integer> path, int n, int k, List<List<Integer>> result) {
        // Base case: if the combination has reached the required length k
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        // Optimization: stop early if there aren't enough numbers left to fill the combination
        // (i.e., replacing i <= n with i <= n - (k - path.size()) + 1)
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);                            // Add current number
            backtrack(i + 1, path, n, k, result);   // Move to the next number
            path.remove(path.size() - 1);           // Backtrack to try other possibilities
        }
    }
}