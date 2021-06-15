package poly.comm;

public interface IStatusCode {

	// 파일 전송 상태값
	public String FileUploadStart = "FS"; // 하둡 저장전 시작전
	public String FileUploadStartProgress = "FP"; // 하둡 저장중
	public String FileUploadStartEnd = "FF"; // 하둡 저장 완료
	public String FileUploadStartError = "FE"; // 하둡 저장 에러

	// 하둡처리 상태 값
	public String HadoopStart = "HS"; // 하둡 저장전 시작전
	public String HadoopProgress = "HP"; // 하둡 저장중
	public String HadoopEnd = "HF"; // 하둡 저장 완료
	public String HadoopError = "HE"; // 하둡 저장 에러

	// 빅데이터분석 상태 값
	public String BigDataStart = "BS"; // 빅데이터 시작전
	public String BigDataProgress = "BP"; // 빅데이터 진행중
	public String BigDataEnd = "BF"; // 빅데이터 완료
	public String BigDataError = "BE"; // 빅데이터 에러
}
