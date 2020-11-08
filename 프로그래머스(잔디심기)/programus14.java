<<<<<<< HEAD
package programus;
=======
package practice;
>>>>>>> c75a49d103dd5c1915599e557045c8f43753e8ff

public class programus14 {

	public static void main(String[] args) {
<<<<<<< HEAD
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
=======
		int n = 10;
		programus14 quest = new programus14();
		quest.solution(n);

	}
	 public int solution(int n) {
	        int answer = 0;
	        int[] num=new int[n+1];
	        
	        for(int i=2; i<=n; i++) {
	            num[i] = i;
	        }
	        
	        for(int i=2; i<=n; i++) {
	            if(num[i]==0) {
	                continue;
	            }
	            for(int j=2*i; j<=n; j+=i) {
	                num[j]=0;
	            }
	        }
	        
	        for(int i=0; i<num.length; i++) {
	           if(num[i]!=0) {
	               answer++;
	           }
	        }
	        return answer;
	    }
>>>>>>> c75a49d103dd5c1915599e557045c8f43753e8ff

}
