package practice;

import java.util.List;
import java.util.ArrayList;

public class programus7 {

	public static void main(String[] args) {
			int []arr = {1,1,3,3,0,1,1};
			programus7 quest = new programus7();
			quest.solution(arr);
	}
	
	 public int[] solution(int []arr) {
	        List<Integer> arrList = new ArrayList<Integer>();
			
			arrList.add(arr[0]);
			
			for(int i=1; i<arr.length; i++) { 
				if(arrList.get(arrList.size()-1)!=arr[i]) {
					arrList.add(arr[i]);
				}
			}
			
			int [] answer = new int [arrList.size()];
			
			for(int i=0; i<answer.length; i++) { 
				answer[i] = arrList.get(i);
			}
			
	        return answer;
	    }

}
