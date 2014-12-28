package org.dworski.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Async("executor")
    public void heavyweightOperation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Operation complete with " + Thread.currentThread().getName());
    }
}
