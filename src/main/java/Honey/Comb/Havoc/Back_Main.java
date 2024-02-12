package Honey.Comb.Havoc;

import Honey.Comb.Havoc.database.MongoClientConnection;
import Honey.Comb.Havoc.entity.UserProfile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back_Main {

	public static void main(String[] args) {
		SpringApplication.run(Back_Main.class, args);

		// Example usage of MongoDBService
		MongoClientConnection mongoDBService = new MongoClientConnection();
		UserProfile userProfile = new UserProfile("1", "exampleUser", "user@example.com");
		mongoDBService.saveUserProfile(userProfile);
	}

}
