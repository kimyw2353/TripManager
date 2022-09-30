package recommend.model;

public class RecommendVO {
	
	private int rec_num;
	private int info_num;
	private String rec_name;
	private String rec_content;
	private String rec_filename;
	private int rec_filesize;
	
	public RecommendVO() {
		
	}

	public RecommendVO(int rec_num, int info_num, String rec_name, String rec_content, String rec_filename,
			int rec_filesize) {
		super();
		this.rec_num = rec_num;
		this.info_num = info_num;
		this.rec_name = rec_name;
		this.rec_content = rec_content;
		this.rec_filename = rec_filename;
		this.rec_filesize = rec_filesize;
	}

	public int getRec_num() {
		return rec_num;
	}

	public void setRec_num(int rec_num) {
		this.rec_num = rec_num;
	}

	public int getInfo_num() {
		return info_num;
	}

	public void setInfo_num(int info_num) {
		this.info_num = info_num;
	}

	public String getRec_name() {
		return rec_name;
	}

	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}

	public String getRec_content() {
		return rec_content;
	}

	public void setRec_content(String rec_content) {
		this.rec_content = rec_content;
	}

	public String getRec_filename() {
		return rec_filename;
	}

	public void setRec_filename(String rec_filename) {
		this.rec_filename = rec_filename;
	}

	public int getRec_filesize() {
		return rec_filesize;
	}

	public void setRec_filesize(int rec_filesize) {
		this.rec_filesize = rec_filesize;
	}
	
	
}
