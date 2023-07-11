package com.client.clientdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface priceRepo extends JpaRepository<priceEntity, Long> {
}
