package programus;

public class programus28 {

	public static void main(String[] args) {
		int n = 6;
	
		programus28 quest = new programus28();
		quest.solution(n);

	}
	 public int solution(int num) {
		 int answer = 0;
	        long num2 = num;
	        for(int i=0; i<501; i++) { 
				if(num2==1) {
					break;
				}
				
				if(num2%2==0) { 
					num2 = num2/2;
					answer++;

				} else if(num2%2!=0){ 
					num2 = num2*3 +1;
					answer++;

				}
				
			}
	        if(answer > 500) { 
				answer = -1;
			}
			
	        return answer;
	    }

}
