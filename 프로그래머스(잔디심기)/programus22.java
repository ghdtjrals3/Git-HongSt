package practice;

public class programus22 {

	public static void main(String[] args) {
		int n = 123;
		
		programus22 quest = new programus22();
		quest.solution(n);
	}
	    public int solution(int n) {
	        int answer = 0;

	        while(n>0) { 
	            answer += n%10;
	            n=n/10;
	        }

	        return answer;
	    }

}
