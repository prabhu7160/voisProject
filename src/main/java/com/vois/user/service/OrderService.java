package com.vois.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vois.user.dto.OrderAck;
import com.vois.user.dto.OrderRequest;
import com.vois.user.entity.PaymentInfo;
import com.vois.user.entity.Products;
import com.vois.user.repo.PaymentRepo;
import com.vois.user.repo.ProductRepo;
import static com.vois.user.util.PaymentValidation.validatePaymentInfo;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Transactional
	public OrderAck placeOrder(OrderRequest orderRequest) {
		Products product = orderRequest.getProductInfo();
		product = productRepo.save(product);
		
		PaymentInfo payInfo = orderRequest.getPaymentInfo();
		validatePaymentInfo(payInfo);
		
		product.setProductName(payInfo.getProductName());
		product.setProductStatus(product.getProductStatus());
		productRepo.save(product);
		paymentRepo.save(payInfo);
		return new OrderAck("SUCCESS",payInfo.getAmount(),payInfo);
		
	}
}