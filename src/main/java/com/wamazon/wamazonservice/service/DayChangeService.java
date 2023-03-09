package com.wamazon.wamazonservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class DayChangeService {

    private LocalDateTime currentDateTime = LocalDateTime.now();

    @Scheduled(fixedDelay = 1000)
    private void changeCurrentDate() {
        currentDateTime = currentDateTime.plusHours(1);
        log.info("Текущая дата: {}", currentDateTime);
    }
}
