package com.messagebroker.kafka.kafkacustom.repository;

import com.messagebroker.kafka.kafkacustom.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findAllByIsSended(Long value);
}
