package algo;

public class Juamgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Juamgame aj= new Juamgame();
		//int [] nums={3,2,1,0,4};
		int [] nums={2,3,1,1,4};
		
		aj.canJump(nums);

	}
    public boolean canJump(int[] nums) {
    	int tem=nums[0];    	
    	System.out.println(jump(tem,nums));
    	
		return jump(tem,nums);
        
    }
    
    public boolean jump(int tem,int []nums){
    	if(tem>nums.length-1){
    		System.out.println("--false---");
    		return false;
    	}else if(tem==nums.length-1){
    		System.out.println("-----true----");
    		return true;
    	}else{
    		if(nums[tem]!=0){
    		   tem=tem+nums[tem];
    		   System.out.println(tem+"------"+nums[tem]);
    		   return jump(tem,nums);
    		}else{
    			return false;
    		}
    	}
    	
    	//return ;
    }
}
