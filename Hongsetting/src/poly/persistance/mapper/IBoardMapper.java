package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.BoardDTO;

@Mapper("BoardMapper")
public interface IBoardMapper {
	
	public void insertData(BoardDTO bDTO) throws Exception;
	
	public List<BoardDTO> getData() throws Exception;
	
	public BoardDTO boardDetail(BoardDTO bDTO) throws Exception;
	
	public List<BoardDTO> boardAnswerDetail(BoardDTO rDTO) throws Exception;
	
	public int answerInsertData(BoardDTO bDTO) throws Exception;
	
	public int deleteBoard(BoardDTO bDTO) throws Exception;
	
	public int deleteBoardAnswer(BoardDTO bDTO) throws Exception;
	
	public int updateBoard(BoardDTO bDTO) throws Exception;
	
	public int updateBoardAnswer(BoardDTO bDTO) throws Exception;

}
