package practice;

public class programus27 {

	public static void main(String[] args) {
		int n = 3;
		int m = 12;
		programus27 quest = new programus27();
		quest.solution(n, m);

	}

	 public int[] solution(int n, int m) {
	       int[] answer = new int[2];       
	      int tmp1,tmp2;
	      int r=1;                     
	      if(n>m){                          
	          tmp1 = n;                     
	          tmp2 = m;                     
	      }else{                            
	          tmp1 = m;              
	          tmp2 = n;              
	      }
	      
	      while(r>0){                       
	          r=tmp1%tmp2;                  
	          tmp1 = tmp2;               
	          tmp2 = r;                    
	      }
	      answer[0]= tmp1;                  
	      answer[1]=n*m/tmp1;               
	      return answer;
	  }
}
