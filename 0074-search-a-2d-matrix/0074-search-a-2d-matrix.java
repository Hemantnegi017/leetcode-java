class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int n= row*col;

        int start = 0;
        int end = n-1;

        while(start<=end){
            int mid = start+(end-start)/2;
            int rowIndex = mid/col;
            int colIndex = mid%col;

            if(matrix[rowIndex][colIndex]==target){
                return true;
            }
            if(matrix[rowIndex][colIndex]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }
}