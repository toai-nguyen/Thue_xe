package qlxm.func;

import java.util.ArrayList;
import java.util.List;


//import java.util.Collection;
//import java.util.Comparator;

import qlxm.entity.Motorbike;
import qlxm.entity.MotorbikeXML;
import qlxm.utils.FileUtils;

public class MotorbikeFunc {
	private static final String MOTORBIKE_FILE_NAME = "motorbike.xml";
	private List<Motorbike> listMotorbike;
	
	public MotorbikeFunc() {
		this.listMotorbike = readListMotorbike();
		if(listMotorbike == null) {
			listMotorbike = new ArrayList<Motorbike>();
		}
	}

    public List<Motorbike> getListMotorbike() {
        return listMotorbike;
    }

    public void setListMotorbike(List<Motorbike> listMotorbike) {
        this.listMotorbike = listMotorbike;
    }
	/**
     * Lưu các đối tượng motorbike vào file motorbike.xml
     * 
     * @param motorbike
     */ 
	public void writeListMotorbike(List<Motorbike> motorbike) {
		MotorbikeXML motorbikeXML = new MotorbikeXML();
		motorbikeXML.setMotorbike(motorbike);
		FileUtils.writeXMLtoFile(MOTORBIKE_FILE_NAME, motorbikeXML);
	}
	/**
     * Đọc các đối tượng motorbike từ file motorbike.xml
     * 
     * @return list motorbike
     */
	public List<Motorbike> readListMotorbike(){
		List<Motorbike> list = new ArrayList<Motorbike>();
		MotorbikeXML motorbikeXML = (MotorbikeXML) FileUtils.readXMLFile(MOTORBIKE_FILE_NAME,MotorbikeXML.class);
		if(motorbikeXML != null) {
			list = motorbikeXML.getMotorbike();
		}
		return list;
	}
	
	 /**
     * thêm motorbike vào listMotorbike và lưu listMotorbike vào file
     * 
     * @param motorbike
     */
	public void add(Motorbike motorbike) {
		int id = 1;
		if(listMotorbike != null && listMotorbike.size() > 0) {
			id = listMotorbike.size() + 1;
		}
		motorbike.setId(id);
		listMotorbike.add(motorbike);
		writeListMotorbike(listMotorbike);
	}
	public void edit(Motorbike motorbike) {
		int size = listMotorbike.size();
		for(int i = 0; i < size; i++) {
			if(listMotorbike.get(i).getId() == motorbike.getId()) {
				listMotorbike.get(i).setModel(motorbike.getModel());
				listMotorbike.get(i).setLicense(motorbike.getLicense());
				listMotorbike.get(i).setRentDate(motorbike.getRentDate());
				listMotorbike.get(i).setRentName(motorbike.getRentName());
				listMotorbike.get(i).setStatus(motorbike.isStatus());
				writeListMotorbike(listMotorbike);
				break;
			}
		}
	}
	public boolean delete(Motorbike motor) {
		boolean isFound = false;
		int size = listMotorbike.size();
		for(int i = 0; i < size; i++) {
			if(listMotorbike.get(i).getId() == motor.getId()) {
				motor = listMotorbike.get(i);
				isFound = true;
				break;
			}
		}
		if(isFound) {
			listMotorbike.remove(motor);
			writeListMotorbike(listMotorbike);
			return true;
		}
		return false;
	}
	public List<Motorbike> searchByModel(String model) {
		int size = listMotorbike.size();
        List<Motorbike> motor = new ArrayList<Motorbike>();
        for(int i = 0; i < size; i++){
            if(listMotorbike.get(i).getModel().equals(model)){
                motor.add(listMotorbike.get(i));
            }
        }
        return motor;                               
	}
	public Motorbike searchByLicense(String license) {
		int size = listMotorbike.size();
        Motorbike motor = new Motorbike();
        for(int i = 0; i < size; i++){
            if(listMotorbike.get(i).getLicense().equals(license)){
                motor = listMotorbike.get(i);
                break;
            }
        }
        return motor;                             
	}
	public boolean checkByLicense(String license) {
		int size = listMotorbike.size();
		for(int i = 0; i < size; i++){
            if(listMotorbike.get(i).getLicense().equals(license)){
                return true;
            }
        }
		return false;
	}
	public List<Motorbike> sortRentMotor() {
		List<Motorbike> rentMotor = new ArrayList<Motorbike>();
		int size = listMotorbike.size();
        for(int i = 0; i < size; i++){
            if(listMotorbike.get(i).isStatus() == false){
                rentMotor.add(listMotorbike.get(i));
            }
        }
        return rentMotor;                                           
	}
	public List<Motorbike> sortMotorByModel(String model){
		List<Motorbike> motor = new ArrayList<Motorbike>();
		int size = listMotorbike.size();
		for(int i = 0; i < size; i++) {
			if(listMotorbike.get(i).getModel().contains(model)) {
				motor.add(listMotorbike.get(i));
			}
		}
		return motor;
	}
}
