package programus1;

import java.util.ArrayList;
import java.util.List;

public class programus37 {

	public static void main(String[] args) {
		programus37 quest = new programus37();
		int n = 45;
		
		quest.solution(n);
	}
	public int solution(int n) { 
		int answer = 0;
		
		//while문 돌리기 위한 변수
		boolean cnt = true;
		
		//3진수를 담기 위한 변수
		List<Integer> sList = new ArrayList<Integer>();

		//3진수를 담는 변수의 첨자 변수
		int k = 0;
		
		while(cnt) { 
			if(n/3 == 0) { 
				sList.add(k, n%3);
				cnt = false;
				System.out.println("sList : " + sList.get(k));
				k++;
			} else { 
				sList.add(k, n%3);
				n = n/3;
				System.out.println("sList : " + sList.get(k));
				k++;
			}
		}
		
		k = 0;
		
		for(int i=sList.size()-1; i>=0; i--) { 
			answer += sList.get(i)*Math.pow(3, k);
			k++;
		}
		return answer;
	}

}
