package View;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;

public class MainPage extends JInternalFrame {

    private JFrame fr;
    public JLabel icon;
    private JPanel photop, mainp, bntp, mainbnt, bnthire;
    private JButton reg, rent, manage;
    private ImageIcon chns;
    private Font f1 = new Font("Arial Rounded MT Bold", Font.BOLD, 20);
    private MDI frame;

    public MainPage(boolean resizable, boolean closable, boolean maximizable, boolean iconificable, MDI frame) {
        super("Manage Books", resizable, closable, maximizable, iconificable);
        this.frame = frame;
        init();
    }

    public void init() {

        this.setLayout(new GridLayout(3,1));
        photop = new JPanel();

        Path currentB = Paths.get("src/main/java/img/1.png");
        String b = currentB.toAbsolutePath().toString();
        ImageIcon cicon = new ImageIcon(b);
        Image img = cicon.getImage();
        Image newimg = img.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
        cicon = new ImageIcon(newimg);

        icon = new JLabel(cicon);
        photop.setLayout(new FlowLayout());
        photop.add(icon);
        photop.setSize(100, 109);

        photop.setBackground(new Color(69,68,68));

        bntp = new JPanel();
        mainbnt = new JPanel();
        reg = new JButton("Register");
        reg.setFont(new Font("Arial Rounded MT Bold", 0, 72));
        manage = new JButton("Manage");
        manage.setFont(new Font("Arial Rounded MT Bold", 0, 72));
        mainbnt.add(bntp, BorderLayout.CENTER);
        bntp.setLayout(new FlowLayout());
        bntp.add(reg);
        bntp.add(manage);
        mainbnt.add(bntp);

        bntp.setBackground(new Color(69,68,68));
        mainbnt.setBackground(new Color(69,68,68));
        reg.setBackground(new Color(250,0,100)); reg.setForeground(Color.white);
        manage.setBackground(new Color(250,0,100)); manage.setForeground(Color.WHITE);

        bnthire = new JPanel();
        rent = new JButton("Rent");
        rent.setFont(new Font("Arial Rounded MT Bold", 0, 72));
        bnthire.setLayout(new FlowLayout());
        bnthire.add(rent);

        bnthire.setBackground(new Color(69,68,68));
        rent.setBackground(new Color(250,0,100)); rent.setForeground(Color.WHITE);

        this.add(photop);
        this.add(mainbnt);
        this.add(bnthire);
        //ลบ Title bar
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        frame.setTitle("Main Page");
        this.setSize(450,400);
        this.setVisible(true);
    }

    public JFrame getFr() {
        return fr;
    }

    public void setFr(JFrame fr) {
        this.fr = fr;
    }

    public JLabel getIcon() {
        return icon;
    }

    public void setIcon(JLabel icon) {
        this.icon = icon;
    }

    public JPanel getPhotop() {
        return photop;
    }

    public void setPhotop(JPanel photop) {
        this.photop = photop;
    }

    public JPanel getMainp() {
        return mainp;
    }

    public void setMainp(JPanel mainp) {
        this.mainp = mainp;
    }

    public JPanel getBntp() {
        return bntp;
    }

    public void setBntp(JPanel bntp) {
        this.bntp = bntp;
    }

    public JPanel getMainbnt() {
        return mainbnt;
    }

    public void setMainbnt(JPanel mainbnt) {
        this.mainbnt = mainbnt;
    }

    public JPanel getBnthire() {
        return bnthire;
    }

    public void setBnthire(JPanel bnthire) {
        this.bnthire = bnthire;
    }

    public JButton getReg() {
        return reg;
    }

    public void setReg(JButton reg) {
        this.reg = reg;
    }

    public JButton getRent() {
        return rent;
    }

    public void setRent(JButton rent) {
        this.rent = rent;
    }

    public JButton getManage() {
        return manage;
    }

    public void setManage(JButton manage) {
        this.manage = manage;
    }

    public ImageIcon getChns() {
        return chns;
    }

    public void setChns(ImageIcon chns) {
        this.chns = chns;
    }

}
