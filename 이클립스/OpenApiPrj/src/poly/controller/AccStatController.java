package poly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.AccStatDTO;
import poly.service.impl.AccStatService;
import poly.util.CmmUtil;

@Controller
public class AccStatController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "AccStatService")
	private AccStatService accStatService;
	
	@RequestMapping(value = "accStat/getAccStatInfo")
	@ResponseBody
	public Map<String, Object> getAccStatInfo(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		log.info(this.getClass().getName() + ".getAccStatInfo start ! ");
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		String yyyymm = CmmUtil.nvl(request.getParameter("yyyymm"));

		String a_code = CmmUtil.nvl(request.getParameter("a_code"));
		
		AccStatDTO pDTO = new AccStatDTO();
		
		pDTO.setYyyymm(yyyymm);
		pDTO.setA_code(a_code);
		
		List<AccStatDTO> rList = accStatService.getAccStatInfo(pDTO);
		
		if(rList == null) { 
			rList = new ArrayList<AccStatDTO>();
		}
		
		rMap.put("reqYYYYMM", yyyymm);
		rMap.put("reqAcode", a_code);
		rMap.put("recordCnt", rList.size());
		rMap.put("res", rList);
		
		log.info(this.getClass().getName() + ".getAccStatInfo end !");
		
		return rMap;
	}
	
}
