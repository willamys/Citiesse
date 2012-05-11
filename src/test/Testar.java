package test;

import dao.TestCaseDAOImpl;
import entity.Testcase;

public class Testar {
	
	public static void main(String[] args) {
		Testcase t = new Testcase();
		t.setId(12);
		t.setDescriptionsteps("dddd");
		t.setTestcasename("dddddd");
		
		TestCaseDAOImpl tdao = new TestCaseDAOImpl();
		tdao.save(t);
	}
}
