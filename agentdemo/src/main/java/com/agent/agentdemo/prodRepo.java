package com.agent.agentdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface prodRepo extends JpaRepository<productEntity, Long> {
}
