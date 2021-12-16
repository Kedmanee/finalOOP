package Controller;
import View.MDI;
import View.RentView;
import model.Book;
import java.awt.*;
import java.awt.Component;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import View.InfoBook;

public class Rent_Controller implements ActionListener {

    private MDI main;
    private Book bookDB;
    private InfoBook infoBook;
    private List<Integer> idcheck = new LinkedList();
    private List<Integer> daycheck = new LinkedList();
    //ปุ่มในตาราง
    private ButtonRenderer btn;
    private JButton button;
    private int keepRow;
    private RentView view;


    public Rent_Controller(RentView view, MDI main) {
        this.view = view;
        this.main = main;
        bookDB = new Book();
        infoBook = new InfoBook();
        btn = new ButtonRenderer();
        btn.setFont(main.titleFont);
        button = new JButton();
        button.setFont(main.titleFont);
        button.setBackground(new Color(69, 69, 69));
        button.setForeground(Color.white);
        button.addActionListener(this);
        main.getRentView().getBtn_add().addActionListener(this);
        main.getRentView().getBtn_submit().addActionListener(this);
        main.getRentView().getBtn_delete().addActionListener(this);
        main.getRentView().getBack().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(main.getRentView().getBtn_add())) { //ถ้ากดปุ่มAdd
            int search = Integer.parseInt(main.getRentView().getBookCodeTF().getText());//รับIDที่จะเพิ่มมาจากผู้ใช้
            int days = Integer.parseInt(main.getRentView().getTextDayrentTF().getText());//รับวันที่จะเพิ่มมาจากผู้ใช้
            Book booklist = new Book();//รับลิสต์หนังสือมาจากdb
            Book book = new Book();//เอาไว้สำหรับรับหนังสือจะยืม
            if (idcheck.indexOf(search) == -1) {
                for (int i = 0; i < booklist.getBookList().size(); i++) { //ลูปตามจำนวนหนังสือที่มี
                    int id = booklist.getBookList().get(i).getBookID();// ให้รับIDของหนังสือจากdbทุกตัวมาเช็ค
                    if (id == search) {//เช็คว่ามีหนังสือที่จะยืมไหม
                        book = booklist.getBookList().get(i);
                        break;
                    }
                }
            } else {
                main.getRentView().getBookCodeTF().setText("");
                main.getRentView().getTextDayrentTF().setText("");
            }
            //เริ่มลูป

            //จบลูป
            if (!Objects.equals(book.getTitle(), "")& book.isStatus()==true) {
                Object[] row = {main.getRentView().getBookCodeTF().getText(), book.getTitle(), main.getRentView().getTextDayrentTF().getText()}; //รับข้อมูลมาใส่ในobject
                main.getRentView().getModel().addRow(row); //นำrowที่รับข้อมูลต่างๆไปใส่ในตาราง
                main.getRentView().getTableOfRentals().getColumn("").setCellRenderer(btn);
                main.getRentView().getTableOfRentals().getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
                idcheck.add(search); //เพิ่มไอดีในลิสต์
                daycheck.add(days); //เพิ่มวันในลิสต์
            }
            System.out.println("The id are " + idcheck); //เอาไว้เช็คลิสต์ที่เก็บไอดี
            System.out.println("The day are " + daycheck); //เอาไว้เช็คลิสต์ที่เก็บวัน
        }

        else if (ae.getSource().equals(main.getRentView().getBtn_submit())) {
            Book booklist = new Book();//รับลิสต์หนังสือมาจากdb
            Book book = new Book();//เอาไว้สำหรับรับหนังสือจะยืม
            this.main.getRentView().setVisible(false);
            this.main.getRentView().hide();
            this.main.getDesktopPane().remove(this.main.getRentView());
            this.main.getDesktopPane().add(this.main.getPricePreview());
            this.main.getPricePreview().setVisible(true);
            this.main.getPricePreview().show();

            for (int j = 0; j < idcheck.size(); j++) {
                for (int i = 0; i < booklist.getBookList().size(); i++) {
                    int id = booklist.getBookList().get(i).getBookID();
                    List<Book> bookList = new LinkedList<>();//เอาไว้เพิ่มลิสต์หนังสือที่จะยืมทั้งหมด
                    if (idcheck.get(j) == id) {
                        book = booklist.getBookList().get(i);
                        book.setDay(daycheck.get(j));
                        book.setStatus(false);
                        bookList.add(book);//เพิ่มหนังสือนั้นเข้าไปในลิสต์
                        book.rentBooks(bookList);
                        break;
                    }
                }
            }
        }

        else if (ae.getSource().equals(button)) {
            int row;
            if (main.getRentView().getTableOfRentals().getSelectedRow() == -1) {
                row = keepRow;
            } else {
                row = main.getRentView().getTableOfRentals().getSelectedRow();
                keepRow = row;
            }
            System.out.println();
            for (Book checkBook : bookDB.getBookList()) {
                System.out.println(main.getRentView().getTableOfRentals().getModel().getValueAt(row, 0));
                if (Integer.parseInt((String) main.getRentView().getTableOfRentals().getModel().getValueAt(row, 0)) == (checkBook.getBookID())) {
                    infoBook.getBookId2().setText(String.valueOf(checkBook.getBookID()));
                    infoBook.getBookNameTF().setText(checkBook.getTitle());
                    infoBook.getCategoryCB().setSelectedItem(checkBook.getCategories());
                    infoBook.getAuthorTF().setText(checkBook.getWriter());
                    infoBook.getPricePerDayTF().setText(String.valueOf(checkBook.getPrice()));
                }
            }
            infoBook.getFrame().setVisible(true);
        }

        else if (ae.getSource().equals(main.getRentView().getBtn_delete())) {
            int index = (main.getRentView().getTableOfRentals().getSelectedRow());
            idcheck.remove(index);
            daycheck.remove(index);
            /*for (int i : idcheck){
                System.out.println(i);
            }*/
            main.getRentView().getModel().setRowCount(0);
            for (int i = 0; i < idcheck.size(); i++) {
                for (Book checkbook : bookDB.getBookList()) {
                    if (idcheck.get(i) == checkbook.getBookID()) {
                        Object[] row = {idcheck.get(i), checkbook.getTitle(), daycheck.get(i)}; //รับข้อมูลมาใส่ในobject
                        main.getRentView().getModel().addRow(row); //นำrowที่รับข้อมูลต่างๆไปใส่ในตาราง
                        main.getRentView().getTableOfRentals().getColumn("").setCellRenderer(btn);
                        main.getRentView().getTableOfRentals().getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
                    }
                }
            }
        }


        else if (ae.getSource().equals(main.getRentView().getBack())) {
            this.main.getRentView().setVisible(false);
            this.main.getRentView().hide();
            this.main.getDesktopPane().remove(this.main.getRentView());
            this.main.getDesktopPane().add(this.main.getMainPage());
            this.main.getMainPage().setVisible(true);
            this.main.getMainPage().show();

        }

    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
            //ปรับสีปุ่มในตาราง
            setOpaque(true);
            setBackground(new Color(69, 69, 69));
            setForeground(Color.white);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "More Detail.." : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private String label;
        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }
        public Component getTableCellEditorComponent(JTable table, Object value,boolean isSelected, int row, int column) {
            label = (value == null) ? "More Detail.." : value.toString();
            button.setText(label);
            return button;
        }
        public Object getCellEditorValue() {
            return new String(label);
        }
    }
}