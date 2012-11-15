package com.socialIT.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import com.socialIT.entity.Location
;
import com.socialIT.service.LocationService;


@ManagedBean
public class LocationBean {
	@ManagedProperty(value = "#{locationService}")
	private LocationService locationService;
	private List<Location> allLocations;
	
	
	public LocationBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Location> getAllLocations(){
		allLocations = locationService.getAllLocations();
		return allLocations;
	}


	public LocationService getLocationService() {
		return locationService;
	}


	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}


	public void setAllLocations(List<Location> allLocations) {
		this.allLocations = allLocations;
	}
	
	
}
