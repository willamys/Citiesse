package bean;


import dao.TestCaseSetupDAOImpl;
import entity.Testcasesetup;

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
public class TestCaseSetupBean {

    private Testcasesetup testCaseSetup = null;
    private List<Testcasesetup> testCaseSetups = new ArrayList<Testcasesetup>();

    public TestCaseSetupBean() {
        listAll();
    }

    private TestCaseSetupDAOImpl getPersistence() {
        return new TestCaseSetupDAOImpl();
    }

    public Testcasesetup getTestCaseSetup() {
        return testCaseSetup;
    }

    public void setTestCaseSetup(Testcasesetup testCaseSetup) {
        this.testCaseSetup = testCaseSetup;
    }

    public List<Testcasesetup> getTestCaseSetups() {
        return testCaseSetups;
    }

    public void setTestCaseSetups(List<Testcasesetup> testCaseSetups) {
        this.testCaseSetups = testCaseSetups;
    }

    private void listAll() {
        testCaseSetups = getPersistence().listAllOrderBy("descriptionsetup");
    }

    public List<Testcasesetup> autoComplete(String query) {
        List<Testcasesetup> suggestions = new ArrayList<Testcasesetup>();
        for (Testcasesetup c : testCaseSetups) {
            if (c.getDescriptionsetup().toLowerCase().startsWith(query.toLowerCase())) {
                suggestions.add(c);
            }
        }
        return suggestions;
    }
}

