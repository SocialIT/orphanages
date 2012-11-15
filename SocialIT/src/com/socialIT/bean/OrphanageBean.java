package com.socialIT.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.socialIT.entity.Orphanage;


@ManagedBean
@SessionScoped
public class OrphanageBean {
	
	private Orphanage newOrphanage;
	private List<Orphanage> orphanages;
	
	
	public Orphanage getNewOrphanage() {
		return newOrphanage;
	}
	public void setNewOrphanage(Orphanage newOrphanage) {
		this.newOrphanage = newOrphanage;
	}
	public List<Orphanage> getOrphanages() {
		return orphanages;
	}
	public void setOrphanages(List<Orphanage> orphanages) {
		this.orphanages = orphanages;
	}
	
	
}
