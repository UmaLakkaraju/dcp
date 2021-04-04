package dcp.DCP22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DCP22 {
	
	public List<String> wordBreaker(String input, List<String> dict){
	   
	   return wordBreakerHelper(input,dict,new HashMap<String,List<String>>());
	}

	public List<String> wordBreakerHelper(String input, List<String> dict,Map<String,List<String>> memo){
		if(memo.containsKey(input)){
			return memo.get(input);
		}
		List<String> results=new ArrayList<>();
		if(input.length()==0){
			results.add("");
			return results;
		}
		for(String word :dict){
			if(input.startsWith(word)){
				String sub =input.substring(word.length());
				List<String> subStrings=wordBreakerHelper(sub, dict,memo);
				for(String subString :subStrings){
					String optionalString=subString.isEmpty()?"":" ";
				   results.add(word+optionalString+subString);
				}
				
			}
		}
		memo.put(input,results);
		System.out.println(results);
		return results;
	}
	public static void main(String[] args) {
		DCP22 dcp22=new DCP22();
		//tc1
		/*String input= "catsanddog";
		List<String> dict=new ArrayList<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");*/
		
		//tc2
		String input= "pineapplepenapple";
		List<String> dict=new ArrayList<>();
		dict.add("apple");
		dict.add("pen");
		dict.add("applepen");
		dict.add("pine");
		dict.add("pineapple");
		
		dcp22.wordBreaker(input, dict);
		
	}

}
