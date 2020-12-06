package practice;

public class programus21 {

	public static void main(String[] args) {
		String s = "try hello world";
		programus21 quest = new programus21();
		quest.solution(s);
	}
	public String solution(String s) {
        String answer = "";
        String []data = s.split("");
        int len = data.length;
        int cnt = 0;
        
        for(int i=0; i<len; i++) {
            if(data[i].equals(" ")) {
                cnt=0;
            } else { 
                if(cnt%2==0) {
                    data[i]=data[i].toUpperCase();
                    cnt++;
                } else { 
                    data[i]=data[i].toLowerCase();
                    cnt++;
                }
            }
            answer += data[i];
        }
        
       
        return answer;
    }

}
