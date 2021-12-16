package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.MDI;
import View.RegisterView;
import model.Admin;
import model.Member;

public class RegisterController implements ActionListener {
    private RegisterView view;
    private Member model;
    private MDI mdi;

    public RegisterController(RegisterView view, MDI mdi){
        this.view = view;
        this.mdi = mdi;
        //view = new RegisterView();
        model = new Member();
        view.getSubmit().addActionListener(this);
        view.getBack().addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent ae){
        int index = 0;
        double totalprice = 0.00; //ราคาเช่า (Day x Price)
        //for(int i=0;i<RentController.bookList.size();i++){
        //totalprice += RentController.bookList.get(i).getPrice() * RentController.bookList.get(i).getDay();
        //}

        if(ae.getSource().equals(view.getSubmit())){
            //เช็ค ข้อมูล ถ้าถูกต้อง Alert ขึ้น แล้วกลับหน้าเช่าหนังสือ
            if(view.getFname().getText().equals("") || view.getLname().getText().equals("") || view.getAddress().getText().equals("") || view.getContract().getText().equals("")){
                JOptionPane.showMessageDialog(view.getFrame(), "Please Insert Name or Address or Contract.");
            }

            else{
                Member member = new Member(view.getId().getText(),view.getFname().getText(),view.getLname().getText(),view.getAddress().getText(),view.getCardid().getText(),view.getContract().getText());
                member.registerMember();
                JOptionPane.showMessageDialog(view.getFrame(), "Register Success.");
            }
        }
        if(ae.getSource().equals(view.getBack())){
            this.mdi.getRegisterView().setVisible(false);
            this.mdi.getRegisterView().hide();
            this.mdi.getDesktopPane().remove(this.mdi.getRegisterView());
            this.mdi.getDesktopPane().add(this.mdi.getMainPage());
            this.mdi.getMainPage().setVisible(true);
            this.mdi.getMainPage().show();
        }
    }

}
