package algo;

public class uniquepaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		uniquepaths uni = new uniquepaths();
		System.out.println(uni.uniquePaths2(8, 9));
	}
	
    public int uniquePaths(int m, int n) {
        int d=0;
    	unique(m,n,0,0,d);
    	
    	return d;
    }
    
    public int unique(int m,int n,int row,int column,int d){
    	if(m==1&&n==1){
    		//d++;
    		return 1;
    	}
    	return unique(m--,n,row++,column,d)+unique(m,n--,row,column++,d);
    		
    	
    	
    }
    
    
    public static int uniquePaths2(int m, int n){  
        if(m==0 || n==0) return 0;  
        if(m ==1 || n==1) return 1;  
         
       int[][] dp = new int[m][n];  
         
       //只有一行时，到终点每个格子只有一种走法  
       for (int i=0; i<n; i++)  
           dp[0][i] = 1;  
         
       // 只有一列时，到终点每个格子只有一种走法
       for (int i=0; i<m; i++)  
           dp[i][0] = 1;  
         
       // for each body node, number of path = paths from top + paths from left  
       for (int i=1; i<m; i++){  
           for (int j=1; j<n; j++){  
               dp[i][j] = dp[i-1][j] + dp[i][j-1];  
               System.out.println(dp[i-1][j]+"-------"+dp[i][j-1]);
           }  
       }  
       return dp[m-1][n-1];  
   }

}
