package bean;


import dao.ExecutionTestDAOImpl;
import entity.Executiontest;
import entity.Testcase;
import entity.Testcasesetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author 
 */
@ManagedBean
@ViewScoped
public class ExecutionTestBean {

	private Executiontest executionTest = new Executiontest();
	private List<Executiontest> executionTests = new ArrayList<Executiontest>();

	public ExecutionTestBean() {
	}

	private ExecutionTestDAOImpl getPersistence() {
		return new ExecutionTestDAOImpl();
	}

	public Executiontest getExecutionTest() {
		return executionTest;
	}

	public void setExecutionTest(Executiontest executionTest) {
		this.executionTest = executionTest;
	}

	public List<Executiontest> getExecutionTests() {
		executionTests = new ArrayList<Executiontest>();
		executionTests = getPersistence().listAllOrderBy("id");
		return executionTests;
	}

	public void setExecutionTests(List<Executiontest> executionTests) {
		this.executionTests = executionTests;
	}

	private void listAll() {
		executionTests = getPersistence().listAllOrderBy("id");
	}

	public List<Executiontest> autoComplete(String query) {
		List<Executiontest> suggestions = new ArrayList<Executiontest>();
		for (Executiontest c : executionTests) {
			if (String.valueOf(c.getId()).toLowerCase().startsWith(query.toLowerCase())) {
				suggestions.add(c);
			}
		}
		return suggestions;
	}
	
    
    public void adjustSave() {
    	String 
        executionTest.setFinishdatatime(new UtilBean().formatDate(new Date()));
        testcase.setTestcasename(testcase.getTestcasename());
        testcase.setOrderworkflow(testcase.getOrderworkflow());
        Testcasesetup tsetup = new Testcasesetup();
    	tsetup.setNote("note");
    	tsetup.setDescriptionsetup("description");
    	
        testcase.setTestcasesetup(tsetup);
        tsetup.setTestcase(testcase);
    }
    
  public void adjustUpdate() {
        testcase.setId(testcase.getId());
        testcase.setDescriptionsteps(testcase.getDescriptionsteps());
        testcase.setTestcasename(testcase.getTestcasename());
        testcase.setOrderworkflow(testcase.getOrderworkflow());
    }
    
    public String save() {
        try {
            adjustSave();
            getPersistence().save(testcase);
            listAll();
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
        return "manager";
    }

    public String update() {
        try {
            adjustUpdate();
            getPersistence().update(testcase);
            listAll();
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
        return "manager";
    }

    public void delete() {
        try {
            getPersistence().delete(testcase);
            listAll();
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
    }
}