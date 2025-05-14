package com.example.auth.repository;

import com.example.auth.models.ERole;
import com.example.auth.models.Notification;
import com.example.auth.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query(value = "SELECT COUNT(*) FROM notification WHERE userId = :userId", nativeQuery = true)
    Long countNotificationByUserId(@Param("userId") Long userId);

    List<Notification> findByUserId(Long userId);
}

