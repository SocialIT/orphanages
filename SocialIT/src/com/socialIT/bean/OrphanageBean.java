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
	
	private Orphanage newOrphanage;
	
	
	
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

}
