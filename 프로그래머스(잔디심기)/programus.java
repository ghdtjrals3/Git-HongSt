package proramus;

import java.util.Map;
import java.util.HashMap;

public class programus {

	public static void main(String[] args) {
		programus quest = new programus();
		

	}
	public String solution(String[] participant, String[] completion) { 
	String answer ="";
	Map<String, Integer> hm = new HashMap<>();
	for (String player : participant)
		hm.put(player, hm.getOrDefault(player, 0) + 1);
	for (String player : completion)
		hm.put(player, hm.get(player) - 1);

	for (String key : hm.keySet()) {
		if (hm.get(key) != 0) {
			answer = key;
		}
	}
	return answer;
	}

}
