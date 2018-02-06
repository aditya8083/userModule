package com.coviam.ticket.user_microservice.repositories;

import com.coviam.ticket.user_microservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


}
