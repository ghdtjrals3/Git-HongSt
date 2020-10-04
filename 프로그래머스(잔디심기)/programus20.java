package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class programus20 {

	public static void main(String[] args) {
		programus20 quest = new programus20();
		int [] numbers = {2,1,3,4,1};
		quest.solution(numbers);
	}
	public int[] solution(int[] numbers) {
        List<Integer> answerList = new ArrayList<>();
		for(int i=0; i<numbers.length-1; i++) { 
			for(int j=i+1; j<numbers.length; j++) { 
				if(!answerList.contains(numbers[i]+numbers[j])) { 
					answerList.add(numbers[i]+numbers[j]);
				}
				
			}
		}
		int [] answer = new int [answerList.size()];
		Collections.sort(answerList);
		for(int i=0; i<answer.length; i++) { 
			answer[i] = answerList.get(i);
		}
		return answer;
    }

}
