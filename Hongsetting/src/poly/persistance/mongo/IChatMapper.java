package poly.persistance.mongo;

import java.util.List;
import java.util.Map;

public interface IChatMapper {

	public int insertData(List<Map<String, Object>> fList, String colNm) throws Exception;
	
	public int insertHaksaData(List<Map<String, Object>> fList, String colNm) throws Exception;
	
	public List<Map<String,String>> getFoodList(String colNm) throws Exception;

	public List<Map<String,String>> getHaksaList(String colNm) throws Exception;
}
