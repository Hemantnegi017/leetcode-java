class Solution {

    private String[] letters = {
        "", "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };

    private void solve(String digits, int index, String current,
                       List<String> result) {

        // Base case
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';

        String chars = letters[digit];

        for (int i = 0; i < chars.length(); i++) {

            solve(
                digits,
                index + 1,
                current + chars.charAt(i),
                result
            );
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        solve(digits, 0, "", result);

        return result;
    }
}