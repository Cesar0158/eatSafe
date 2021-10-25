package pe.edu.upc.eatSafe.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
//import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.eatSafe.business.crud.AdminService;
import pe.edu.upc.eatSafe.model.entity.Admin;

@Named("adminView")
@ViewScoped
public class AdminView implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<Admin> admins;
	private Admin adminSelected;
	private List<Admin> adminsSelected;
	private Admin adminSearch;

	//@Inject
	private AdminService adminService;
	
	@PostConstruct
	public void init() {
		adminsSelected = new ArrayList<>();
		adminSearch = new Admin();
		getAllAdmin();
	}
	
	public boolean hasAdminsSelected() { /* Manipulacion de interfaz has=(seleccionar cuadritos en la vista) */
		if (adminsSelected.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hasAdminSelected() {
		if (adminsSelected.size() == 1) { /* para seleccionar solo 2 o 1 elemento */
			return true;
		}
		return false;
	}

	public void createNew() {
		adminSelected = new Admin();
	}

	public void editAdminSelected() {
		adminSelected = adminsSelected.get(0);
	}
	
	public void saveAdmin() {
		try {
			System.out.println(adminSelected.getId());
			System.out.println(adminSelected.getEmail());

			if (adminSelected.getId() == null) {
				adminService.create(adminSelected);
				admins.add(adminSelected);
			} else {
				adminService.update(adminSelected);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('adminDialog').hide()");
		PrimeFaces.current().ajax().update("adminDataTable");
	}
	
	public void deleteAdmin() {
		try {
			this.admins.remove(adminSelected);
			adminService.deleteById(this.adminSelected.getId());
			this.adminSelected = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		//PrimeFaces.current().ajax().update("form:messages","adminDataTable");
	}

	public void searchAdmin() {
		try	{
			admins = adminService.findByEmail(adminSearch.getEmail());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllAdmin() {
		try {
			admins = adminService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public Admin getAdminSelected() {
		return adminSelected;
	}

	public void setAdminSelected(Admin adminSelected) {
		this.adminSelected = adminSelected;
	}

	public List<Admin> getAdminsSelected() {
		return adminsSelected;
	}

	public void setAdminsSelected(List<Admin> adminsSelected) {
		this.adminsSelected = adminsSelected;
	}

	public Admin getAdminSearch() {
		return adminSearch;
	}

	public void setAdminSearch(Admin adminSearch) {
		this.adminSearch = adminSearch;
	}
}
