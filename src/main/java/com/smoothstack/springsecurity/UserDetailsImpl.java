package com.smoothstack.springsecurity;

import com.smoothstack.springsecurity.entity.User;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Rob Maes
 * Mar 16 2021
 */
public class UserDetailsImpl implements UserDetails {

  private static final long serialVersionUID = 1L;
  private String userName;
  private String password;
  private boolean active;
  private List<GrantedAuthority> authorities;

  public UserDetailsImpl(User user) {
    this.userName = user.getUserName();
    this.password = user.getPassword();
    this.active = user.isActive();
    this.authorities =
      Arrays
        .stream(user.getRoles().split(","))
        .map(String::trim)
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
    System.out.println(this.userName);
    System.out.println(this.password);
    System.out.println(this.active);
    System.out.println(this.authorities);
    System.out.println(getAuthorities());
  }

  public UserDetailsImpl() {}

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return active;
  }
}
