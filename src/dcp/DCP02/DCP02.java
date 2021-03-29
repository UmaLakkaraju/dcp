package dcp.DCP02;

public class DCP02 {
   public int[] productExceptSelf(int[] nums){
	    int length = nums.length;
	    int[] L = new int[length];
        int[] R = new int[length];
        int[] answer = new int[length];
         L[0] = 1;
         R[length - 1] = 1;
       for (int i = 1; i < length; i++) {

          L[i] = nums[i - 1] * L[i - 1];
       }

        
       for (int i = length - 2; i >= 0; i--) {

           R[i] = nums[i + 1] * R[i + 1];
       }

       // Constructing the answer array
       for (int i = 0; i < length; i++) {
    	   System.out.println(L[i] * R[i]);
           answer[i] = L[i] * R[i];
       }

       return answer;
   
   }
	
	
	
	
	public static void main(String[] args) {
		
		DCP02 dcp02=new DCP02();
		int[] nums=new int[]{4,5,1,8,2,10,6};
		
		dcp02.productExceptSelf(nums);
	}

}
