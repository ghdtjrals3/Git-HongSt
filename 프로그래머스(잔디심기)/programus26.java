package practice;


import java.util.ArrayList;
import java.util.List;

public class programus26 {

	public static void main(String[] args) {
		int [] arr = {4,3,2,1};
		programus26 quest = new programus26();
		quest.solution(arr);

	}
	public int[] solution(int[] arr) {
        int idx = 0;
		
		if(arr.length==1) { 
			idx = arr.length;
		} else { 
			idx = arr.length-1;
		}
		
		int [] answer = new int[idx];
		
		if(idx==1) { 
			answer[0] = -1;
		} else {
			
			List<Integer> nList = new ArrayList<Integer>();
			for(int i=0; i<arr.length; i++) { 
				nList.add(arr[i]);
			}
			int min = nList.get(0);
			
			for(int i=0; i<arr.length; i++) { 
				if(min>nList.get(i)) { 
					min = nList.get(i);
				}
			}
			for(int i=0; i<arr.length; i++) { 
				if(min==nList.get(i)) { 
					nList.remove(i);
					break;
				}
			}
			
				for(int i=0; i<answer.length; i++) { 
					answer[i] = nList.get(i);
				}
				
			}
		
		return answer;
	}

}
