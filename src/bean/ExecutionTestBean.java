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
import javax.faces.context.FacesContext;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 *
 * @author 
 */
@ManagedBean
@ViewScoped
public class ExecutionTestBean {

	private Executiontest executionTest = new Executiontest();
	private List<Executiontest> executionTests = new ArrayList<Executiontest>();
	private int lastidinserted = 0;
	

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

	public int getLastidinserted() {
		return lastidinserted;
	}

	public void setLastidinserted(int lastidinserted) {
		this.lastidinserted = lastidinserted;
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
        executionTest.setStartdatatime(new UtilBean().formatDate(new Date()));
        executionTest.setStarttime(new UtilBean().formatHour(new Date()));
        executionTest.setFinishdatatime("");
        executionTest.setFinishtime("");
    }
  public void adjustUpdate() {
	  executionTest.setFinishdatatime(new UtilBean().formatDate(new Date()));
      executionTest.setFinishtime(new UtilBean().formatHour(new Date()));
    }
    public String save() {
        try {
            adjustSave();
            lastidinserted = getPersistence().savereturn(executionTest);
            listAll();
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
        return "/execution/manager";
    }

    public String update() {
        try {
            adjustUpdate();
            getPersistence().update(executionTest);
            listAll();
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
        return "/execution/manager";
    }
    public void delete() {
        try {
            getPersistence().delete(executionTest);
            listAll();
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
    }
}