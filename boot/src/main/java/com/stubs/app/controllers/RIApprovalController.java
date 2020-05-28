package com.stubs.app.controllers;

import java.net.URI;
import java.util.Date;

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

import com.stubs.app.model.mcsend.OiApprovalRequest;
import com.stubs.app.model.mcsend.OiApprovalResponse;
import com.stubs.app.model.mcsend.RFPOiApprovalRequest;
import com.stubs.app.model.mcsend.RFPOiApprovalResponse;
import com.stubs.app.model.mcsend.TransactionIdentification;
import com.stubs.app.model.mps.RIApprovalRequest;
import com.stubs.app.model.mps.RIApprovalResponse;
import com.stubs.app.service.RIService;
import com.stubs.app.util.StubsUtil;

@RestController
@RequestMapping("/zapp/rfa")
public class RIApprovalController {
	@Autowired
	private RIService riService;

	@Value("${signing.generation.path}" )
	private String signatureGenURL;

	@Value("${timeout}" )
	private Long timeout;

	@PostMapping(value = "/ri-approval",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	ResponseEntity<RIApprovalResponse> getPiiDetails(@RequestHeader(value="X-Participant-Id") String participantId,
													 @RequestHeader(value="X-Business-Message-Identifier") String businessMessageIdentifier,
//													@RequestHeader(value="X-Delivery-Control") String deliveryControl,
													 @RequestHeader(value="X-JWS-Signature") String signature,
													 @RequestBody RIApprovalRequest request) {
		System.out.println("------------");

		if (request.getCreditorConsumer().getAccountDetails().getAccountReference().toString().equalsIgnoreCase("2019200000000002")) {
			try {
				Thread.sleep(timeout);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (request.getCreditorConsumer().getAccountDetails().getAccountReference().toString().equalsIgnoreCase("2019200000000003")) {
			participantId = "0003990";
		}
		
		if (request.getCreditorConsumer().getAccountDetails().getAccountReference().toString().equalsIgnoreCase("2019200000000004")) {
			participantId = "0003994";
		}
		
		RIApprovalResponse response = riService.getRiDetails(participantId);
		
		System.out.println("Successfully retrived RI details..");

		HttpHeaders headers = new HttpHeaders();

		if(null != response.getHeaderReponse()) {
			
			if(participantId == "0003990" || participantId == "0003994")
				headers.set("X-Participant-Id",response.getInitiatingPartyId());
				
			else 
				headers.set("X-Participant-Id",response.getHeaderReponse().getParticipantId());
			
			
			headers.set("X-Business-Message-Identifier",response.getHeaderReponse().getBusinessMessageIdentifier());
			headers.set("X-Delivery-Control",response.getHeaderReponse().getDeliveryControl());

			//generate JSW signature
			headers.set("X-JWS-Signature",generateSignature(response));
			return new ResponseEntity<>(response,headers, HttpStatus.OK);
		} else {
			switch(response.getStatusCode()) {
				case 200:
					return  new ResponseEntity<>(response, HttpStatus.OK);

				case 400:
					return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

				case 401:
					return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);

				case 403:
					return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);

				case 404:
					return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

				case 406:
					return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);

				case 415:
					return new ResponseEntity<>(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

				case 500:
					return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

				default :
					return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}


	}

	@PostMapping(value = "/oi-approval",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	ResponseEntity<OiApprovalResponse> getOIDetails(@RequestHeader(value="X-Participant-Id") String participantId,
													@RequestHeader(value="X-Business-Message-Identifier") String businessMessageIdentifier,
													@RequestHeader(value="X-Delivery-Control") String deliveryControl,
													@RequestHeader(value="X-JWS-Signature") String signature,
													@RequestBody OiApprovalRequest request) {
		System.out.println("------------");


		if (request.getCreditorConsumer().getAccountDetails().getAccountReference().toString().equalsIgnoreCase("2019200000000002")) {
			try {
				Thread.sleep(timeout);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


		OiApprovalResponse response = riService.getOiDetails(participantId);
		response.setCreationDate(new Date());
		TransactionIdentification tf = new TransactionIdentification();
		tf.setSchmTxnId(request.getTransactionIdentification().getSchmTxnId());
		response.setTransactionIdentification(tf);


		System.out.println("Successfully retrieved OI details..");

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Participant-Id",participantId);
		headers.set("X-Business-Message-Identifier",businessMessageIdentifier);
		headers.set("X-Delivery-Control",deliveryControl);

		switch (response.getStatusCode()) {
			case "200":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response,headers, HttpStatus.OK);

			case "400":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response,headers, HttpStatus.BAD_REQUEST);

			case "401":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response, headers,HttpStatus.UNAUTHORIZED);

			case "403":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response, headers,HttpStatus.FORBIDDEN);

			case "404":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response, headers,HttpStatus.NOT_FOUND);

			case "406":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response,headers, HttpStatus.NOT_ACCEPTABLE);

			case "415":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

			default:
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response,headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/rfp-oi-approval",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	ResponseEntity<RFPOiApprovalResponse> getRFPOIDetails(@RequestHeader(value="X-Participant-Id") String participantId,
													@RequestHeader(value="X-Business-Message-Identifier") String businessMessageIdentifier,
													@RequestHeader(value="X-Delivery-Control") String deliveryControl,
													@RequestHeader(value="X-JWS-Signature") String signature,
													@RequestBody RFPOiApprovalRequest request) {
		System.out.println("------------");


		if (request.getDebtorConsumer().getAccountDetails().getAccountReference().toString().equalsIgnoreCase("1220400000000002")) {
			try {
				Thread.sleep(timeout);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (request.getDebtorConsumer().getAccountDetails().getAccountReference().toString().equalsIgnoreCase("1220400000000003")) {
			participantId = "0003931";
		}
		
		if (request.getDebtorConsumer().getAccountDetails().getAccountReference().toString().equalsIgnoreCase("1220400000000004")) {
			participantId = "0003932";
		}
		
		if (request.getDebtorConsumer().getAccountDetails().getAccountReference().toString().equalsIgnoreCase("1220400000000045")) {
			participantId = "0003933";
		}

		RFPOiApprovalResponse response = riService.getRFPOiDetails(participantId);
		response.setCreationDate(new Date());
		TransactionIdentification tf = new TransactionIdentification();
		tf.setSchmTxnId(request.getTransactionIdentification().getSchmTxnId());
		response.setTransactionIdentification(tf);


		System.out.println("Successfully retrieved OI details..");

		HttpHeaders headers = new HttpHeaders();
		if(participantId== "0003931" || participantId == "0003932") 
			headers.set("X-Participant-Id",response.getInitiatingPartyId());
			
		else 
			headers.set("X-Participant-Id",participantId);
			
		headers.set("X-Business-Message-Identifier",businessMessageIdentifier);
		headers.set("X-Delivery-Control",deliveryControl);

		switch (response.getStatusCode()) {
			case "200":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response,headers, HttpStatus.OK);

			case "400":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response,headers, HttpStatus.BAD_REQUEST);

			case "401":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response, headers,HttpStatus.UNAUTHORIZED);

			case "403":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response, headers,HttpStatus.FORBIDDEN);

