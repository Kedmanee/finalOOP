package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import View.MDI;
import model.Book;
import model.Member;

public class RegisterView extends JInternalFrame{
    private JPanel p_header, p_fname,p_lname, p_address, p_contract, p_buttons, p_cardid, p_id;
    private JLabel header, fname_header, lname_header, address_header, contract_header, cardid_header, id_header;
    private JTextField fname,lname, cardid, id, contract;
    private JScrollPane sp_address;
    private JTextArea address;
    private JButton back, submit;
    private MDI frame;
    private Font f1 = new Font("Arial Rounded MT Bold", Font.BOLD, 15);
    private Book book = new Book();
    private Member member = new Member();

    public RegisterView(boolean resizable, boolean closable, boolean maximizable, boolean iconificable, MDI frame){
        super("", resizable, closable, maximizable, iconificable);
        this.frame = frame;
        this.init();
    }
    public void init(){
        this.setLayout(new GridLayout(8,1));

        p_header = new JPanel();
        p_fname = new JPanel();
        p_lname = new JPanel();
        p_address = new JPanel();
        p_contract = new JPanel();
        p_buttons = new JPanel();
        p_cardid = new JPanel();
        p_id = new JPanel();

        p_fname.setLayout(new FlowLayout());
        p_lname.setLayout(new FlowLayout());
        p_address.setLayout(new FlowLayout());
        p_contract.setLayout(new FlowLayout());
        p_buttons.setLayout(new FlowLayout());
        p_id.setLayout(new FlowLayout());

        //header
        header = new JLabel("Insert Your Name/Address/Contract");
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));

        p_header.add(header);
        p_header.setBackground(new Color(69,68,68));
        header.setForeground(Color.WHITE);

        //id
        id_header = new JLabel("Card ID: "); id = new JTextField(15);
        p_id.add(id_header); p_id.add(id);
        p_id.setBackground(new Color(69,68,68));
        id_header.setForeground(Color.WHITE);
        id_header.setFont(f1); id.setFont(f1);

        id.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                if(!isNumber(ch)){
                    e.consume();
                }
            }
        });

        //ชื่อ/นามสกุล
        fname_header = new JLabel("First Name: "); fname = new JTextField(15); lname_header = new JLabel("Last Name: "); lname = new JTextField(15);
        p_fname.add(fname_header); p_fname.add(fname); p_lname.add(lname_header); p_lname.add(lname);
        fname_header.setFont(f1); fname.setFont(f1); lname_header.setFont(f1); lname.setFont(f1);

        fname_header.setForeground(Color.WHITE);
        lname_header.setForeground(Color.WHITE);
        p_fname.setBackground(new Color(69,68,68));
        p_lname.setBackground(new Color(69,68,68));

        //บัตรประชาชน
        cardid_header = new JLabel("National ID: "); cardid = new JTextField(15);
        p_cardid.add(cardid_header); p_cardid.add(cardid);
        cardid_header.setFont(f1); cardid.setFont(f1);
        cardid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                if(!isNumber(ch)){
                    e.consume();
                }
            }
        });

        cardid_header.setForeground(Color.WHITE);
        p_cardid.setBackground(new Color(69,68,68));

        //ที่อยู่
        address_header = new JLabel("Address: "); address = new JTextArea(2,20);
        sp_address = new JScrollPane(address, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        p_address.add(address_header); p_address.add(sp_address);
        address_header.setFont(f1); sp_address.setFont(f1); address.setFont(new Font("Arial Rounded MT Bold", Font.BOLD,10));

        address_header.setForeground(Color.WHITE);
        p_address.setBackground(new Color(69,68,68));

        //phone number
        contract_header = new JLabel("Contract: "); contract = new JTextField(15);
        p_contract.add(contract_header); p_contract.add(contract);
        contract_header.setFont(f1); contract.setFont(f1);

        contract_header.setForeground(Color.WHITE);
        p_contract.setBackground(new Color(69,68,68));

        contract.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                if(!isNumber(ch)){
                    e.consume();
                }
            }
        });

        //ปุ่ม
        back = new JButton("Back"); submit = new JButton("Submit");
        p_buttons.add(back); p_buttons.add(submit);
        back.setFont(f1); submit.setFont(f1);

        p_buttons.setBackground(new Color(69,68,68));
        back.setBackground(new Color(250,0,100));
        back.setForeground(Color.WHITE);
        submit.setBackground(new Color(250,0,100));
        submit.setForeground(Color.WHITE);

        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        this.add(p_header);
        this.add(p_id);
        this.add(p_fname);
        this.add(p_lname);
        this.add(p_cardid);
        this.add(p_address);
        this.add(p_contract);
        this.add(p_buttons);
        this.setSize(400,350);
        this.setVisible(false);
    }

    public JPanel getP_header() {
        return p_header;
    }

    public void setP_header(JPanel p_header) {
        this.p_header = p_header;
    }

    public JPanel getP_fname() {
        return p_fname;
    }

    public void setP_fname(JPanel p_fname) {
        this.p_fname = p_fname;
    }

    public JPanel getP_lname() {
        return p_lname;
    }

    public void setP_lname(JPanel p_lname) {
        this.p_lname = p_lname;
    }

    public JPanel getP_address() {
        return p_address;
    }

    public void setP_address(JPanel p_address) {
        this.p_address = p_address;
    }

    public JPanel getP_contract() {
        return p_contract;
    }

    public void setP_contract(JPanel p_contract) {
        this.p_contract = p_contract;
    }

    public JPanel getP_buttons() {
        return p_buttons;
    }

    public void setP_buttons(JPanel p_buttons) {
        this.p_buttons = p_buttons;
    }

    public JPanel getP_cardid() {
        return p_cardid;
    }

    public void setP_cardid(JPanel p_cardid) {
        this.p_cardid = p_cardid;
    }

    public JPanel getP_id() {
        return p_id;
    }

    public void setP_id(JPanel p_id) {
        this.p_id = p_id;
    }

    public JLabel getHeader() {
        return header;
    }

    public void setHeader(JLabel header) {
        this.header = header;
    }

    public JLabel getFname_header() {
        return fname_header;
    }

    public void setFname_header(JLabel fname_header) {
        this.fname_header = fname_header;
    }

    public JLabel getLname_header() {
        return lname_header;
    }

    public void setLname_header(JLabel lname_header) {
        this.lname_header = lname_header;
    }

    public JLabel getAddress_header() {
        return address_header;
    }

    public void setAddress_header(JLabel address_header) {
        this.address_header = address_header;
    }

    public JLabel getContract_header() {
        return contract_header;
    }

    public void setContract_header(JLabel contract_header) {
        this.contract_header = contract_header;
    }

    public JLabel getCardid_header() {
        return cardid_header;
    }

    public void setCardid_header(JLabel cardid_header) {
        this.cardid_header = cardid_header;
    }

    public JLabel getId_header() {
        return id_header;
    }

    public void setId_header(JLabel id_header) {
        this.id_header = id_header;
    }

    public JTextField getFname() {
        return fname;
    }

    public void setFname(JTextField fname) {
        this.fname = fname;
    }

    public JTextField getLname() {
        return lname;
    }

    public void setLname(JTextField lname) {
        this.lname = lname;
    }

    public JTextField getCardid() {
        return cardid;
    }

    public void setCardid(JTextField cardid) {
        this.cardid = cardid;
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }

    public JTextField getContract() {
        return contract;
    }

    public void setContract(JTextField contract) {
        this.contract = contract;
    }

    public JScrollPane getSp_address() {
        return sp_address;
    }

    public void setSp_address(JScrollPane sp_address) {
        this.sp_address = sp_address;
    }

    public JTextArea getAddress() {
        return address;
    }

    public void setAddress(JTextArea address) {
        this.address = address;
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public MDI getFrame() {
        return frame;
    }

    public void setFrame(MDI frame) {
        this.frame = frame;
    }

    public Font getF1() {
        return f1;
    }

    public void setF1(Font f1) {
        this.f1 = f1;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public boolean isNumber(char ch){
        return ch >= '0' && ch <= '9';
    }
}