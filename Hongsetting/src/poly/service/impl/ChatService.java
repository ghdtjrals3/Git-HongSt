package poly.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import poly.dto.ChatFoodDTO;
import poly.dto.HaksaDTO;
import poly.persistance.mongo.IChatMapper;
import poly.service.IChatService;
import poly.util.CmmUtil;
import poly.util.DateUtil;



@Service("ChatService")
public class ChatService implements IChatService{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "ChatMapper")
	private IChatMapper chatMapper;

	@Override
	@Scheduled(cron = "0 00 11 * * *")
	public int collecMenu() throws Exception { 
		log.info(this.getClass().getName() + ".collectMenu Start !!");
		int res = 0;
		
		List<Map<String, Object>> pList = new LinkedList<Map<String, Object>>();
		
		String url = "https://www.kopo.ac.kr/kangseo/content.do?menu=262";
		
		Document doc = null;
		
		doc = Jsoup.connect(url).get();
		
		Elements element = doc.select("table.tbl_table");
		
		log.info(element);
		
		
		Iterator<Element> food_name = element.select("tbody > tr").iterator();
		
		
		ChatFoodDTO fDTO = null;
		int seq = 1;
		while(food_name.hasNext()) { 
			fDTO = new ChatFoodDTO();
			String food = CmmUtil.nvl(food_name.next().text());
			String foodName = food;
			if(food.substring(0,3).equals("토요일")) { 
				break;
			}
			fDTO.setDay(food.substring(0,3));
			fDTO.setFoodName(foodName.substring(3,foodName.length()).trim());
			fDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			fDTO.setSeq(String.valueOf(seq));
			seq++;
			log.info(fDTO.getSeq());
			log.info(fDTO.getDay());
			log.info(fDTO.getFoodName());
			log.info(fDTO.getCollectTime());
			
			Map<String, Object> fMap = new LinkedHashMap<String, Object>();
			fMap.put("collectTime", fDTO.getCollectTime());
			fMap.put("day", fDTO.getDay());
			fMap.put("foodName", fDTO.getFoodName());
			fMap.put("seq", fDTO.getSeq());
			
			pList.add(fMap);
			fMap = null;
		}
		doc = null;
		String colNm = "FOOD_" + DateUtil.getDateTime("yyyyMMdd");
		res = chatMapper.insertData(pList, colNm);
		
		
		log.info(this.getClass().getName() + ".collectMenu End !!");
		
		return res;
	}

	@Override
	public List<Map<String, String>> getFoodList() throws Exception {
		log.info(this.getClass().getName() + ".getFoodList Start !!");
		String colNm = "FOOD_" + DateUtil.getDateTime("yyyyMMdd");
		
		List<Map<String, String>> rList = chatMapper.getFoodList(colNm);
		
		log.info("I'm not null");
		if(rList == null) { 
			log.info("I'm null");
			rList = new LinkedList<Map<String, String>>();
		}
		for(Map<String, String> fMap : rList) { 
			log.info("foodName : " + fMap.get("foodName"));
			log.info("day : " + fMap.get("day"));
		}
		
		log.info(this.getClass().getName() + ".getFoodList End !!");
		return rList;
	}

	@Override
	@Scheduled(cron = "0 00 11 * * *")
	public int collectHaksa() throws Exception {
		log.info(this.getClass().getName() + ".collectHaksa Start !!");
		int res = 0;
		
		List<Map<String, Object>> pList = new LinkedList<Map<String, Object>>();
		
		String url = "https://www.kopo.ac.kr/kangseo/content.do?menu=274";
		
		Document doc = null;
		
		doc = Jsoup.connect(url).get();
		
		Elements element = doc.select("div.calendar_con>.cl_ev>ul");
		
		/*log.info(element);*/
		
		
		Iterator<Element> haksa = element.select("li > div > span.date").iterator();
		Iterator<Element> haksa2 = element.select("li > div > span.event").iterator();
		
		
		HaksaDTO hDTO = null;
		int seq = 1;
		while(haksa.hasNext()) { 
			hDTO = new HaksaDTO();
			String day = haksa.next().html();
			String iljeong = haksa2.next().html();
			
			hDTO.setDay(day.substring(31,41) + " ~ " + day.substring(44,54));
			hDTO.setIljeong(iljeong);
			hDTO.setCollectTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			
			log.info("getDay : " + hDTO.getDay());
			log.info("getIljeong : " + hDTO.getIljeong());
			
			
			Map<String, Object> fMap = new LinkedHashMap<String, Object>();
			fMap.put("day", hDTO.getDay());
			fMap.put("iljeong", hDTO.getIljeong());
			
			pList.add(fMap);
			fMap = null;
		}
		doc = null;
		String colNm = "HAKSA_" + DateUtil.getDateTime("yyyyMMdd");
		res = chatMapper.insertHaksaData(pList, colNm);
		
		
		log.info(this.getClass().getName() + ".collectHaksa End !!");
		
		return res;
	}

	@Override
	public List<Map<String, String>> getHaksaList() throws Exception {
		log.info(this.getClass().getName() + ".getHaksaList Start !!");
		String colNm = "HAKSA_" + DateUtil.getDateTime("yyyyMMdd");
		
		List<Map<String, String>> rList = chatMapper.getHaksaList(colNm);
		
		log.info("I'm not null");
		if(rList == null) { 
			log.info("I'm null");
			rList = new LinkedList<Map<String, String>>();
		}
		for(Map<String, String> fMap : rList) { 
			log.info("day : " + fMap.get("day"));
			log.info("iljeong : " + fMap.get("iljeong"));
		}
		
		log.info(this.getClass().getName() + ".getHaksaList End !!");
		return rList;
	}

}
