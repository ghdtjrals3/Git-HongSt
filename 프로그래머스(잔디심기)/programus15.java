package practice;

public class programus15 {

	public static void main(String[] args) {
		String [] seoul = {"Jane", "Kim"};
		programus15 quest = new programus15();
		quest.solution(seoul);

	}

	 public String solution(String[] seoul) {
	        String answer = "";
	       for(int i=0; i<seoul.length; i++) {
				if(seoul[i].contains("Kim")) {
					answer="김서방은 "+i+"에 있다";
				}
			}
	        
	        
	        return answer;
	    }
}
