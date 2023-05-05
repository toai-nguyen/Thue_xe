/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxm.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import qlxm.entity.User;
import qlxm.func.UserFunc;
import qlxm.view.LoginView;
import qlxm.view.MotorbikeView;
/**
 *
 * @author maxng
 */
public class LoginController {
    private UserFunc userFunc;
    private LoginView loginView;
    private MotorbikeView motorbikeView;
    
    public LoginController(LoginView view){
        this.loginView = view;
        this.userFunc = new UserFunc();
        view.addLoginListener(new LoginListener());
    }
    public void showLoginView(){
        loginView.setVisible(true);
    }
    
    class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            User user = loginView.getUser();
            if(userFunc.checkUser(user)){
                motorbikeView = new MotorbikeView();
                MotorbikeController motorbikeController = new MotorbikeController(motorbikeView);
                motorbikeController.showMotorbikeView();
                loginView.setVisible(false);    
            }
            else{
                loginView.showMessage("Tài khoản hoặc mật khẩu không đúng");
            }
        }
    }
}
