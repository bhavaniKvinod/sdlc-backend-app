package com.htc.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;

    @Column(name = "jwttoken", columnDefinition = "TEXT")
    private String jwtToken;

    @Column(name = "is_expired", nullable = false)
    private Boolean isExpired;

    @Column(name = "is_revoked", nullable = false)
    private Boolean isRevoked;

    // Constructors
    public Token() {}

    public Token(User user, String jwtToken, Boolean isExpired, Boolean isRevoked) {
        this.user = user;
        this.jwtToken = jwtToken;
        this.isExpired = isExpired;
        this.isRevoked = isRevoked;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
