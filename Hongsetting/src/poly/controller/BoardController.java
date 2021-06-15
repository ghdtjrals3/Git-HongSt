package poly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.BoardDTO;
import poly.persistance.mapper.IBoardMapper;
import poly.service.IBoardService;
import poly.util.DateUtil;

@Controller
public class BoardController {
	
	private Logger log = Logger.getLogger(this.getClass());
	

	@Resource(name = "BoardService")
	private IBoardService boardService;
	
	@Resource(name = "BoardMapper")
	private IBoardMapper boardMappper;
	
	
	@RequestMapping(value = "/board/getBoardPage")
	public String getBoardPage(HttpServletRequest request, HttpServletResponse reponse, ModelMap model)
		throws Exception {
		log.info(this.getClass().getName() + ".getBoardPage Start !!");
		
		List<BoardDTO> bList = boardService.getData();
		
		for(BoardDTO bDTO : bList) { 
			log.info(bDTO.getTitle());
		}
		
		model.addAttribute("bList", bList);
		
		bList = null;
		
		log.info(this.getClass().getName() + ".getBoardPage End !!");
		return "/board/board";
	}
	
	@RequestMapping(value = "/board/getBoardPage/insertPage")
	public String insertPage(HttpServletRequest request, HttpServletResponse reponse)
		throws Exception {
		log.info(this.getClass().getName() + ".insertPage Start !!");
		
		log.info(this.getClass().getName() + ".insertPage End !!");
		return "/board/insertData";
	}
	
	@RequestMapping(value = "/board/getBoardPage/insertPage/insertData")
	public String insertData(HttpServletRequest request, HttpServletResponse reponse, ModelMap model) throws Exception { 
		log.info(this.getClass().getName() + ".insertData Start !!");
		
		BoardDTO bDTO = new BoardDTO();
		
		String reg_name = request.getParameter("reg_name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String value = "1";
		
		if(reg_name.contains("& lt;") || reg_name.contains("& gt;") || reg_name.contains("& #40;") || reg_name.contains("& #41;") || reg_name.contains("& #39;")){ 
			reg_name = reg_name.replaceAll("& lt;", "<");
			reg_name = reg_name.replaceAll("& gt;", ">");
			reg_name = reg_name.replaceAll("& #40;", "(");
			reg_name = reg_name.replaceAll("& #41;", ")");
			reg_name = reg_name.replaceAll("& #39;", "'");
		}
		if(title.contains("& lt;") || title.contains("& gt;") || title.contains("& #40;") || title.contains("& #41;") || title.contains("& #39;")) { 
			title = title.replaceAll("& lt;", "<");
			title = title.replaceAll("& gt;", ">");
			title = title.replaceAll("& #40;", "(");
			title = title.replaceAll("& #41;", ")");
			title = title.replaceAll("& #39;", "'");
		}
		if(content.contains("& lt;") || content.contains("& gt;") || content.contains("& #40;") || content.contains("& #41;") || content.contains("& #39;")) { 
			content = content.replaceAll("& lt;", "<");
			content = content.replaceAll("& gt;", ">");
			content = content.replaceAll("& #40;", "(");
			content = content.replaceAll("& #41;", ")");
			content = content.replaceAll("& #39;", "'");
		}
		bDTO.setReg_name(reg_name);
		bDTO.setTitle(title);
		bDTO.setContent(content);
		bDTO.setValue(value);
		bDTO.setReg_date(DateUtil.getDateTime("yyyy-MM-dd"));

		log.info("reg_name : " + reg_name + " | title : " + title + " | content : " + content);
		
		String result = boardService.insertData(bDTO);
		
		log.info("result : " + result);
		
		String url = "/board/getBoardPage.do";
		
		if(result.equals("success")) { 
			model.addAttribute("msg", "등록에 성공했습니다.");
			model.addAttribute("url", url);
		} else { 
			model.addAttribute("msg", "등록에 실패했습니다.");
			model.addAttribute("url", url);
		}
		
		log.info(this.getClass().getName() + ".insertData End !!");
		return "/board/redirect";
	}
	
	@RequestMapping(value="board/boardDetail")
	public String boardDetail(HttpServletRequest request, ModelMap model) throws Exception{ 
		log.info(this.getClass().getName() + ".boardDetail start!!");
		
		String qst_seq = request.getParameter("qst_seq");
		BoardDTO rDTO = new BoardDTO();
		
		rDTO.setQst_seq(qst_seq);
		log.info("qst_seq : " + rDTO.getQst_seq());
		
		BoardDTO bDTO = boardMappper.boardDetail(rDTO);
		List<BoardDTO> aList = boardMappper.boardAnswerDetail(rDTO);
		
		if(bDTO == null && aList == null) {
			model.addAttribute("msg", "메인페이지로 넘어갑니다.");
			model.addAttribute("url", "/board/getBoardPage.do");
				
			return "/board/redirect";
		}
		
		model.addAttribute("aList",aList);
		model.addAttribute("bDTO", bDTO);
		
		/*for(BoardDTO tDTO : aList) { 
			log.info(tDTO.getReg_name());
		}
		log.info("title : " + bDTO.getTitle() + " | content : " + bDTO.getContent() + " | name : " + bDTO.getReg_name());*/
		
		log.info(this.getClass().getName() + ".boardDetail End!!");
		return "/board/boardDetail";
	}

	@RequestMapping(value="board/boardAnswer")
	public String boardAnswer(HttpServletRequest request, ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".boardAnswer Start !!");
		
		log.info(this.getClass().getName() + ".boardAnswer End !!");
		return "/board/boardAnswer";
	}
	
