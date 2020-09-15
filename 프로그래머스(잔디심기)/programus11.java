package practice;

public class programus11 {

	public static void main(String[] args) {
		String s = "pPoooyY";
		programus11 quest = new programus11();
		quest.solution(s);

	}
	 boolean solution(String s) {
	        boolean answer = true;
	        int pNum = 0;
			int yNum = 0;
			
			char [] str = s.toCharArray();
			
			for(int i=0; i<str.length; i++) { 
				if(str[i]=='p' || str[i]=='P') {
					pNum++;
				} else if(str[i]=='y' || str[i]=='Y') {
					yNum++;
				}
			}
	        
	        if(pNum==yNum) return true;
	        else return false;
	    }

}
