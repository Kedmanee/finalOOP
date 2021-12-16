import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Book;
import model.Member;
import model.NonMember;

public class NonMem extends JInternalFrame implements ActionListener{
    private JPanel p_header, p_fname,p_lname, p_address, p_contract, p_buttons, p_cardid, p_id;
    private JLabel header, fname_header, lname_header, address_header, contract_header, cardid_header, id_header;
    private JTextField fname,lname, cardid, id, contract;
    private JScrollPane sp_address;
    private JTextArea address;
    private JButton back, next;
    private Pay_MDI frame;
    private Font f1 = new Font("Arial Rounded MT Bold", Font.BOLD, 15);
    private Book book = new Book();
    private Member member = new Member();
    
    public NonMem(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconificable, Pay_MDI frame){
        super(title, resizable, closable, maximizable, iconificable);
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
        back = new JButton("Back"); next = new JButton("Next");
        p_buttons.add(back); p_buttons.add(next);
        back.setFont(f1); next.setFont(f1);
        back.addActionListener(this);
        next.addActionListener(this);

        p_buttons.setBackground(new Color(69,68,68));
        back.setBackground(new Color(250,0,100));
        back.setForeground(Color.WHITE);
        next.setBackground(new Color(250,0,100));
        next.setForeground(Color.WHITE);
        
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
    
    @Override
    public void actionPerformed(ActionEvent ae){
        int index = 0;
        double totalprice = 0.00; //ราคาเช่า (Day x Price)
        //for(int i=0;i<RentController.bookList.size();i++){
            //totalprice += RentController.bookList.get(i).getPrice() * RentController.bookList.get(i).getDay();
        //}

        if(ae.getSource().equals(next)){
           //เช็ค ข้อมูล ถ้าถูกต้อง Alert ขึ้น แล้วกลับหน้าเช่าหนังสือ
           if(fname.getText().equals("") || lname.getText().equals("") || address.getText().equals("") || contract.getText().equals("")){
                JOptionPane.showMessageDialog(frame, "Please Insert Name or Address or Contract.");
           }
           
           else{
                JOptionPane.showMessageDialog(frame, book.getBookList().get(index).getTitle()+ " Rented\nTotal Price: "+ totalprice);
                NonMember nonmem = new NonMember(fname.getText(),lname.getText(),address.getText(),cardid.getText());
                nonmem.addNonmemberDetail();
           }
        }
        if(ae.getSource().equals(back)){
            this.frame.getPrice_pre().setVisible(true);
            this.frame.getNonmem().setVisible(false);
        }
    }

    public boolean isNumber(char ch){
        return ch >= '0' && ch <= '9';
    }
}
