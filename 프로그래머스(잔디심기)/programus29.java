package programus;

public class programus29 {

	public static void main(String[] args) {
		int [] arr = {1,2,3,4};
		
		programus29 quest = new programus29();
		quest.solution(arr);

	}
	public double solution(int[] arr) {
		double answer = 0;
        
	    for(int i=0; i<arr.length; i++) {
	        answer+=arr[i];
	    }
	    
	        answer=answer/arr.length;
	        return answer;
	    }

}
