package practice;

public class programus19 {

	public static void main(String[] args) {
		int n = 12;
		programus19 quest = new programus19();
		quest.solution(n);

	}
	 public int solution(int n) {
	        int answer = 0;
	        int sum = 0;
	        
	        for(int i=1; i<=n/2; i++) {
	            if((n%i)==0) {
	                sum+=i;
	            }
	        }
	        sum+=n;
	        answer=sum;
	        return answer;
	    }

}
