package dcp;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
	public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = count("");
        for (String b: B) {
        	int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
     search:for (String a: A) {
     int[] aCount = count(a);
            for (int i = 0; i < 26; ++i)
                if (aCount[i] < bmax[i]){
                	
                    continue search;
                }
            System.out.println("--"+a);
            ans.add(a);
        }

        return ans;
    }

    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
	
	
	public static void main(String[] args) {
	String[] arrA=new String[]{"amazon","apple","facebook","google","leetcode"};
	String[] arrB=new String[]{"e","o"};
     WordSubsets ws=new WordSubsets();
    
     ws.wordSubsets(arrA, arrB);
	}

}
