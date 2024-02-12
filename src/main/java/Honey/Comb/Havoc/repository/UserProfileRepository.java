package Honey.Comb.Havoc.repository;

import Honey.Comb.Havoc.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
}

