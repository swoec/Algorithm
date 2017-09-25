package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class nqueen2 {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nqueen2 as = new nqueen2();
		as.solveNQueens(9);

	}
	
	public ArrayList<String[]> solveNQueens(int n) {  
	    ArrayList<String[]> res = new ArrayList<String[]>();  
	    int sum=0;
	    HashMap map = new HashMap();
	    helper(n,0,new int[n], res,map); 
	    System.out.println(map.entrySet().size()+"------"+res.size());
	    return res;  
	}  
	private void helper(int n, int row, int[] columnForRow, ArrayList<String[]> res,HashMap map)  
	{  
	    if(row == n)  
	    {  
	        String[] item = new String[n];  
	        StringBuilder strtotal = new StringBuilder(); 
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
	            //System.out.println(i+"---4------strrow------"+strRow.toString());
	            item[i] = strRow.toString();
	            strtotal.append(item[i]);
	            //strtotal.toString()
	        }  
	        if(!map.containsKey(Arrays.toString(item))){
	        	//map.put(item[0], "1");
	        	map.put(Arrays.toString(item), "1");
	        }
	        System.out.println(Arrays.toString(item));
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
	            helper(n,row+1,columnForRow,res,map);  
	            //System.out.println("helper----return-------row----"+row+"----n----"+n);
	        }  
	    }  
	}  
	private boolean check(int row, int[] columnForRow)  
	{  
		String ss="";
		int d=0;
		//System.out.println(row+"-------------"+Arrays.toString(columnForRow));
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
