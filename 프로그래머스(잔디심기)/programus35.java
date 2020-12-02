package programus;

import java.util.Arrays;

public class programus35 {
	//프로그래머스 예산
	public static void main(String[] args) {
		int [] d = {1,3,2,5,4};
		int budget = 9;
		programus35 quest = new programus35();
		quest.solution(d, budget);

	}
	public int solution(int[] d, int budget) {
        int answer = 0;
		int sum = 0;
		Arrays.sort(d);
		
		for(int i=0; i<d.length; i++) { 
			sum += d[i];
			if(sum <= budget) {
				answer ++;
			}
		}
		
		return answer;
    }

}
