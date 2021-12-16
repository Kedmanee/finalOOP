package View;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;
public class InfoBook {
    private JFrame frame;
    private JPanel pDelete,pUpdate,pBookNameF,pUpdateAndDelete,pHeading,pBookId,pTitle,pCategoryAndAuthor,pBookNameG,pCategoryG,pCategoryF,pAuthorG,pAuthorF,pPriceG,pPriceF,pInfo,p1,p2,p3,p4,p5;
    private JButton detele,update;
    private JLabel bookName, category, author, pricePerDay,bookId1,bookId2,heading,baht;
    private JTextField bookNameTF, authorTF, pricePerDayTF;
    private JComboBox categoryCB;

    public InfoBook(){
        frame = new JFrame("Information Of Book");
        pHeading = new JPanel();
        heading = new JLabel("INFORMATION OF BOOK");
        heading.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
        pHeading.add(heading); pHeading.setBackground(new Color(69,68,68));
        heading.setForeground(Color.white);

        //ชื่อหนังสือ
        bookName = new JLabel("Book name : ");
        bookName.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        bookNameTF = new JTextField(14);
        bookNameTF.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        p1= new JPanel(new FlowLayout(FlowLayout.RIGHT,10,10));
        p1.add(bookName);
        pBookNameG = new JPanel(new GridLayout(1,2));
        pBookNameG.add(p1);
        pBookNameG.add(bookNameTF);
        pBookNameF =new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        pBookNameF.add(pBookNameG); pBookNameF.setBackground(new Color(69,68,68)); p1.setBackground(new Color(69,68,68));
        bookName.setForeground(Color.WHITE);


        bookId1 = new JLabel("Book Id : ");
        bookId2 = new JLabel();
        bookId1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 28));
        bookId2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 28));
        pBookId = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        pBookId.add(bookId1);
        pBookId.add(bookId2);
        pBookId.setBackground(new Color(69,68,68));
        bookId1.setForeground(Color.WHITE); bookId2.setForeground((Color.WHITE));

        category = new JLabel("Category : ");
        category.setFont(new Font("Arial Rounded MT Bold", 0, 20));
        categoryCB = new JComboBox();
        categoryCB.addItem("Other");
        categoryCB.addItem("Comic/Manga");
        categoryCB.addItem("Novel");
        categoryCB.addItem("Business");
        categoryCB.addItem("Technology");
        categoryCB.addItem("History/Politics");
