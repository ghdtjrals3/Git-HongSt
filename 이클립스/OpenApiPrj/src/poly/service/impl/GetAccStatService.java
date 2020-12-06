package poly.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import poly.dto.AccStatDTO;
import poly.service.IGetAccStatService;
import poly.util.CmmUtil;

@Service("GetAccStatService")
public class GetAccStatService implements IGetAccStatService{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private String getUrlForJSON(String callUrl) { 
		
		log.info(this.getClass().getName() + ".getUrlForJSON start !");
		
		log.info("Requested URL : " + callUrl );
		
		StringBuilder sb =new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		
		String json = "";
		
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		
		try { 
			URL url = new URL(callUrl);
			
			urlConn = url.openConnection();
			
			if(urlConn != null) { 
				urlConn.setReadTimeout(60 * 1000);
			}
			if(urlConn != null && urlConn.getInputStream() != null) { 
				in = new InputStreamReader(urlConn.getInputStream(), Charset.forName("UTF-8"));
				
				BufferedReader bufferedReader = new BufferedReader(in);
				
				if(bufferedReader != null) { 
					int cp;
					while ((cp = bufferedReader.read()) != -1) { 
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			in.close();
		} catch (Exception e) { 
			throw new RuntimeException("Exception URL : " + callUrl, e);
		}
		
		json = sb.toString();
		log.info("JSON result : " + json);
		log.info(this.getClass().getName() + ".getUrlForJson End !");
		
		return json;
	}
	
	@Override
	public Map<String, Object> getAccStatForJSON(AccStatDTO pDTO) throws Exception { 
		log.info(this.getClass().getName() + ".getAccstatForJSON start !");
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		String json = getUrlForJSON(CmmUtil.nvl(pDTO.getUrl()));
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(json);
		
		JSONObject jsonObject = (JSONObject) obj;
		
		String reqYYYYMM = CmmUtil.nvl((String) jsonObject.get("reqYYYYMM"));
		log.info("reqYYYYMM : " + reqYYYYMM);
		
		rMap.put("reqYYYYMM", reqYYYYMM);
		
		String reqAcode = CmmUtil.nvl((String) jsonObject.get("reqAcode"));
		log.info("reqAcode : " + reqAcode);
		
		rMap.put("reqAcode", reqAcode);
		
		long recordCnt = (Long) jsonObject.get("recordCnt");
		log.info("recordCnt : " + recordCnt);
		
		rMap.put("recordCnt", recordCnt);
		
		JSONArray resArr = (JSONArray) jsonObject.get("res");
		
		List<AccStatDTO> rList = new ArrayList<AccStatDTO>();
		
		AccStatDTO rDTO = null;
		
		for(int i=0; i < resArr.size(); i++) { 
			JSONObject result = (JSONObject) resArr.get(i);
			
			rDTO = new AccStatDTO();
			
			log.info("yyyymm : " + CmmUtil.nvl((String) result.get("yyyymm")));
			log.info("a_code : " + CmmUtil.nvl((String) result.get("a_code")));
			log.info("a_name : " + CmmUtil.nvl((String) result.get("a_name")));
			log.info("stat_a : " + CmmUtil.nvl((String) result.get("stat_a")));
			log.info("stat_b : " + CmmUtil.nvl((String) result.get("stat_b")));
			
			rDTO.setYyyymm(CmmUtil.nvl((String) result.get("yyyymm")));
			rDTO.setA_code(CmmUtil.nvl((String) result.get("a_code")));
			rDTO.setA_name(CmmUtil.nvl((String) result.get("a_name")));
			rDTO.setStat_a(CmmUtil.nvl((String) result.get("stat_a")));
			rDTO.setStat_b(CmmUtil.nvl((String) result.get("stat_b")));
			
			rList.add(rDTO);
			
		}
		
		rMap.put("res", rList);
		
		log.info(this.getClass().getName() + ".getAccStatForJSON end!");
		
		return rMap;
	}

}
