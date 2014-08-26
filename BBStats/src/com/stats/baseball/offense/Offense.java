package com.stats.baseball.offense;

public class Offense {
	/**
	 * Batting Average 타율
	 * @param hits
	 * @param ab
	 * @return
	 */
	public static double getAVG(double hits, double ab){
		double avg = hits / ab;
		return avg;
	}
	/**
	 * OBP(on-base percentage)
	 * @param hit	: Hits
	 * @param bb	: Base on balls
	 * @param hbp	: Times hit by pitch
	 * @param ab 	: At bats
	 * @param sf	: Sacrifice flies
	 * @return
	 */
	public static double getOBP(double hit, double bb, double hbp, double ab, double sf){
		double obp = (hit + bb + hbp) / (ab + bb + hbp + sf);
		return obp;
	}
	/**
	 * SLG(slugging average) : 장타율
	 * @param tb : Times hit by pitch
	 * @param ab : At bats
	 * @return
	 */
	public static double getSLG(double tb, double ab){
		double slg = tb / ab;
		return slg;
	}
	/**
	 * SLG(slugging average) : 장타율
	 * @param oneB
	 * @param twoB
	 * @param threeB
	 * @param hr
	 * @return
	 */
//	public static double getSLG(double oneB, double twoB, double threeB, double hr){
//		double slg = ( oneB + (2 * twoB) + (3 * threeB) + (4 * hr) );
//		return slg;
//	}
	
	/**
	 * OPS
	 * @param tb	: Total bases
	 * @param ab	: At bats
	 * @param hit 	: Hits
	 * @param bb	: Base on balls
	 * @param hbp	: Times hit by pitch
	 * @param sf	: Sacrifice flies
	 * @return
	 */
	public static double getOPS(double tb, double ab, double hit, double bb, double hbp, double sf){
		double ops = getOBP(hit, bb, hbp, ab, sf) + getSLG(tb, ab);
		return ops;
	}
	
	/**
	 * Adjusted OPS (OPS+)
	 * @param hit 	: hits
	 * @param bb	: Base on balls
	 * @param hbp	: Times hit by pitch
	 * @param ab 	: at Bats
	 * @param sf	: Sacrifice flies
	 * @param tb 	: total Bases
	 * @param lgOBP	
	 * @param lgSLG
	 * @return
	 */
	public static double getOPSPlus(double hit, double bb, double hbp, double ab, double sf, double tb, double lgOBP, double lgSLG){
		double obp = getOBP(hit, bb, hbp, ab, sf);
		double slg = getSLG(tb, ab);
		
		double opsPlus = 100 * ( (obp/lgOBP) + (slg/lgSLG) - 1);
		return opsPlus;
	}
	/**
	 * RC(Runs Created)
	 * @param h 	: hits
	 * @param w 	: walks
	 * @param tb 	: total Bases
	 * @param ab 	: at Bats
	 * @return
	 */
	public static double getRC(double hit, double w, double tb, double ab){
		double rc = ((hit + w) * tb) / (ab + w);
		return rc;
	}
	
	public static double getwOBA(){
		return 0;
	}
	public static double wRAA(){
		return 0;
	}
	
	public static double getUBR(){
		return 0;
	}
	
	public static double getwSB(){
		return 0;
	}
	
	public static double wRC(){
		return 0 ;
	}
	
	public static double wRCPlus(){
		return 0 ;
	}
	
	public static double getBABIP(){
		return 0;
	}
	
	public static double getISO(){
		return 0;
	}
	
	public static double getHRFB(){
		return 0;
	}
	
	public static double getGB(){
		return 0;
	}
	
	public static double getLD(){
		return 0;
	}
	
	public static double getFB(){
		return 0;
	}
	
	/**
	 * K% : Strikeout rate
	 * @param k
	 * @param pa
	 * @return
	 */
	public static double getK(double k, double pa){
		double kPer = k / pa;
		return kPer;
	}

	public static double getBB(){
		return 0;
	}
	
	// check out data through : http://www.koreabaseball.com/Record/HitterDetail1.aspx?pcode=75125
	public static void main(String[] args) throws Exception{
		
		System.out.println("avg : " + (((double)109 / (double)365)));
		System.out.println("avg : " + (double)(109.00 / 365.00));
		// 타율
		System.out.println("avg : " + String.format("%04.3f",Offense.getAVG(109, 365)));
		// OPS
		System.out.println("ops : " + String.format("%04.3f",Offense.getOPS(243, 365, 109, 82, 11, 4)));
		// 출루율
		System.out.println("obp : " + String.format("%04.3f",Offense.getOBP(109, 82, 11, 365, 4)));
		// 장타율
		System.out.println("slg : " + String.format("%04.3f",Offense.getSLG(243, 365)));
	}
}
