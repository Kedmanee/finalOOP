package Controller;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author lenovo
 */

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import View.InfoBook;
import View.InsertBook;
import View.MDI;
import View.ManageBooks;
import model.Book;

public class ManageBookController implements ActionListener {
    private int test;
    private MDI main;
    private InsertBook addingBook;
    private InfoBook infoBook;
    //ปุ่มในตาราง
    private ButtonRenderer btn;
    private JButton button;
    private Book book;
    private int keepRow;
    private ManageBooks manageBooks;

    public ManageBookController(MDI main) {
        this.manageBooks = new ManageBooks(false, false, false, false, this, main);
        main.setManageBooks(this.manageBooks);
        this.main = main;
        addingBook = new InsertBook();
        infoBook = new InfoBook();

        btn = new ButtonRenderer();
        button = new JButton();
        btn.setFont(main.titleFont);
        button.setFont(main.titleFont);
        manageBooks.getAddBooks().addActionListener(this);
        main.getManageBooks().getSearch().addActionListener(this);
        main.getManageBooks().getReturnBook().addActionListener(this);
        main.getManageBooks().getBack().addActionListener(this);
        button.addActionListener(this);
        addingBook.getAdd().addActionListener(this);

        infoBook.getUpdate().addActionListener(this);
        infoBook.getDetele().addActionListener(this);

        button.setBackground(new Color(69, 69, 69));
        button.setForeground(Color.white);

        book = new Book();

    }

    public List<Book> getBooks() {
        Book dummy = new Book();
        return dummy.getBookList();

    }

