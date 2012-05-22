package test;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.TestCaseDAOImpl;

import entity.Testcase;

@ManagedBean
@SessionScoped
public class Workflow {


	List<Testcase> list = new ArrayList<Testcase>();
	TestCaseDAOImpl dao = new TestCaseDAOImpl();
	Testcase t;
	private int idTest;
	
	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public Testcase getT() {
		return t;
	}

	public void setT(Testcase t) {
		this.t = t;
	}

	public List<Testcase> getList() {
		return list;
	}

	public void setList(List<Testcase> list) {
		this.list = list;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	int listSize = 0;
	int itemList = 0;
	
	public Workflow(){
		this.list = dao.listAllOrderBy("orderworkflow");
		this.listSize = list.size();
		//this.descriptionSteps = list.get(0).getDescriptionsteps();
	}

//	public void execute(){
//		if(itemList < listSize){
//			int test = list.get(itemList).getId();
//			setDescriptionSteps(list.get(itemList).getDescriptionsteps());
//			if(test == 68){
//				itemList++;
//			}
//			if(test == 64){
//				itemList++;
//			}
//		}else{
//			setDescriptionSteps("oi1"); 
//		}
//	}
//	
	
	public String recoveryItemList(String value){
		String description = "";
		for (int i = 0; i < listSize; i++) {
			if(list.get(i).getId() == Integer.parseInt(value)){
				description = list.get(i).getDescriptionsteps();
			}
		}
		return description;
	}
	public void execute(){
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		String css = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("css");
		t = new Testcase();
		t.setOrderworkflow(css);
		t.setDescriptionsteps(recoveryItemList(value));
		t.setId(Integer.parseInt(value));
		idTest = Integer.parseInt(value);
	}
	
	public void executeSec(){
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idSec");
		t = new Testcase();
		t.setDescriptionsteps(recoveryItemList(value));
		t.setId(Integer.parseInt(value));
	}
	
	public void executeThird(){
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idThird");
		t = new Testcase();
		t.setDescriptionsteps(recoveryItemList(value));
		t.setId(Integer.parseInt(value));
	}
	public void executeFour(){
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idFour");
		t = new Testcase();
		t.setDescriptionsteps(recoveryItemList(value));
		t.setId(Integer.parseInt(value));
	}
	public void executFive(){
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idFive");
		t = new Testcase();
		t.setDescriptionsteps(recoveryItemList(value));
		t.setId(Integer.parseInt(value));
	}
	public void executeSix(){
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idSix");
		t = new Testcase();
		t.setDescriptionsteps(recoveryItemList(value));
		t.setId(Integer.parseInt(value));
	}
	public void executeSeven(){
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idSeven");
		t = new Testcase();
		t.setDescriptionsteps(recoveryItemList(value));
		t.setId(Integer.parseInt(value));
	}
	public void executeEight(){
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idEight");
		t = new Testcase();
		t.setDescriptionsteps(recoveryItemList(value));
		t.setId(Integer.parseInt(value));
	}
	public void executeNine(){
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idNine");
		t = new Testcase();
		t.setDescriptionsteps(recoveryItemList(value));
		t.setId(Integer.parseInt(value));
	}
	public void executeTen(){
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTen");
		t = new Testcase();
		t.setDescriptionsteps(recoveryItemList(value));
		t.setId(Integer.parseInt(value));
	}
}
