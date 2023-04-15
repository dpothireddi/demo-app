package com.snap.svixpocserver.service;

public interface EmailService {

  String send( String to, String sub, String msg );
}
