class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        boolean check[][]=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    for(int a=0;a<col;a++){
                        check[i][a]=true;
                    }
                    for(int b=0;b<row;b++){
                        check[b][j]=true;
                    }
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(check[i][j]==true){
                    matrix[i][j]=0;
                }
            }
        }
    }
}