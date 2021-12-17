package database;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class MongoDB {

    private static MongoClient client;
    private static final String DB_URI = "mongodb+srv://testuser:abcd123456@cluster0.ozbpu.mongodb.net/";

    public MongoDB(){

    }

    private static MongoDatabase getDatabase(){
        if(MongoDB.client==null){
            MongoDB.setClient(MongoClients.create(DB_URI));
        }

        return client.getDatabase("chuenangsao");
    }
    public MongoCollection<Document> getBookCollection(){
        return MongoDB.getDatabase().getCollection("book");
    }
    public MongoCollection<Document> getMemberCollection(){
        return MongoDB.getDatabase().getCollection("member");
    }
    public MongoCollection<Document> getAdminCollection(){
        return MongoDB.getDatabase().getCollection("admin");
    }
    public MongoCollection<Document> getNonMemberCollection(){return MongoDB.getDatabase().getCollection("non-member");}

    public static MongoClient getClient() {
        return client;
    }

    public static void setClient(MongoClient client) {
        MongoDB.client = client;
    }
}