package bean;

import dao.ResultDAOImpl;
import entity.Result;

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
public class ResultBean {

	private Result result = null;
	private List<Result> results = new ArrayList<Result>();

	public ResultBean() {
		listAll();
	}

	private ResultDAOImpl getPersistence() {
		return new ResultDAOImpl();
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	private void listAll() {
		results = getPersistence().listAllOrderBy("id");
	}

	public List<Result> autoComplete(String query) {
		List<Result> suggestions = new ArrayList<Result>();
		for (Result c : results) {
			if (String.valueOf(c.getId()).toLowerCase().startsWith(query.toLowerCase())) {
				suggestions.add(c);
			}
		}
		return suggestions;
	}
}