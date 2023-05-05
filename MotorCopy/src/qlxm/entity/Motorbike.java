package qlxm.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "motorbike")
@XmlAccessorType(XmlAccessType.FIELD)


public class Motorbike implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String license;
	private String model;
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate rentDate; 
	private String rentName;
	private boolean status;
	
	public Motorbike() {
		
	}
	
	public Motorbike(int id, String license, String model, LocalDate rentDate, String rentName, boolean status) {
		this.id = id;
		this.license = license;
		this.model = model;
		this.rentDate = rentDate;
		this.rentName = rentName;
		this.status = status;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDate getRentDate() {
		return rentDate;
	}

	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}

	public String getRentName() {
		return rentName;
	}

	public void setRentName(String rentName) {
		this.rentName = rentName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}