    public void updateTable() {
        main.getManageBooks().getModel().setRowCount(0);
        for (Book infoBook : getBooks()) {
            if (infoBook.isStatus() == true) {
                Object[] row = {infoBook.getBookID(), infoBook.getCategories(), infoBook.getTitle()};
                main.getManageBooks().getModel().addRow(row);
                main.getManageBooks().getTableOfInfoBooks().getColumn("").setCellRenderer(btn);
                main.getManageBooks().getTableOfInfoBooks().getColumn("").setCellEditor(this.new ButtonEditor(new JCheckBox()));
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(main.getManageBooks().getAddBooks())) {
            addingBook.getFrame().setVisible(true);
            updateTable();
        } else if (ae.getSource().equals(addingBook.getAdd())) {
            if (addingBook.getNameTF().getText().equals("") || addingBook.getAuthorTF().getText().equals("") || addingBook.getPricePerDayTF().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter information of book.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                test = book.getBookList().size();
                Book dummy = new Book(checkID(0), addingBook.getNameTF().getText(), (String) addingBook.getCategoryCB().getSelectedItem(), true, addingBook.getAuthorTF().getText(), Double.parseDouble(addingBook.getPricePerDayTF().getText()), 0);
                dummy.insertBook();
                addingBook.getNameTF().setText("");
                addingBook.getAuthorTF().setText("");
                addingBook.getPricePerDayTF().setText("");
                addingBook.getCategoryCB().setSelectedItem("เบ็ดเตล็ด");
                main.getManageBooks().getModel().setRowCount(0);
                updateTable();
            }

        } else if (ae.getSource().equals(main.getManageBooks().getSearch())) {
            try {
                main.getManageBooks().getModel().setRowCount(0);
                if (main.getManageBooks().getSearchCB().getSelectedIndex() == 0) {
                    if (main.getManageBooks().getSearchTF().getText().equals("")) {
                        updateTable();
                    } else {
                        for (Book infoBook : getBooks()) {
                            if (Integer.parseInt(main.getManageBooks().getSearchTF().getText()) == infoBook.getBookID()) {
                                Object[] row = {infoBook.getBookID(), infoBook.getCategories(), infoBook.getTitle()};
                                main.getManageBooks().getModel().addRow(row);
                                main.getManageBooks().getTableOfInfoBooks().getColumn("").setCellRenderer(btn);
                                main.getManageBooks().getTableOfInfoBooks().getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));

                            }
                        }
                    }
                } else {
                    for (Book infoBook : getBooks()) {
                        if (main.getManageBooks().getSearchTF().getText().equals("")) {
                            updateTable();
                        } else {
                            if (main.getManageBooks().getSearchTF().getText().equals(infoBook.getTitle())) {
                                Object[] row = {infoBook.getBookID(), infoBook.getCategories(), infoBook.getTitle()};
                                main.getManageBooks().getModel().addRow(row);
                                main.getManageBooks().getTableOfInfoBooks().getColumn("").setCellRenderer(btn);
                                main.getManageBooks().getTableOfInfoBooks().getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));

                            }
                        }
                    }
                }


            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid book ID.", "Warning", JOptionPane.WARNING_MESSAGE);


            }

        } else if (ae.getSource().equals(main.getManageBooks().getReturnBook())) {
            book.returnBook(Integer.parseInt(main.getManageBooks().getBookCodeTF().getText()));
            main.getManageBooks().getModel().setRowCount(0);
            updateTable();
            main.getManageBooks().getBookCodeTF().setText("");

        } else if (ae.getSource().equals(button)) {
            int row;
            if (main.getManageBooks().getTableOfInfoBooks().getSelectedRow() == -1) {
                row = keepRow;
            } else {
                row = main.getManageBooks().getTableOfInfoBooks().getSelectedRow();
                keepRow = row;
            }


            System.out.println(main.getManageBooks().getTableOfInfoBooks().getModel().getValueAt(row, 0));
            for (Book checkBook : getBooks()) {
                if (main.getManageBooks().getTableOfInfoBooks().getModel().getValueAt(row, 0).equals(checkBook.getBookID())) {
                    infoBook.getBookId2().setText(String.valueOf(checkBook.getBookID()));
                    infoBook.getBookNameTF().setText(checkBook.getTitle());
                    infoBook.getCategoryCB().setSelectedItem(checkBook.getCategories());
                    infoBook.getAuthorTF().setText(checkBook.getWriter());
                    infoBook.getPricePerDayTF().setText(String.valueOf(checkBook.getPrice()));
                }

            }
            infoBook.getFrame().setVisible(true);

        } else if (ae.getSource().equals(infoBook.getUpdate())) {
            Book dummy = new Book(Integer.parseInt(infoBook.getBookId2().getText()), infoBook.getBookNameTF().getText(), (String) infoBook.getCategoryCB().getSelectedItem(), true, infoBook.getAuthorTF().getText(), Double.parseDouble(infoBook.getPricePerDayTF().getText()), 0);
            dummy.editBookDetail();
            try {
                TimeUnit.SECONDS.sleep(1);
                updateTable();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            infoBook.getFrame().dispose();

        } else if (ae.getSource().equals(infoBook.getDetele())) {
            book.deleteBook(Integer.parseInt(infoBook.getBookId2().getText()));
            infoBook.getFrame().dispose();
            main.getManageBooks().getModel().setRowCount(0);
            updateTable();


        } else if (ae.getSource().equals(main.getManageBooks().getBack())) {
            this.main.getManageBooks().setVisible(false);
            this.main.getManageBooks().hide();
            this.main.getDesktopPane().remove(this.main.getManageBooks());
            this.main.getDesktopPane().add(this.main.getMainPage());
            this.main.getMainPage().setVisible(true);
            this.main.getMainPage().show();

        }

    }


    public class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
            //ปรับสีปุ่มในตาราง
            setBackground(new Color(69, 69, 69));
            setForeground(Color.white);

        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText("More Detail");
            setFont(main.titleFont);
            return this;
        }
    }

    public class ButtonEditor extends DefaultCellEditor {

        private String label;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            label = (value == null) ? "More Detail.." : value.toString();
            button.setText(label);
            return button;
        }

        public Object getCellEditorValue() {
            return new String(label);
        }
    }

    public int checkID(int i) {

        while (true) {
            boolean check = true;
            for (Book book : getBooks()) {
                if (book.getBookID() == i) {
                    check = false;
                }
            }
            if (check) {
                return i;
            } else if (i > getBooks().size()) {
                return i;
            } else {
                i++;
            }
        }
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public MDI getMain() {
        return main;
    }

    public void setMain(MDI main) {
        this.main = main;
    }

    public InsertBook getAddingBook() {
        return addingBook;
    }

    public void setAddingBook(InsertBook addingBook) {
        this.addingBook = addingBook;
    }

    public ButtonRenderer getBtn() {
        return btn;
    }

    public void setBtn(ButtonRenderer btn) {
        this.btn = btn;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}