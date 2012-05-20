package entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FlowImages {

	private String [] firstline;
	private String [] secondline;
	private String [] thirdline;
	private String [] fourline;
	private String [] fiveline;
	private String [] sixline;
	private String [] sevenline;
	private String [] eightline;
	private String [] nineline;
	private String [] tenline;
	private String [] elevenline;
	private String [] twelveline;
	private String [] thirteenline;

	
	public String[] getFirstline(){
		firstline = new String[]{"1","68","3","4"};
		return firstline;
	}
	
	public String[] getSecondline(){
		secondline = new String[]{"1","2","66","4","5"};
		return secondline;
	}
	
	public String[] getThirdline(){
		thirdline = new String[]{"1","2","3","4"};
		return thirdline;
	}
	
	public String[] getFourline(){
		fourline = new String[]{"1","2","3","4"};
		return fourline;
	}
	public String[] getFiveline(){
		fiveline = new String[]{"1","2","3","4"};
		return fiveline;
	}
	public String[] getSixline(){
		sixline = new String[]{"1","2","3","4"};
		return sixline;
	}
	public String[] getSevenline(){
		sevenline = new String[]{"1","2","3","4"};
		return sevenline;
	}
	public String[] getEightline(){
		eightline = new String[]{"1","2","3","4"};
		return eightline;
	}
	public String[] getNineline(){
		nineline = new String[]{"1","2","3","4"};
		return nineline;
	}
	public String[] getTenline(){
		tenline = new String[]{"1","2","3","4"};
		return tenline;
	}
	public String[] getElevenline(){
		elevenline = new String[]{"1","2","3","4"};
		return elevenline;
	}
	public String[] getTwelveline(){
		twelveline = new String[]{"1","2","3","4"};
		return twelveline;
	}
	
	public String[] getThirteenline(){
		thirteenline = new String[]{"1","2","3","4"};
		return thirteenline;
	}
}
