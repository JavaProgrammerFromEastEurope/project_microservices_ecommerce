package by.epam.ecommerce.userservice.repository;

import by.epam.ecommerce.userservice.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository
  extends JpaRepository<VerificationToken, Long> {
  VerificationToken findByToken(String token);
}