			case "404":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response, headers,HttpStatus.NOT_FOUND);

			case "406":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response,headers, HttpStatus.NOT_ACCEPTABLE);

			case "415":
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

			default:
				response.setStatusCode(null);
				headers.set("X-JWS-Signature",generateOISignature(response));
				return new ResponseEntity<>(response,headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public String generateSignature(RIApprovalResponse resps){
		System.out.println("Generate signature from ri-approval");
		try {
			URI uri = new URI(signatureGenURL);
			HttpHeaders headers = StubsUtil.fetchHeaders();
			RestTemplate restTemplate = StubsUtil.fetchRestTemplate();

			HttpEntity<RIApprovalResponse> request = new HttpEntity<>(resps, headers);
			ResponseEntity<?> result = restTemplate.postForEntity(uri, request,RIApprovalResponse.class);
			return result.getHeaders().get("X-JWS-Signature").get(0).toString();

		}catch (Exception ex){
			ex.printStackTrace();
			return "ABC456";
		}
	}

	public String generateOISignature(OiApprovalResponse resps){
		System.out.println("Generate signature from OI");
		try {
			URI uri = new URI(signatureGenURL);
			HttpHeaders headers = StubsUtil.fetchHeaders();
			RestTemplate restTemplate = StubsUtil.fetchRestTemplate();

			HttpEntity<OiApprovalResponse> request = new HttpEntity<>(resps, headers);
			ResponseEntity<?> result = restTemplate.postForEntity(uri, request,OiApprovalResponse.class);
			return result.getHeaders().get("X-JWS-Signature").get(0).toString();

		}catch (Exception ex){
			ex.printStackTrace();
			return "ABC456";
		}
	}
	
	public String generateOISignature(RFPOiApprovalResponse resps){
		System.out.println("Generate signature from OI");
		try {
			URI uri = new URI(signatureGenURL);
			HttpHeaders headers = StubsUtil.fetchHeaders();
			RestTemplate restTemplate = StubsUtil.fetchRestTemplate();

			HttpEntity<RFPOiApprovalResponse> request = new HttpEntity<>(resps, headers);
			ResponseEntity<?> result = restTemplate.postForEntity(uri, request,RFPOiApprovalResponse.class);
			return result.getHeaders().get("X-JWS-Signature").get(0).toString();
		}catch (Exception ex){
			ex.printStackTrace();
			return "ABC456";
		}
	}
}
