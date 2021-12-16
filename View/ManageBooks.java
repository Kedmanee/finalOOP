package View;

import Controller.ManageBookController;
import model.Book;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class ManageBooks extends JInternalFrame implements InternalFrameListener {

    //ประกาศ Table แสดงข้อมูล
    private DefaultTableModel model;
    private JTable tableOfInfoBooks;
    private JScrollPane scroll;
    private JButton addBooks, button, returnBook, search,back;
    private JPanel pHeading,pBack, pAddBook, pReturnBook, pAddBookAndReturnBook, pSearch, pHeadingAndSearch,pHeadingAndBack;
    private JLabel heading, bookCode;
    private JTextField bookCodeTF, searchTF;
    private JComboBox searchCB;
    private ManageBookController controller;

    //main Desktop
    private MDI frame;

    public ManageBooks(boolean resizable, boolean closable, boolean maximizable, boolean iconificable, ManageBookController controller, MDI frame) {
        super("Manage Books", resizable, closable, maximizable, iconificable);
        this.controller = controller;
        this.frame = frame;
        addBooks = new JButton("Add a Book");
        init();
    }

    public void init() {

        //หัวข้อการจัดการหนังสือ
        heading = new JLabel("Book Management");
        heading.setFont(new Font("Arial Rounded MT Bold", 0, 52));
        pHeading = new JPanel();
        pHeading.add(heading);


        pHeadingAndBack = new JPanel(new BorderLayout());
        Path currentB = Paths.get("src/main/java/img/go-back-arrow.png");
        String b = currentB.toAbsolutePath().toString();
        ImageIcon backIcon = new ImageIcon(b);
        Image img = backIcon.getImage();
        Image newimg = img.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
        backIcon = new ImageIcon(newimg);
        back = new JButton(backIcon);
        pBack = new JPanel((new FlowLayout(FlowLayout.LEFT, 10, 10)));
        pBack.add(back);
        pHeadingAndBack.add(pBack, BorderLayout.WEST);
        pHeadingAndBack.add(pHeading);
        pHeading.setBackground(new Color(69,68,68));
        pBack.setBackground(new Color(69,68,68));
        heading.setForeground(Color.WHITE);
        back.setBackground(new Color(250,0,100));



        //ตารางแสดงข้อมูลหนังสือ
        model = new DefaultTableModel();
        tableOfInfoBooks = new JTable();
        scroll = new JScrollPane(tableOfInfoBooks);
        model.addColumn("Book ID");
        model.addColumn("Category");
        model.addColumn("Book Name");
        model.addColumn("");
        tableOfInfoBooks.setModel(model);
        //ปุ่มในตาราง
        button = new JButton();
        button.setBackground(new Color(69,69,69));
        button.setForeground(Color.white);

        //set ความสูง
        tableOfInfoBooks.setRowHeight(100);
        //set font
        tableOfInfoBooks.getTableHeader().setFont(frame.headFont.deriveFont(30f));
        tableOfInfoBooks.getTableHeader().setOpaque(false);
        tableOfInfoBooks.setFont(frame.titleFont);
        //สี ของ ตาราง
        tableOfInfoBooks.setBackground(new Color(69,69,69));
        tableOfInfoBooks.setForeground(Color.white);
        tableOfInfoBooks.getTableHeader().setBackground(new Color(100,100,100));
        tableOfInfoBooks.getTableHeader().setOpaque(false);
        tableOfInfoBooks.getTableHeader().setForeground(Color.white);
        //text อยู่ตรงกลาง ในตาราง
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableOfInfoBooks.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableOfInfoBooks.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tableOfInfoBooks.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        //คืนหนังสือ
        pReturnBook = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        bookCode = new JLabel("Book ID");
        bookCode.setFont(frame.titleFont);
        bookCodeTF = new JTextField(15);
        bookCodeTF.setFont(frame.titleFont);
        returnBook = new JButton("Return a Book");
        returnBook.setFont(frame.titleFont);
        pReturnBook.add(bookCode);
        pReturnBook.add(bookCodeTF);
        pReturnBook.add(returnBook);
        //สีใน ReturnBooks
        pReturnBook.setBackground(new Color(69,68,68));
        bookCode.setForeground(Color.WHITE);
        returnBook.setBackground(new Color(250,0,100));
        returnBook.setForeground(Color.white);

        //เพิ่มหนังสือ
        pAddBook = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        //addBooks = new JButton("Add a Book");
        pAddBook.add(addBooks);
        addBooks.setFont(frame.titleFont);
        //สีใน AddBooks
        pAddBook.setBackground(new Color(69,68,68));
        addBooks.setForeground(Color.WHITE);
        addBooks.setBackground(new Color(250,0,100));

        //นำเพิ่มกับคืนรวมกัน
        pAddBookAndReturnBook = new JPanel(new GridLayout(1, 2));
        pAddBookAndReturnBook.add(pReturnBook);
        pAddBookAndReturnBook.add(pAddBook);

        //ค้นหาหนังสือ
        pSearch = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        searchCB = new JComboBox();
        searchCB.addItem("Book ID");
        searchCB.addItem("Book Name");
        searchCB.setFont(frame.titleFont);
        ((JLabel)searchCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        searchTF = new JTextField(15);
        searchTF.setFont(frame.titleFont);



        //set path for icon
        Path current = Paths.get("src/main/java/img/search.png");
        String s = current.toAbsolutePath().toString();
        ImageIcon searchIcon = new ImageIcon(s);
//        Image img = searchIcon.getImage();
//        Image newimg = img.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
//        searchIcon = new ImageIcon(newimg);
        search = new JButton(searchIcon);




        pSearch.add(searchCB);
        pSearch.add(searchTF);
        pSearch.add(search);
        //สีใน SearchBar
        searchCB.setBackground(new Color(250,0,100));
        searchCB.setForeground(Color.white);
        pSearch.setBackground(new Color(69,68,68));
        search.setBackground(new Color(250,0,100));
        search.setForeground(Color.white);

        //หัวข้อกับค้นหารวมกัน
        pHeadingAndSearch = new JPanel(new GridLayout(2, 1));
        pHeadingAndSearch.add(pHeadingAndBack);
        pHeadingAndSearch.add(pSearch);

        //ลบ Title bar
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        frame.setTitle("Manage Books");
        this.setLayout(new BorderLayout());
        this.getContentPane().add(pHeadingAndSearch, BorderLayout.NORTH);
        this.getContentPane().add(scroll);
        this.getContentPane().add(pAddBookAndReturnBook, BorderLayout.SOUTH);
        this.pack();
//        this.setVisible(true);
        this.addInternalFrameListener(this);
        this.show();

    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
//        System.out.println(this.controller.getBooks());
//   this.controller.updateTable();
        for (Book infoBook : this.controller.getBooks()) {
            if (infoBook.isStatus() == true) {
                Object[] row = {infoBook.getBookID(), infoBook.getCategories(), infoBook.getTitle()};
                getModel().addRow(row);
                getTableOfInfoBooks().getColumn("").setCellRenderer(this.controller.new ButtonRenderer());
                getTableOfInfoBooks().getColumn("").setCellEditor(this.controller.new ButtonEditor(new JCheckBox()));
            }

        }
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {

    }

    public ManageBookController getController() {
        return controller;
    }

    public void setController(ManageBookController controller) {
        this.controller = controller;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JTable getTableOfInfoBooks() {
        return tableOfInfoBooks;
    }

    public void setTableOfInfoBooks(JTable tableOfInfoBooks) {
        this.tableOfInfoBooks = tableOfInfoBooks;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JButton getAddBooks() {
        return addBooks;
    }

    public void setAddBooks(JButton addBooks) {
        this.addBooks = addBooks;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JButton getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(JButton returnBook) {
        this.returnBook = returnBook;
    }

    public JButton getSearch() {
        return search;
    }

    public void setSearch(JButton search) {
        this.search = search;
    }

    public JPanel getpHeading() {
        return pHeading;
    }

    public void setpHeading(JPanel pHeading) {
        this.pHeading = pHeading;
    }

    public JPanel getpAddBook() {
        return pAddBook;
    }

    public void setpAddBook(JPanel pAddBook) {
        this.pAddBook = pAddBook;
    }

    public JPanel getpReturnBook() {
        return pReturnBook;
    }

    public void setpReturnBook(JPanel pReturnBook) {
        this.pReturnBook = pReturnBook;
    }

    public JPanel getpAddBookAndReturnBook() {
        return pAddBookAndReturnBook;
    }

    public void setpAddBookAndReturnBook(JPanel pAddBookAndReturnBook) {
        this.pAddBookAndReturnBook = pAddBookAndReturnBook;
    }

    public JPanel getpSearch() {
        return pSearch;
    }

    public void setpSearch(JPanel pSearch) {
        this.pSearch = pSearch;
    }

    public JPanel getpHeadingAndSearch() {
        return pHeadingAndSearch;
    }

    public void setpHeadingAndSearch(JPanel pHeadingAndSearch) {
        this.pHeadingAndSearch = pHeadingAndSearch;
    }

    public JLabel getHeading() {
        return heading;
    }

    public void setHeading(JLabel heading) {
        this.heading = heading;
    }

    public JLabel getBookCode() {
        return bookCode;
    }

    public void setBookCode(JLabel bookCode) {
        this.bookCode = bookCode;
    }

    public JTextField getBookCodeTF() {
        return bookCodeTF;
    }

    public void setBookCodeTF(JTextField bookCodeTF) {
        this.bookCodeTF = bookCodeTF;
    }

    public JTextField getSearchTF() {
        return searchTF;
    }

    public void setSearchTF(JTextField searchTF) {
        this.searchTF = searchTF;
    }

    public JComboBox getSearchCB() {
        return searchCB;
    }

    public void setSearchCB(JComboBox searchCB) {
        this.searchCB = searchCB;
    }

    public MDI getFrame() {
        return frame;
    }

    public void setFrame(MDI frame) {
        this.frame = frame;
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public JPanel getpBack() {
        return pBack;
    }

    public void setpBack(JPanel pBack) {
        this.pBack = pBack;
    }

    public JPanel getpHeadingAndBack() {
        return pHeadingAndBack;
    }

    public void setpHeadingAndBack(JPanel pHeadingAndBack) {
        this.pHeadingAndBack = pHeadingAndBack;
    }

    private static class HeaderRenderer implements TableCellRenderer {

        DefaultTableCellRenderer renderer;

        public HeaderRenderer(JTable table) {
            renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int col) {
            return renderer.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, col);
        }
    }
}