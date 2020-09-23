package practice;

public class programus16 {

	public static void main(String[] args) {
		int n=3;
		programus16 quest = new programus16();
		quest.solution(n);

	}
	public String solution(int n) {
        String answer = "";
        String waterMelon = "수박";
		String halfMelon = "수";
		
		if(n%2==0) { 
			for(int i=0; i<n/2; i++) {
				answer += waterMelon;
			}
		} else { 
			for(int i=0; i<n/2; i++) {
				answer += waterMelon;
			}
			
			answer += halfMelon;
		}
        
        return answer;
    }

}
