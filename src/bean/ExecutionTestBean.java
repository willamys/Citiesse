package bean;


import dao.ExecutionTestDAOImpl;
import entity.Executiontest;

import java.util.ArrayList;
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

	private Executiontest executionTest = null;
	private List<Executiontest> executionTests = new ArrayList<Executiontest>();

	public ExecutionTestBean() {
		listAll();
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
}