package com.example.auth.controllers;

import com.example.auth.models.Client;
import com.example.auth.repository.ClientRepository;
import com.example.auth.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.auth.models.Notification;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepo;

    @Autowired
    private ClientRepository clientRepo;

    @PostMapping("/launch-notification")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createNotification  = notificationRepo.save(notification);
        return new ResponseEntity<>(createNotification, HttpStatus.CREATED);
    }

    @GetMapping("/list-notifications/{userId}")
    public ResponseEntity<List<Notification>> getListNotificationByUserId(@PathVariable("userId") Long userId) {
        List<Notification> listNotifications = notificationRepo.findByUserId(userId);
        return new ResponseEntity<>(listNotifications, HttpStatus.OK);
    }

    @GetMapping("/count-notifications/{idUser}")
    public Long countNotificationByUserId(@PathVariable("idUser") Long idUser) {
        return notificationRepo.countNotificationByUserId(idUser);
    }
}
