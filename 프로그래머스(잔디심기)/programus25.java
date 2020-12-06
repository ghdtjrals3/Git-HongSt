package practice;

public class programus25 {

	public static void main(String[] args) {
		int num = 3;
		programus25 quest = new programus25();
		quest.solution(num);

	}
	 public String solution(int num) {
	        String Odd="Odd";
	        String Even="Even";
	        String answer = "";
	        if(num%2==0) {
	            answer = Even;
	        } else { 
	            answer = Odd;
	        }
	        
	        return answer;
	    }

}
