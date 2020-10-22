package programus;

public class programus31 {

	public static void main(String[] args) {
		int arr = 10;
		
		programus31 quest = new programus31();
		quest.solution(arr);

	}
	public boolean solution(int x) {
		boolean answer = true;
		int sum = 0;
		int orX = x;
		int idx = 0;
		while(idx < 5) { 
			sum += x%10;
			x /= 10;
			idx ++;
			if(x==0) {
				break;
			}
		}
		if(orX%sum==0)  { 
				answer = true;
		} else { 
			answer = false;
		}
			
		return answer;

	}
}
