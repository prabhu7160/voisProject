package com.vois.user.dto;

import com.vois.user.entity.PaymentInfo;
import com.vois.user.entity.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
	private Products productInfo;
	
	private PaymentInfo paymentInfo;
}