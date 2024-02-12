package com.marcus.awsWebServiceTest.repository;

import com.marcus.awsWebServiceTest.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
}
