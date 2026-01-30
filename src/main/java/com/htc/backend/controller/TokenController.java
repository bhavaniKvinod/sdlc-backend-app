package com.htc.backend.controller;

import com.htc.backend.model.Token;
import com.htc.backend.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tokens")
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<Token> createToken(@RequestBody Token token) {
        Token createdToken = tokenService.createToken(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdToken);
    }

    @GetMapping
    public ResponseEntity<List<Token>> getAllTokens() {
        List<Token> tokens = tokenService.getAllTokens();
        return ResponseEntity.ok(tokens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Token> getTokenById(@PathVariable Long id) {
        Optional<Token> token = tokenService.getTokenById(id);
        return token.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/jwt/{jwtToken}")
    public ResponseEntity<Token> getTokenByJwt(@PathVariable String jwtToken) {
        Token token = tokenService.getTokenByJwtToken(jwtToken);
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Token>> getTokensByUser(@PathVariable Long userId) {
        List<Token> tokens = tokenService.getTokensByUserId(userId);
        return ResponseEntity.ok(tokens);
    }

    @GetMapping("/expired/{isExpired}")
    public ResponseEntity<List<Token>> getExpiredTokens(@PathVariable Boolean isExpired) {
        List<Token> tokens = tokenService.getExpiredTokens(isExpired);
        return ResponseEntity.ok(tokens);
    }

    @GetMapping("/revoked/{isRevoked}")
    public ResponseEntity<List<Token>> getRevokedTokens(@PathVariable Boolean isRevoked) {
        List<Token> tokens = tokenService.getRevokedTokens(isRevoked);
        return ResponseEntity.ok(tokens);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Token> updateToken(@PathVariable Long id, @RequestBody Token token) {
        Token updatedToken = tokenService.updateToken(id, token);
        if (updatedToken != null) {
            return ResponseEntity.ok(updatedToken);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToken(@PathVariable Long id) {
        tokenService.deleteToken(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllTokens() {
        tokenService.deleteAllTokens();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
