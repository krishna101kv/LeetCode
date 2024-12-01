class Solution {
    public int delrow[]={-1,0,1,0};
    public int delcol[]={0,1,0,-1};
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int vis[][]=new int[n][m];
        for(int i=0;i<m;i++){//traverse for 1st and last row
            if(vis[0][i]==0 && board[0][i]=='O')//first row
                dfs(0,i,vis,board);
            if(vis[n-1][i]==0 && board[n-1][i]=='O')//last row
                dfs(n-1,i,vis,board);
        }
        for(int j=0;j<n;j++){
            if(vis[j][0]==0 && board[j][0]=='O')//first col
                dfs(j,0,vis,board);
            if(vis[j][m-1]==0 && board[j][m-1]=='O')//last col
                dfs(j,m-1,vis,board);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O')
                    board[i][j]='X';
            }
        }
        //return board;
    }
    public void dfs(int row,int col,int[][] vis,char[][] board){
        vis[row][col]=1;
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && ncol>=0 && ncol<m && nrow<n && vis[nrow][ncol]==0 &&
            board[nrow][ncol]=='O'){
                dfs(nrow,ncol,vis,board);
            }
        }
    }
}