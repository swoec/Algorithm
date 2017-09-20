package algo;
public class Solutions {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int [] nums  = new int[nums1.length+nums2.length];
        int sum=nums1.length+nums2.length;
        int m=0;
        int n=0;
        if(nums1==null || nums1.length==0){
            nums = nums2;
        }
        if(nums2==null || nums2.length==0){
            nums = nums1;
        }
        if((nums1==null || nums1.length==0)&&(nums2==null || nums2.length==0)){
            return 0;
        }
        while(m<nums1.length&&n<nums2.length){
            if(nums1[m]<=nums2[n]){
                nums[m+n]=nums1[m];
                m++;
                
            }else{
               // if(nums1[m]>nums[n]){
                    nums[m+n]=nums2[n];
                    n++;
                //}
            }
            
        }
        
        while(m<nums1.length){
            nums[m+n]=nums1[m];
            m++;
        }
        
        while(n<nums2.length){
            nums[m+n]=nums2[n];
            n++;
        }
            
        
        
       // for(int i=0;i<nums.length;i++){
        // System.out.println(nums[i]);
        //}
        
        if((sum%2)==0){
            if(sum>1){
                int d= sum/2-1;
                double ss = nums[sum/2] + nums[d];
                System.out.println(nums[d]);
                System.out.println(nums[sum/2]+"--------------------"+nums[sum/2-1]);
                System.out.println(ss);
                return ss/2;
            }else{
                return nums[0]/2;
            }
            
        }else{
            System.out.println(nums[(sum-1)/2]+"_____");
            if(sum>1){
                return nums[(sum-1)/2];
            }else{
                return nums[0];
            }
        }
        
        
    }
    
    public int divede(int [] nums){
        
        return 0;
        
    }
    
    
}
