package com.messagebroker.kafkasubscriber.repository;

import com.messagebroker.kafkasubscriber.entity.PulledEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PulledEmailRepository extends JpaRepository<PulledEmail, Long> {

}
