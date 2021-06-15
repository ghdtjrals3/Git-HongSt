package poly.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.service.IBoardService;
import poly.service.IChatService;


@Controller
public class ChatController {

private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "ChatService")
	private IChatService chatService;

	@RequestMapping(value = "/chatbot/getChatbotPage")
	public String getChatbotPage(HttpServletRequest request, HttpServletResponse reponse)
		throws Exception {
		log.info(this.getClass().getName() + ".getChatbotPage Start !!");
		
		log.info(this.getClass().getName() + ".getChatbotPage End !!");
		return "/chatbot/chatbot";
	}
	
	@RequestMapping(value = "/chatbot/collectMenu")
	@ResponseBody
	public String collectMenu() throws Exception{ 
		log.info(this.getClass().getName() + ".collectMenu Start");
		
		chatService.collecMenu();
		
		log.info(this.getClass().getName() + ".collectMenu End");
		return "success";
	}
	
	@RequestMapping(value = "/chatbot/collectHaksa")
	@ResponseBody
	public String collectHaksa() throws Exception{ 
		log.info(this.getClass().getName() + ".collectHaksa Start");
		
		chatService.collectHaksa();
		
		log.info(this.getClass().getName() + ".collectHaksa End");
		return "success";
	}
	
	@RequestMapping(value = "/chatbot/resultPage")
	public String resultPage(HttpServletRequest request, HttpServletResponse reponse) throws Exception { 
		log.info(this.getClass().getName() + ".resultPage Start !!");
		
		log.info(this.getClass().getName() + ".resultPage End !!");
		return "";
	}
	
	@RequestMapping(value = "/chatbot/getFoodList")
	@ResponseBody
	public List<Map<String, String>> getFoodList(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		log.info(this.getClass().getName() + ".getFoodList Start !!");
		
		List<Map<String, String>> rList = chatService.getFoodList();
		
		for(Map<String, String> fMap : rList) { 
			log.info("foodName : " + fMap.get("foodName"));
		}
		
		log.info(this.getClass().getName() + ".getFoodList End !!");
		
		return rList;

	}
	
	@RequestMapping(value = "/chatbot/getHaksaList")
	@ResponseBody
	public List<Map<String, String>> getHaksaList(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		log.info(this.getClass().getName() + ".getHaksaList Start !!");
		
		List<Map<String, String>> rList = chatService.getHaksaList();
		
		for(Map<String, String> fMap : rList) { 
			log.info("day : " + fMap.get("day"));
			log.info("iljeong : " + fMap.get("iljeong"));
		}
		
		log.info(this.getClass().getName() + ".getHaksaList End !!");
		
		return rList;

	}
	
	@RequestMapping(value = "/chatbot/handMadeChatbot")
	public String handMadeChatbot(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		log.info(this.getClass().getName() + ".handMadeChatbot Start !!");
		
		
		log.info(this.getClass().getName() + ".handMadeChatbot End !!");
		return "/chatbot/handMadeChatbot";
	}
	
	@RequestMapping(value="/chatbot/haksikFood", produces = "application/text;charset=utf8")
	@ResponseBody
	public String haksikFood(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		log.info(this.getClass().getName() + ".haksikFood Start !!");
		
		String day = request.getParameter("day");
		log.info("day : " + day);
		List<Map<String, String>> rList = chatService.getFoodList();
		
		for(Map<String, String> fMap : rList) { 
			log.info("fMap.get(day) : " + fMap.get("day"));
			if(day.equals(fMap.get("day").toString())) { 
				log.info("fMap.get(foodName) : " + fMap.get("foodName"));
				log.info(this.getClass().getName() + ".haksikFood End !!");
				return fMap.get("foodName").toString();
			}
		}
		
		log.info(this.getClass().getName() + ".haksikFood End !!");
		return "fail";
	}
	@RequestMapping(value="/chatbot/haksa")
	@ResponseBody
	public List<Map<String, String>> haksa(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		log.info(this.getClass().getName() + ".haksa Start !!");
		
		List<Map<String, String>> rList = chatService.getHaksaList();
		
		for(Map<String, String> fMap : rList) { 
			log.info("fMap.get(day) : " + fMap.get("day"));
			log.info("fMap.get(iljeong) : " + fMap.get("iljeong"));
		}
		
		log.info(this.getClass().getName() + ".haksa End !!");
		return rList;
	}
}
