package poly.service.impl;

import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.dto.FoodDTO;
import poly.persistance.mapper.IFoodMapper;
import poly.service.IFoodService;
import poly.util.CmmUtil;
import poly.util.DateUtil;

@Service("FoodService")
public class FoodSerivce implements IFoodService{
	
	@Resource(name="FoodMapper")
	private IFoodMapper foodMapper;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	
	public int getFoodInfoFromWEB() throws Exception {
		log.info(this.getClass().getName() + ".getMovieInfoFromWEB start !");
		
		int res = 0;
		
		String url = "http://www.kopo.ac.kr/kangseo/content.do?menu=262";
		Document doc = null;
		doc = Jsoup.connect(url).get();
		
		Elements element = doc.select("div.meal_box");
		
		log.info(element);
		
		Iterator<Element> food_nm = element.select("tbody tr td:nth-child(3)").iterator();
		Iterator<Element> day = element.select("tbody tr td:nth-child(1)").iterator();
		FoodDTO pDTO = null;
		
		while(day.hasNext()) {
			
			pDTO = new FoodDTO();
				
			pDTO.setCollect_time(DateUtil.getDateTime("yyyyMMdd24hmmss"));
				
			pDTO.setDay(CmmUtil.nvl(day.next().text()));
				
			pDTO.setFood_name(CmmUtil.nvl(food_nm.next().text()));
				
			pDTO.setReg_id("admin");
				
			log.info("collect_time : "+pDTO.getCollect_time());
			log.info("day : "+pDTO.getDay());
			log.info("food_name : "+pDTO.getFood_name());
			log.info("reg_id : "+pDTO.getReg_id());
			
			if(pDTO.getFood_name().equals("")) { 
				break;
			}
				
			res += foodMapper.InsertFoodInfo(pDTO);
			
			
		}
		log.info(this.getClass().getName() + ".getFoodInfoFromWEB end ! ");
		return res;
		
	}


}
