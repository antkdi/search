package com.saramin.lab.search.common;

import java.util.HashMap;
import java.util.HashSet;

public class GlobalConstant {

	public static String CHARSET_EUCKR="euc-kr";
	public static String CHARSET_UTF8="utf-8";
	
	public static String KWD_SPELL_CHECK_NM = "SEARCH_KEYWORD_FILTER_PATTRN";
	
	// HashMap <parameter name, column name>
	public static HashMap<String, String> PARAM_MAP = new HashMap<String, String>();

	// HashMap <column name, Map>
	public static HashMap<String, Object> COLUMN_MAP = new HashMap<String, Object>();

	public static HashMap<String, String> SITE_MAP = new HashMap<String, String>();
	public static HashMap<String, String> CATE_MAP = new HashMap<String, String>();

	private static HashMap<Integer, Integer> EMPLOYEE_MAP = new HashMap<Integer, Integer>();
	private static HashMap<String, String> STOCK_GB_MAP = new HashMap<String, String>();

	public static HashSet<String> COMPANYINFO_MUPJIK_SET = new HashSet<String>();
	public static HashSet<String> COMPANY_NAME_SET = new HashSet<String>();

	public static HashMap<String, String> AREA_MCODE_MAP = new HashMap<String, String>();
	public static HashMap<String, String> AREA_BCODE_MAP = new HashMap<String, String>();

	public static HashMap<String, String> AREA_MCODE_NM_MAP = new HashMap<String, String>();
	public static HashMap<String, String> AREA_BCODE_NM_MAP = new HashMap<String, String>();
	//public static HashMap<String, String> AREA_BCODE_SYN_MAP = new HashMap<String, String>();

	public static HashMap<String, String> JIK_MCODE_CD_MAP = new HashMap<String, String>();
	public static HashMap<String, String> JIK_MCODE_NM_MAP = new HashMap<String, String>();

	//public static HashMap<String, String> JIK_BCODE_CD_MAP = new HashMap<String, String>();
	public static HashMap<String, String> JIK_BCODE_NM_MAP = new HashMap<String, String>();

	public static HashMap<String, String> UP_MCODE_NM_MAP = new HashMap<String, String>();

	public static HashMap<String, String> SUBWAY_NM_MAP = new HashMap<String, String>();

	public static HashMap<String, String> LICENSE_NM_MAP = new HashMap<String, String>();
	

	//public static HashSet<String> MAIN_AREA_SET = new HashSet<String>();

	static {
		// page parameter name to column name
		PARAM_MAP.put("employ", "employee");
		PARAM_MAP.put("company", "stock_gb");
		PARAM_MAP.put("com_idx", "com_idx");
		PARAM_MAP.put("mcom_idx", "mcom_idx");

		// key : column name 
		// val : map
		COLUMN_MAP.put("employee", EMPLOYEE_MAP);
		COLUMN_MAP.put("employee_cnt", EMPLOYEE_MAP);
		COLUMN_MAP.put("stock_gb", STOCK_GB_MAP);
		COLUMN_MAP.put("stock", STOCK_GB_MAP);

		// page parameter value to column value
		EMPLOYEE_MAP.put(0, 0);
		EMPLOYEE_MAP.put(1, 50);
		EMPLOYEE_MAP.put(2, 100);
		EMPLOYEE_MAP.put(3, 300);
		EMPLOYEE_MAP.put(4, 1000);
		EMPLOYEE_MAP.put(5, -1);

		STOCK_GB_MAP.put("kind","kind");
		STOCK_GB_MAP.put("kospi","kospi");
		STOCK_GB_MAP.put("kosdaq","kosdaq");
		STOCK_GB_MAP.put("level30","level30");
		STOCK_GB_MAP.put("sales1000","sales1000");

		SITE_MAP.put("m_saramin", "모바일사람인");
		SITE_MAP.put("saramin", "사람인");
		SITE_MAP.put("051", "부산사람인");
		SITE_MAP.put("052", "울산사람인");
		SITE_MAP.put("055", "경남사람인");
		SITE_MAP.put("042", "대전사람인");
		SITE_MAP.put("041", "충남사람인");
		SITE_MAP.put("043", "충북사람인");
		SITE_MAP.put("032", "인천사람인");
		SITE_MAP.put("053", "대구사람인");
		SITE_MAP.put("054", "경북사람인");
		SITE_MAP.put("062", "광주사람인");
		SITE_MAP.put("061", "전남사람인");
		SITE_MAP.put("063", "전북사람인");
		SITE_MAP.put("dev", "개발사람인");
		SITE_MAP.put("design", "디자인사람인");
		SITE_MAP.put("game", "게임사람인");
		SITE_MAP.put("shop", "판매사람인");
		SITE_MAP.put("tm", "TM사람인");
		SITE_MAP.put("media", "미디어사람인");
		SITE_MAP.put("const", "건설사람인");
		SITE_MAP.put("nurse", "간호사람인");
		SITE_MAP.put("gangsa", "강사사람인");
		SITE_MAP.put("esthetic", "뷰티사람인");
		SITE_MAP.put("md", "MD사람인");
		SITE_MAP.put("distribution", "물류사람인");
		SITE_MAP.put("production", "생산사람인");
		SITE_MAP.put("highschool", "고졸채용사람인");

		CATE_MAP.put("0", "통합검색");
		CATE_MAP.put("1", "채용정보");
		CATE_MAP.put("2", "기업정보");
		CATE_MAP.put("3", "공채속보");
		CATE_MAP.put("4", "자료통");
		CATE_MAP.put("5", "연봉정보");
		CATE_MAP.put("6", "알바인");
		CATE_MAP.put("7", "인재정보");
		/*
		MAIN_AREA_SET.add("서울");
		MAIN_AREA_SET.add("경기");
		MAIN_AREA_SET.add("인천");
		MAIN_AREA_SET.add("경남");
		MAIN_AREA_SET.add("충북");
		MAIN_AREA_SET.add("대전");
		MAIN_AREA_SET.add("대구");
		MAIN_AREA_SET.add("부산");
		MAIN_AREA_SET.add("광주");
		MAIN_AREA_SET.add("전남");
		MAIN_AREA_SET.add("울산");
		MAIN_AREA_SET.add("충남");
		MAIN_AREA_SET.add("강원");
		MAIN_AREA_SET.add("전북");
		MAIN_AREA_SET.add("세종");
		MAIN_AREA_SET.add("경북");
		MAIN_AREA_SET.add("제주");
		MAIN_AREA_SET.add("아시아");
		MAIN_AREA_SET.add("중동");
		MAIN_AREA_SET.add("아프리카");
		MAIN_AREA_SET.add("남미");
		MAIN_AREA_SET.add("유럽");
		MAIN_AREA_SET.add("중미");
		 */

	}
}
