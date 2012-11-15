package com.socialIT.bean;

import java.util.List;
import java.util.Map;

import com.socialIT.entity.Bank;
import com.socialIT.entity.Contact;
import com.socialIT.entity.Need;
import com.socialIT.entity.Orphanage;
import com.socialIT.service.LocationService;
import com.socialIT.service.OrphanageService;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class OrphanageBean {
	@ManagedProperty(value = "#{orphanageService}")
	private OrphanageService orphanageService;
	
	@ManagedProperty(value = "#{locationService}")
	private LocationService locationService;

	private List<Bank> bankAccounts;
	private Orphanage orphanageDetails;
	private List<Contact> orphanageContacts;
	private List<Need> orphanageNeeds;
	
	//for saving
	private String name;
	private String location;
	private String details;
	private String address;
	
	public String add(){
		System.out.println("in add");
		int id = locationService.getLocationByName(location);
		System.out.println("locatio id is "+id);
		orphanageService.addOrphanage(name, details, address, id);
		return "AllOrphanages";
	}
	
	
	public String outcome() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String orphanageID = getOrphanageIDParam(fc);
		Long id = Long.parseLong(orphanageID);
		orphanageService.setOrphanageObject(orphanageService.getOrphanageById(id));
		Orphanage details = orphanageService.getOrphanageById(id);
		List<Contact> contacts = orphanageService.getOrphanageContacts(id);
		List<Bank> bankAccounts = orphanageService.getOrphanageAccounts(id);
		List<Need> needs = orphanageService.getOrphanageNeeds(id);
		setOrphanageDetails(details);
		setOrphanageContacts(contacts);
		setBankAccounts(bankAccounts);
		setOrphanageNeeds(needs);
		return "OrphanageDetails.xhtml";
	}

	// /get value from f:param
	public String getOrphanageIDParam(FacesContext fc) {
		Map<String, String> params = fc.getExternalContext()
				.getRequestParameterMap();
		return params.get("orphanageID");
	}

	public String deleteOrphanage() {
		System.out.println("in delete orphanage");
		Orphanage orphanage = orphanageService.getOrphanageObject();
		Long id = (long) orphanage.getId();
		orphanageService.deleteOrphanage(id);
		return "AllOrphanages.xhtml";
	}

	public OrphanageBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Orphanage> getOrphanages() {
		return orphanageService.retriveOrphanages();
	}

	public List<Need> getOrphanageNeeds() {
		return orphanageNeeds;
	}

	public void setOrphanageNeeds(List<Need> orphanageNeeds) {
		this.orphanageNeeds = orphanageNeeds;
	}

	public List<Bank> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<Bank> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public Orphanage getOrphanageDetails() {
		return orphanageDetails;
	}

	public void setOrphanageDetails(Orphanage orphanageDetails) {
		this.orphanageDetails = orphanageDetails;
	}

	public List<Contact> getOrphanageContacts() {
		return orphanageContacts;
	}

	public void setOrphanageContacts(List<Contact> orphanageContacts) {
		this.orphanageContacts = orphanageContacts;
	}

	public OrphanageService getOrphanageService() {
		return orphanageService;
	}

	public void setOrphanageService(OrphanageService orphanageService) {
		this.orphanageService = orphanageService;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public LocationService getLocationService() {
		return locationService;
	}


	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	
	
	


}
