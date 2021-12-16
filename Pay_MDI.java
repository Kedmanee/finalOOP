import javax.swing.*;
import java.awt.*;
public class Pay_MDI extends JFrame{
    private PricePreview price_pre;
    private CardID cardid;
    private NonMem nonmem;
    private JDesktopPane desktop;

    
    public Pay_MDI(){
        price_pre = new PricePreview("Price Preview", false,false,false,false,this);
        cardid = new CardID("Card ID", false,false,false,false,this);
        nonmem = new NonMem("Non-Member", false,false,false,false,this);
        desktop = new JDesktopPane();
        
        desktop.add(price_pre);
        desktop.add(cardid);
        desktop.add(nonmem);
        
        this.add(desktop);
        this.setSize(415,390);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public PricePreview getPrice_pre() {
        return price_pre;
    }

    public void setPrice_pre(PricePreview price_pre) {
        this.price_pre = price_pre;
    }

    public JDesktopPane getDesktop() {
        return desktop;
    }

    public void setDesktop(JDesktopPane desktop) {
        this.desktop = desktop;
    }

    public CardID getCardid() {
        return cardid;
    }

    public void setCardid(CardID cardid) {
        this.cardid = cardid;
    }

    public NonMem getNonmem() {
        return nonmem;
    }

    public void setNonmem(NonMem nonmem) {
        this.nonmem = nonmem;
    }
    
}

