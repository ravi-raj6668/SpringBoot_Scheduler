package com.org.springbootscheduler.service;

import com.org.springbootscheduler.model.Employee;
import com.org.springbootscheduler.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final Random random = new Random();
    @Scheduled(fixedRate = 5000)
    public void addDBJob() {
        Employee user = new Employee();
        user.setName("User" + this.random.nextInt(111));
        userRepository.save(user);
        log.info("Add job service call in : " + new Date());
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void fetchDBJob() {
        List<Employee> userList = userRepository.findAll();
        log.info("Fetch service call in " + new Date());
        log.info("No. of records fetched : " + userList.size());
        log.info("userList : {} ", userList);
    }
}