package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class programus8 {

	public static void main(String[] args) {
		int [] arr = {5,9,7,10};
		int divisor = 5;
		
		programus8 quest = new programus8();
		quest.solution(arr, divisor);

	}
	 public int[] solution(int[] arr, int divisor) {
	        List<Integer> arrList = new ArrayList<Integer>();
			
			for(int i=0; i<arr.length; i++) { 
				if(arr[i]%divisor==0) { 
					arrList.add(arr[i]);
				} 
			}
	        if(arrList.isEmpty()) { 
				arrList.add(-1);
			}
			Collections.sort(arrList);
			int [] answer = new int [arrList.size()];
			
			for(int i=0; i<answer.length; i++) { 
				answer[i] = arrList.get(i);
			}
	        return answer;
	    }

}
