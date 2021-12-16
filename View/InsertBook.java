package View;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
import javax.swing.*;
import java.awt.*;

public class InsertBook {

    private JFrame frame;
    private JPanel pHeading,pAdd, pNameLB, pCategoryLB, pAuthorLB, pPricePerDayLB,pNameG,pCategoryG,pAuthorG,pPricePerDayG ,p1,p2,p3,p4,pForm;
    private JLabel name, category, author, pricePerDay, heading;
    private JTextField nameTF, authorTF, pricePerDayTF;
    private JComboBox categoryCB;
    private JButton add;

    public InsertBook() {
        frame = new JFrame("Adding Book");

        //หัวข้อ
        pHeading = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        heading = new JLabel("Adding a Book");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Arial Rounded MT Bold", 0, 50));
        pHeading.add(heading);
        pHeading.setBackground(new Color(69,68,68));

        //สร้าง form
        name = new JLabel("Book Name: ");
        nameTF = new JTextField(14);
        name.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        nameTF.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        pNameLB = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 5));
        pNameLB.add(name);
        pNameG = new JPanel(new GridLayout(1, 2));
        pNameG.add(pNameLB);
        pNameG.add(nameTF);
        p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
        p1.add(pNameG);

        //สีใน Name
        pNameLB.setBackground(new Color(69,68,68));
        name.setForeground(Color.WHITE);
        p1.setBackground(new Color(69,68,68));

        category = new JLabel("Categories: ");
        categoryCB = new JComboBox();
        categoryCB.addItem("Other");
        categoryCB.addItem("Comic/Manga");
        categoryCB.addItem("Novel");
        categoryCB.addItem("Business");
        categoryCB.addItem("Technology");
        categoryCB.addItem("History/Politics");
        category.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        categoryCB.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        categoryCB.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxxxxxx");
        pCategoryLB = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 5));
        pCategoryLB.add(category);
        pCategoryG = new JPanel(new GridLayout(1, 2));
        pCategoryG.add(pCategoryLB);
        pCategoryG.add(categoryCB);
        p2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
        p2.add(pCategoryG);
        ((JLabel)categoryCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        //สี ใน Category
        pCategoryLB.setBackground(new Color(69,68,68));
        category.setForeground(Color.WHITE);
        p2.setBackground(new Color(69,68,68));
        categoryCB.setBackground(new Color(255,0,100));

        author = new JLabel("Author: ");
        authorTF = new JTextField(14);
        author.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        authorTF.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        pAuthorLB = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 5));
        pAuthorLB.add(author);
        pAuthorG = new JPanel(new GridLayout(1, 2));
        pAuthorG.add(pAuthorLB);
        pAuthorG.add(authorTF);
        p3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
        p3.add(pAuthorG);

        //สี ใน Author
        pAuthorLB.setBackground(new Color(69,68,68));
        author.setForeground(Color.WHITE);
        p3.setBackground(new Color(69,68,68));

        pricePerDay = new JLabel("Price/Day: ");
        pricePerDayTF = new JTextField(14);
        pricePerDay.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        pricePerDayTF.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        pPricePerDayLB = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 5));
        pPricePerDayLB.add(pricePerDay);
        pPricePerDayG = new JPanel(new GridLayout(1, 2));
        pPricePerDayG.add(pPricePerDayLB);
        pPricePerDayG.add(pricePerDayTF);
        p4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
        p4.add(pPricePerDayG);

        //สีใน PricePerDay
        pPricePerDayLB.setBackground(new Color(69,68,68));
        pricePerDay.setForeground(Color.WHITE);
        p4.setBackground(new Color(69,68,68));

        pForm = new JPanel(new GridLayout(2, 2));
        pForm.add(p1);
        pForm.add(p2);
        pForm.add(p3);
        pForm.add(p4);

        //สร้างปุ่มเพิ่มหนังสือ
        add = new JButton("Add");
        add.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        pAdd = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pAdd.add(add);

        //สีปุ่ม Add a Book
        pAdd.setBackground(new Color(69,68,68));
        add.setBackground(new Color(255,0,100));
        add.setForeground(Color.WHITE);
        
        frame.add(pHeading, BorderLayout.NORTH);
        frame.add(pForm);
        frame.add(pAdd,BorderLayout.SOUTH);


        frame.setSize(1300,450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(false);
        
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getNameTF() {
        return nameTF;
    }

    public void setNameTF(JTextField nameTF) {
        this.nameTF = nameTF;
    }

    public JTextField getAuthorTF() {
        return authorTF;
    }

    public void setAuthorTF(JTextField authorTF) {
        this.authorTF = authorTF;
    }

    public JTextField getPricePerDayTF() {
        return pricePerDayTF;
    }

    public void setPricePerDayTF(JTextField pricePerDayTF) {
        this.pricePerDayTF = pricePerDayTF;
    }

    public JComboBox getCategoryCB() {
        return categoryCB;
    }

    public void setCategoryCB(JComboBox categoryCB) {
        this.categoryCB = categoryCB;
    }

    public JButton getAdd() {
        return add;
    }

    public void setAdd(JButton add) {
        this.add = add;
    }
    
}
