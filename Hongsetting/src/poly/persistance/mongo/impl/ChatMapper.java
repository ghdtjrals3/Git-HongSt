package poly.persistance.mongo.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import poly.persistance.mongo.IChatMapper;
import poly.persistance.mongo.comm.MongoDBComon;
import poly.util.CmmUtil;

@Component("ChatMapper")
public class ChatMapper extends MongoDBComon implements IChatMapper{
	@Autowired
	private MongoTemplate mongodb;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public int insertData(List<Map<String, Object>> fList, String colNm) throws Exception {
		log.info(this.getClass().getName() + ".insertData Start !");
		int res = 0;
		if(fList == null) { 
			fList = new LinkedList<Map<String,Object>>();
		}
		
		super.createCollection(colNm, "collectTime");
		MongoCollection<Document> col = mongodb.getCollection(colNm);
		Iterator<Map<String, Object>> it = fList.iterator();
		
		while(it.hasNext()) {
			Map<String, Object> fMap = it.next();
			
			if(fMap == null) {
				fMap = new LinkedHashMap<String, Object>();
			}
			col.insertOne(new Document(fMap));
		}
		col = null;
		res = 1;
		log.info(this.getClass().getName() + ".insertData End !");
		return res;
	}

	@Override
	public List<Map<String, String>> getFoodList(String colNm) throws Exception {
		log.info(this.getClass().getName() + ".getFoodList Start !!");
		
		List<Map<String, String>> rList = new LinkedList<Map<String, String>>();
		
		MongoCollection<Document> col = mongodb.getCollection(colNm);
		
		Document projection = new Document();
		projection.append("foodName", "$foodName");
		projection.append("day", "$day");
		projection.append("_id", 0);
		
		FindIterable<Document> rs = col.find(new Document()).projection(projection);
		Iterator<Document> cursor = rs.iterator();
		
		while(cursor.hasNext()) {
			Document doc = cursor.next();
			
			if(doc == null) {
				doc = new Document();
			}
			
			String foodName = CmmUtil.nvl(doc.getString("foodName"));
			String day = CmmUtil.nvl(doc.getString("day"));
			log.info("foodName : " + foodName);
			log.info("day : " + day);
			
			Map<String, String> rMap = new LinkedHashMap<>();
			
			rMap.put("foodName", foodName);
			rMap.put("day", day);
			
			rList.add(rMap);
			
			rMap = null;
			doc = null;
		}
		
		cursor = null;
		rs = null;
		col = null;
		projection = null;
		
		log.info(this.getClass().getName() + " .getFoodList End !!");
		return rList;
	}

	@Override
	public int insertHaksaData(List<Map<String, Object>> fList, String colNm) throws Exception {
		log.info(this.getClass().getName() + ".insertHaksaData Start !");
		int res = 0;
		if(fList == null) { 
			fList = new LinkedList<Map<String,Object>>();
		}
		
		super.createCollection(colNm, "collectTime");
		MongoCollection<Document> col = mongodb.getCollection(colNm);
		Iterator<Map<String, Object>> it = fList.iterator();
		
		while(it.hasNext()) {
			Map<String, Object> fMap = it.next();
			
			if(fMap == null) {
				fMap = new LinkedHashMap<String, Object>();
			}
			col.insertOne(new Document(fMap));
		}
		col = null;
		res = 1;
		log.info(this.getClass().getName() + ".insertHaksaData End !");
		return res;
	}

	@Override
	public List<Map<String, String>> getHaksaList(String colNm) throws Exception {
log.info(this.getClass().getName() + ".getHaksaList Start !!");
		
		List<Map<String, String>> rList = new LinkedList<Map<String, String>>();
		
		MongoCollection<Document> col = mongodb.getCollection(colNm);
		
		Document projection = new Document();
		projection.append("day", "$day");
		projection.append("iljeong", "$iljeong");
		projection.append("_id", 0);
		
		FindIterable<Document> rs = col.find(new Document()).projection(projection);
		Iterator<Document> cursor = rs.iterator();
		
		while(cursor.hasNext()) {
			Document doc = cursor.next();
			
			if(doc == null) {
				doc = new Document();
			}
			
			String day = CmmUtil.nvl(doc.getString("day"));
			String iljeong = CmmUtil.nvl(doc.getString("iljeong"));
			log.info("day : " + day);
			log.info("iljeong : " + iljeong);
			
			Map<String, String> rMap = new LinkedHashMap<>();
			
			rMap.put("day", day);
			rMap.put("iljeong", iljeong);
			
			rList.add(rMap);
			
			rMap = null;
			doc = null;
		}
		
		cursor = null;
		rs = null;
		col = null;
		projection = null;
		
		log.info(this.getClass().getName() + " .getHaksaList End !!");
		return rList;
	}
}
