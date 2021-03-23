package dcp;

import java.util.HashMap;
import java.util.Map;

public class DCP01 {
    private int[] result=new int[]{0};
    Map<Integer,Integer> hm=new HashMap<>();
	public int[] twoSum(int[] nums,int target){
		for(int n=0;n<nums.length;n++){
			//System.out.println("---"+hm.get(target-nums[n])+"---"+n);
		  if(hm.containsKey(target-nums[n])){
			  System.out.println("---"+hm.get(target-nums[n])+"---"+n);
			  return new int[]{hm.get(target-nums[n]),n};
			 }else{
				 hm.put( nums[n], n);
			 }	
		}
		System.out.println("result"+result);
		return result;
	}
	
	
	
	
	public static void main(String[] str){
		DCP01 dcp01=new DCP01();
		int[] nums=new int[]{2,7,11,15};
		int target=9;
		//int[] nums=new int[]{3,2,4};
	    //int target=6;
		//int[] nums=new int[]{};
		//int target=9;
		dcp01.twoSum(nums,target);
	}
}
