package database;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class MongoDB {

    private final MongoClient client;
    private final String DB_URI = "mongodb+srv://testuser:abcd123456@cluster0.ozbpu.mongodb.net/";

    public MongoDB(){
        this.client = MongoClients.create(DB_URI);
    }

    private MongoDatabase getDatabase(){
        return client.getDatabase("chuenangsao");
    }
    public MongoCollection<Document> getBookCollection(){
        return getDatabase().getCollection("book");
    }
    public MongoCollection<Document> getMemberCollection(){
        return getDatabase().getCollection("member");
    }
    public MongoCollection<Document> getAdminCollection(){
        return getDatabase().getCollection("admin");
    }
    public MongoCollection<Document> getNonMemberCollection(){return getDatabase().getCollection("non-member");}


}
