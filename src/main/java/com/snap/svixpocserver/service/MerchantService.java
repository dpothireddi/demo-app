package com.snap.svixpocserver.service;

import com.snap.svixpocserver.entity.Merchant;

import java.util.List;

public interface MerchantService {
  List<Merchant> getAll();

  void createMerchant( Merchant merchant );
}
