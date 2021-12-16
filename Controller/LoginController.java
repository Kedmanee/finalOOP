package Controller;

import View.Login;
import View.MDI;
import model.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LoginController implements ActionListener {
    private Login view;
    private Admin model;
    private MDI test;

    public LoginController(){
        test = new MDI();
        view = new Login();
        model = new Admin();

        view.getUsert().addActionListener(this);
        view.getPasst().addActionListener(this);
        view.getLogin().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(view.getLogin())) {
            if (model.isLogin(view.getUsert().getText(), view.getPasst().getText())){
                view.getFr().setVisible(false);
                test.setVisible(true);

            }
            else {
                JOptionPane.showMessageDialog(null, "Incorrect Username/Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
