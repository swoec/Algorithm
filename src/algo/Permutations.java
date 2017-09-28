package algo;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
	List<List<Integer>> res;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations ap = new Permutations();
		int [] nums ={0,1,2,3,4};
		ap.permute(nums);
		System.out.println(ap.res.toString());
	}
	
  
    
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<List<Integer>>();
        helper(nums, 0);
        return res;
    }
    
    public void helper(int[] nums, int i){
        // 找到转置完成后的解，将其存入列表中
        if(i == nums.length - 1){
            List<Integer> list = new LinkedList<Integer>();
            for(int j = 0; j < nums.length; j++){
                list.add(nums[j]);
            }
            res.add(list);
        }
        // 将当前位置的数跟后面的数交换，并搜索解
        for(int j = i; j < nums.length; j++){
        	System.out.println(i+"-------"+j);
            swap(nums, i , j);
            helper(nums, i + 1);
            System.out.println(i+"--******-----"+j);
            swap(nums, i, j);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
