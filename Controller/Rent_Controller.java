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
    public static List<Book> bookList;
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
        infoBook.getUpdate().addActionListener(this);
        infoBook.getDetele().addActionListener(this);
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
            else {
                main.getRentView().getBookCodeTF().setText("");
                main.getRentView().getTextDayrentTF().setText("");
            }
        }

        else if (ae.getSource().equals(main.getRentView().getBtn_submit())) {
            Book booklist = new Book();//รับลิสต์หนังสือมาจากdb
            Book book = new Book();//เอาไว้สำหรับรับหนังสือจะยืม
            if(idcheck.size() == 0){
                return;
            }
            this.main.getRentView().setVisible(false);
            this.main.getRentView().hide();
            this.main.getDesktopPane().remove(this.main.getRentView());
            this.main.getDesktopPane().add(this.main.getPricePreview());
            this.main.getPricePreview().setVisible(true);
            this.main.getPricePreview().show();
            bookList = new LinkedList<>();
            for (int j = 0; j < idcheck.size(); j++) {
                for (int i = 0; i < booklist.getBookList().size(); i++) {
                    int id = booklist.getBookList().get(i).getBookID();
                    //เอาไว้เพิ่มลิสต์หนังสือที่จะยืมทั้งหมด
                    if (idcheck.get(j) == id) {
                        book = booklist.getBookList().get(i);
                        book.setDay(daycheck.get(j));
                        book.setStatus(false);
                        bookList.add(book);//เพิ่มหนังสือนั้นเข้าไปในลิสต์

                        break;
                    }
                }
            }
            book.rentBooks(bookList);
            main.getRentView().getModel().setRowCount(0);
            idcheck.clear();
            daycheck.clear();
        }

        else if (ae.getSource().equals(button)) {
            int row = main.getRentView().getTableOfRentals().getSelectedRow();
            if (row == -1) {
                row = keepRow;
            } else {
                row = main.getRentView().getTableOfRentals().getSelectedRow();
                keepRow = row;
            }

            for (Book checkBook : bookDB.getBookList()) {
                System.out.println(checkBook.getBookID());
                if (main.getRentView().getTableOfRentals().getValueAt(row, 0).equals(String.valueOf(checkBook.getBookID())))  {

                    System.out.println(checkBook.getBookID());

                    infoBook.getBookId2().setText(String.valueOf(checkBook.getBookID()));
                    infoBook.getBookNameTF().setText(checkBook.getTitle());
                    infoBook.getBookNameTF().setEditable(false);
                    infoBook.getCategoryCB().setSelectedItem(checkBook.getCategories());
                    infoBook.getCategoryCB().setEnabled(false);
                    infoBook.getAuthorTF().setText(checkBook.getWriter());
                    infoBook.getAuthorTF().setEditable(false);
                    infoBook.getPricePerDayTF().setText(String.valueOf(checkBook.getPrice()));
                    infoBook.getPricePerDayTF().setEditable(false);
                    infoBook.getUpdate().setEnabled(false);
                    infoBook.getDetele().setEnabled(false);
                }
            }
            infoBook.getFrame().setVisible(true);
        }

        else if (ae.getSource().equals(main.getRentView().getBtn_delete())) {
            int index = (main.getRentView().getTableOfRentals().getSelectedRow());
            idcheck.remove(index);
            daycheck.remove(index);
            checkBooksIdForRent();
        }


        else if (ae.getSource().equals(main.getRentView().getBack())) {
            this.main.getRentView().setVisible(false);
            this.main.getRentView().hide();
            this.main.getDesktopPane().remove(this.main.getRentView());
            this.main.getDesktopPane().add(this.main.getMainPage());
            this.main.getMainPage().setVisible(true);
            this.main.getMainPage().show();

        }
        else if (ae.getSource().equals(infoBook.getUpdate())) {
            Book dummy = new Book(Integer.parseInt(infoBook.getBookId2().getText()), infoBook.getBookNameTF().getText(), (String) infoBook.getCategoryCB().getSelectedItem(), true, infoBook.getAuthorTF().getText(), Double.parseDouble(infoBook.getPricePerDayTF().getText()), 0);
            dummy.editBookDetail();
            checkBooksIdForRent();
            infoBook.getFrame().dispose();

        } else if (ae.getSource().equals(infoBook.getDetele())) {
            bookDB.deleteBook(Integer.parseInt(infoBook.getBookId2().getText()));
            infoBook.getFrame().dispose();
            main.getManageBooks().getModel().setRowCount(0);
            checkBooksIdForRent();


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
    public void checkBooksIdForRent(){
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
}