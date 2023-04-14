package com.snap.svixpocserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
  private String dbaName;
  private String name;
  private String website;

}
