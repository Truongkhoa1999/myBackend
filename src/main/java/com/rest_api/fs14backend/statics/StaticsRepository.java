package com.rest_api.fs14backend.statics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StaticsRepository extends JpaRepository<Statics, UUID> {
}
