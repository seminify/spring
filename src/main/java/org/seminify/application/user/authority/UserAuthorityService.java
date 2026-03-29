package org.seminify.application.user.authority;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.seminify.application.authority.AuthorityDTO;
import org.seminify.application.authority.AuthorityService;
import org.seminify.application.user.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserAuthorityService {

  private final UserAuthorityMapper userAuthorityMapper;
  private final AuthorityService authorityService;

  public void delete(UserAuthorityDTO userAuthorityDTO) {
    userAuthorityMapper.delete(userAuthorityDTO);
  }

  @Transactional(readOnly = true)
  public List<UserAuthorityDTO> get() {
    return userAuthorityMapper.get();
  }

  @Transactional(readOnly = true)
  public UserAuthorityDTO getById(UserAuthorityDTO userAuthorityDTO) {
    return userAuthorityMapper.getById(userAuthorityDTO);
  }

  public void post(UserAuthorityDTO userAuthorityDTO) {
    userAuthorityMapper.post(userAuthorityDTO);
  }

  public void postAdmin(UserDTO userDTO) {
    userAuthorityMapper.post(
      new UserAuthorityDTO()
        .setUser(userDTO)
        .setAuthority(
          authorityService.getByAuthority(
            new AuthorityDTO().setAuthority("ROLE_ADMIN")
          )
        )
    );
  }

  public void put(UserAuthorityDTO userAuthorityDTO) {
    userAuthorityMapper.put(userAuthorityDTO);
  }
}
