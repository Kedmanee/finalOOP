import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PricePreview extends JInternalFrame implements ActionListener{
    private JPanel p_price, p_buttons, p_choice;
    private JLabel price_header;
    private JLabel choice;
    private JButton non_mem, mem;
    private Pay_MDI frame;
    private Font f1 = new Font("Arial Rounded MT Bold", Font.BOLD, 15);
    
    public PricePreview(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconificable, Pay_MDI frame){
        super(title, resizable, closable, maximizable, iconificable);
        this.frame = frame;
        this.init();
    }
    
    public void init(){
        this.setLayout(new GridLayout(3,1));
        p_price = new JPanel();
        p_buttons = new JPanel();
        p_choice = new JPanel();
        p_price.setLayout(new BorderLayout());
        p_buttons.setLayout(new FlowLayout());
        p_choice.setLayout(new FlowLayout());
        
        price_header = new JLabel("The Price of [[Book's Title]]: (Book's Price)");
        price_header.setHorizontalAlignment(JLabel.CENTER);
        choice = new JLabel("Select The Pay Choice");
        choice.setHorizontalAlignment(JLabel.CENTER);
        p_choice.add(choice);
        p_price.add(price_header);
        choice.setFont(f1);
        price_header.setFont(f1);
        p_price.setBackground(new Color(69,68,68));
        price_header.setForeground(Color.WHITE);
        p_choice.setBackground(new Color(69,68,68));
        choice.setForeground(Color.WHITE);

        
        non_mem = new JButton("Non-Member");
        mem = new JButton("Member");
        p_buttons.add(mem);
        p_buttons.add(non_mem);
        mem.setFont(f1);
        non_mem.setFont(f1);
        non_mem.setBackground(new Color(250,0,100));
        non_mem.setForeground(Color.WHITE);
        mem.setBackground(new Color(250,0,100));
        mem.setForeground(Color.WHITE);
        p_buttons.setBackground(new Color(69,68,68));
        p_buttons.setForeground(Color.WHITE);
        
        non_mem.addActionListener(this);
        mem.addActionListener(this);
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        this.add(p_price, BorderLayout.CENTER);
        this.add(p_choice);
        this.add(p_buttons);
        this.setSize(400,350);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(mem)){
            this.frame.getPrice_pre().setVisible(false);
            this.frame.getCardid().setVisible(true);
        }
        
        if(ae.getSource().equals(non_mem)){
            this.frame.getPrice_pre().setVisible(false);
            this.frame.getNonmem().setVisible(true);
        }
    }
}
