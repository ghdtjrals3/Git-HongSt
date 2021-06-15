package poly.comm;

public interface ISocStdCont {

	/*
	 * #############################################################################
	 * SOC 기준데이터
	 * #############################################################################
	 */

	// SOC 0 값을 계산하기 위한 최소 볼트 범위 : 3.2v 이하
	public double soc0Range = 3.3;

	// SOC 0 값 계산을 위한 변화값 비율 140% 이상 변화가 발생한 지점을 SOC 0으로 정의함
	public double soc0Rate = 1.4;

	public int socRecordTime = 2; // CC측정 레코드당 측정시간 : 레코드당 2초

	public int socStd100 = 100;
	public int socStd0 = 0;

}
