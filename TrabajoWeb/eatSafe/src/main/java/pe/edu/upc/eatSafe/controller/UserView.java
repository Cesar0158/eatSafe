package pe.edu.upc.eatSafe.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.eatSafe.business.crud.UserService;
import pe.edu.upc.eatSafe.model.entity.User;

@Named("userView")
@ViewScoped
public class UserView implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<User> users;
	private User userSelected;
	private List<User> usersSelected;
	private User userSearch;


	@Inject
	private UserService userService;
	
	@PostConstruct
	public void init() {
		usersSelected = new ArrayList<>();
		userSearch = new User();
		getAllUser();
	}
	
	public boolean hasUsersSelected() { /* Manipulacion de interfaz has=(seleccionar cuadritos en la vista) */
		if (usersSelected.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hasUserSelected() {
		if (usersSelected.size() == 1) { /* para seleccionar solo 2 o 1 elemento */
			return true;
		}
		return false;
	}

	public void createNew() {
		userSelected = new User();
	}

	public void editUserSelected() {
		userSelected = usersSelected.get(0);
	}
	
	public void saveUser() {
		try {
			System.out.println(userSelected.getId());
			System.out.println(userSelected.getName());
			System.out.println(userSelected.getLastName());
			System.out.println(userSelected.getPhone());
			System.out.println(userSelected.getEmail());
			System.out.println(userSelected.getPassword());

			if (userSelected.getId() == null) {
				userService.create(userSelected);
				users.add(userSelected);
			} else {
				userService.update(userSelected);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('userDialog').hide()");
		PrimeFaces.current().ajax().update("userDataTable");
	}
	
	public void deleteUser() {
		try {
			this.users.remove(userSelected);
			userService.deleteById(this.userSelected.getId());
			this.userSelected = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		//PrimeFaces.current().ajax().update("form:messages","userDataTable");
	}

	public void searchUser() {
		try	{
			users = userService.findByEmail(userSearch.getEmail());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllUser() {
		try {
			users = userService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(User userSelected) {
		this.userSelected = userSelected;
	}

	public List<User> getUsersSelected() {
		return usersSelected;
	}

	public void setUsersSelected(List<User> usersSelected) {
		this.usersSelected = usersSelected;
	}

	public User getUserSearch() {
		return userSearch;
	}

	public void setUserSearch(User userSearch) {
		this.userSearch = userSearch;
	}

}
