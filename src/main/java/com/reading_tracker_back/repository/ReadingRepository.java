package com.reading_tracker_back.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reading_tracker_back.domain.Reading;

public interface ReadingRepository extends JpaRepository<Reading, UUID> {

}
