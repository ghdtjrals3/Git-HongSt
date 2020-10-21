package programus;

public class programus30 {

	public static void main(String[] args) {
		String phone_number = "01033334444";
		
		programus30 quest = new programus30();
		quest.solution(phone_number);

	}
	public String solution(String phone_number) {
		char [] arr = phone_number.toCharArray();
        for(int i=0; i<arr.length-4; i++) {
			arr[i]='*';
		}
        return String.valueOf(arr);
	    }

}
