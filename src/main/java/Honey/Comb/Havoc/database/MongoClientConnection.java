package Honey.Comb.Havoc.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import Honey.Comb.Havoc.entity.UserProfile;
import org.bson.Document;

public class MongoClientConnection {

    private static final String DATABASE_NAME = "YourDatabaseName";
    private static final String COLLECTION_NAME = "UserDB";
    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoClientConnection() {
        String connectionString = "mongodb+srv://cristofferostberg85:Tomtarna1@cluster0.imetavy.mongodb.net/?retryWrites=true&w=majority";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase(DATABASE_NAME);
    }

    public void saveUserProfile(UserProfile userProfile) {
        try {
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            Document userProfileDocument = new Document("username", userProfile.getUsername())
                    .append("email", userProfile.getEmail());

            collection.insertOne(userProfileDocument);
            System.out.println("User profile saved successfully!");
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
