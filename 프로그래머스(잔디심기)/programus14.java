package programus;

public class programus14 {

	public static void main(String[] args) {
		String [] seoul = {"Jane","Kim"};
		programus14 quest = new programus14();
		quest.solution(seoul);
		
	}
	
	public String solution(String[] seoul) {
        String answer = "";
        String frontAnswer="김서방은 ";
        String backAnswer="에 있다";
       for(int i=0; i<seoul.length; i++) {
			if(seoul[i].contains("Kim")) {
				answer="김서방은 "+i+"에 있다";
			}
		}
        
        
        return answer;
    }

}
