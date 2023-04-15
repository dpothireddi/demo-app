package com.snap.svixpocserver.service.impl;

import com.snap.svixpocserver.entity.Merchant;
import com.snap.svixpocserver.service.EmailService;
import com.snap.svixpocserver.service.MerchantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    this.availableMerchants.add( merchant );
    this.emailService.send( "dpothireddi@snapfinancebpo.com", "New merchant onboarded", merchant.toString() );
  }

  @Override
  public void deleteAll() {
    this.availableMerchants.clear();
  }

}
