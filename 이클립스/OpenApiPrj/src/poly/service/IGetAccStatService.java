package poly.service;

import java.util.Map;

import poly.dto.AccStatDTO;

public interface IGetAccStatService {
	
	Map<String, Object> getAccStatForJSON(AccStatDTO pDTO) throws Exception;

}
