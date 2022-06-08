package com.github.prgrms.socialserver.User.model;

import java.util.Date;

public class User {
    private final long seq;
    private String email;
    private String passwd;
    private int loginCount;
    private Date lastLoginAt;
    private Date createAt;

    private User(Builder builder){
        this.seq = builder.seq;
        this.email = builder.email;
        this.passwd = builder.passwd;
        this.loginCount = builder.loginCount;
        this.lastLoginAt = builder.lastLoginAt;
        this.createAt = builder.createAt;
    }

    public long getSeq(){
        return this.seq;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPasswd(){
        return this.passwd;
    }

    public int getLoginCount(){
        return this.loginCount;
    }

    public Date getLastLoginAt(){
        return this.lastLoginAt;
    }

    public Date getCreateAt(){
        return this.createAt;
    }

    public static class Builder{
        private long seq;
        private String email;
        private String passwd;
        private int loginCount;
        private Date lastLoginAt;
        private Date createAt;

        public Builder(String email, String passwd){
            this.email = email;
            this.passwd = passwd;
        }

        public Builder(long seq, String email, String passwd, int loginCount, Date createAt){
            this.seq = seq;
            this.email = email;
            this.passwd = passwd;
            this.loginCount = loginCount;
            this.createAt = createAt;
        }

        public Builder lastLoginAt(Date lastLoginAt) {
            this.lastLoginAt = lastLoginAt;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
