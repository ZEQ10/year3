package com.example.ltdtdd_contentprovider;

public class sms {
private String address;
private String body;

    public sms( String address,String body) {
        this.body = body;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
