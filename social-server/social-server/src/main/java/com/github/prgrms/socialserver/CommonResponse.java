package com.github.prgrms.socialserver;

public class CommonResponse {
    private boolean success;
    private String response;

    public CommonResponse(boolean success, String response){
        this.success = success;
        this.response = response;
    }
}
