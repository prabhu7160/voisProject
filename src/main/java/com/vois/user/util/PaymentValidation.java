package com.vois.user.util;

import java.util.HashMap;
import java.util.Map;

import com.vois.user.entity.PaymentInfo;
import com.vois.user.exceptions.InsufficientAmount;

public class PaymentValidation {

	private static Map<String, Double> paymentDetails = new HashMap<>();
	
	static
	{
		paymentDetails.put("Mobile", 50000.0);
		paymentDetails.put("Laptop", 70000.0);
		paymentDetails.put("Fridge", 20000.0);
		paymentDetails.put("Mixer", 5000.0);
		
	}
	public static boolean validatePaymentInfo(PaymentInfo payInfo) {
		if(payInfo.getAmount()< paymentDetails.get(payInfo.getProductName()))
		{
			throw new InsufficientAmount("Insufficient amount");
		}
		else
			return true;
	}	
}