package View;
import java.awt.*;
import javax.swing.*;
//loginp เป็น Panel ตรงปุ่ม Login ทำ setter/getter แล้ว

public class Login{
    private JFrame fr;
    public JLabel user, pass,log;
    private JPanel userp, passp, nop, loginp;
    private JButton login;
    private JTextField usert;private JPasswordField passt;
    private Font f1 = new Font("Arial Rounded MT Bold", Font.BOLD, 15);

    public Login(){
        fr = new JFrame();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new GridLayout(4,1));

        userp = new JPanel();
        user = new JLabel("Username: ");
        usert = new JTextField(15);
        userp.setLayout(new FlowLayout());
        user.setFont(f1);
        usert.setFont(f1);
        userp.add(user);
        userp.add(usert);

        userp.setBackground(new Color(69,68,68));
        user.setForeground(Color.WHITE);

        passp = new JPanel();
        pass = new JLabel("Password: ");
        passt = new JPasswordField(15);
        passp.setLayout(new FlowLayout());
        passp.add(pass);
        passp.add(passt);
        pass.setFont(f1);
        passt.setFont(f1);

        passp.setBackground(new Color(69,68,68));
        pass.setForeground(Color.WHITE);

        loginp = new JPanel();
        loginp.setLayout(new FlowLayout());
        login = new JButton("LOGIN");
        loginp.add(login);
        login.setFont(f1);

        loginp.setBackground(new Color(69,68,68));
        login.setBackground(new Color(250,0,100));
        login.setForeground(Color.WHITE);

        nop = new JPanel();
        log = new JLabel("LOGIN");
        nop.add(log);
        log.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));

        nop.setBackground(new Color(69,68,68));
        log.setForeground(Color.WHITE);

        fr.setLocationRelativeTo(null);
        fr.add(nop);
        fr.add(userp);
        fr.add(passp);
        fr.add(loginp);
        fr.setSize(400,350);
        fr.setBackground(new Color(69,68,68));
        fr.setResizable(false);
    }

    public JFrame getFr() {
        return fr;
    }

    public void setFr(JFrame fr) {
        this.fr = fr;
    }

    public JLabel getUser() {
        return user;
    }

    public void setUser(JLabel user) {
        this.user = user;
    }

    public JLabel getPass() {
        return pass;
    }

    public void setPass(JLabel pass) {
        this.pass = pass;
    }

    public JLabel getLog() {
        return log;
    }

    public void setLog(JLabel log) {
        this.log = log;
    }

    public JPanel getUserp() {
        return userp;
    }

    public void setUserp(JPanel userp) {
        this.userp = userp;
    }

    public JPanel getPassp() {
        return passp;
    }

    public void setPassp(JPanel passp) {
        this.passp = passp;
    }

    public JPanel getNop() {
        return nop;
    }

    public void setNop(JPanel nop) {
        this.nop = nop;
    }

    public JButton getLogin() {
        return login;
    }

    public void setLogin(JButton login) {
        this.login = login;
    }

    public JTextField getUsert() {
        return usert;
    }

    public void setUsert(JTextField usert) {
        this.usert = usert;
    }

    public JTextField getPasst() {
        return passt;
    }

    public void setPasst(JPasswordField passt) {
        this.passt = passt;
    }

    public void setLoginp(JPanel loginp) {this.loginp = loginp;}

    public JPanel getLoginp(){return loginp;}
}
