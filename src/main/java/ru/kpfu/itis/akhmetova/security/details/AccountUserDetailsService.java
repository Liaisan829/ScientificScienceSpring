package ru.kpfu.itis.akhmetova.security.details;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.akhmetova.repository.UserRepository;

@Service
public class AccountUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AccountUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new AccountUserDetails(
                userRepository.findByEmail(email)
                        .orElseThrow(
                                ()-> new UsernameNotFoundException("User not found")));
    }
}
