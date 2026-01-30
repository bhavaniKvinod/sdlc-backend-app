package com.htc.backend.service.impl;

import com.htc.backend.model.Token;
import com.htc.backend.repository.TokenRepository;
import com.htc.backend.service.TokenService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Token createToken(Token token) {
        return tokenRepository.save(token);
    }

    @Override
    public Optional<Token> getTokenById(Long id) {
        return tokenRepository.findById(id);
    }

    @Override
    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }

    @Override
    public Token getTokenByJwtToken(String jwtToken) {
        return tokenRepository.findByJwtToken(jwtToken).orElse(null);
    }

    @Override
    public List<Token> getTokensByUserId(Long userId) {
        return tokenRepository.findByUserUserId(userId);
    }

    @Override
    public List<Token> getExpiredTokens(Boolean isExpired) {
        return tokenRepository.findByIsExpired(isExpired);
    }

    @Override
    public List<Token> getRevokedTokens(Boolean isRevoked) {
        return tokenRepository.findByIsRevoked(isRevoked);
    }

    @Override
    public Token updateToken(Long id, Token token) {
        Optional<Token> existingToken = tokenRepository.findById(id);
        if (existingToken.isPresent()) {
            Token tokenToUpdate = existingToken.get();
            if (token.getJwtToken() != null) {
                tokenToUpdate.setJwtToken(token.getJwtToken());
            }
            if (token.getIsExpired() != null) {
                tokenToUpdate.setIsExpired(token.getIsExpired());
            }
            if (token.getIsRevoked() != null) {
                tokenToUpdate.setIsRevoked(token.getIsRevoked());
            }
            if (token.getUser() != null) {
                tokenToUpdate.setUser(token.getUser());
            }
            return tokenRepository.save(tokenToUpdate);
        }
        return null;
    }

    @Override
    public void deleteToken(Long id) {
        tokenRepository.deleteById(id);
    }

    @Override
    public void deleteAllTokens() {
        tokenRepository.deleteAll();
    }
}
