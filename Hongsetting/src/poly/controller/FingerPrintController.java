package poly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.AttendDTO;
import poly.persistance.mapper.IFingerPrintMapper;
import poly.util.DateUtil;

@Controller
public class FingerPrintController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "FingerPrintMapper")
	private IFingerPrintMapper fingerPrintMapper;
	
	@RequestMapping(value="/fingerPrint/getSession")
	public String getSession(HttpServletRequest request, HttpServletResponse reponse, HttpSession session) { 
		log.info(this.getClass().getName() + ".getSession Start!!");
		String name = request.getParameter("nameId").split("T")[0];
		String id = request.getParameter("nameId").split("T")[1];
		
		log.info("name : " + name);
		log.info("id : " + id);
		
		if(name!=null && id!=null) { 
			log.info("session Start !!");
			session.setAttribute("name", name);
			session.setAttribute("id", id);
		}
		
		log.info(this.getClass().getName() + ".getSession End!!");
		return "/attend/enrollAndprintPage";
	}
	
	@RequestMapping(value="/enrollAndprintPage")
	public String test() {
		
		return "/attend/enrollAndprintPage";
		
	}
	
	@RequestMapping(value="/fingerPrint/logout")
	public String logout(HttpSession session) { 
		log.info(this.getClass().getName() + ".logout Start !!");
		
		session.invalidate();
		
		log.info(this.getClass().getName() + ".logout End !!");
		return "/calendar/mainPage";
	}
	@RequestMapping(value="/fingerPrint/attend")
	public String attend(HttpServletRequest request) throws Exception{
		log.info(this.getClass().getName() + ".attend Start !!");
		
		String id = request.getParameter("id");
		AttendDTO aDTO = new AttendDTO();
		aDTO.setId(id);
		aDTO.setAttendTime(DateUtil.getDateTime("yyyyMMddHHmmss"));
		
		log.info("aDTO.getId() : " + aDTO.getId());
		log.info("aDTO.getAttendTime() : " + aDTO.getAttendTime());
		
		int result = fingerPrintMapper.attend(aDTO);
		
		if(result == 1) { 
			log.info(this.getClass().getName() + ".attend End!!");
			return "success";
		}
		
		log.info(this.getClass().getName() + ".attend End!!");
		return "fail";
	}
	@RequestMapping(value="/fingerprint/getFingerPrintPage")
	public String getFingerPrintPage(HttpServletRequest request, ModelMap model) throws Exception{
		log.info(this.getClass().getName() + ".getFingerPrintPage Start !!");
		
		if(request.getParameter("id").length()>0) { 
			
			log.info("request.getParameter(id)"+request.getParameter("id"));
			AttendDTO aDTO = new AttendDTO();
			aDTO.setId(request.getParameter("id"));
			List<AttendDTO> aList = fingerPrintMapper.getData(aDTO);
			
			int index = 0;
			for(AttendDTO fDTO : aList) { 
				log.info("fDTO.getId() : " + fDTO.getId());
				log.info("fDTO.getAttendTime() : " + fDTO.getAttendTime());
				log.info("fDTO.getName() : " + fDTO.getName());
				log.info("fDTO.getValue() : " + fDTO.getValue());
				
				if(index%2==0) {
					aList.get(index).setAtime("0");
					log.info("fDTO.getAtime() : " + fDTO.getAtime());
					index ++;
				} else {
					int atime = Integer.parseInt(aList.get(index-1).getAttendTime().substring(8,12)) - Integer.parseInt(aList.get(index).getAttendTime().substring(8,12));
					aList.get(index).setAtime(String.valueOf(atime));
					log.info("fDTO.getAtime() : " + fDTO.getAtime());
					index++;
				}
			}
			
			model.addAttribute("aList", aList);
			
			aList = null;
			aDTO = null;
			
			return "/attend/fingerPrint";
		} else { 
			String url = "/calendar/mainPage.do";
			String msg = "로그인이 되어있지 않습니다.";
			
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);
			
			return "/board/redirect";
		}
	}

}
