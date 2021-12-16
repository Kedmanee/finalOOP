package model;

import com.mongodb.client.FindIterable;
import database.MongoDB;
import org.bson.Document;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Admin extends User{
    private String password;

    public Admin(String id, String firstName, String lastName, String password) {
        super(id, firstName, lastName);
        this.password = password;
    }

    public Admin() {
        super();
        this.password = "";
    }

    //register new admin
    public void registerAdmin(){
        MongoDB mongoDB = new MongoDB();
        Document doc = new Document("id", super.getId())
                .append("firstName", super.getFirstName())
                .append("lastName", super.getLastName())
                .append("password", this.password);
        mongoDB.getAdminCollection().insertOne(doc);
    }
    //get all admin list
    public List<Admin> getAdminList(){
        List<Admin> adminList = new LinkedList<Admin>();
        MongoDB mongoDB = new MongoDB();
        FindIterable<Document> iterable = mongoDB.getAdminCollection().find();
        for(Document iterate : iterable) {
            Admin Admin = new Admin(iterate.getString("id"),iterate.getString("firstName"),iterate.getString("lastName"),iterate.getString("password"));
            adminList.add(Admin);
        }
        return adminList;
    }

    public boolean isLogin(String id, String password){
        List<Admin> adminList = new LinkedList<Admin>();
        MongoDB mongoDB = new MongoDB();
        Document doc = new Document("id", id);
        FindIterable<Document> iterable = mongoDB.getAdminCollection().find(doc);
        for(Document iterate : iterable) {
            if (iterate.getString("password").equals(password)){
                return true;
            }
        }
        return false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
