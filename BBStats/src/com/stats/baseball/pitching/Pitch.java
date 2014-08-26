package com.stats.baseball.pitching;

public class Pitch {
	/**
	 * @brief get a ERA. : 투수가 얼마나 던졌는지 보여주는 가장 기본적인 지표. 계산하는 방법은 총 자책점에 던진 이닝 수를 나누고 9를 곱하는 것.
	 * @param earnedRuns
	 * @param inningsPitched
	 * @return
	 */
	public static double getERA(double earnedRuns, double inningsPitched){
		return (earnedRuns/inningsPitched)*9;
	}
	
	/**
	 * @brief get a FIP. : 다른 모든 상황들이 리그 평균이라고 가정했을 때, 투수의 실제 ERA가 얼마나 되는지 측정해주는 지표
	 * 기본 데이터
	 * @param hr
	 * @param bb
	 * @param hbp
	 * @param k
	 * @param ip
	 * 방어율 관련
	 * @param earnedRuns
	 * @param inningsPitched
	 * 리그 평균 데이터
	 * @param lgHr
	 * @param lgEra
	 * @param lgBb
	 * @param lgHbp
	 * @param lgK
	 * @param lgIp
	 * @return
	 */
	public static double getFIP(double hr, double bb, double hbp, double k, double ip, double earnedRuns, double inningsPitched, double lgHr, double lgEra, double lgBb, double lgHbp, double lgK, double lgIp){
		
		double era 		= Pitch.getERA(earnedRuns, inningsPitched);
		double constant = Pitch.getFIPConstant(lgEra, lgHr, lgBb, lgHbp, lgK, lgIp);
		
		return  ((13*hr)+(3*(bb+hbp))-(2*k))/ip + constant;
	}
	
	public static double getFIPConstant(double lgEra, double lgHr, double lgBb, double lgHbp, double lgK, double lgIp){
		return lgEra - (((13*lgHr)+(3*(lgBb+lgHbp))-(2*lgK))/lgIp);
	}
	
	// 회귀된 (regressed) FIP. FIP와 동일하게 계산하지만, 바뀌는 점은 투수의 피홈런수대신에 투수가 홈런을 허용했어야하는 수치로 대체
	public static double getXFIP(double flyBalls, double lgHr, double lgEra, double lgBb, double lgHbp, double lgK, double lgIp, double fb, double bb, double hbp, double k, double ip){
		
		double constant = Pitch.getFIPConstant(lgEra, lgHr, lgBb, lgHbp, lgK, lgIp);
		
		return  ((13*(flyBalls * lgHr/fb))+(3*(bb+hbp))-(2*k))/ip + constant;
	}
	/**earned
	 * @brief get a BABIP : 투수가 허용한 ‘인플레이 타구’(balls in play)가 얼마나 안타로 연결되었는지 나타내는 수치
	 * @param h
	 * @param hr
	 * @param ab
	 * @param k
	 * @param sf
	 * @return
	 */
	public static double getBABIP(double h, double hr, double ab, double k, double sf){
		return (h - hr)/(ab - k - hr + sf);
	}
	
	/**
	 * @brief Home Run to Fly Ball rate (HR/FB) : 투수가 허용한 뜬공의 총 숫자에서 홈런을 내준 비율
	 * @param homerunCnt
	 * @param flyballCnt
	 * @return
	 */
	public static double getHRFB(double homerunCnt, double flyballCnt){
		return homerunCnt/flyballCnt;
	}
	/**
	 * @brief Left on Base Percentage (LOB%) : 한 시즌 동안 잔루를 얼마나 시켰는지 측정해주는 지표
	 * @param h
	 * @param bb
	 * @param hbp
	 * @param r
	 * @param hr
	 * @return
	 */
	public static double getLOB(double h, double bb, double hbp, double r, double hr){
		return (h+bb+hbp-r)/(h+bb+hbp-(1.4*hr));
	}
	
	// GB, LD, FB : 한 투수가 타자를 상대했을 때, 땅볼, 라인 드라이브, 뜬 공이 나올 확률이 얼마인지를 보여주는 지표
	
	// IFFB : 내야에 뜬 공의 비율
	
	public static void main(String[] args) throws Exception{
		// 자책점
		System.out.println("era : " + String.format("%04.2f",Pitch.getERA(65, 141)));
		// 잔루
		System.out.println("lob : " + String.format("%04.2f",Pitch.getLOB(135, 62, 2, 67, 8)));
//		System.out.println("fip : " + String.format("%04.3f",Pitch.getFIP(8, 62, 2, 138, 141, 65, 141, lgHr, lgEra, lgBb, lgHbp, lgK, lgIp)
	}
	
}
