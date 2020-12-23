package programus1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class programus43 {

	public static void main(String[] args) {
		programus43 quest = new programus43();
		
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		
		quest.solution(progresses, speeds);
	}
public int[] solution(int[] progresses, int[] speeds) { 
		
		int dayIdx = 0;
		
		List<Integer> pList = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<progresses.length; i++) { 
			while(progresses[i]<100) { 
				progresses[i] += speeds[i];
				dayIdx++;
				
				if(progresses[i] >= 100) { 
					if(i==0) { 
						pList.add(dayIdx);
						dayIdx=0;
					}else { 
						int pastIdx = i-1;
						if(dayIdx >= pList.get(pastIdx)) { 
							pList.add(dayIdx);
							dayIdx=0;
						}else { 
							pList.add(pList.get(pastIdx));
							dayIdx=0;
						}
					}
				}
			}
			queue.offer(pList.get(i));
		}

		List<Integer> answerList = new ArrayList<>();
		boolean boo = true;
		
		int Idx = 1;
		int peek=queue.peek();
		queue.remove();
		
		while(boo) { 
			if(queue.peek()==null) { 
				answerList.add(Idx);
				boo = false;
				break;
			} else { 
				if(peek==queue.peek()) { 
					Idx++;
					queue.remove();
				} else { 
					answerList.add(Idx);
					Idx = 1;
					peek=queue.peek();
					queue.remove();
				}
			}
		}

		int[] answer = new int[answerList.size()];
		
		for(int i=0; i<answer.length; i++) { 
			answer[i] = answerList.get(i);
		}
		
		return answer;
	}

}
