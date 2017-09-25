package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class nqueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nqueens as = new nqueens();
		as.solveNQueens(10);

	}
	
	public ArrayList<String[]> solveNQueens(int n) {  
	    ArrayList<String[]> res = new ArrayList<String[]>();  
	    helper(n,0,new int[n], res);  
	    return res;  
	}  
	private void helper(int n, int row, int[] columnForRow, ArrayList<String[]> res)  
	{  
	    if(row == n)  
	    {  
	        String[] item = new String[n];  
	        for(int i=0;i<n;i++)  
	        {  
	            StringBuilder strRow = new StringBuilder();  
	            for(int j=0;j<n;j++)  
	            {  
	                if(columnForRow[i]==j)  
	                    strRow.append('Q');  
	                else  
	                    strRow.append('.');  
	            }  
	            System.out.println(i+"---4------strrow------"+strRow.toString());
	            item[i] = strRow.toString();  
	        }  
	        res.add(item);  
	        return;  
	    }  
	    String str="";
	    for(int i=0;i<n;i++)  
	    {  
	    	//System.out.println("1--columnForRow[row]----"+columnForRow[row]+"---i--"+i+"-------row-------"+row);
	        columnForRow[row] = i;  
	       // System.out.println("helper-------i---"+i);
	        str+="*";
	        //System.out.println("helper----"+str);
	        if(check(row,columnForRow))  
	        {   //System.out.println("helper-------row----"+(row+1)+"----n----"+n);
	            helper(n,row+1,columnForRow,res);  
	            //System.out.println("helper----return-------row----"+row+"----n----"+n);
	        }  
	    }  
	}  
	private boolean check(int row, int[] columnForRow)  
	{  
		String ss="";
		int d=0;
		System.out.println(row+"-------------"+Arrays.toString(columnForRow));
	    for(int i=0;i<row;i++)  
	    {  
	    	ss+="-";
	    	d++;
        	//System.out.println(ss+"^^check^^^"+i);
	    	//System.out.println("3------columnForRow["+row+"]----"+columnForRow[row]+"---!--columnForRow["+i+"]----"+columnForRow[i]+"-------columnForRow[row]-columnForRow[i]-----!!---"+Math.abs(columnForRow[row]-columnForRow[i])+"---row-i--!!!-"+(row-i));
	        if(columnForRow[row]==columnForRow[i] || Math.abs(columnForRow[row]-columnForRow[i])==row-i){ 
	        	//  System.out.println("check------false--");
	        	//ss+="-";
	        	//System.out.println(ss);
	            return false;  
	        }
	    }  
	   // System.out.println("check-----true-----");
	    return true;  
	}  

}
