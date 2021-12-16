package View;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class RentView extends JInternalFrame {

    //ประกาศ Table แสดงข้อมูล
    private DefaultTableModel model;
    private JTable tableOfRentals;
    private JScrollPane scroll;
    private JButton btn_submit, btn_add, btn_delete, button, button2;
    private JPanel pHeading, pAddBook, pn_addbook, pButtonCTRL, pHeadTop, pTable_dltbtn, pDelete;
    private JLabel heading, bookCode, textDayrent;
    private JTextField bookCodeTF, textDayrentTF;

    //main Desktop
    private MDI frame;

    public RentView(boolean resizable, boolean closable, boolean maximizable, boolean iconificable, MDI frame) {
        super("model.Book Rentals", resizable, closable, maximizable, iconificable);
        this.frame = frame;
        this.init();
    }

    public JButton getBtn_delete() {
        return btn_delete;
    }

    public void setBtn_delete(JButton btn_delete) {
        this.btn_delete = btn_delete;
    }

    public void init() {
        button = new JButton();
        button2 = new JButton();
        //หัวข้อการจัดการหนังสือ
        heading = new JLabel("Book Rentals");
        heading.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 56));
        pHeading = new JPanel();
        pHeading.add(heading);
        pHeading.setBackground(new Color(69, 68, 68));
        heading.setForeground(Color.WHITE);

        //ตารางแสดงข้อมูลหนังสือ
        model = new DefaultTableModel();
        tableOfRentals = new JTable();
        scroll = new JScrollPane(tableOfRentals);
        model.addColumn("Book ID");
        model.addColumn("Book Name");
        model.addColumn("Number of rental days");
        model.addColumn("");
        tableOfRentals.setModel(model);
        //ปุ่มในตาราง

        //set ความสูง
        tableOfRentals.setRowHeight(100);
        //set font
        tableOfRentals.getTableHeader().setFont(frame.headFont.deriveFont(30f));
        tableOfRentals.getTableHeader().setOpaque(false);
        tableOfRentals.setFont(frame.titleFont);

        //สี ของ ตาราง
        tableOfRentals.setBackground(new Color(69, 69, 69));
        tableOfRentals.setForeground(Color.white);
        tableOfRentals.getTableHeader().setBackground(new Color(100, 100, 100));
        tableOfRentals.getTableHeader().setOpaque(false);
        tableOfRentals.getTableHeader().setForeground(Color.white);

        //text อยู่ตรงกลาง ในตาราง
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableOfRentals.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableOfRentals.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tableOfRentals.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        pTable_dltbtn = new JPanel(new BorderLayout());
        pTable_dltbtn.add(scroll);
        btn_delete = new JButton("Delete");
        btn_delete.setFont(frame.titleFont);
        pDelete = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        pDelete.add(btn_delete);
        pTable_dltbtn.add(pDelete, BorderLayout.SOUTH);

        //คืนหนังสือ
        pn_addbook = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        bookCode = new JLabel("Book ID");
        bookCode.setFont(frame.titleFont);
        bookCodeTF = new JTextField(5);
        textDayrent = new JLabel("No. Days");
        textDayrent.setFont(frame.titleFont);
        textDayrentTF = new JTextField(5);
        bookCodeTF.setFont(frame.titleFont);
        textDayrentTF.setFont(frame.titleFont);
        btn_add = new JButton("Add");

        btn_add.setFont(frame.titleFont);

        pn_addbook.add(bookCode);
        pn_addbook.add(bookCodeTF);
        pn_addbook.add(textDayrent);
        pn_addbook.add(textDayrentTF);
        pn_addbook.add(btn_add);

        //สีใน n_addbooks
        pn_addbook.setBackground(new Color(69, 68, 68));
        textDayrent.setForeground(Color.WHITE);
        bookCode.setForeground(Color.WHITE);
        btn_add.setBackground(new Color(250, 0, 100));
        btn_add.setForeground(Color.white);
        btn_delete.setBackground(new Color(250, 0, 100));
        btn_delete.setForeground(Color.white);

        //เพิ่มหนังสือ
        pAddBook = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        btn_submit = new JButton("Submit");
        pAddBook.add(btn_submit);

        btn_submit.setFont(frame.titleFont);

        //สีใน btn_submit
        pAddBook.setBackground(new Color(69, 68, 68));
        btn_submit.setForeground(Color.WHITE);
        btn_submit.setBackground(new Color(250, 0, 100));

        //นำเพิ่มกับคืนรวมกัน
        pButtonCTRL = new JPanel(new GridLayout(1, 2));
        pButtonCTRL.add(pn_addbook);
        pButtonCTRL.add(pAddBook);

        //หัวข้อกับค้นหารวมกัน
        pHeadTop = new JPanel(new GridLayout(1, 1));
        pHeadTop.add(pHeading);

        //ลบ Title bar
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        frame.setTitle("Book Rentals");
        this.setLayout(new BorderLayout());
        this.getContentPane().add(pHeadTop, BorderLayout.NORTH);
        this.getContentPane().add(pTable_dltbtn);
        this.getContentPane().add(pButtonCTRL, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(false);//แก้
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JTable getTableOfRentals() {
        return tableOfRentals;
    }

    public void setTableOfRentals(JTable tableOfRentals) {
        this.tableOfRentals = tableOfRentals;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JButton getBtn_submit() {
        return btn_submit;
    }

    public void setBtn_submit(JButton btn_submit) {
        this.btn_submit = btn_submit;
    }

    public JButton getBtn_add() {
        return btn_add;
    }

    public void setBtn_add(JButton btn_add) {
        this.btn_add = btn_add;
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

    public JPanel getPn_addbook() {
        return pn_addbook;
    }

    public void setPn_addbook(JPanel pn_addbook) {
        this.pn_addbook = pn_addbook;
    }

    public JPanel getpButtonCTRL() {
        return pButtonCTRL;
    }

    public void setpButtonCTRL(JPanel pButtonCTRL) {
        this.pButtonCTRL = pButtonCTRL;
    }

    public JPanel getpHeadTop() {
        return pHeadTop;
    }

    public void setpHeadTop(JPanel pHeadTop) {
        this.pHeadTop = pHeadTop;
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

    public JLabel getTextDayrent() {
        return textDayrent;
    }

    public void setTextDayrent(JLabel textDayrent) {
        this.textDayrent = textDayrent;
    }

    public JTextField getBookCodeTF() {
        return bookCodeTF;
    }

    public void setBookCodeTF(JTextField bookCodeTF) {
        this.bookCodeTF = bookCodeTF;
    }

    public JTextField getTextDayrentTF() {
        return textDayrentTF;
    }

    public void setTextDayrentTF(JTextField textDayrentTF) {
        this.textDayrentTF = textDayrentTF;
    }

    public MDI getFrame() {
        return frame;
    }

    public void setFrame(MDI frame) {
        this.frame = frame;
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