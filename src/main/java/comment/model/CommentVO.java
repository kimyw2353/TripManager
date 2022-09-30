package comment.model;

import java.sql.Date;

public class CommentVO {
	
	private int re_num;
	private String u_id;
	private String com_content;
	private Date com_date;

	public CommentVO() {
		this(0,"","");
		System.out.println("CommentVOºó »ı¼ºÀÚ...");
	}
	
	public CommentVO(int re_num, String u_id, String com_content) {
		super();
		this.re_num = re_num;
		this.u_id = u_id;
		this.com_content = com_content;
	}
	
	public int getRe_num() {
		return re_num;
	}

	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getCom_content() {
		return com_content;
	}

	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}

	public Date getCom_date() {
		return com_date;
	}

	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}
}
