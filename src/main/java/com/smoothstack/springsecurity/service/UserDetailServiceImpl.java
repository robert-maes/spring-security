package com.smoothstack.springsecurity.service;

import com.smoothstack.springsecurity.UserDetailsImpl;
import com.smoothstack.springsecurity.dao.UserRepository;
import com.smoothstack.springsecurity.entity.User;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Rob Maes
 * Mar 16 2021
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String userName)
    throws UsernameNotFoundException {
    System.out.println("inside UserDetailService");
    Optional<User> user = userRepository.findByUserName(userName);
    user.orElseThrow(
      () -> new UsernameNotFoundException("not found " + userName)
    );
    return new UserDetailsImpl(user.get());
  }
}
