package practice;

public class programus6 {

	public static void main(String[] args) {
		String s = "abced";
		programus6 quest = new programus6();
		quest.solution(s);

	}
	
	public String solution(String s) {
        String answer = "";
		if(s.length()%2==1) {
			answer = s.substring(s.length()/2,s.length()/2+1);	
		}
		else {
			answer = s.substring(s.length()/2-1,s.length()/2+1);
			
		}
        return answer;
    }

}
