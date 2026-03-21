package org.seminify.application.user;

import java.util.List;

import org.seminify.application.user.authority.UserAuthorityService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserMapper userMapper;
    private final UserAuthorityService userAuthorityService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void delete(UserDTO userDTO) {
        userMapper.delete(userDTO);
    }

    @Transactional(readOnly = true)
    public List<UserDTO> get() {
        return userMapper.get();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.loadUserByUsername(username);
    }

    public void post(UserDTO userDTO) {
        userMapper.post(userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword())));
    }

    public void postAdminUser(UserDTO userDTO) {
        post(userDTO);
        userAuthorityService.postAdminUser(userDTO);
    }
}
