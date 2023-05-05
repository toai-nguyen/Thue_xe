/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxm.controller;

/**
 *
 * @author maxng
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import qlxm.entity.Motorbike;
import qlxm.func.MotorbikeFunc;
import qlxm.view.MotorbikeView;

public class MotorbikeController {
    private MotorbikeFunc motorbikeFunc;
    private MotorbikeView motorbikeView;
    
    public MotorbikeController(MotorbikeView view){
        this.motorbikeView = view;
        motorbikeFunc = new MotorbikeFunc();
        view.addAddMotorbikeListener(new AddMotorbikeListener());
        view.addEditMotorbikeListener(new EditMotorbikeListener());
        view.addDeleteMotorbikeListener(new DeleteMotorbikeListener());
        view.addListMotorbikeListener(new ListMotorbikeSelectionListener());
        view.addRentMotorbikeListener(new SortMotorbikeListener());
        view.addSearchLicenseMotorbikeListener(new SearchLicenseMotorbikeListener());
        view.addSearchModelMotorbikeListener(new SearchModelMotorbikeListener());
        view.addClearModelMotorbikeListener(new ClearMotorbikeListener());
    }
    
    public void showMotorbikeView(){
        List<Motorbike> listMotorbike = motorbikeFunc.getListMotorbike();
        motorbikeView.setVisible(true);
        motorbikeView.showListMotorbike(listMotorbike);
    }
    class AddMotorbikeListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Motorbike motor = motorbikeView.getMotorbikeInfo();
            if(motor != null ){
                motorbikeFunc.add(motor);
                motorbikeView.showMotorbike(motor);
                motorbikeView.showListMotorbike(motorbikeFunc.getListMotorbike());
                motorbikeView.showMessage("Thêm thành công !");
                motorbikeView.clearMotorbikeInfo();
            }
        }
    }
    class EditMotorbikeListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		Motorbike motorbike = motorbikeView.getMotorbikeInfo();
    		if(motorbike != null) {
    			motorbikeFunc.edit(motorbike);
    			motorbikeView.showMotorbike(motorbike);
    			motorbikeView.showListMotorbike(motorbikeFunc.getListMotorbike());
    			motorbikeView.showMessage("Cập nhật thành công");
    			motorbikeView.clearMotorbikeInfo();
    		}
    	}
    }
    class DeleteMotorbikeListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		Motorbike motorbike = motorbikeView.getMotorbikeInfo();
    		if(motorbike != null) {
    			motorbikeFunc.delete(motorbike);
    			motorbikeView.showMessage("Đã xóa !");
    			motorbikeView.clearMotorbikeInfo();
    			motorbikeView.showListMotorbike(motorbikeFunc.getListMotorbike());
    		}
    	}
    }
    class ListMotorbikeSelectionListener implements ListSelectionListener{
    	public void valueChanged (ListSelectionEvent e) {
    		motorbikeView.fillMotorbikeFromSelectedRow();
    	}
    }
    //lớp tìm kiếm các xe chưa được thuê
    class SortMotorbikeListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		List<Motorbike> rentList = motorbikeFunc.sortRentMotor();
    		motorbikeView.showMessage("Lọc thành công");
    		motorbikeView.showListMotorbike(rentList);
    	}
    }
    //lớp tìm kiếm xe theo biển số
    class SearchLicenseMotorbikeListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String license = motorbikeView.getLicenseSortTxt();
    		if(license == null || "".equals(license.trim())) {
    			motorbikeView.showMessage("Nhập biển số cần tìm");
    		}else {
    			if(motorbikeFunc.checkByLicense(license) == true) {
        			Motorbike motor = motorbikeFunc.searchByLicense(license);
        			motorbikeView.showMessage("Tìm kiếm thành công");
        			motorbikeView.showAMotorbike(motor);
        			motorbikeView.clearTxtSort();
        		}else {
        			motorbikeView.showMessage("Không tìm thấy dữ liệu");
        			motorbikeView.clearTxtSort();
        		}
    		}
    	}
    }
    //lớp tìm kiếm xe theo model
    class SearchModelMotorbikeListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String model = motorbikeView.getModelSortTxt();
    		if(model == null || "".equals(model.trim())) {
    			motorbikeView.showMessage("Nhập kiểu xe");
    			
    		}else {
    			List<Motorbike> motor = motorbikeFunc.sortMotorByModel(model);
        		if(motor.size() != 0) {
        			motorbikeView.showMessage("Tìm kiếm thành công");
        			motorbikeView.showListMotorbike(motor);
        			motorbikeView.clearTxtSort();
        		}else {
        			motorbikeView.showMessage("Không tìm thấy kiểu xe yêu cầu");
        			motorbikeView.clearTxtSort();
        		}
    		}
    	}
    }
    class ClearMotorbikeListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		motorbikeView.clearMotorbikeInfo();
    		motorbikeView.clearTxtSort();
    		motorbikeView.showListMotorbike(motorbikeFunc.getListMotorbike());
    	}
    }
}
