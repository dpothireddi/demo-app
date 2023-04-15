package com.snap.svixpocserver.controller;

import com.snap.svixpocserver.entity.Merchant;
import com.snap.svixpocserver.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MerchantController {

  private static final Logger LOGGER = LoggerFactory.getLogger( MerchantController.class );

  private MerchantService merchantService;

  public MerchantController( final MerchantService merchantService ) {
    this.merchantService = merchantService;
  }

  @GetMapping( value = "/merchants", produces = MediaType.APPLICATION_JSON_VALUE )
  public ResponseEntity<List<Merchant>> getAll() {
    return new ResponseEntity<>( this.merchantService.getAll(), HttpStatus.OK );
  }

  @PostMapping( value = "/merchants/create", consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE )
  public ResponseEntity<HttpStatus> save( @RequestBody Merchant merchant ) {
    this.merchantService.createMerchant( merchant );
    return new ResponseEntity<>( HttpStatus.OK );
  }

  @DeleteMapping( value = "/merchants/delete", produces = MediaType.APPLICATION_JSON_VALUE )
  public ResponseEntity<HttpStatus> deleteAll() {
    this.merchantService.deleteAll();
    return new ResponseEntity<>( HttpStatus.OK );
  }

  @PostMapping( value = "/merchants/approve", consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE )
  public ResponseEntity<HttpStatus> approve( @RequestBody Merchant merchant ) {
    this.merchantService.approveMerchant( merchant.getId() );
    return new ResponseEntity<>( HttpStatus.OK );
  }

}
