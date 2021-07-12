package io.staticvoid.springsecurityjpa;

import io.staticvoid.springsecurityjpa.models.MyUserDetails;
import io.staticvoid.springsecurityjpa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // hard coded user details instance
       //  return new MyUserDetails(s);
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        // convert to type: MyUserDetails
       return user.map(MyUserDetails::new).get();


    }
}
