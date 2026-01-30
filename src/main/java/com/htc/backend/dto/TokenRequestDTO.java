package com.htc.backend.dto;

public class TokenRequestDTO {

    private Long userId;
    private String jwtToken;
    private Boolean isExpired;
    private Boolean isRevoked;

    // Constructors
    public TokenRequestDTO() {}

    public TokenRequestDTO(Long userId, String jwtToken, Boolean isExpired, Boolean isRevoked) {
        this.userId = userId;
        this.jwtToken = jwtToken;
        this.isExpired = isExpired;
        this.isRevoked = isRevoked;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public Boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    public Boolean getIsRevoked() {
        return isRevoked;
    }

    public void setIsRevoked(Boolean isRevoked) {
        this.isRevoked = isRevoked;
    }
}
