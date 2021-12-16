package model;

import com.mongodb.client.FindIterable;
import database.MongoDB;
import org.bson.Document;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Member extends User{

    private String address;
    private String nationalID;
    private String phoneNumber;

    public Member(String id, String firstName, String lastName, String address, String nationalID, String phoneNumber) {
        super(id, firstName, lastName);
        this.address = address;
        this.nationalID = nationalID;
        this.phoneNumber = phoneNumber;
    }

    public Member() {
        super();
        this.address = "";
        this.nationalID = "";
        this.phoneNumber = "";
    }

    //register new member
    public void registerMember(){
        MongoDB mongoDB = new MongoDB();
        Document doc = new Document("id", super.getId())
                .append("firstName", super.getFirstName())
                .append("lastName", super.getLastName())
                .append("address", this.address)
                .append("nationalID", this.nationalID)
                .append("phoneNumber", this.phoneNumber);
        mongoDB.getMemberCollection().insertOne(doc);
    }

    //get all member list
    public List<Member> getMemberList(){
        List<Member> memberList = new LinkedList<Member>();
        MongoDB mongoDB = new MongoDB();
        List<Document> results = new ArrayList<>();
        FindIterable<Document> iterable = mongoDB.getMemberCollection().find();
        iterable.into(results);
        for(Document iterate : iterable) {
            Member member = new Member(iterate.getString("id"),iterate.getString("firstName"),iterate.getString("lastName"),iterate.getString("address"),iterate.getString("nationalID"),iterate.getString("phoneNumber"));
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

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
}
