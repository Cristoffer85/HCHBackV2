package com.marcus.awsWebServiceTest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UserDB")
public class UserProfile {

    @Id
    private String userId;

    @Indexed(unique = true)
    private String username;

    private String email;
}
