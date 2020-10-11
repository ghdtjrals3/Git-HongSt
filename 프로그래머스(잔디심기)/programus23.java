package practice;

public class programus23 {

	public static void main(String[] args) {
		int n = 12345;
		
		programus23 quest = new programus23();
		quest.solution(n);

	}
	public int[] solution(long n) {
        long cnt=0;
        long t=n;
		
		while(t>0) { 
			t=t/10;
			cnt++;
		}
			int[] answer = new int[(int) cnt];
        
        for(int i=0; i<answer.length; i++) {
	            answer[i]= (int) (n%10);
	            n=n/10;
        }
        return answer;
    }

}
