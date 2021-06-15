package poly.comm;

public interface ICommCont {

	// MongoDB명
	public String MongoDBName = "qsDB";

	// 운영 OS정보 가져오기
	public String OS = System.getProperty("os.name").toLowerCase();

	// FTP로 전송된 SOC 기준데이터가 저장되는 홈 위치
	public String FtpDataHomeSocStd = "/data/repo/soc_std";

	// FTP로 전송된 SOC 측정데이터가 저장되는 홈 위치
	public String FtpDataHomeSocExam = "/data/repo/soc_exam";

	// 데이터분석에 사용될 소수점 자릿수 (기본값 : 소수점 2자리)
	final public double ContDataSize = 100d;

	// 데이터분석에 사용될 소수점 자릿수 (기본값 : 소수점 3자리)
	final public double SocDataSize = 1000d;

	/*
	 * #############################################################################
	 * 저장된 데이터의 키 구분(진단, SOC 기준)
	 * #############################################################################
	 */

	// SOC 유니크 키 이름(파일명 앞에 붙일 이름)
	public String keyNameforStdSOC = "STD_SOC_";

	// 퀀텀솔루션 SOC 유니크 키 이름(파일명 앞에 붙일 이름)
	public String keyNameforStdSOC_QSOL = keyNameforStdSOC + "QSOL_";

	// 제주테크노파크 SOC 유니크 키 이름(파일명 앞에 붙일 이름)
	public String keyNameforStdSOC_JTP = keyNameforStdSOC + "JTP_";

//	public String keyNameforStdSOCTemp = "STD_SOC_TEMP_";

	// SOC 측정 유니크 키 이름(파일명 앞에 붙일 이름)
	public String keyNameforExamSOC = "RES_EXAM_SOC_";

	// SOC 유니크 키 이름(파일명 앞에 붙일 이름)
	public String keyNameforSOC = "SOC_";

	// 측정 유니크 키 이름(파일명 앞에 붙일 이름)
	public String keyNameforEXAM = "EXAM_";

	/*
	 * #############################################################################
	 * 측정 데이터 10%/ 20% 구분
	 * #############################################################################
	 */

	// 측정시간 6분
	public String soc6Min = "10p";

	// 측정시간 12분
	public String soc12Min = "20p";

	/*
	 * #############################################################################
	 * 기준 데이터 CC/CV 구분
	 * #############################################################################
	 */

	// CC
	public String modeCC = "D-CC";

	// CV
	public String modeCV = "C-CV";

	// CC
	public String modeExamCC = "Discharging";

	// CV
	public String modeExamCV = "Charging";

	/*
	 * #############################################################################
	 * Hadoop 서버 정보
	 * #############################################################################
	 */

	// Hadoop 호스트
	public String HadoopHost = "localhost";

	// Hadoop 포트
	public String HadoopPort = "9100";

	// Hadoop 홈디렉토리
	public String HadoopHomeDir = "/BT";

	// Hadoop SOC 기준 데이터 디렉토리
	public String HadoopSocDir = HadoopHomeDir + "/SOC";

	// Hadoop 진단 데이터 디렉토리
	public String HadoopExamDir = HadoopHomeDir + "/EXAM";

	// RedisDB에 저장되는 파일 유효기간
	public int days = 2;

	/*
	 * #############################################################################
	 * 인터페이스 서버 정보
	 * #############################################################################
	 */

	// 인터페이스 서버 호스트
	public String IfProtocol = "http";

	// 인터페이스 서버 호스트
	public String IfHost = "qsolution.iptime.org";

	// 인터페이스 서버 포트
	public String IfPort = "13000";

	// 인터페이스 서버 URL
	public String IfUrl = IfProtocol + "://" + IfHost + ":" + IfPort;

	// 인터페이스 서버 호스트
	public String devIfProtocol = "http";

	// 인터페이스 개발서버 호스트
	public String devIfHost = "localhost";

	// 인터페이스 개발서버 포트
	public String devIfPort = "12000";

	// 인터페이스 개발서버 URL
	public String devIfUrl = devIfProtocol + "://" + devIfHost + ":" + devIfPort;

	/*
	 * #############################################################################
	 * API
	 * #############################################################################
	 */

	// 인터페이스서버 빅데이터 처리 분석 이력 관리 API : SOC 기준 데이터 상태 관리
	public String doSaveStatusAPI = "/bigProc/doSaveStatusForSOC.do";

}
