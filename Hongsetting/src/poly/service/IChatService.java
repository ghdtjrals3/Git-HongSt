package poly.service;

import java.util.List;
import java.util.Map;

public interface IChatService {
	
	public int collecMenu() throws Exception;
	
	public List<Map<String, String>> getFoodList() throws Exception;
	public List<Map<String, String>> getHaksaList() throws Exception;
	
	public int collectHaksa() throws Exception;

}