	@RequestMapping(value="board/boardDetail/insertData")
	public String answerInsertData(HttpServletRequest request, ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".answerData Start !");
		
		BoardDTO bDTO = new BoardDTO();
		
		String reg_name = request.getParameter("reg_name");
		String content = request.getParameter("content");
		String rfe_seq = request.getParameter("rfe_seq");
		String value = "2";
		
		if(content.contains("& lt;") || content.contains("& gt;") || content.contains("& #40;") || content.contains("& #41;")  || content.contains("& #39;")) { 
			content = content.replaceAll("& lt;", "<");
			content = content.replaceAll("& gt;", ">");
			content = content.replaceAll("& #40;", "(");
			content = content.replaceAll("& #41;", ")");
			content = content.replaceAll("& #39", "'");
		}
		
		log.info("content : " + content);
		log.info("rfe_seq : " + rfe_seq);
		
		bDTO.setRfe_seq(rfe_seq);
		bDTO.setReg_name(reg_name);
		bDTO.setContent(content);
		bDTO.setValue(value);
		bDTO.setReg_date(DateUtil.getDateTime("yyyy-MM-dd"));
		
		String url = "/board/boardDetail.do?qst_seq="+rfe_seq;
		
		int result = boardMappper.answerInsertData(bDTO);
		if(result==1) { 
			model.addAttribute("msg", "등록에 성공했습니다.");
			model.addAttribute("url", url);
		} else { 
			model.addAttribute("msg", "등록에 실패했습니다.");
			model.addAttribute("url", url);
		}
		
