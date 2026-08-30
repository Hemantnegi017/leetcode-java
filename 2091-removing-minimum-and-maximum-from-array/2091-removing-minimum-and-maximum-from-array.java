class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Find indexes of min and max
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Make minIndex the smaller index
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // Option 1: remove everything from left
        int removeLeft = right + 1;

        // Option 2: remove everything from right
        int removeRight = n - left;

        // Option 3: remove left part up to left
        // and right part from right
        int removeBoth = (left + 1) + (n - right);

        return Math.min(removeLeft, Math.min(removeRight, removeBoth));
    }
}