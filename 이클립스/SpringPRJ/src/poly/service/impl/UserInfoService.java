package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.MailDTO;
import poly.dto.UserInfoDTO;
import poly.persistance.mapper.UserInfoMapper;
import poly.service.IMailService;
import poly.service.IUserInfoService;
import poly.util.CmmUtil;
import poly.util.DateUtil;
import poly.util.EncryptUtil;

@Service("UserInfoService")
public class UserInfoService implements IUserInfoService{
	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="UserInfoMapper")
	private UserInfoMapper userInfoMapper;
	
	@Resource(name = "MailService")
	private IMailService mailService;
	
	@Override
	public int insertUserInfo(UserInfoDTO pDTO) throws Exception { 
		
		log.info(this.getClass().getName() + ".insertUserInfo service start ! ");
		int res = 0;
		
		//---------------------------------------------------------
		log.info(this.getClass().getName() + ".pDTO");
		log.info("user_id : " + pDTO.getUser_id());
		log.info("user_name : " + pDTO.getUser_name());
		log.info("password : " + pDTO.getPassword());
		log.info("email : " + pDTO.getEmail());
		log.info("addr1 : " + pDTO.getAddr1());
		log.info("addr2 : " + pDTO.getAddr2());
		//---------------------------------------------------------
		
		if(pDTO == null) { 
			pDTO = new UserInfoDTO();
		}
		
		//---------------------------------------------------------
		log.info("***********************************");
		log.info("getUserExists start ! ");
		//---------------------------------------------------------
		UserInfoDTO rDTO = userInfoMapper.getUserExists(pDTO);
		
		//---------------------------------------------------------
		log.info(this.getClass().getName() + ".getUserExists rDTO");
		log.info("user_id : " + rDTO.getUser_id());
		log.info("user_name : " + rDTO.getUser_name());
		log.info("password : " + rDTO.getPassword());
		log.info("email : " + rDTO.getEmail());
		log.info("addr1 : " + rDTO.getAddr1());
		log.info("addr2 : " + rDTO.getAddr2());
		log.info("getUserExists end ! ");
		log.info("***********************************");
		//---------------------------------------------------------
		
		if(rDTO==null) { 
			rDTO = new UserInfoDTO();
		}
		
		if(CmmUtil.nvl(rDTO.getExists_yn()).equals("Y")) { 
			res = 2;
			log.info("rDTO.getExists = Y /// res : " + rDTO.getExists_yn());
		} else { 
			
			log.info("rDTO.getExists = N /// res : " + rDTO.getExists_yn());
			
			log.info("***********************************");
			log.info("insertUserInfo start ! ");
			int success = userInfoMapper.insertUserInfo(pDTO);
			log.info("insertUserInfo end ! ");
			log.info("***********************************");
			
			if(success > 0) { 
				res = 1;
				log.info("success ");
				
				/* #####################################################
				 * 						메일 발송 로직 추가 시작 !!
				 * #####################################################
				 */
				
				MailDTO mDTO = new MailDTO();
				
				mDTO.setToMail(EncryptUtil.decAES128CBC(CmmUtil.nvl(pDTO.getEmail())));
				
				mDTO.setTitle("회원가입을 축하드립니다.");
				
				mDTO.setContents(CmmUtil.nvl(pDTO.getUser_name()) + "님의 회원가입을 진심으로 축하드립니다.");
				
				mailService.doSendMail(mDTO);
				
			} else { 
				log.info("fail ");
				res = 0;
			}
		}
		
		return res;
	}
	@Override
	public int getUserLoginCheck(UserInfoDTO pDTO) throws Exception { 
		int res = 0;
		
		UserInfoDTO rDTO = userInfoMapper.getUserLoginCheck(pDTO);
		
		if(rDTO == null) { 
			rDTO = new UserInfoDTO();
		}
		
		if(CmmUtil.nvl(rDTO.getUser_id()).length()>0) { 
			res = 1;
			
			/* #####################################################
			 * 						메일 발송 로직 추가 시작 !!
			 * #####################################################
			 */
			
			MailDTO mDTO = new MailDTO();
			
			mDTO.setToMail(EncryptUtil.decAES128CBC(CmmUtil.nvl(rDTO.getEmail())));
			
			mDTO.setTitle("로그인 알림 !");
			
			mDTO.setContents(DateUtil.getDateTime("yyyy.MM.dd 24h:mm:ss") + "에" + CmmUtil.nvl(rDTO.getUser_name()) + "님의 로그인하셨습니다.");
			
			mailService.doSendMail(mDTO);
			
			/* #####################################################
			 * 						메일 발송 로직 추가 끝 !!
			 * #####################################################
			 */
		}
		return res;
	}

}
