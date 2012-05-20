package test;

import dao.TestCaseDAOImpl;
import dao.UserDAOImpl;
import entity.Testcase;
import entity.User;

public class Testar {
	
	public static void main(String[] args) {
//		Testcase t = new Testcase();
//		t.setId(12);
//		t.setDescriptionsteps("dddd");
//		t.setTestcasename("dddddd");
//		
//		TestCaseDAOImpl tdao = new TestCaseDAOImpl();
//		tdao.save(t);
		
		UserDAOImpl d = new UserDAOImpl();
		System.out.println(d.listAll().size());
		System.out.println(d.searchBy("login", "admin"));
	}
}
