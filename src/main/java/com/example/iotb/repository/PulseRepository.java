package com.example.iotb.repository;

import com.example.iotb.model.Pulse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PulseRepository extends JpaRepository<Pulse, Long> {
    @Query(value = "SELECT MAX(e.value) FROM Pulse e WHERE e.date BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    Integer findMaxValueByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "SELECT MIN(e.value) FROM Pulse e WHERE e.date BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    Integer findMinValueByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "SELECT AVG(e.value) FROM Pulse e WHERE e.date BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    Integer findAvgValueByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "SELECT * FROM Pulse e WHERE e.date BETWEEN :startDate AND :endDate ORDER BY e.date ASC",
            nativeQuery = true)
    List<Pulse> findValuesByDateRange(LocalDateTime startDate, LocalDateTime endDate);

}
