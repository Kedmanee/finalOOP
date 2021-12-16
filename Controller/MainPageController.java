package Controller;

import View.MDI;
import View.MainPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageController implements ActionListener {
    private MainPage view;
    private MDI mdi;


    public MainPageController(MainPage view, MDI mdi) {
        this.mdi = mdi;
        this.view = view;
        this.view.getManage().addActionListener(this);
        this.view.getReg().addActionListener(this);
        this.view.getRent().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getReg())) {
            this.mdi.getMainPage().setVisible(false);
            this.mdi.getMainPage().hide();
            this.mdi.getDesktopPane().remove(this.mdi.getMainPage());
            this.mdi.getDesktopPane().add(this.mdi.getRegisterView());
            this.mdi.getRegisterView().setVisible(true);
            this.mdi.getRegisterView().show();

        } else if (e.getSource().equals(view.getManage())) {
            this.mdi.getMainPage().setVisible(false);
            this.mdi.getMainPage().hide();
            this.mdi.getDesktopPane().remove(this.mdi.getMainPage());
            this.mdi.getDesktopPane().add(this.mdi.getManageBooks());
            this.mdi.getManageBooks().setVisible(true);
            this.mdi.getManageBooks().show();

        } else if (e.getSource().equals(view.getRent())) {
            this.mdi.getMainPage().setVisible(false);
            this.mdi.getMainPage().hide();
            this.mdi.getDesktopPane().remove(this.mdi.getMainPage());
            this.mdi.getDesktopPane().add(this.mdi.getRentView());
            this.mdi.getRentView().setVisible(true);
            this.mdi.getRentView().show();
        }
    }
}

