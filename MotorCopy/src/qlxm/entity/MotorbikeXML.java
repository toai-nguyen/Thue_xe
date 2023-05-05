package qlxm.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "motorbikes")
@XmlAccessorType(XmlAccessType.FIELD)

public class MotorbikeXML {
	private List<Motorbike> motorbike;
	
	public MotorbikeXML() { }
	
	public List<Motorbike> getMotorbike(){
		return motorbike;
	}
	public void setMotorbike(List<Motorbike> motorbike) {
		this.motorbike = motorbike;
	}
}
