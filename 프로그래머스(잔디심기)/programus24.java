package practice;

public class programus24 {

	public static void main(String[] args) {
		long n = 121;
		programus24 quest = new programus24();
		quest.solution(n);

	}
	 public long solution(long n) {
	        long answer = 0;
	        if((long) Math.sqrt(n)*Math.sqrt(n)==n) {
				answer = (long) ((Math.sqrt(n)+1)*(Math.sqrt(n)+1));
			} else { 
				answer = -1;
			}
	        return answer;
	    }
}
