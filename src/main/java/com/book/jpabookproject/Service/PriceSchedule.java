package com.book.jpabookproject.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class PriceSchedule {
//    Logger log = LoggerFactory.getLogger(PriceSchedule.class);
//    @Scheduled(initialDelay = 2000, fixedRate = 2000)
//    @Async
//public void printPriceSchedule() throws InterruptedException {
//        Thread.sleep(4000);
//    log.info("compute price >>"+ LocalDateTime.now());
//
//}
}
