package grass;

import java.util.ArrayList;
import java.util.List;

public class programus4 {

	public static void main(String[] args) {
		int [][] board = {{0,0,0,0,0,},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		
		programus4 quest = new programus4();
		quest.solution(board, moves);

	}
	
	public int solution(int[][] board, int[] moves) {
        List<Integer> bList = new ArrayList<Integer>();
		int answer=0;
		
		for(int i=0; i<moves.length; i++) {
			if(bList.size()>1) { 
				for(int x=0; x<bList.size()-1; x++) {
					if(bList.get(x)==bList.get(x+1)) {
						
						bList.remove(x+1);
						bList.remove(x);
						
						answer+=2;
						
					}
				}
			}
			
			
			for(int j=0; j<board.length; j++) { 
				
				if(board[j][moves[i]-1]!=0) {
					bList.add(board[j][moves[i]-1]);
					board[j][moves[i]-1]=0;
					
					break;
				}
			}
			
		}
        return answer;
	}

}
