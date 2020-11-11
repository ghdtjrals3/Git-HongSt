package programus;

public class programus33 {

	public static void main(String[] args) {
		int x = 2;
		int n = 5;
		programus33 quest = new programus33();
		quest.solution(x,n);

	}
	
	public long[] solution(int x, int n) {
	       long [] answer = new long[n];
			for(int i=0; i<n; i++) { 
				answer[i] = (long) (i+1)*x;
			}
			return answer;
	    }

}
