package entity;

// Generated May 11, 2012 3:56:49 AM by Hibernate Tools 3.2.1.GA

import java.util.Date;

/**
 * Executiontest generated by hbm2java
 */
public class Executiontest implements java.io.Serializable {

	private Integer id;
	private String startdatatime;
	private String finishdatatime;
	private int iduser;
	private String starttime;
	private String finishtime;

	public Executiontest() {
	}

	public Executiontest(String startdatatime, String finishdatatime, String starttime, String finishtime, int iduser) {
		this.startdatatime = startdatatime;
		this.finishdatatime = finishdatatime;
		this.starttime = starttime;
		this.finishtime = finishtime;
		this.iduser = iduser;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartdatatime() {
		return this.startdatatime;
	}

	public void setStartdatatime(String startdatatime) {
		this.startdatatime = startdatatime;
	}

	public String getFinishdatatime() {
		return this.finishdatatime;
	}

	public void setFinishdatatime(String finishdatatime) {
		this.finishdatatime = finishdatatime;
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getFinishtime() {
		return finishtime;
	}

	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}

}
