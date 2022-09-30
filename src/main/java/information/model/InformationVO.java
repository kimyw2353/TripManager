package information.model;

public class InformationVO {
	
	private int info_num;
	private int loc_num;
	private String info_spe;
	private String info_list;
	
	public InformationVO() {
	}

	public InformationVO(int info_num, int loc_num, String info_spe, String info_list) {
		super();
		this.info_num = info_num;
		this.loc_num = loc_num;
		this.info_spe = info_spe;
		this.info_list = info_list;
	}

	public int getInfo_num() {
		return info_num;
	}

	public void setInfo_num(int info_num) {
		this.info_num = info_num;
	}

	public int getLoc_num() {
		return loc_num;
	}

	public void setLoc_num(int loc_num) {
		this.loc_num = loc_num;
	}

	public String getInfo_spe() {
		return info_spe;
	}

	public void setInfo_spe(String info_spe) {
		this.info_spe = info_spe;
	}

	public String getInfo_list() {
		return info_list;
	}

	public void setInfo_list(String info_list) {
		this.info_list = info_list;
	}
	
	
	
}
