package user.model;

public class UserVO {

	private int u_idx;
	private String u_name;
	private String u_id;
	private String u_pwd;
	private String u_phone;
	private String u_mail;
	private String u_loc;
	
	public UserVO() {
		
		this(0,"","","","","","");
		
	}
	public UserVO(String u_id,String u_pwd) {
		super();
		this.u_id=u_id;
		this.u_pwd=u_pwd;
	}

	public UserVO(int u_idx, String u_name, String id, String u_pwd, 
			String phone, String mail,String loc) {
		
		this.u_idx=u_idx;
		this.u_name=u_name;
		this.u_id=id;
		this.u_pwd=u_pwd;
		this.u_phone=phone;
		this.u_mail=mail;
		this.u_loc=loc;
		
	}

	public int getU_idx() {
		return u_idx;
	}
	public void setU_idx(int u_idx) {
		this.u_idx = u_idx;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_mail() {
		return u_mail;
	}
	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}
	public String getU_loc() {
		return u_loc;
	}
	public void setU_loc(String u_loc) {
		this.u_loc = u_loc;
	}
	@Override
	public String toString() {
		return "UserVO [idx=" + u_idx + ", name=" + u_name + ", u_id=" + u_id + ", u_pwd=" + u_pwd + ", phone=" + u_phone
				+ ", mail=" + u_mail + ", loc=" + u_loc + "]";
	}
		
	

}
