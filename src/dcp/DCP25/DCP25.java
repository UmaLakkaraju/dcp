package dcp.DCP25;

public class DCP25 {
public boolean isMatch(String text, String pattern) {
	 if (pattern.isEmpty()){ 
		 return text.isEmpty();
	 }
	 //find if the first chars match
     boolean first_match = (!text.isEmpty() &&
                            (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

     if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
         return (isMatch(text, pattern.substring(2)) ||
                 (first_match && isMatch(text.substring(1), pattern)));
     } else {
         return first_match && isMatch(text.substring(1), pattern.substring(1));
     }

      
    }
	public static void main(String[] args) {
		DCP25 dcp26=new DCP25();
		System.out.println(dcp26.isMatch("mississippi", "mis*is*p*."));

	}

}
