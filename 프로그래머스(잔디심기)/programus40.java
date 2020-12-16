package programus1;

public class programus40 {

	public static void main(String[] args) {
		programus40 quest = new programus40();
		String dartResult = "1T2D6S*";
		
		quest.solution(dartResult);

	}
	
	
	public int solution(String dartResult) { 
		int answer = 0;
		
		String[] arrAnswer = new String[dartResult.length()];
		
		int idx = 0;
		//1D2S#10S
		
		int forIdx = 0;
		int i=0;
		for(int j=0; j<dartResult.length(); j++) {
			arrAnswer[i] = "";
			if(forIdx!=2) {
				if(dartResult.charAt(j)=='S' || dartResult.charAt(j)=='T' || dartResult.charAt(j)=='D') { 
					
					if(dartResult.charAt(j+1)=='#' || dartResult.charAt(j+1)=='*') { 
						arrAnswer[i] = dartResult.substring(idx, j+2).trim();
						idx = j+2;
						forIdx++;
						System.out.println("arrAnswer[" + i + "] : " + arrAnswer[i]);
						i++;
					}else { 
						arrAnswer[i] = dartResult.substring(idx, j+1).trim();
						idx = j+1;
						forIdx++;
						System.out.println("arrAnswer[" + i + "] : " + arrAnswer[i]);
						i++;
					}
				}
			} else { 
				arrAnswer[i] = dartResult.substring(idx, dartResult.length()).trim();
				System.out.println("arrAnswer[" + i + "] : " + arrAnswer[i]);
				forIdx=0;
				break;
			}
		}
		
		int[] arrSum = new int[3];
		int sum = 0;
		
		for(int j=0; j<3; j++) { 
			
			int acc = 0;
			if(arrAnswer[j].contains("10")) { 
				acc = 10;
			}
			
			for(int x=0; x<arrAnswer[j].length(); x++) { 
				System.out.println("arrAnswer[" + j + "].charAt(" + x + ") : " + arrAnswer[j].charAt(x));
				switch(arrAnswer[j].charAt(x)) {
				case 'S' : 
					arrSum[j] += (int) Math.pow(acc, 1);
					System.out.println("arrSum[" + j + "] : " + arrSum[j]);
					break;
				case 'D' :
					arrSum[j] += (int) Math.pow(acc, 2);
					System.out.println("arrSum[" + j + "] : " + arrSum[j]);
					break;
				case 'T' :
					arrSum[j] += (int) Math.pow(acc, 3);
					System.out.println("arrSum[" + j + "] : " + arrSum[j]);
					break;
				case '#' :
					arrSum[j] *= (-1);
					break;
				case '*' : 
					if(j==0) { 
						arrSum[j] = arrSum[j]*2;
					} else { 
						arrSum[j-1] = arrSum[j-1]*2;
						arrSum[j] = arrSum[j]*2;
					}
					break;
				default : 
					if(arrAnswer[j].charAt(1)=='0') {
						
					} else { 
						acc =Integer.parseInt(Character.toString(arrAnswer[j].charAt(x)));
					}
				}
			}
		}
		
		for(int a : arrSum) { 
			sum += a ;
		}
		System.out.println("sum : " + sum);
		return answer;
	}

}
