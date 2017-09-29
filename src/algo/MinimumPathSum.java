package algo;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumPathSum sm = new MinimumPathSum();
		//sm.minPathSum(grid)
	}
	
public int minPathSum(int[][] grid) {
        
        int row =grid.length;
    	int column= grid[0].length;
    	if(row==1&&column==1) return grid[0][0];
        
    	int [][] d= new int [row][column];
        
        d[0][0]= grid[0][0];
        
        //row
        for(int i=1;i<column;i++){
            d[0][i]=d[0][i-1] + grid[0][i];
        }
        
        //column
        for(int j=1;j<row;j++){
            
            d[j][0]= d[j-1][0]+ grid[j][0];
        }
    	
    	for(int i=1;i<row;i++){
    		for(int j=1;j<column;j++){
    			d[i][j]= Math.min(d[i-1][j], d[i][j-1])+grid[i][j];
    		}
    	}
    	
        
    	return d[row-1][column-1];
        
    }

}
