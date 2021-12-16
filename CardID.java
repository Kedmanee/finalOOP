import com.mongodb.client.FindIterable;
import model.Book;
import model.Member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CardID extends JInternalFrame implements ActionListener{
    private JLabel insert, id_insert;
    private JPanel p_insert, p_id, p_buttons;
    private JPasswordField id;
    private JButton accept, back;
    private Pay_MDI frame;
    private Font f1 = new Font("Arial Rounded MT Bold", Font.BOLD, 15);
    private Book book = new Book();
    private Member member = new Member();
    
    public CardID(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconificable, Pay_MDI frame){
        super(title, resizable, closable, maximizable, iconificable);
        this.frame = frame;
        this.init();
    }
    
    public void init(){
        this.setLayout(new GridLayout(3,1));
        p_insert = new JPanel();
        p_id = new JPanel();
        p_buttons = new JPanel();
        p_id.setLayout(new FlowLayout());
        p_buttons.setLayout(new FlowLayout());
        
        insert = new JLabel("Insert Your Card ID");
        insert.setHorizontalAlignment(JLabel.CENTER);
        insert.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        p_insert.add(insert);
        p_insert.setBackground(new Color(69,68,68));
        insert.setForeground(Color.WHITE);

        id_insert = new JLabel("Card ID: ");
        id = new JPasswordField(20);
        p_id.add(id_insert); p_id.add(id);
        id_insert.setFont(f1);
        id.setFont(f1);
        p_id.setBackground(new Color(69,68,68));
        id_insert.setForeground(Color.WHITE);

        
        accept = new JButton("Next");
        back = new JButton("Back");
        p_buttons.add(back); p_buttons.add(accept);
        back.setFont(f1);
        accept.setFont(f1);

        accept.setBackground(new Color(250,0,100));
        accept.setForeground(Color.WHITE);

        back.setBackground(new Color(250,0,100));
        back.setForeground(Color.WHITE);

        p_buttons.setBackground(new Color(69,68,68));
        
        accept.addActionListener(this);
        back.addActionListener(this);
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        this.add(p_insert);
        this.add(p_id);
        this.add(p_buttons);
        this.setSize(400,350);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        int index = 0;
        int check = 0;
        double totalprice = book.getBookList().get(index).getPrice() * book.getBookList().get(index).getDay(); //ราคาเช่า (Day x Price)
        if(ae.getSource().equals(accept)){
            while(index < member.getMemberList().size()){
                if(member.getMemberList().get(index).getId().equals(id.getText())==false){
                    index++;
                    check = 0;
                }
                else{
                    check = 1;
                    break;
                }
            }
            if(check == 0){
                JOptionPane.showMessageDialog(frame, "Invalid Card ID"); //ราคาตาม Collection หนังสือ
            }
            else{
                JOptionPane.showMessageDialog(frame, book.getBookList().get(index).getTitle()+ " Rented\nTotal Price: "+ totalprice);
            }
        }
        if(ae.getSource().equals(back)){
            this.frame.getPrice_pre().setVisible(true);
            this.frame.getCardid().setVisible(false);
        }
    }
}
