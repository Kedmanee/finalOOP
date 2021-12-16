package View;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author lenovo
 */

import Controller.MainPageController;
import Controller.ManageBookController;
import Controller.RegisterController;
import Controller.Rent_Controller;

import javax.swing.*;
import java.awt.*;

public class MDI extends JFrame {

    private MainPage mainPage;
    private JDesktopPane desktopPane;
    private ManageBooks manageBooks;
    private RegisterView registerView;
    public Font headFont = new Font("Angsana new", Font.BOLD, 56);
    public Font titleFont = new Font("Angsana new", Font.BOLD, 30);
    private MainPageController mainPageController;
    private RegisterController registerController;
    private ManageBookController manageBookController;
    private RentView rentView;
    private Rent_Controller rent_controller;
    private PricePreview pricePreview;
    private MemberVC memberVC;
    private NonMemberVC nonMemberVC;

    public RentView getRentView() {
        return rentView;
    }

    public void setRentView(RentView rentView) {
        this.rentView = rentView;
    }

    public ManageBookController getManageBookController() {
        return manageBookController;
    }

    public void setManageBookController(ManageBookController manageBookController) {
        this.manageBookController = manageBookController;
    }

    public MDI() {
        desktopPane = new JDesktopPane();
        desktopPane.setLayout(new BorderLayout());

        //สร้างหน้าการจัดการหนังสือ
        nonMemberVC = new NonMemberVC("Non-Member", false,false,false,false,this);
        memberVC = new MemberVC("Member", false,false,false,false,this);
        pricePreview = new PricePreview("Price Preview", false, false, false, false, this);
        rentView = new RentView(false, false, false, false, this);
        registerView = new RegisterView(false, false, false, false, this);
        mainPage = new MainPage(false, false, false, false, this);
        mainPageController = new MainPageController(mainPage, this);
        registerController = new RegisterController(registerView, this);
        rent_controller = new Rent_Controller(rentView, this);

        //manageBooks = new ManageBooks(false, false, false, false, this);
        manageBookController = new ManageBookController(this);


        //เพิ่มหน้าหนังสือ
        this.setLayout(new BorderLayout());
        this.add(desktopPane);

        this.desktopPane.add(mainPage, BorderLayout.CENTER);
        this.mainPage.setVisible(true);
        //
        // desktopPane.add(manageBooks);

        this.setMinimumSize(new Dimension(1200, 600));
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ให้ย่อแล้วอยู่ตรงกลาง
        this.setLocationRelativeTo(null);
        this.setVisible(false);

    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    public ManageBooks getManageBooks() {
        return manageBooks;
    }

    public void setManageBooks(ManageBooks manageBooks) {
        this.manageBooks = manageBooks;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    public RegisterView getRegisterView() {
        return registerView;
    }

    public void setRegisterView(RegisterView registerView) {
        this.registerView = registerView;
    }

    public PricePreview getPricePreview() {
        return pricePreview;
    }

    public MemberVC getMemberVC() {
        return memberVC;
    }

    public void setMemberVC(MemberVC memberVC) {
        this.memberVC = memberVC;
    }

    public NonMemberVC getNonMemberVC() {
        return nonMemberVC;
    }

    public void setNonMemberVC(NonMemberVC nonMemberVC) {
        this.nonMemberVC = nonMemberVC;
    }

    public void setPricePreview(PricePreview pricePreview) {
        this.pricePreview = pricePreview;
    }
}


