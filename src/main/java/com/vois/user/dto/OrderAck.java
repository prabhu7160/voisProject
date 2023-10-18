package com.vois.user.dto;

import com.vois.user.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderAck {

	private String status;
	private double payableAmount;
	private PaymentInfo paymentInfo;
}