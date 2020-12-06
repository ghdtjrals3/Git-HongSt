package poly.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.dto.OcrDTO;
import poly.persistance.mapper.IOcrMapper;
import poly.service.IOcrService;
import poly.util.CmmUtil;
import poly.util.DateUtil;
import poly.util.FileUtil;

@Controller
public class OcrController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "OcrService")
	private IOcrService ocrService;
	
	@Resource(name = "OcrMapper")
	private IOcrMapper ocrMapper;
	
	final private String FILE_UPLOAD_SAVE_PATH = "c:/upload";
	
	@RequestMapping(value = "ocr/imageFileUpload")
	public String Index() { 
		log.info(this.getClass().getName() + ".imageFileUpload !");
		
		return "/ocr/ImageFileUpload";
	}
	
	@RequestMapping(value = "ocr/getReadforImageText")
	public String getReadforImageText(HttpServletRequest request, HttpServletResponse reponse,
			ModelMap model, @RequestParam(value = "fileUpload") MultipartFile mf) throws Exception {
		
		log.info(this.getClass().getName() + ".getReadforImageText start ! ");
		
		String res = "";
		
		String originalFileName = mf.getOriginalFilename();
		
		log.info("mf.getOriginalFilename : " + mf.getOriginalFilename());
		
		String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length()).toLowerCase();
		
		if(ext.equals("jpeg") || ext.equals("jpg") || ext.equals("gif") || ext.equals("png"))  {
			
			String saveFilename = DateUtil.getDateTime("24hhmmss") + "." + ext;
			
			String saveFilePath = FileUtil.mkdirForDate(FILE_UPLOAD_SAVE_PATH);
			
			String fullFileInfo = saveFilePath + "/" + saveFilename;
			
			log.info("ext : " + ext);
			log.info("saveFileName : " + saveFilename);
			log.info("saveFilePath : " + saveFilePath);
			log.info("fullFileInfo : " + fullFileInfo);
			
			mf.transferTo(new File(fullFileInfo));
			
			OcrDTO pDTO = new OcrDTO();
			
			pDTO.setFileName(saveFilename);
			pDTO.setFilePath(saveFilePath);
			
			OcrDTO rDTO = ocrService.getReadforImageText(pDTO);
			
			if(rDTO == null) { 
				rDTO = new OcrDTO();
			}
			
			res = CmmUtil.nvl(rDTO.getTextFromImage());
			
			//Mapper에 넣을 DTO 생성
			String reg_id = "admin";
			
			log.info("DB 삽입전 res : " + res);
			
			OcrDTO mDTO = new OcrDTO();
			mDTO.setSave_file_name(saveFilename);
			mDTO.setSave_file_path(saveFilePath);
			mDTO.setOrg_file_name(originalFileName);
			mDTO.setExt1(ext);
			mDTO.setOcr_text(res);
			mDTO.setReg_id(reg_id);
			mDTO.setChg_id(reg_id);
			mDTO.setReg_dt(DateUtil.getDateTime("24hhmmss"));
			
			int result = ocrMapper.insertImageInfo(mDTO);
			
			if(result==1) { 
				log.info(result + "데이터 삽입 성공");
			} else { 
				log.info(result + "데이터 삽입 실패");
			}
			
	
			
			//
			rDTO = null;
			pDTO = null;
			
		}else { 
			res = "이미지 파일이 아니라서 인식이 불가능합니다.";
		}
		
		model.addAttribute("res",res);
		
		log.info(this.getClass().getName() + ".getReadforImageText end !");
		
		return "/ocr/TextFromImage";
	}
	
}
