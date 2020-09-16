package practice;

import java.util.Arrays;
import java.util.Collections;

public class programus12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public String reverseStr(String str){
	        char[] sol = str.toCharArray();
	        Arrays.sort(sol);
	        return new StringBuilder(new String(sol)).reverse().toString();
	    }
	    
	    public String solution(String s) {
	        programus12 answer = new programus12();
	        return answer.reverseStr(s);
	    }

}
