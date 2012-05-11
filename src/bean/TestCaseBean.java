package bean;

import dao.TestCaseDAOImpl;
import entity.Testcase;

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
public class TestCaseBean {

    private Testcase testcase = new Testcase();
    private List<Testcase> testCases = new ArrayList<Testcase>();

    public TestCaseBean() {
        listAll();
    }

    private TestCaseDAOImpl getPersistence() {
        return new TestCaseDAOImpl();
    }

    public Testcase getTestcase() {
        return testcase;
    }

    public void setTestcase(Testcase testcase) {
        this.testcase = testcase;
    }

    public List<Testcase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<Testcase> testCases) {
        this.testCases = testCases;
    }

    private void listAll() {
        testCases = getPersistence().listAllOrderBy("testcasename");
    }

    public List<Testcase> autoComplete(String query) {
        List<Testcase> suggestions = new ArrayList<Testcase>();
        for (Testcase c : testCases) {
            if (c.getTestcasename().toLowerCase().startsWith(query.toLowerCase())) {
                suggestions.add(c);
            }
        }
        return suggestions;
    }
    
    public void adjust() {
        testcase.setId(testcase.getId());
        testcase.setDescriptionsteps(testcase.getDescriptionsteps().toLowerCase());
        testcase.setTestcasename(testcase.getTestcasename().toLowerCase());
    }
    
    public void save() {
        try {
            adjust();
            getPersistence().save(testcase);
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
    }

    public void update() {
        try {
            adjust();
            getPersistence().update(testcase);
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
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
