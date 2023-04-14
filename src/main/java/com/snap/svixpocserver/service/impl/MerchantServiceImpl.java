package com.snap.svixpocserver.service.impl;

import com.snap.svixpocserver.entity.Merchant;
import com.snap.svixpocserver.service.MerchantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

  private List<Merchant> availableMerchants = new ArrayList<>();

  @Override
  public List<Merchant> getAll() {
    return availableMerchants;
  }

  @Override
  public void createMerchant( final Merchant merchant ) {
    this.availableMerchants.add( merchant );
  }

}
