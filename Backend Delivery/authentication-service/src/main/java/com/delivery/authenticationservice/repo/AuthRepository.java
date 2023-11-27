package com.delivery.authenticationservice.repo;

import com.delivery.authenticationservice.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Users, Integer> {
    public Users findByEmailId(String emailId);

    public Users findByEmailIdAndPassword(String emailId, String password);
}
