package by.epam.ecommerce.userservice.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="user_registration")
public class User {

	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;
  private String lastName;
  private String email;

  @Column(length = 60)
  private String password;

  private String role;
  private boolean enabled = false;
}
