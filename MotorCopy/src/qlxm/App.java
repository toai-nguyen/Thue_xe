package qlxm;

import java.awt.EventQueue;
import qlxm.controller.LoginController;
import qlxm.view.LoginView;

public class App {

    public static void main(String[] args ){
        EventQueue.invokeLater(new Runnable()
        {
           public void run(){
               LoginView view = new LoginView();
               LoginController controller = new LoginController(view);
               controller.showLoginView();
           } 
        });
    }
}
