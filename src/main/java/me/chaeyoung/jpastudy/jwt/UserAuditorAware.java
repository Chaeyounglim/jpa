/*
package me.chaeyoung.jpastudy.jwt;

import java.util.Optional;
import me.chaeyoung.jpastudy.user.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserAuditorAware implements AuditorAware<User> {

  @Override
  public Optional<User> getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null || !authentication.isAuthenticated()) { // 인증 정보가 null이거나 인증되지 않았다면
      return Optional.empty();
    }

    return Optional.of(((UserDetailsImpl) authentication.getPrincipal()).getUser());
  }
}
*/
