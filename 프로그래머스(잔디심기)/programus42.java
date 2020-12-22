package programus1;

import java.util.ArrayList;
import java.util.List;

public class programus42 {

	public static void main(String[] args) {
		programus42 quest = new programus42();

		int n = 10;

		quest.solution(n);
	}
	
	public String solution(int n) { 
		String answer = "";
		
		List<String> aList = new ArrayList<>();
		
		while(n>0) { 
			if(n%3==0) { 
				aList.add("4");
				n -= 1;
				n /= 3;
			} else {
				if(n%3==1) { 
					aList.add("1");
					n /= 3;
				} else if(n%3==2) { 
					aList.add("2");
					n /= 3;
				}
			}
			
		}
		
		for(int i=aList.size()-1; i>=0; i--) { 
			answer += aList.get(i);
		}
		
		System.out.println(answer);
		
		return answer;
	}
}
