package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.MessageBean;

import dao.TestCaseDAOImpl;

import entity.Testcase;

@ManagedBean
@SessionScoped
public class Workflow {


	private List<Testcase> list = new ArrayList<Testcase>();
	private TestCaseDAOImpl dao = new TestCaseDAOImpl();
	private Testcase t;
	private int i = 0;
	private int idTest;
	private List<Testcase> listTemp =  new ArrayList<Testcase>();
	private boolean ableNext = true;
	private boolean ablePrev = true;
	private boolean ableFinish = true;
	private boolean enableGettingStart = false;
	
	public boolean isEnableGettingStart() {
		return enableGettingStart;
	}

	public void setEnableGettingStart(boolean enableGettingStart) {
		this.enableGettingStart = enableGettingStart;
	}
	
	

	public boolean isAbleNext() {
		return ableNext;
	}

	public void setAbleNext(boolean ableNext) {
		this.ableNext = ableNext;
	}

	public boolean isAblePrev() {
		return ablePrev;
	}

	public void setAblePrev(boolean ablePrev) {
		this.ablePrev = ablePrev;
	}

	public boolean isAbleFinish() {
		return ableFinish;
	}

	public void setAbleFinish(boolean ableFinish) {
		this.ableFinish = ableFinish;
	}


	public List<Testcase> getListTemp() {
		return listTemp;
	}


	public void setListTemp(List<Testcase> listTemp) {
		this.listTemp = listTemp;
	}

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
		listTemp.clear();
		if(value.equals("52")){
			for (int i = 52; i < 55; i++) {
				t = new Testcase();
				t.setOrderworkflow(css);
				t.setDescriptionsteps(recoveryItemList(String.valueOf(i)));
				t.setId(i);
				idTest = Integer.parseInt(value);
				listTemp.add(t);
			}
			System.out.println(listTemp.size());
		}else{
			t = new Testcase();
			t.setOrderworkflow(css);
			t.setDescriptionsteps(recoveryItemList(value));
			t.setId(Integer.parseInt(value));
			idTest = Integer.parseInt(value);
			listTemp.add(t);
		}
	}

	
	public void executeFirst(){
		if(i == 0){
			t = new Testcase();
			t.setId(list.get(i).getId());
			idTest = list.get(i).getId();
			System.out.println(idTest);
			t.setDescriptionsteps(list.get(i).getDescriptionsteps());
			System.out.println("first"+i);
			ableNext = false;
			ablePrev = true;
		}
		else{
			new MessageBean().error();
		}
	}
	
	public void executeNext(){
		i++;
		if(i < listSize & i > 0){
			t = new Testcase();
			t.setId(list.get(i).getId());
			idTest = list.get(i).getId();
			t.setDescriptionsteps(list.get(i).getDescriptionsteps());
			System.out.println("next"+i);
				ableNext = false;
				ablePrev = false;
				ableFinish = true;
		}else{
			if (i == listSize) {
				ableFinish = false;
				ableNext = true;
			}
			new MessageBean().error();
		}
	}
	
	public void executePrevious(){
		i--;
		if(i < listSize & i > 0){
			t = new Testcase();
			t.setId(list.get(i).getId());
			idTest = list.get(i).getId();
			t.setDescriptionsteps(list.get(i).getDescriptionsteps());
			System.out.println("previous"+i);
				ableNext = false;
				ableFinish = true;
		}else{
			if(i == 0){
				ablePrev = true;
			}
			new MessageBean().error();
		}
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
