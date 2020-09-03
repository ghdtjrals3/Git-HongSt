package practice;

import java.util.ArrayList;
import java.util.List;

public class programus2 {

	public static void main(String[] args) {
		programus2 quest = new programus2();
		int [] answers = {1,2,3,4,5};
		System.out.println(quest.solution(answers));
		
	}
	public int[] solution(int[] answers) { 
		int [] st1 = {1,2,3,4,5};
		int [] st2 = {2,1,2,3,2,4,2,5};
		int [] st3 = {3,3,1,1,2,2,4,4,5,5};
        
        List<Integer> answer1 = new ArrayList<Integer>();
		
		int stIdx1=0;
		int stIdx2=0;
		int stIdx3=0;
		
		int idx1=0;
		int idx2=0;
		int idx3=0;
		
		for(int i=0; i<answers.length; i++) { 
			if(st1[stIdx1]==answers[i]) { 
				idx1++;
			}
			if(st2[stIdx2]==answers[i]) { 
				idx2++;
			}
			if(st3[stIdx3]==answers[i]) { 
				idx3++;
			}
			stIdx1++;
			stIdx2++;
			stIdx3++;
			if(stIdx1==5) { 
				stIdx1=0;
			}
			if(stIdx2==8) { 
				stIdx2=0;
			}
			if(stIdx3==10) { 
				stIdx3=0;
			}
		}
		
		
    if(idx1>=idx2 && idx1>=idx3) {
				answer1.add(1);
			} if(idx2 >= idx3 && idx2 >= idx1) { 
				answer1.add(2);
			} if (idx3 >= idx1 && idx3 >= idx2){ 
				answer1.add(3);
			}
			
			int [] answer = new int [answer1.size()];
			
			for(int i=0; i<answer.length; i++) { 
				answer[i]=answer1.get(i);
			}
			for(int i:answer) { 
				System.out.println(i);
				
			}
        return answer;
	}

}
