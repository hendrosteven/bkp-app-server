package com.bkn.dto;

import java.io.Serializable;

public class ResponseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean responseStatus;
    private String responseMessage;
    private ResponseData payload;

    public ResponseObject() {

    }

    public ResponseObject(boolean responseStatus, String responseMessage, ResponseData payload) {
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
        this.payload = payload;
    }

    public boolean isResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(boolean responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResponseData getPayload() {
        return payload;
    }

    public void setPayload(ResponseData payload) {
        this.payload = payload;
    }

}
