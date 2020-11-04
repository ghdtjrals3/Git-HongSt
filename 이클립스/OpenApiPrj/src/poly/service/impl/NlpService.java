package poly.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.NlpDTO;
import poly.persistance.mapper.INlpMapper;
import poly.service.INlpService;
import poly.util.CmmUtil;
import poly.util.StringUtil;

@Service("NlpService")
public class NlpService implements INlpService {
	
	@Resource(name = "NlpMapper")
	private INlpMapper nlpMapper;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private Map<String, List<NlpDTO>> NLP_DIC = new HashMap<String, List<NlpDTO>>();
	
	@Override
	public void getWord() throws Exception { 
		
		log.info(this.getClass().getName() + ".getWord start !");
		
		NlpDTO pDTO = new NlpDTO();
		
		List<NlpDTO> rList = null;
		
		pDTO.setWord("ㄱ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㄱ", rList);
		
		pDTO.setWord("ㄴ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㄴ", rList);
		
		pDTO.setWord("ㄷ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㄷ", rList);
		
		pDTO.setWord("ㄹ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㄹ", rList);
		
		pDTO.setWord("ㅁ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅁ", rList);
		
		pDTO.setWord("ㅂ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅂ", rList);
		
		pDTO.setWord("ㅅ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅅ", rList);
		
		pDTO.setWord("ㅇ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅇ", rList);
		
		pDTO.setWord("ㅈ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅈ", rList);
		
		pDTO.setWord("ㅊ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅊ", rList);
		
		pDTO.setWord("ㅋ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅋ", rList);
		
		pDTO.setWord("ㅌ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅌ", rList);
		
		pDTO.setWord("ㅍ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅍ", rList);
		
		pDTO.setWord("ㅎ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅎ", rList);
		
		pDTO.setWord("ㄲ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㄲ", rList);
		
		pDTO.setWord("ㄸ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㄸ", rList);
		
		pDTO.setWord("ㅃ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅃ", rList);
		
		pDTO.setWord("ㅆ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅆ", rList);
		
		pDTO.setWord("ㅉ");
		rList = nlpMapper.getWord(pDTO);
		if(rList == null) { 
			rList = new ArrayList<NlpDTO>();
		}
		NLP_DIC.put("ㅉ", rList);
	
		log.info(this.getClass().getName() + ".getWord End!");
	}
	
	public int preProcessWordAnalysisForMind(NlpDTO pDTO) throws Exception { 
		log.info(this.getClass().getName() + ".WordAnalysisForMind start !");
		
		int res = 0;
		
		String text = CmmUtil.nvl(pDTO.getWord()).replaceAll("[^\\uAC00-\\uD7A3xfe0-9a-zA-Z\\\\s]", " ");
		
		text = text.replaceAll("\\s{2,}", " ");
		
		log.info("text : " + text);
		
		String[] textArr = text.split(" ");
		
		log.info("textArr.length : " + textArr.length);
		
		if(textArr.length<4) { 
			String firstWord = textArr[0].substring(0,1);
			res = WordAnalysisForMind(firstWord, text);
		} else { 
			int maxCnt = textArr.length-2;
			
			log.info("###textArr.length : " + textArr.length);
			log.info("###maxCnt : " + maxCnt);
			
			for(int i=0; i < maxCnt; i++) { 
				String firstWord2 = textArr[i].substring(0,1);
				
				log.info("###반복 횟수 : " + i);
				String text2 = textArr[i] + " " + textArr[i+1] + " " +textArr[i+2];
				
				res += WordAnalysisForMind(firstWord2, text2);
			}
		}
		
		log.info("Res : " + res);
		log.info(this.getClass().getName() + ".WordAnalysisForMind End !");
		
		return res;
	}
	
	public int WordAnalysisForMind(String firstWord, String text) throws Exception { 
		int res = 0;
		
		log.info("firstWord : " + firstWord);
		log.info("text : " + text);
		
		String dicType = StringUtil.getFirstWord(firstWord);
		
		log.info("DIC type : " + dicType);
		
		if(dicType.length() > 0) { 
			List<NlpDTO> rList = NLP_DIC.get(StringUtil.getFirstWord(firstWord));
			
			if(rList == null) { 
				rList = new ArrayList<NlpDTO>();
			}
			
			Iterator<NlpDTO> it = rList.iterator();
			
			while (it.hasNext()) { 
				NlpDTO rDTO = it.next();
				
				if(rDTO == null) { 
					rDTO = new NlpDTO();
				}
				
				if(text.indexOf(CmmUtil.nvl(rDTO.getWord())) > -1) { 
					log.info("DIC-word : " + CmmUtil.nvl(rDTO.getWord()));
					log.info("DIC-word getPolaritu : " + CmmUtil.nvl(rDTO.getPolarity()));
					log.info("text : " + text);
					res += Integer.parseInt(CmmUtil.nvl(rDTO.getPolarity(), "0"));
					
					break;
				}
			}
		}
		
		return res;
	}

}
