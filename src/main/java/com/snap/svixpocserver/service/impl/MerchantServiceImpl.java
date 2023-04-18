package com.snap.svixpocserver.service.impl;

import com.snap.svixpocserver.entity.Merchant;
import com.snap.svixpocserver.service.EmailService;
import com.snap.svixpocserver.service.MerchantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class MerchantServiceImpl implements MerchantService {

  private EmailService emailService;

  public MerchantServiceImpl( final EmailService emailService ) {
    this.emailService = emailService;
  }

  private List<Merchant> availableMerchants = new ArrayList<>();

  @Override
  public List<Merchant> getAll() {
    return availableMerchants;
  }

  @Override
  public void createMerchant( final Merchant merchant ) {
    merchant.setId( this.availableMerchants.size() + 1 );
    this.availableMerchants.add( merchant );
    this.emailService.send( "snagare@snapfinancebpo.com", "SVIX CALL: New Merchant Onboarded", merchant.toString() );
  }

  @Override
  public void deleteAll() {
    this.availableMerchants.clear();
  }

  @Override
  public void approveMerchant( final int id ) {
    int index = IntStream.range( 0, this.availableMerchants.size() )
            .filter( i -> this.availableMerchants.get( i ).getId() == id )
            .findFirst()
            .orElse( -1 );
    if ( index > -1 ) {
      Merchant merchant = this.availableMerchants.get( index );
      merchant.setApproved( true );
      this.availableMerchants.set( index, merchant );
      this.emailService.send( "snagare@snapfinancebpo.com", "SVIX CALL: Merchant Approved", merchant.toString() );
    }
  }

}
