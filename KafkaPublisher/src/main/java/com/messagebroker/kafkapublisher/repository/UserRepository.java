package com.messagebroker.kafkapublisher.repository;

import com.messagebroker.kafkapublisher.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
