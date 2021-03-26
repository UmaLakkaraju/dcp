package dcp;

public class DCP04 {
	 public int firstMissingPositive(int[] nums) {
		 System.out.println("input size :" +nums.length);
		 int size=nums.length;int min=0;
		 for(int i=0;i<size;i++){
			 if(nums[i]==1){
				 min=1;
				 break;
			 }
			 if(min==0)return 1;
			 if(size==1)return 2;
			 
		 }
		 for (int i = 0; i < size; i++)
		      if ((nums[i] <= 0) || (nums[i] > size))
		        nums[i] = 1;
		 for (int i = 0; i < size; i++) {
		      int a = Math.abs(nums[i]);
		      
		      if (a == size)
		        nums[0] = - Math.abs(nums[0]);
		      else
		        nums[a] = - Math.abs(nums[a]);
		    }
		 for (int i = 1; i < size; i++) {
		      if (nums[i] > 0)
		        return i;
		    }
		 if(nums[0]>0){
			 return size;
		 }
	      return size+1;
	    }
	public static void main(String[] args) {
	    DCP04 dcp04=new DCP04();
		//int[] inputData=new int[]{3,4,-1,-2,1,5,16,0,2,0};
	    int[] inputData=new int[]{1,2,0};
		System.out.println(dcp04.firstMissingPositive(inputData));
	}

}
