package poly.persistance.mongo.comm;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.client.model.Indexes;


public abstract class MongoDBComon {

	// 로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private MongoTemplate mongodb;
	
	protected boolean createCollection(String colNm) throws Exception {
		return createCollection(colNm, "");
	} 

	protected boolean createCollection(String colNm, String index) throws Exception {
		String[] indexArr = { index };
		return createCollection(colNm, indexArr);
	}

	private boolean createCollection(String colNm, String[] index) throws Exception {
		
		log.info(this.getClass().getName() + ".createCollection Start !");
		
		boolean res = false;
		
		if(!mongodb.collectionExists(colNm)) {
			if(index.length > 0) { 
				mongodb.createCollection(colNm).createIndex(Indexes.ascending(index));
			} else {
				mongodb.createCollection(colNm);
			}
			
			res = true;
		}
		
		log.info(this.getClass().getName() + ".createCollection End !");
		return res;
	}

}