//        category.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
//        categoryCB.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        categoryCB.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxxxxxx");
        categoryCB.setFont(new Font("Arial Rounded MT Bold", 0, 20));
        p2= new JPanel(new FlowLayout(FlowLayout.RIGHT,10,10));
        p2.add(category);
        pCategoryG = new JPanel(new GridLayout(1,2));
        pCategoryG.add(p2);
        pCategoryG.add(categoryCB);
        pCategoryF = new JPanel();
        pCategoryF.add(pCategoryG);
        ((JLabel)categoryCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        p2.setBackground(new Color(69,68,68)); pCategoryF.setBackground(new Color(69,68,68));
        category.setForeground(Color.WHITE);
        categoryCB.setBackground(new Color(250,0,100)); categoryCB.setForeground(Color.white);

        author = new JLabel("Author : ");
        author.setFont(new Font("Arial Rounded MT Bold", 0, 20));
        authorTF = new JTextField(14);
        authorTF.setFont(new Font("Arial Rounded MT Bold", 0, 20));
        p3= new JPanel(new FlowLayout(FlowLayout.RIGHT,10,10));
        p3.add(author);
        pAuthorG = new JPanel(new GridLayout(1,2));
        pAuthorF = new JPanel();
        pAuthorG.add(p3);
        pAuthorG.add(authorTF);
        pAuthorF.add(pAuthorG);

        p3.setBackground(new Color(69,68,68)); pAuthorF.setBackground(new Color(69,68,68));
        author.setForeground(Color.white);

        pCategoryAndAuthor = new JPanel(new GridLayout(1,2));
        pCategoryAndAuthor.add(pCategoryF);
        pCategoryAndAuthor.add(pAuthorF);

        pricePerDay = new JLabel("Price per day : ");
        pricePerDay.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        baht = new JLabel(" Baht.");
        baht.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        pricePerDayTF = new JTextField();
        pricePerDayTF.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        p4= new JPanel(new FlowLayout(FlowLayout.RIGHT,10,10));
        p4.add(pricePerDay);
        p5 = new JPanel(new GridLayout(1,2));
        p5.add(pricePerDayTF);
        p5.add(baht);
        pPriceG = new JPanel(new GridLayout(1,2));
        pPriceG.add(p4);
        pPriceG.add(p5);
        pPriceF = new JPanel(new FlowLayout(FlowLayout.CENTER,40,10));
        pPriceF.add(pPriceG);

        pPriceF.setBackground(new Color(69,68,68)); p4.setBackground(new Color(69,68,68)); p5.setBackground(new Color(69,68,68));
        pricePerDay.setForeground(Color.WHITE); baht.setForeground(Color.WHITE);

        pInfo = new JPanel(new GridLayout(4,1));
        pInfo.add(pBookId);
        pInfo.add(pBookNameF);
        pInfo.add(pCategoryAndAuthor);
        pInfo.add(pPriceF);
        pInfo.setBackground(new Color(69,68,68));

        pUpdate = new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        update = new JButton("Update");
        update.setFont(new Font("Arial Rounded MT Bold", 0, 20));
        pUpdate.add(update);

        pUpdate.setBackground(new Color(69,68,68));
        update.setBackground(new Color(250,0,100));
        update.setForeground(Color.white);

        Path currentD = Paths.get("src/main/java/img/trash.png");
        String d = currentD.toAbsolutePath().toString();
        ImageIcon deleteIcon = new ImageIcon(d);
        Image img = deleteIcon.getImage();
        Image newimg = img.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
        deleteIcon = new ImageIcon(newimg);
        detele = new JButton(deleteIcon);
        pDelete = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,10));
        pDelete.add(detele);

        pDelete.setBackground(new Color(69,68,68));
        detele.setBackground(new Color(250,0,100));

        pUpdateAndDelete = new JPanel(new GridLayout(1,2));
        pUpdateAndDelete.add(pUpdate);
        pUpdateAndDelete.add(pDelete);

        frame.add(pHeading,BorderLayout.NORTH);
        frame.add(pInfo);
        frame.add(pUpdateAndDelete, BorderLayout.SOUTH);

        frame.setSize(1100,600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(false);
        frame.setResizable(false);


    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getpDelete() {
        return pDelete;
    }

    public void setpDelete(JPanel pDelete) {
        this.pDelete = pDelete;
    }

    public JPanel getpUpdate() {
        return pUpdate;
    }

    public void setpUpdate(JPanel pUpdate) {
        this.pUpdate = pUpdate;
    }

    public JPanel getpBookNameF() {
        return pBookNameF;
    }

    public void setpBookNameF(JPanel pBookNameF) {
        this.pBookNameF = pBookNameF;
    }

    public JPanel getpUpdateAndDelete() {
        return pUpdateAndDelete;
    }

    public void setpUpdateAndDelete(JPanel pUpdateAndDelete) {
        this.pUpdateAndDelete = pUpdateAndDelete;
    }

    public JPanel getpHeading() {
        return pHeading;
    }

    public void setpHeading(JPanel pHeading) {
        this.pHeading = pHeading;
    }

    public JPanel getpBookId() {
        return pBookId;
    }

    public void setpBookId(JPanel pBookId) {
        this.pBookId = pBookId;
    }

    public JPanel getpTitle() {
        return pTitle;
    }

    public void setpTitle(JPanel pTitle) {
        this.pTitle = pTitle;
    }

    public JPanel getpCategoryAndAuthor() {
        return pCategoryAndAuthor;
    }

    public void setpCategoryAndAuthor(JPanel pCategoryAndAuthor) {
        this.pCategoryAndAuthor = pCategoryAndAuthor;
    }

    public JPanel getpBookNameG() {
        return pBookNameG;
    }

    public void setpBookNameG(JPanel pBookNameG) {
        this.pBookNameG = pBookNameG;
    }

    public JPanel getpCategoryG() {
        return pCategoryG;
    }

    public void setpCategoryG(JPanel pCategoryG) {
        this.pCategoryG = pCategoryG;
    }

    public JPanel getpCategoryF() {
        return pCategoryF;
    }

    public void setpCategoryF(JPanel pCategoryF) {
        this.pCategoryF = pCategoryF;
    }

    public JPanel getpAuthorG() {
        return pAuthorG;
    }

    public void setpAuthorG(JPanel pAuthorG) {
        this.pAuthorG = pAuthorG;
    }

    public JPanel getpAuthorF() {
        return pAuthorF;
    }

    public void setpAuthorF(JPanel pAuthorF) {
        this.pAuthorF = pAuthorF;
    }

    public JPanel getpPriceG() {
        return pPriceG;
    }

    public void setpPriceG(JPanel pPriceG) {
        this.pPriceG = pPriceG;
    }

    public JPanel getpPriceF() {
        return pPriceF;
    }

    public void setpPriceF(JPanel pPriceF) {
        this.pPriceF = pPriceF;
    }

    public JPanel getpInfo() {
        return pInfo;
    }

    public void setpInfo(JPanel pInfo) {
        this.pInfo = pInfo;
    }

    public JPanel getP1() {
        return p1;
    }

    public void setP1(JPanel p1) {
        this.p1 = p1;
    }

    public JPanel getP2() {
        return p2;
    }

    public void setP2(JPanel p2) {
        this.p2 = p2;
    }

    public JPanel getP3() {
        return p3;
    }

    public void setP3(JPanel p3) {
        this.p3 = p3;
    }

    public JPanel getP4() {
        return p4;
    }

    public void setP4(JPanel p4) {
        this.p4 = p4;
    }

    public JPanel getP5() {
        return p5;
    }

    public void setP5(JPanel p5) {
        this.p5 = p5;
    }

    public JButton getDetele() {
        return detele;
    }

    public void setDetele(JButton detele) {
        this.detele = detele;
    }

    public JButton getUpdate() {
        return update;
    }

    public void setUpdate(JButton update) {
        this.update = update;
    }

    public JLabel getBookName() {
        return bookName;
    }

    public void setBookName(JLabel bookName) {
        this.bookName = bookName;
    }

    public JLabel getCategory() {
        return category;
    }

    public void setCategory(JLabel category) {
        this.category = category;
    }

    public JLabel getAuthor() {
        return author;
    }

    public void setAuthor(JLabel author) {
        this.author = author;
    }

    public JLabel getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(JLabel pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public JLabel getBookId1() {
        return bookId1;
    }

    public void setBookId1(JLabel bookId1) {
        this.bookId1 = bookId1;
    }

    public JLabel getBookId2() {
        return bookId2;
    }

    public void setBookId2(JLabel bookId2) {
        this.bookId2 = bookId2;
    }

    public JLabel getHeading() {
        return heading;
    }

    public void setHeading(JLabel heading) {
        this.heading = heading;
    }

    public JLabel getBaht() {
        return baht;
    }

    public void setBaht(JLabel baht) {
        this.baht = baht;
    }

    public JTextField getBookNameTF() {
        return bookNameTF;
    }

    public void setBookNameTF(JTextField bookNameTF) {
        this.bookNameTF = bookNameTF;
    }

    public JTextField getAuthorTF() {
        return authorTF;
    }

    public void setAuthorTF(JTextField authorTF) {
        this.authorTF = authorTF;
    }

    public JTextField getPricePerDayTF() {
        return pricePerDayTF;
    }

    public void setPricePerDayTF(JTextField pricePerDayTF) {
        this.pricePerDayTF = pricePerDayTF;
    }

    public JComboBox getCategoryCB() {
        return categoryCB;
    }

    public void setCategoryCB(JComboBox categoryCB) {
        this.categoryCB = categoryCB;
    }
}
