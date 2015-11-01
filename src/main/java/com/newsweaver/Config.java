package com.newsweaver;

public class Config {
    private final String username;
    private final String password;
    private final String userAgent;
    private final String accountCode;

    public Config(Builder builder)
    {
        this.username = builder.username;
        this.password = builder.password;
        this.userAgent = builder.userAgent;
        this.accountCode = builder.accountCode;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public static class Builder {
        private String username;
        private String password;
        private String userAgent;
        private String accountCode;

        public Builder(String username, String password)
        {
            this.username = username;
            this.password = password;
        }

        public Builder userAgent(String userAgent)
        {
            this.userAgent = userAgent;
            return this;
        }

        public Builder accountCode(String accountCode)
        {
            this.accountCode = accountCode;
            return this;
        }

        public Config build()
        {
            return new Config(this);
        }
    }
}
