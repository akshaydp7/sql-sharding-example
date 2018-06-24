package com.sharding.example.repository;

import com.sharding.example.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByCurrentMinuteAndUserId(Integer currentMinute, Integer userId);
}

