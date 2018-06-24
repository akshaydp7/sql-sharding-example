package com.sharding.example.service;

import com.sharding.example.entity.Order;
import com.sharding.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    public void insertAndReadDemo() throws Exception {
        Integer count = 10;
        List<Long> requestIds = new ArrayList<>(count);
        List<Order> orderTracking = new ArrayList<>(count);
        System.out.println("1.Insert Records");
        for (int i = 0; i < count; i++) {
            Calendar calendar = Calendar.getInstance();
            int minute = calendar.get(Calendar.MINUTE);
            Order order = new Order();
            order.setRequestTime(new Date());
            order.setStatus("PAYMENT");
            order.setUserId(i+1);
            order.setCurrentMinute(minute);
            orderTracking.add(order);
            requestIds.add(orderRepository.save(order).getRequestId());
            Thread.sleep(2000);
        }
        System.out.println("2.Query Inserted Records");
        for (Order orderz: orderTracking) {
            Order order = orderRepository.findByCurrentMinuteAndUserId(orderz.getCurrentMinute(), orderz.getUserId());
            System.out.println("OUTPUT IS :  " + order.toString());
        }
    }
}
