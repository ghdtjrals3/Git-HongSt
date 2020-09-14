package practice;

import java.util.Arrays;

public class programus10 {

	public static void main(String[] args) {
		String [] strings = {"sun", "bed", "car"};
		int n = 1;
		
		programus10 quest = new programus10();
		
		quest.solution(strings, n);
		

	}
    public String[] solution(String[] strings, int n) {
        
        String [] answer = new String [strings.length];
		
		for(int i=0; i<strings.length; i++)  {
			strings[i] = strings[i].substring(n,n+1) + strings[i];
		}
		
		Arrays.sort(strings);
		
		for(int i=0; i<strings.length; i++) { 
			answer[i] = strings[i].substring(1,strings[i].length());
		}
        return answer;
    }

}
