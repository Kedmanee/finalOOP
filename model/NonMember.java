package model;

import com.mongodb.client.FindIterable;
import database.MongoDB;
import org.bson.Document;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NonMember extends User{
    private String address;
    private String nationalID;

    public NonMember(String firstName, String lastName, String address, String nationalID) {
        super("0000", firstName, lastName);
        this.address = address;
        this.nationalID = nationalID;
    }

    public NonMember() {
        this.address = "";
        this.nationalID = "";
    }

    public void addNonmemberDetail(){
        MongoDB mongoDB = new MongoDB();
        Document doc = new Document("id", super.getId())
                .append("firstName", super.getFirstName())
                .append("lastName", super.getLastName())
                .append("address", this.address)
                .append("nationalID", this.nationalID);
        mongoDB.getNonMemberCollection().insertOne(doc);
    }

    public List<NonMember> getNonMemberList(){
        List<NonMember> memberList = new LinkedList<NonMember>();
        MongoDB mongoDB = new MongoDB();
        List<Document> results = new ArrayList<>();
        FindIterable<Document> iterable = mongoDB.getNonMemberCollection().find();
        iterable.into(results);
        for(Document iterate : iterable) {
            NonMember member = new NonMember(iterate.getString("firstName"),iterate.getString("lastName"),iterate.getString("address"),iterate.getString("nationalID"));
            memberList.add(member);
        }
        return memberList;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }
}
