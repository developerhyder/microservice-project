package com.javatechie.spring.paypal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class PaypalController {

	@Autowired
	PaypalService service;

	@Autowired
	RestTemplate restTemplate;
	
	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";
	
	

	@RequestMapping(method = RequestMethod.POST,value="/pay")
	public String payment(@RequestBody Order order) {
		try {
			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:9090/" + CANCEL_URL,
					"http://localhost:9090/"+ SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "redirect:"+link.getHref();
				}
			}
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	 	@GetMapping(value = CANCEL_URL)
	    public String cancelPay() {
	        return "cancel";
	    }

	   @RequestMapping(value= SUCCESS_URL)
	    public ModelAndView successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
		   ModelAndView model=new ModelAndView("success");
	        try {
	            Payment payment = service.executePayment(paymentId, payerId);
	            System.out.println(payment.getId());
	            if (payment.getState().equals("approved")) {
	            	
	            	model.addObject("transactionId",payment.getId());
	            	System.out.println(model.getModel());
	            	System.out.println(model.getViewName());
	            	if(model.getViewName().equals("success")){
	            		String url="http://localhost:5000/buy/"+payment.getId()+"/2/12";
	            		restTemplate.getForObject(url, String.class);
	            	}else {
	            		String url="http://localhost:5000/buy/none/2/12";
	            		restTemplate.getForObject(url, String.class);
	            	}
	                return model;
	            }
	        } catch (PayPalRESTException e) {
	         System.out.println(e.getMessage());
	        }
	        return model;
	    }

}
