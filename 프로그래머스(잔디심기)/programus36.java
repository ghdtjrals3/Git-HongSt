package programus1;

public class programus36 {

	public static void main(String[] args) {
		programus36 quest = new programus36();
		long n = 12536;
		
		quest.solution(n);

	}
	public long solution(long n) { 
		long answer = 0 ;
		long swap;
		char [] arrAnswer = Long.toString(n).toCharArray();
		
		for(int i=0; i<arrAnswer.length-1; i++) { 
			for(int j=0; j<arrAnswer.length-i-1; j++) { 
				if(arrAnswer[j] < arrAnswer[j+1]) { 
					swap = arrAnswer[j];
					arrAnswer[j] = arrAnswer[j+1];
					arrAnswer[j+1] = (char) swap;
				}
			}
		}
		
		String fakeAnswer = "";
		
		for(int i=0; i<arrAnswer.length; i++) { 
			fakeAnswer += arrAnswer[i];
		}
		
		answer = Long.valueOf(fakeAnswer);
		
		return answer;
	}

}
