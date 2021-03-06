package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.UserInfoDTO;
import poly.service.IUserInfoService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Controller
public class UserInfoController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "UserInfoService")
	private IUserInfoService userInfoService;
	
	@RequestMapping(value = "user/userRegForm")
	public String userRegForm() { 
		log.info(this.getClass().getName() + ".user/userRegForm ok !");
		
		return "/user/UserRegForm";
	}
	
	@RequestMapping(value = "user/insertUserInfo")
	public String insertUserInfo(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception { 
		log.info(this.getClass().getName() + ".insertUserInfo start!");
		
		String msg = "";
		
		UserInfoDTO pDTO = null;
		
		try { 
			String user_id = CmmUtil.nvl(request.getParameter("user_id"));
			String user_name = CmmUtil.nvl(request.getParameter("user_name"));
			String password = CmmUtil.nvl(request.getParameter("password"));
			String email = CmmUtil.nvl(request.getParameter("email"));
			String addr1 = CmmUtil.nvl(request.getParameter("addr1"));
			String addr2 = CmmUtil.nvl(request.getParameter("addr2"));
			
			/*
			 JSP에서 잘 받았는 지 확인하는 로그
			 */
			log.info("*********************************** JSP에서 받았다");
			log.info("user_id : " + user_id);
			log.info("user_name : " + user_name);
			log.info("password : " + password);
			log.info("email : " + email);
			log.info("addr1 : " + addr1);
			log.info("addr2 : " + addr2);
			
			pDTO = new UserInfoDTO();
			
			pDTO.setUser_id(user_id);
			pDTO.setUser_name(user_name);
			pDTO.setPassword(EncryptUtil.encHashSHA256(password));
			pDTO.setEmail(EncryptUtil.encAES128CBC(email));
			pDTO.setAddr1(addr1);
			pDTO.setAddr2(addr2);
			
			int res = userInfoService.insertUserInfo(pDTO);
			
			log.info("*********************************** insertUserInfo에서 받았다");
			log.info("user_id : " + pDTO.getUser_id());
			log.info("user_name : " + pDTO.getUser_name());
			log.info("password : " + pDTO.getPassword());
			log.info("email : " + pDTO.getEmail());
			log.info("addr1 : " + pDTO.getAddr1());
			log.info("addr2 : " + pDTO.getAddr2());

			
			log.info(this.getClass().getName() + " res : " + res);
			
			if(res==1) { 
				msg = "회원가입되었습니다.";
				
			} else if (res==2) { 
				msg = "이미 가입된 이메일 주소입니다.";
			} else { 
				msg = "오류로 인해 회원가입이 실패했습니다.";
			}
		} catch(Exception e) { 
			msg = "실패하였습니다. : " + e.toString();
			log.info(e.toString());
			e.printStackTrace();
		} finally { 
			log.info(this.getClass().getName() + ".insertUserInfo end ! ");
			
			model.addAttribute("msg", msg);
			model.addAttribute("pDTO", pDTO);
			
			pDTO = null;
		}
		return "/user/Msg";
	}
	
	@RequestMapping(value = "user/loginForm")
	public String loginForm() {
		log.info(this.getClass().getName() + " .yser/loginForm ok ! ");
		
		return "/user/LoginForm";
	}
	@RequestMapping(value = "user/getUserLoginCheck")
	public String getUserLoginCheck(HttpSession session, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".getUserLoginCheck start ! ");
		
		int res = 0;
		
		UserInfoDTO pDTO = null;
		
		try { 
			String user_id = CmmUtil.nvl(request.getParameter("user_id"));
			String password = CmmUtil.nvl(request.getParameter("password"));
			
			log.info("user_id : " + user_id);
			log.info("password : " + password);
			
			pDTO = new UserInfoDTO();
			pDTO.setUser_id(user_id);
			pDTO.setPassword(EncryptUtil.encHashSHA256(password));

			res = userInfoService.getUserLoginCheck(pDTO);
			
			if(res == 1) { 
				session.setAttribute("SS_USER_ID", user_id);
			}
		} catch (Exception e) {
			res = 2;
			log.info(e.toString());
			e.printStackTrace();
		} finally {
			log.info(this.getClass().getName() + ".insertUserInfo end !");
			model.addAttribute("res", String.valueOf(res));
			
			pDTO = null;
		}
		return "/user/LoginResult";
	}
}
