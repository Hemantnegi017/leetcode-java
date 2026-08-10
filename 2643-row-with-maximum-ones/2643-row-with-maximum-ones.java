class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max = 0;
        int row = 0;

        for(int i = 0; i<mat.length; i++){
            int ones = 0;

            for(int j = 0 ; j<mat[0].length ; j++){
                if(mat[i][j]==1){
                    ones++;
                }
            }
            if(ones>max){
                max = ones;
                row=i;
            }
        }
        return new int[]{row, max};
    }
}