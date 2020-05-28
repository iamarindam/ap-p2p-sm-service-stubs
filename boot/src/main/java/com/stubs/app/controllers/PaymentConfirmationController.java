package com.stubs.app.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stubs.app.model.payconf.PaymentConfirmationCoreRequest;
import com.stubs.app.model.payconf.PaymentConfirmationCoreResponse;
import com.stubs.app.model.payconf.PaymentConfirmationCoreUpdateRequest;
import com.stubs.app.model.payconf.PaymentConfirmationCoreUpdateResponse;
import com.stubs.app.model.payconf.PaymentConfirmationRIRequest;
import com.stubs.app.model.payconf.PaymentConfirmationRIResponse;
import com.stubs.app.service.PaymentConfirmationService;
import com.stubs.app.util.StubsUtil;

@RestController
@RequestMapping("/payment-confirmation")
public class PaymentConfirmationController {

	@Autowired
	private PaymentConfirmationService service;

	@Value("${signing.generation.path}" )
	private String signatureGenURL;

	@Value("${timeout}" )
	private Long timeout;

	@PostMapping(value = "/core-info", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<PaymentConfirmationCoreResponse> informPaymentConfToCore(
			@RequestHeader(value = "X-Participant-Id") String participantId,
			@RequestHeader(value = "X-Correlation-Id") String correlationId,
			@RequestHeader(value = "X-Business-Message-Identifier") String businessMsgIdentifier,
			@RequestHeader(value = "X-Delivery-Control") String deliveryControl,
			@RequestBody PaymentConfirmationCoreRequest request) {

		System.out.println("Payment confirmation Stub execution started ....");
		PaymentConfirmationCoreResponse resp = new PaymentConfirmationCoreResponse();

		if(request.getInitiatingPartyId().toString().equalsIgnoreCase("9740629804"))
			 resp = service.informPaymentConfToCore("9740629804");
		
		else if(!request.getReceivingPartyId().toString().equalsIgnoreCase("ZAPP Processor"))
			resp = service.informPaymentConfToCore("9740629805");
		
		else if(null!=request.getTransactionIdentification() && request.getTransactionIdentification().getSchmTxnId().toString().equalsIgnoreCase("9740629806"))
			resp = service.informPaymentConfToCore("9740629806");
		
		else if(!request.getAuthorisation().getResult().toString().equalsIgnoreCase("APPR")
				&& !request.getAuthorisation().getResult().toString().equalsIgnoreCase("DECL"))
				resp = service.informPaymentConfToCore("9740629807");
		
		else if(null!=request.getSettlementInfo() && null!=request.getSettlementInfo().getSettlementMethod()) {
			if(!request.getSettlementInfo().getSettlementMethod().toString().equalsIgnoreCase("ONUS")
				&& !request.getSettlementInfo().getSettlementMethod().toString().equalsIgnoreCase("CLRG"))
				resp = service.informPaymentConfToCore("9740629810");
			
			else {
				if(request.getAuthorisation().getResult().toString().equalsIgnoreCase("DECL")) {
				if(!request.getAuthorisation().getResultDetails().toString().equalsIgnoreCase("OTHR")
						&& !request.getAuthorisation().getResultDetails().toString().equalsIgnoreCase("RJCT"))
					resp = service.informPaymentConfToCore("9740629808");
				}
			}
				
		}
				
		else if(request.getAuthorisation().getResult().toString().equalsIgnoreCase("APPR")) {
			if(null==request.getSettlementInfo())
				resp = service.informPaymentConfToCore("9740629809");
				
			else
				resp = service.informPaymentConfToCore(participantId);
		}
		
		else if(!request.getAuthorisation().getResult().toString().equalsIgnoreCase("APPR")) {
			
			if(!request.getAuthorisation().getResult().toString().equalsIgnoreCase("DECL")) {
			
				if(null!=request.getSettlementInfo())
				resp = service.informPaymentConfToCore("9740629809");
			
				else
				resp = service.informPaymentConfToCore(participantId);
			
			}
			else if(request.getAuthorisation().getResult().toString().equalsIgnoreCase("DECL")) {
				if(!request.getAuthorisation().getResultDetails().toString().equalsIgnoreCase("OTHR")
						&& !request.getAuthorisation().getResultDetails().toString().equalsIgnoreCase("RJCT"))
					resp = service.informPaymentConfToCore("9740629808");
				
				else
					resp = service.informPaymentConfToCore(participantId);
			}
			
			else
				resp = service.informPaymentConfToCore(participantId);
			}
				
		else if(request.getAuthorisation().getResult().toString().equalsIgnoreCase("DECL")) {
			if(!request.getAuthorisation().getResultDetails().toString().equalsIgnoreCase("OTHR")
					&& !request.getAuthorisation().getResultDetails().toString().equalsIgnoreCase("RJCT"))
				resp = service.informPaymentConfToCore("9740629808");
			
			else
				resp = service.informPaymentConfToCore(participantId); 
		}
		
		else
			 resp = service.informPaymentConfToCore(participantId);

		
		if (null != resp.getErrors()) {
			resp.setStatusCode(null);
			return new ResponseEntity<>(resp, HttpStatus.NOT_ACCEPTABLE);
		} else {
			
			if(participantId.toString().equalsIgnoreCase("119588")) {
				
				resp = service.informPaymentConfToCore(participantId);
				resp.setStatusCode(null);
				System.out.println("Payment confirmation Stub execution completed ....");
				return new ResponseEntity<>(resp, HttpStatus.NOT_ACCEPTABLE);
			}
			
			else {
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-Correlation-Id", correlationId);
			
			if(resp.getStatusCode()==null)
				resp = service.informPaymentConfToCore(participantId);
			
			if (participantId.toString().equalsIgnoreCase("9844295504")) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			System.out.println("Payment confirmation Stub execution completed ....");

			return new ResponseEntity<>(resp, headers, HttpStatus.OK);
			}
		}
	}

	@PostMapping(value = "/pi-info", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<PaymentConfirmationRIResponse> informPaymentConfToRI(
			@RequestHeader(value = "X-Participant-Id") String participantId,
			@RequestHeader(value = "X-Business-Message-Identifier") String businessMsgIdentifier,
			@RequestHeader(value = "X-Delivery-Control") String deliveryControl,
			@RequestHeader(value = "X-JWS-Signature") String signature, 
			@RequestBody PaymentConfirmationRIRequest request) {

		System.out.println("Payment confirmation Stub SM-RI execution started ....");

		PaymentConfirmationRIResponse resp = service.informPaymentConfToRI(participantId);

		if (null != resp.getErrors()) {
			resp.setStatusCode(null);
			return new ResponseEntity<>(resp, HttpStatus.NOT_ACCEPTABLE);
		} else {

			HttpHeaders headers = new HttpHeaders();
			headers.set("X-Participant-Id", participantId);
			headers.set("X-Business-Message-Identifier", businessMsgIdentifier);
			headers.set("X-Delivery-Control", deliveryControl);
			//headers.set("X-JWS-Signature", "ABC456");// as per the MM sheet setting signature as ABC456, discussed with BA.
			headers.set("X-JWS-Signature", generateSignature(resp));
			if (participantId.toString().equalsIgnoreCase("9620111008")) {
				try {
					Thread.sleep(timeout);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("Payment confirmation Stub SM-RI execution completed ....");

			return new ResponseEntity<>(resp, headers, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/core-update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<PaymentConfirmationCoreUpdateResponse> paymentConfUpdateToCore(
			@RequestHeader(value = "X-Participant-Id") String participantId,
			@RequestHeader(value = "X-Correlation-Id") String correlationId,
			@RequestHeader(value = "X-Business-Message-Identifier") String businessMsgIdentifier,
			@RequestBody PaymentConfirmationCoreUpdateRequest request) {

		System.out.println("Payment confirmation Stub SM-core update execution started ....");
		
		if(null != request.getErrorDetails()) {
			
			PaymentConfirmationCoreUpdateResponse resp = service.paymentConfUpdateToCore(participantId);
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-Correlation-Id", correlationId);
			resp.setStatusCode(null);
			System.out.println("Payment confirmation Stub SM-core update execution completed ....");

			return new ResponseEntity<>(resp, headers, HttpStatus.NOT_ACCEPTABLE);
		}
		else {
		PaymentConfirmationCoreUpdateResponse resp = service.paymentConfUpdateToCore(participantId);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Correlation-Id", correlationId);

		System.out.println("Payment confirmation Stub SM-core update execution completed ....");

		return new ResponseEntity<>(resp, headers, HttpStatus.OK);
		}
	}


	public String generateSignature(PaymentConfirmationRIResponse resps){
		System.out.println("Generate signature from RI");
		try {
			URI uri = new URI(signatureGenURL);
			HttpHeaders headers = StubsUtil.fetchHeaders();
			RestTemplate restTemplate = StubsUtil.fetchRestTemplate();

			HttpEntity<PaymentConfirmationRIResponse> request = new HttpEntity<>(resps, headers);
			ResponseEntity<?> result = restTemplate.postForEntity(uri, request,PaymentConfirmationRIResponse.class);
			return result.getHeaders().get("X-JWS-Signature").get(0).toString();

		}catch (Exception ex){
			ex.printStackTrace();
			return "ABC456";
		}
	}

}
