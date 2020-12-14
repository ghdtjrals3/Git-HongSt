package programus1;

public class programus38 {

	public static void main(String[] args) {
		programus38 quest = new programus38();
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		
		quest.solution(a,b);

	}

	public int solution(int[] a, int[] b) { 
		int answer = 0;
		
		for(int i=0; i<a.length; i++) { 
			answer += a[i]*b[i];
		}
		
		System.out.println(answer);
		
		return answer;
	}
}
