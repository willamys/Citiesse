package entity;

// Generated May 11, 2012 3:56:49 AM by Hibernate Tools 3.2.1.GA

/**
 * Testcasesetup generated by hbm2java
 */
public class Testcasesetup implements java.io.Serializable {

	private int id;
	private String note;
	private String descriptionsetup;
	private Testcase testcase;

	public Testcase getTestcase() {
		return testcase;
	}

	public void setTestcase(Testcase testcase) {
		this.testcase = testcase;
	}

	public Testcasesetup() {
	}
	
	public Testcasesetup(int id) {
		this.id = id;
	}

	public Testcasesetup(int id, String note, String descriptionsetup) {
		this.id = id;
		this.note = note;
		this.descriptionsetup = descriptionsetup;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDescriptionsetup() {
		return this.descriptionsetup;
	}

	public void setDescriptionsetup(String descriptionsetup) {
		this.descriptionsetup = descriptionsetup;
	}

}
