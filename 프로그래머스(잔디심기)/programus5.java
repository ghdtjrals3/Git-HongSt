package practice;

import java.util.Calendar;
public class programus5 {

	public static void main(String[] args) {
		int a=5;
		int b=24;
		
		programus5 quest = new programus5();
		quest.solution(a, b);

	}
	public String solution(int a, int b) {
        String answer = "";
        int year = 2016;
        Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,a-1);
		cal.set(Calendar.DAY_OF_MONTH,b);
        
        switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			answer="SUN";
			break;
		case 2:
			answer="MON";
			break;
		case 3:
			answer="TUE";
			break;
		case 4:
			answer="WED";
			break;
		case 5:
			answer="THU";
			break;
		case 6:
			answer="FRI";
			break;
		case 7:
			answer="SAT";
			break;
		}
        
        return answer;
    }

}
