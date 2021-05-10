package com.github.youssfbr.clients.model.repositories;

import com.github.youssfbr.clients.model.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
