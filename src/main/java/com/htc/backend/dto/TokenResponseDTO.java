package com.htc.backend.dto;

public class TokenResponseDTO {
    private Long id;
    private Long userId;
    private String jwtToken;
    private Boolean isExpired;
    private Boolean isRevoked;

    public TokenResponseDTO() {}

    public TokenResponseDTO(Long id, Long userId, String jwtToken, Boolean isExpired, Boolean isRevoked) {
        this.id = id;
        this.userId = userId;
        this.jwtToken = jwtToken;
        this.isExpired = isExpired;
        this.isRevoked = isRevoked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
