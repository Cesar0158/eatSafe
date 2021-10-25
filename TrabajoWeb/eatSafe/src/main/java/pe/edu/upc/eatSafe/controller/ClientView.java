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

import pe.edu.upc.eatSafe.business.crud.ClientService;
import pe.edu.upc.eatSafe.model.entity.Client;

@Named("clientView")
@ViewScoped
public class ClientView implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<Client> clients;
	private Client clientSelected;
	private List<Client> clientsSelected;
	private Client clientSearch;
	
	//@Inject
	private ClientService clientService;
	
	@PostConstruct
	public void init() {
		clientsSelected = new ArrayList<>();
		clientSearch = new Client();
		getAllClient();
	}
	
	public boolean hasClientsSelected() { /* Manipulacion de interfaz has=(seleccionar cuadritos en la vista) */
		if (clientsSelected.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hasClientSelected() {
		if (clientsSelected.size() == 1) { /* para seleccionar solo 2 o 1 elemento */
			return true;
		}
		return false;
	}

	public void createNew() {
		clientSelected = new Client();
	}

	public void editClientSelected() {
		clientSelected = clientsSelected.get(0);
	}
	
	public void saveClient() {
		try {
			System.out.println(clientSelected.getId());
			System.out.println(clientSelected.getEmail());

			if (clientSelected.getId() == null) {
				clientService.create(clientSelected);
				clients.add(clientSelected);
			} else {
				clientService.update(clientSelected);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('clientDialog').hide()");
		PrimeFaces.current().ajax().update("clientDataTable");
	}
	
	public void deleteClient() {
		try {
			this.clients.remove(clientSelected);
			clientService.deleteById(this.clientSelected.getId());
			this.clientSelected = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		//PrimeFaces.current().ajax().update("form:messages","clientDataTable");
	}

	public void searchClient() {
		try	{
			clients = clientService.findByEmail(clientSearch.getEmail());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllClient() {
		try {
			clients = clientService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client getClientSelected() {
		return clientSelected;
	}

	public void setClientSelected(Client clientSelected) {
		this.clientSelected = clientSelected;
	}

	public List<Client> getClientsSelected() {
		return clientsSelected;
	}

	public void setClientsSelected(List<Client> clientsSelected) {
		this.clientsSelected = clientsSelected;
	}

	public Client getClientSearch() {
		return clientSearch;
	}

	public void setClientSearch(Client clientSearch) {
		this.clientSearch = clientSearch;
	}
	

}
