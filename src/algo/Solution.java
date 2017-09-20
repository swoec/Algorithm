package algo;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String[]args){
		Solution a = new Solution();
		a.combinationSum3(3, 9);
	}
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> total = new ArrayList<>();
        if (k<=0 || n<=0)
            return total;
         System.out.println("------combination-----"+k+n);
        com(new ArrayList<Integer>(), 1, k, n, total);
         
        return total;
    }
     
    public void com(List<Integer> list, int i, int k, int n, List<List<Integer>> total) {
        if (i==10 || i>n || k==0)
            return;
        System.out.println("------com1----i---"+(i+1)+"--k--"+k+"----n--"+n);
        com(list, i+1, k, n, total);
         
        List<Integer> newList = new ArrayList<>(list);
        System.out.println("------com2----i-"+i+"------");
        newList.add(i);
        if (i==n && k==1){
            total.add(newList);
        }
        else{
        	System.out.println("------com3----i-"+(i+1)+"----k--"+(k-1)+"--n-"+(n-i));
            com(newList, i+1, k-1, n-i, total);
        }
    }
}