package com.htc.backend.repository;

import com.htc.backend.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByJwtToken(String jwtToken);
    List<Token> findByUserUserId(Long userId);
    List<Token> findByIsExpired(Boolean isExpired);
    List<Token> findByIsRevoked(Boolean isRevoked);
}
