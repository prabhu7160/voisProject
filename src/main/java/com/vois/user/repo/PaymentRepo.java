package com.vois.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vois.user.entity.PaymentInfo;

public interface PaymentRepo extends JpaRepository<PaymentInfo, Long> {

}