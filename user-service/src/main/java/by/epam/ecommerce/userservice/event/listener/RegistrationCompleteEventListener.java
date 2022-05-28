package by.epam.ecommerce.userservice.event.listener;

import by.epam.ecommerce.userservice.entity.User;
import by.epam.ecommerce.userservice.event.RegistrationCompleteEvent;
import by.epam.ecommerce.userservice.service.UserService;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RegistrationCompleteEventListener
  implements ApplicationListener<RegistrationCompleteEvent> {
  @Autowired
  private UserService userService;

  @Override
  public void onApplicationEvent(RegistrationCompleteEvent event) {
    //Create the Veriication Token for the User with Link
    User user = event.getUser();
    String token = UUID.randomUUID().toString();
    userService.saveVerificationTokenForUser(token, user);
    //Send Mail to User
    String url = String.format(
      "%s /verifyRegistration?token=%s",
      event.getApplicationUrl(),
      token
    );

    //sendVerificationEmail()
    log.info("Click the link to verify your account: {}", url);
  }
}
