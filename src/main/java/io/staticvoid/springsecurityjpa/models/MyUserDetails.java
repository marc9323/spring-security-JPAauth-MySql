package io.staticvoid.springsecurityjpa.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// whatever User instance is passed it constructs UserDetails
public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

//    public MyUserDetails(String userName) {
//        this.userName = userName;
//    }

    public MyUserDetails(User user) {
        // extract the values form the User instance retrieved by the repository and
        // convert it into the UserDetails instance
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

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

    //
//    public MyUserDetails() {
//
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // returns a collection of GrantedAuthority instances
//        return Arrays.asList(
//                new SimpleGrantedAuthority("ROLE_USER")
//        );
//    }
//
//    @Override
//    public String getPassword() {
//        return "pass";
//    }
//
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
