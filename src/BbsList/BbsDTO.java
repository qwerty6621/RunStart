package BbsList;

import java.io.Serializable;

public class BbsDTO implements Serializable {

	private int seq;
	private String id;
	private int ref;
	private int step;
	private int depth;
	
	private String qatype;
	private String title;
	private String content;
	private String wdate;
	private int parent;
	
	private String image;
	
	private int del;
	private int readcount;
	
	public BbsDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public BbsDTO(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}



	public BbsDTO(int seq, String id, int ref, int step, int depth, String qatype, String title, String content,
			String wdate, int parent, String image, int del, int readcount) {
		super();
		this.seq = seq;
		this.id = id;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.qatype = qatype;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.parent = parent;
		this.image = image;
		this.del = del;
		this.readcount = readcount;
	}








	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getQatype() {
		return qatype;
	}

	public void setQatype(String qatype) {
		this.qatype = qatype;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
