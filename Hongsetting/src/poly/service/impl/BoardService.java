package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.BoardDTO;
import poly.persistance.mapper.IBoardMapper;
import poly.service.IBoardService;

@Service("BoardService")
public class BoardService implements IBoardService{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "BoardMapper")
	private IBoardMapper boardMapper;

	@Override
	public String insertData(BoardDTO bDTO) throws Exception {
		log.info(this.getClass().getName() + ".insertData Start !");
		
		if(bDTO==null) {
			log.info("bDTO is null");
			bDTO = new BoardDTO();
			log.info(this.getClass().getName() + ".insertData End !");
			
			return "fail";
		} else { 
			log.info("reg_name : " + bDTO.getReg_name() + " | title : " + bDTO.getTitle()+ " | content : " + bDTO.getContent());
			boardMapper.insertData(bDTO);
			log.info(this.getClass().getName() + ".insertData End !");
			return "success";
		}
		
	}

	@Override
	public List<BoardDTO> getData() throws Exception {
		log.info(this.getClass().getName() + ".getData Start !");
		
		
		log.info(this.getClass().getName() + ".getData End !");
		return boardMapper.getData();
	}

}
