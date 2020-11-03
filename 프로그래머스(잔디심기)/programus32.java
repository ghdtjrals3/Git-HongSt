package programus;

public class programus32 {

	public static void main(String[] args) {
		int [][] arr1 = {{1,2},{2,3}};
		int [][] arr2 = {{3,4},{5,6}};
		programus32 quest = new programus32();
		quest.solution(arr1,arr2);

	}
	
	 public int [][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];
		for(int i=0; i<arr1.length; i++) { 
			for(int j=0; j<arr2[0].length; j++) { 
				answer[i][j] = arr1[i][j] + arr2[i][j];
				}
			}
		return answer;
	   }

}
