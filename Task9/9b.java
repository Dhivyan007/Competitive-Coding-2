public class RegexMatching {

    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return backtrack(0, 0, s, p, memo);
    }

    private boolean backtrack(int i, int j, String s, String p, Boolean[][] memo) {
        // Memoization check
        if (memo[i][j] != null) return memo[i][j];

        // If pattern is fully used
        if (j == p.length()) {
            return memo[i][j] = (i == s.length());
        }

        // First character matches?
        boolean firstMatch = (i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        // Handle '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Skip "*"
            boolean skipStar = backtrack(i, j + 2, s, p, memo);
            // Use "*"
            boolean useStar = firstMatch && backtrack(i + 1, j, s, p, memo);

            return memo[i][j] = skipStar || useStar;
        }

        // Normal character or '.'
        if (firstMatch) {
            return memo[i][j] = backtrack(i + 1, j + 1, s, p, memo);
        }

        return memo[i][j] = false;
    }

    // Test the function
    public static void main(String[] args) {
        RegexMatching solver = new RegexMatching();

        System.out.println(solver.isMatch("aa", "a"));        // false
        System.out.println(solver.isMatch("aa", "a*"));       // true
        System.out.println(solver.isMatch("ab", ".*"));       // true
        System.out.println(solver.isMatch("aab", "c*a*b"));   // true
        System.out.println(solver.isMatch("mississippi", "mis*is*p*.")); // false
    }
}
