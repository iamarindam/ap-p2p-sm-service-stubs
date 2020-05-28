package com.stubs.app.controllers;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stubs.app.model.mcsend.PaymentRequest;
import com.stubs.app.model.mcsend.PaymentResponse;
import com.stubs.app.model.mcsend.SearchRequest;
import com.stubs.app.model.mcsend.SearchResponse;
import com.stubs.app.model.mcsend.TransferEligibilityResponse;
import com.stubs.app.model.mcsend.TransferEligibleRequest;
import com.stubs.app.service.McSendService;

@RestController
@RequestMapping("/send/partners")
public class McSendStub {
	@Autowired
    private McSendService service;

    @Value("${timeout}" )
    private Long timeout;

    @PostMapping(value = "/{partner_id}/payments",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<PaymentResponse> pResp(@PathVariable("partner_id") String partner_id,
                          @RequestParam("repeat_flag") boolean repeatFlag,
                          @RequestHeader("X-Encrypted") boolean isEncrypted,
                          @RequestBody PaymentRequest request){
        //introduce timeout for 951234033
        try {
            if (request.getPaymentReference().equalsIgnoreCase("951234033")) {
                Thread.sleep(timeout);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        PaymentResponse resp = service.getResponse(request.getPaymentReference());
        switch(resp.getStatusCode()) {
            case "200":
                resp.setStatusCode(null);
                return  new ResponseEntity<>(resp, HttpStatus.OK);

            case "201":
                resp.setStatusCode(null);
                return  new ResponseEntity<>(resp, HttpStatus.CREATED);

            case "400":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);

            case "409":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp, HttpStatus.UNAUTHORIZED);

            //TODO
            default :
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
    @PostMapping(value = "/{partner_id}/payments/searches",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    SearchResponse searchResp(@PathVariable String partner_id, @RequestBody SearchRequest request){
    	SearchResponse srchresp = service.getSearchResponse(partner_id);
        return  srchresp;
    }
    
    @PostMapping(value = "/{partner_id}/transfer-eligibility",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<TransferEligibilityResponse> trEligibleResp(@PathVariable String partner_id,
                                               @RequestHeader("X-Encrypted") boolean isEncrypted,
                                               @RequestBody TransferEligibleRequest request){
        //introduce timeout for 951234033
        try {
            if (request.getRecipientAccountUri().equalsIgnoreCase("951234033")) {
                Thread.sleep(timeout);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        TransferEligibilityResponse resp = service.getTrEligibleResponse(request.getRecipientAccountUri());

        switch(resp.getStatusCode()) {
            case "200":
                resp.setStatusCode(null);
                return  new ResponseEntity<>(resp, HttpStatus.OK);

            case "201":
                resp.setStatusCode(null);
                return  new ResponseEntity<>(resp, HttpStatus.CREATED);

            case "400":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);

            case "409":
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp, HttpStatus.UNAUTHORIZED);

            //TODO
            default :
                resp.setStatusCode(null);
                return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
