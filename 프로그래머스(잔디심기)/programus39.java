package programus1;

public class programus39 {

	public static void main(String[] args) {
		programus39 quest = new programus39();
		int n = 5;
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		
		quest.solution(n, arr1, arr2);
	}
	
	public String[] solution(int n, int[] arr1, int[] arr2) { 
		String[] answer = new String [n];
		
		String twoNum;
		String[] realTwoNum1 = new String[n];
		String[] realTwoNum2 = new String[n];
		String[] realAnswer = new String[n];
		
		for(int i=0; i<n; i++) {
			twoNum="";
			realTwoNum1[i]="";
			realTwoNum2[i]="";
			while(arr1[i]!=0) {
				if(arr1[i]%2==0) {
					twoNum+="0";
				} else { 
					twoNum+="1";
				}
				//System.out.println("arr1["+i+"]/2 : " + arr1[i]/2);
				arr1[i] = arr1[i]/2;
			}
			//System.out.println("twoNum[i] : " + twoNum);
			int minus=twoNum.length()-1;
			if(n-twoNum.length()!=0) { 
				for(int x=0; x<n-twoNum.length(); x++) { 
					realTwoNum1[i] += "0";
				}
				for(int j=0; j<twoNum.length(); j++) {
					realTwoNum1[i] += twoNum.charAt(minus);
					minus--;
				}
			}else { 
				for(int j=0; j<twoNum.length(); j++) {
					realTwoNum1[i] += twoNum.charAt(minus);
					minus--;
				}
			}
			System.out.println("realTwoNum1 : " + realTwoNum1[i]);
			
			//==============================================================
			twoNum="";
			while(arr2[i]!=0) {
				if(arr2[i]%2==0) {
					twoNum+="0";
				} else { 
					twoNum+="1";
				}
				//System.out.println("arr2["+i+"]/2 : " + arr2[i]/2);
				arr2[i] = arr2[i]/2;
			}
			//System.out.println("twoNum[i] : " + twoNum);
			minus=twoNum.length()-1;
			if(n-twoNum.length()!=0) { 
				for(int x=0; x<n-twoNum.length(); x++) { 
					realTwoNum2[i] += "0";
				}
				for(int j=0; j<twoNum.length(); j++) {
					realTwoNum2[i] += twoNum.charAt(minus);
					minus--;
				}
			}else { 
				for(int j=0; j<twoNum.length(); j++) {
					realTwoNum2[i] += twoNum.charAt(minus);
					minus--;
				}
			}
			System.out.println("realTwoNum2 : " + realTwoNum2[i]);
		}
		
		String fakeAnswer = "";
		for(int i=0; i<n; i++) { 
			answer[i] = "";
			fakeAnswer = realTwoNum1[i];
			for(int j=0; j<realTwoNum1[i].length(); j++) { 
				if(fakeAnswer.charAt(j)=='0') { 
					answer[i] += " ";
				} else {
					answer[i] += "#";
				}
			}
			fakeAnswer="";
			System.out.println(answer[i]);
			
			realAnswer[i] = "";
			for(int x=0; x<realTwoNum2[i].length(); x++) { 
				if(answer[i].charAt(x)=='#') { 
					realAnswer[i] += "#";
				} else { 
					if(realTwoNum2[i].charAt(x)=='1') { 
						realAnswer[i] += "#";
					}else { 
							realAnswer[i] += "A";
					}
				}
			}
			realAnswer[i] = realAnswer[i].replaceAll("AA", " ");
			realAnswer[i] = realAnswer[i].replaceAll("A", " ");
		}
		
		System.out.println("==========================================");
		for(String a : realAnswer) { 
			System.out.println(a);
		}
		return answer;
	}

}
