package com.htc.backend.service;

import com.htc.backend.model.Token;
import java.util.List;
import java.util.Optional;

public interface TokenService {
    // Create
    Token createToken(Token token);

    // Read
    Optional<Token> getTokenById(Long id);
    List<Token> getAllTokens();
    Token getTokenByJwtToken(String jwtToken);
    List<Token> getTokensByUserId(Long userId);
    List<Token> getExpiredTokens(Boolean isExpired);
    List<Token> getRevokedTokens(Boolean isRevoked);

    // Update
    Token updateToken(Long id, Token token);

    // Delete
    void deleteToken(Long id);
    void deleteAllTokens();
}
