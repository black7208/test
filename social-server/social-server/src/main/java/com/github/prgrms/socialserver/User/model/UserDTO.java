package com.github.prgrms.socialserver.User.model;

public class UserDTO {
    private String principal;
    private String credentials;

    public UserDTO(String principal, String credentials){
        this.principal = principal;
        this.credentials = credentials;
    }

    public String getPrincipal(){
        return principal;
    }

    public String getCredentials(){
        return credentials;
    }

    public User getEntity(){
        return new User.Builder(this.principal, this.credentials).build();
    }
}
