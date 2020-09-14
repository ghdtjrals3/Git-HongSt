package practice;

public class programus9 {

	public static void main(String[] args) {
		int a=3, b=5;
		programus9 quest = new programus9();
		quest.solution(a, b);

	}
	  public long solution(int a, int b) {
	        long answer = 0;
	        int c=0;
	        if(a>b) {
	            c=b;
	            b=a;
	            a=c;
	        }
	        
	        for(int i=a; a<=b; a++){
	            answer+=a;    
	        }
	        
	        return answer;
	    }

}
