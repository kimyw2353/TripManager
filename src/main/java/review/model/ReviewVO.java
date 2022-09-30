package review.model;

import java.sql.Date;

public class ReviewVO {

	private int loc_num;
	private int re_num;
	private String loc_name;
	private String re_name;
	private String u_id;
	private Date re_date;
	private String u_pwd;
	private String re_content;
	private int re_readnum;

	public ReviewVO() {
		this(0,"","");
		System.out.println("ReviewVOºó »ý¼ºÀÚ...");
	}
	
	public ReviewVO(int re_num, String re_name,	String re_content) {
		super();
		this.re_num = re_num;
		this.re_name = re_name;
		this.re_content = re_content;
	}
	
	public String getRe_name() {
		return re_name;
	}

	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}
	public int getLoc_num() {
		return loc_num;
	}

	public void setLoc_num(int loc_num) {
		this.loc_num = loc_num;
	}

	public int getRe_num() {
		return re_num;
	}

	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}

	public String getLoc_name() {
		return loc_name;
	}

	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public java.sql.Date getRe_date() {
		return re_date;
	}

	public void setRe_date(java.sql.Date re_date) {
		this.re_date = re_date;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getRe_content() {
		return re_content;
	}

	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public int getRe_readnum() {
		return re_readnum;
	}

	public void setRe_readnum(int re_readnum) {
		this.re_readnum = re_readnum;
	}
}
