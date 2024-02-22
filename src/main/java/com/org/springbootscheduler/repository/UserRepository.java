package com.org.springbootscheduler.repository;

import com.org.springbootscheduler.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Employee, Integer> {
}
