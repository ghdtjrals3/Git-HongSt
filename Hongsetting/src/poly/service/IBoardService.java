package poly.service;

import java.util.List;

import poly.dto.BoardDTO;

public interface IBoardService {
	
	public String insertData(BoardDTO bDTO) throws Exception;
	
	public List<BoardDTO> getData() throws Exception;

}
