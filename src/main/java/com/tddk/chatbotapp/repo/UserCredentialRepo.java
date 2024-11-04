package com.tddk.chatbotapp.repo;

import com.tddk.chatbotapp.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepo extends JpaRepository<UserCredential, Integer> {
    Optional<UserCredential> findByUsername(String username);
}