		log.info(this.getClass().getName() + ".answerData End !");
		return "/board/redirect";
	}
	
	@RequestMapping(value="/board/deleteBoard")
	public String deleteBoard(HttpServletRequest request, ModelMap model) throws Exception { 
		log.info(this.getClass().getName() + ".deleteBoard start !!");
		
		BoardDTO bDTO = new BoardDTO();
		
		String qst_seq = request.getParameter("qst_seq");
		String rfe_seq = qst_seq;
		
		bDTO.setQst_seq(qst_seq);
		bDTO.setRfe_seq(rfe_seq);
		bDTO.setValue("2");
		
		int result = boardMappper.deleteBoard(bDTO);
		
		String url = "/board/getBoardPage.do";
		model.addAttribute("msg", "삭제에 성공했습니다.");
		model.addAttribute("url", url);

		log.info(this.getClass().getName() + ".deleteBoard end !!");
		return "/board/redirect";
	}
	
	@RequestMapping(value="/board/deleteBoardAnswer")
	public String deleteBoardAnswer(HttpServletRequest request, ModelMap model)throws Exception {
		log.info(this.getClass().getName() + ".deleteBoardAnswer Start !!");
		BoardDTO bDTO = new BoardDTO();
		
		String qst_seq = request.getParameter("qst_seq");
		bDTO.setQst_seq(qst_seq);
		log.info("qst_seq : " + bDTO.getQst_seq());
		
		int result = boardMappper.deleteBoardAnswer(bDTO);
		
		String url = "/board/getBoardPage.do";
		model.addAttribute("msg", "삭제에 성공했습니다.");
		model.addAttribute("url", url);
		
		log.info(this.getClass().getName() + ".deleteBoardAnswer End !!");
		return "/board/redirect";
	}
	
	@RequestMapping(value="/board/updateBoardPage")
	public String updateBoardPage(HttpServletRequest request, ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".updateBoardPage Start !!");
		String qst_seq = request.getParameter("qst_seq");
		model.addAttribute("qst_seq", qst_seq);
		log.info(this.getClass().getName() + ".updateBoardPage End !!");
		return "/board/updateData";
	}
	
	@RequestMapping(value="/board/updateBoard")
	public String updateBoard(HttpServletRequest request, ModelMap model) throws Exception { 
		log.info(this.getClass().getName() + ".updateBoard start !!");
		
		BoardDTO bDTO = new BoardDTO();
		
		String qst_seq = request.getParameter("qst_seq");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(title.contains("& lt;") || title.contains("& gt;") || title.contains("& #40;") || title.contains("& #41;") || title.contains("& #39;")) { 
			title = title.replaceAll("& lt;", "<");
			title = title.replaceAll("& gt;", ">");
			title = title.replaceAll("& #40;", "(");
			title = title.replaceAll("& #41;", ")");
			title = title.replaceAll("& #39;", "'");
		}
		if(content.contains("& lt;") || content.contains("& gt;") || content.contains("& #40;") || content.contains("& #41;") || content.contains("& #39;")) { 
			content = content.replaceAll("& lt;", "<");
			content = content.replaceAll("& gt;", ">");
			content = content.replaceAll("& #40;", "(");
			content = content.replaceAll("& #41;", ")");
			content = content.replaceAll("& #39;", "'");
		}
		
		bDTO.setQst_seq(qst_seq);
		bDTO.setTitle(title);
		bDTO.setContent(content);
		bDTO.setValue("1");
		
		
		int result = boardMappper.updateBoard(bDTO);
		
		if(result == 1) { 
			
			String url = "/board/getBoardPage.do";
			model.addAttribute("msg", "수정에 성공했습니다.");
			model.addAttribute("url", url);
		} else { 
			String url = "/board/getBoardPage.do";
			model.addAttribute("msg", "수정에 실패했습니다.");
			model.addAttribute("url", url);
		}

		log.info(this.getClass().getName() + ".updateBoard end !!");
		return "/board/redirect";
	}
	@RequestMapping(value="/board/updateBoardAnswerPage")
	public String updateBoardAnswerPage(HttpServletRequest request, ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".updateBoardAnswerPage Start !!");
		String qst_seq = request.getParameter("qst_seq");
		model.addAttribute("qst_seq", qst_seq);
		log.info(this.getClass().getName() + ".updateBoardPage End !!");
		return "/board/updateDataAnswer";
	}
	
	@RequestMapping(value="/board/updateBoardAnswer")
	public String updateBoardAnswer(HttpServletRequest request, ModelMap model) throws Exception { 
		log.info(this.getClass().getName() + ".updateBoardAnswer start !!");
		
		BoardDTO bDTO = new BoardDTO();
		
		String qst_seq = request.getParameter("qst_seq");
		String content = request.getParameter("content");
		
		
		bDTO.setQst_seq(qst_seq);
		bDTO.setContent(content);
		bDTO.setValue("2");
		
		int result = boardMappper.updateBoardAnswer(bDTO);
		
		if(result == 1) { 
			
			String url = "/board/getBoardPage.do";
			model.addAttribute("msg", "수정에 성공했습니다.");
			model.addAttribute("url", url);
		} else { 
			String url = "/board/getBoardPage.do";
			model.addAttribute("msg", "수정에 실패했습니다.");
			model.addAttribute("url", url);
		}

		log.info(this.getClass().getName() + ".updateBoardAnswer end !!");
		return "/board/redirect";
	}
	
	@RequestMapping(value="/redirect")
	@ResponseBody
	public Object re(Object a) throws Exception {
		log.info("asdasdasd");
		
		return a;
	}
}
