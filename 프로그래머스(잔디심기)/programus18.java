package programus;

public class programus18 {

	public static void main(String[] args) {
		String s ="AB";
		int n = 1;
	
		programus18 quest = new programus18();
		quest.solution(s, n);

	}
	 public String solution(String s, int n) {
	       String answer = "";
			char[] list = s.toCharArray();

			for (int i = 0; i < list.length; i++) {
				if((int)list[i]>64&&(int)list[i]<91) {
					if(((int) list[i] + n)>90) {
					
						list[i] = (char) ((int) list[i] + n - 26);
					
					}
					else {
						
						list[i] = (char) ((int) list[i] + n);
						
					}
				}
				if((int)list[i]+n>122) { 

					list[i] = (char) ((int) list[i] + n - 26);
					
				}
				
				else if((int)list[i]>96&&(int)list[i]<123){ 
					
					list[i] = (char) ((int) list[i] + n);
				}
			}
	        s = String.valueOf(list);
			answer = s;
	        
	        return answer;
	    }

}
