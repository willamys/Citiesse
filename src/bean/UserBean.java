package bean;

import dao.UserDAOImpl;
import entity.User;

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
public class UserBean {

	private User user = null;
	private List<User> users = new ArrayList<User>();

	public UserBean() {
		listAll();
	}

	private UserDAOImpl getPersistence() {
		return new UserDAOImpl();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private void listAll() {
		users = getPersistence().listAllOrderBy("login");
	}

	public List<User> autoComplete(String query) {
		List<User> suggestions = new ArrayList<User>();
		for (User c : users) {
			if (c.getLogin().toLowerCase().startsWith(query.toLowerCase())) {
				suggestions.add(c);
			}
		}
		return suggestions;
	}
}