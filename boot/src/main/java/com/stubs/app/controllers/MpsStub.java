package com.stubs.app.controllers;

import com.stubs.app.model.mps.*;
import com.stubs.app.util.StubsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stubs.app.service.LookupService;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mpp-lookup")
public class MpsStub {

    @Autowired
    private LookupService service;

    @Value("${signing.generation.path}" )
    private String signatureGenURL;

    @Value("${timeout}" )
    private Long timeout;

    //MPS
    @PostMapping(value = "/lookups",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<LookUpResponse> lookup(@RequestHeader(value="Participant-Code") String participantCode,
                          @RequestBody LookUpRequest request){
        System.out.println("Request to MPS Stub");

        //introduce timeout for 951345691
        try {
            if (request.getProxyValue().equalsIgnoreCase("951345691")) {
                Thread.sleep(timeout);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Reference","81c51b377eb149cbaf3bf9e7b37461b6 ");
        LookUpResponse resp = service.getResponse(request.getProxyValue());

        	switch(resp.getStatusCode()) {
        	case "200":
        	    resp.setStatusCode(null);
        		return  new ResponseEntity<>(resp,headers,HttpStatus.OK);
        		
        	case "400":
                resp.setStatusCode(null);
        		return new ResponseEntity<>(resp,headers, HttpStatus.BAD_REQUEST);
        		
        	case "401":
                resp.setStatusCode(null);
        		return new ResponseEntity<>(resp,headers, HttpStatus.UNAUTHORIZED);
        	
        	case "403":
                resp.setStatusCode(null);
        		return new ResponseEntity<>(resp,headers, HttpStatus.FORBIDDEN);

            case "404":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp,headers,HttpStatus.NOT_FOUND);

            case "406":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp,headers, HttpStatus.NOT_ACCEPTABLE);

            case "415":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp,headers, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

        	default :
        	    resp.setStatusCode(null);
        	      return new ResponseEntity<>(resp,headers, HttpStatus.INTERNAL_SERVER_ERROR);
        	}
        
    }

    //SDS
    @PostMapping(value = "/send/v1/partners/{partnerId}/mappings/search", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<SdsResponse> sdsLookup(@PathVariable("partnerId") String partnerId,
                                          @RequestBody SdsRequest request) {
        System.out.println("Request to SDS Stub");

		

        HttpHeaders headers = new HttpHeaders();
        headers.set("Reference","81c51b377eb149cbaf3bf9e7b37461b6 ");
        String searchValue;
        String search = request.getSearch().getSearchValue();
        if(search.contains("tel:")){
            searchValue = search.replace("tel:","");
        }else{
            searchValue = search.replace("email:","");
        }
        
      //introduce timeout for 951345679
        try {
			if (searchValue.equalsIgnoreCase("951345679")) {
				Thread.sleep(timeout);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
        
        SdsResponse resp = service.getSdsResponse(searchValue);

        switch(resp.getStatusCode()) {
            case "200":
                resp.setStatusCode(null);
                return  new ResponseEntity<>(resp,headers,HttpStatus.OK);

            case "400":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp,headers, HttpStatus.BAD_REQUEST);

            case "401":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp,headers, HttpStatus.UNAUTHORIZED);

            case "403":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp,headers, HttpStatus.FORBIDDEN);

            case "404":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp,headers,HttpStatus.NOT_FOUND);

            case "406":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp,headers, HttpStatus.NOT_ACCEPTABLE);

            case "415":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp,headers, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

            default :
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp,headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Requested Participant
    @PostMapping(value = "/requestedParticipant", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RequestedParticipantResponse> lookup(@RequestHeader(value="X-Participant-Id")  String participantId,
                                                        @RequestHeader(value="X-Business-Message-Identifier") String businessMessageIdentifier,
                                                        @RequestHeader(value="X-JWS-Signature") String signature,
                                                        @RequestBody RequestForDataRequest request) {
        System.out.println("Request to requestedParticipant Stub");
       //introduce timeout for 20785000000000000001
        try {
            if (participantId.equalsIgnoreCase("000245")) {
                Thread.sleep(timeout);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Delivery-Control","12345Del");

        RequestedParticipantResponse resp = service.getRPResponse(participantId);
        resp.setCreationDate(new Date());
        resp.setTransactionIdentification(request.getTransactionIdentification());

        switch(resp.getStatusCode()) {
            case "200":
                resp.setStatusCode(null);
                headers.set("X-JWS-Signature",generateSignature(resp));
                return  new ResponseEntity<>(resp,headers,HttpStatus.OK);

            case "400":
                resp.setStatusCode(null);
                headers.set("X-JWS-Signature",generateSignature(resp));
                return new ResponseEntity<>(resp,headers, HttpStatus.BAD_REQUEST);

            case "401":
                resp.setStatusCode(null);
                headers.set("X-JWS-Signature",generateSignature(resp));
                return new ResponseEntity<>(resp,headers, HttpStatus.UNAUTHORIZED);

            case "403":
                resp.setStatusCode(null);
                headers.set("X-JWS-Signature",generateSignature(resp));
                return new ResponseEntity<>(resp,headers, HttpStatus.FORBIDDEN);

            case "404":
                resp.setStatusCode(null);
                headers.set("X-JWS-Signature",generateSignature(resp));
                return new ResponseEntity<>(resp,headers,HttpStatus.NOT_FOUND);

            case "406":
                resp.setStatusCode(null);
                headers.set("X-JWS-Signature",generateSignature(resp));
                return new ResponseEntity<>(resp,headers, HttpStatus.NOT_ACCEPTABLE);

            case "415":
                resp.setStatusCode(null);
                headers.set("X-JWS-Signature",generateSignature(resp));
                return new ResponseEntity<>(resp,headers, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

            default :
                resp.setStatusCode(null);
                headers.set("X-JWS-Signature",generateSignature(resp));
                return new ResponseEntity<>(resp,headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public String generateSignature(RequestedParticipantResponse resps){
        System.out.println("Generate signature from RequestedParticipant");
        try {
            URI uri = new URI(signatureGenURL);
            HttpHeaders headers = StubsUtil.fetchHeaders();
            RestTemplate restTemplate = StubsUtil.fetchRestTemplate();

            HttpEntity<RequestedParticipantResponse> request = new HttpEntity<>(resps, headers);
            ResponseEntity<?> result = restTemplate.postForEntity(uri, request,RequestedParticipantResponse.class);
            return result.getHeaders().get("X-JWS-Signature").get(0).toString();

        }catch (Exception ex){
            ex.printStackTrace();
            return "ABC456";
        }
    }
}
