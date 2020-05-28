package com.stubs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stubs.app.model.mps.OiRFARequest;
import com.stubs.app.model.mps.RfaPiiResponse;
import com.stubs.app.model.mps.ZappUpdateRequest;
import com.stubs.app.model.mps.ZappUpdateResponse;
import com.stubs.app.service.ZappCoreStubService;

@RestController
@RequestMapping("/zapp")
public class ZappCoreStubController {
	@Autowired
	private ZappCoreStubService zapCoreService;

	@PostMapping(value = "/pii-info",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	ResponseEntity<RfaPiiResponse> getPiiDetails(@RequestHeader(value="X-Participant-Id") String participantId,
												 @RequestHeader(value="X-Correlation-Id") String correlationId,
												 @RequestHeader(value="X-Business-Message-Identifier") String businessMessageIdentifier,
												 @RequestHeader(value="X-Delivery-Control") String deliveryControl,
												 @RequestBody OiRFARequest request) {
		System.out.println("------------");

		RfaPiiResponse response = zapCoreService.getPiiDetails(participantId);
		
		if (participantId.toString().equalsIgnoreCase("9844295504")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Successfully retrived RI details..");

		HttpHeaders headers = new HttpHeaders();
		if(null != response.getHeaderReponse()) {
//			headers.set("X-Participant-Id",response.getHeaderReponse().getParticipantId());
			headers.set("X-Correlation-Id",response.getHeaderReponse().getCorrelationId()+"AAAA");
//			headers.set("X-Business-Message-Identifier",response.getHeaderReponse().getBusinessMessageIdentifier());
//			headers.set("X-Delivery-Control",response.getHeaderReponse().getDeliveryControl());
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
        	
        	//TODO
        	default : 
        	      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        	}
//			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@PutMapping(value = "/pii-update/{authorisation_id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	ResponseEntity<ZappUpdateResponse> updatePiiDetails(
										@PathVariable("authorisation_id") String authorisationId,
										@RequestHeader(value="X-Participant-Id") String participantId,
										@RequestHeader(value="X-Correlation-Id") String correlationId,
										@RequestHeader(value="X-Business-Message-Identifier") String businessMessageIdentifier,
										@RequestHeader(value="X-Delivery-Control") String deliveryControl,
										@RequestBody ZappUpdateRequest request) {

		ZappUpdateResponse response = zapCoreService.updatePiiDetails(participantId);
		System.out.println("Successfully Updated RI details..");

		HttpHeaders headers = new HttpHeaders();
		
		if(null != response.getHeaderReponse()) {
			headers.set("X-Correlation-Id",response.getHeaderReponse().getCorrelationId());
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

}
