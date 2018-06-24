package com.sharding.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order implements Serializable {

    private static final Long serialVersionUID = 661434701950670670L;

    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "status")
    private String status;

    @Column(name = "request_time")
    private Date requestTime;

    @Column(name = "current_minute")
    private Integer currentMinute;              // configure this to use as base for sharding

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(final Long requestId) {
        this.requestId = requestId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Integer getCurrentMinute() {
        return currentMinute;
    }

    public void setCurrentMinute(Integer currentMinute) {
        this.currentMinute = currentMinute;
    }

    @Override
    public String toString() {
        return String.format("request_id: %s, user_id: %s, status: %s, request_time: %s, current_minute: %s", requestId, userId, status, requestTime, currentMinute);
    }
}
