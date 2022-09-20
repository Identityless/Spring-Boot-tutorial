package com.example.iocspring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Encoder{

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }
    public String encode(String message){
        return this.iEncoder.encode(message);
    }

    public void setiEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }
}
