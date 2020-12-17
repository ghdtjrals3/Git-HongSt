package programus1;

import java.util.LinkedList;
import java.util.Queue;

public class programus41 {

	public static void main(String[] args) {

		programus41 quest = new programus41();
		
		int bridge_length = 3;
		int weight = 10;
		int[] truck_weights = {3,6,4,2};
		
		quest.solution(bridge_length, weight, truck_weights);
		
	}
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int sum = 0;
		
		for(int a : truck_weights) { 
            while(true) {         
                if(queue.isEmpty()) { 
				queue.add(a);
				answer++;
				sum += a;
                break;
			} else if(queue.size()==bridge_length) { 
				sum -= queue.poll();
			} else { 
				if(sum+a>weight) { 
					queue.add(0);
					answer++;
				} else { 
					queue.add(a);
					answer++;
					sum += a;
                    break;
				}
			}
       }
			
	}
		
		System.out.println("answer : " + answer);
		
		return answer + bridge_length;

    }
	

}
