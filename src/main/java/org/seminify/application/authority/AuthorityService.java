package org.seminify.application.authority;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorityService {

  private final AuthorityMapper authorityMapper;

  public void delete(AuthorityDTO authorityDTO) {
    authorityMapper.delete(authorityDTO);
  }

  @Transactional(readOnly = true)
  public List<AuthorityDTO> get() {
    return authorityMapper.get();
  }

  @Transactional(readOnly = true)
  public AuthorityDTO getById(AuthorityDTO authorityDTO) {
    return authorityMapper.getById(authorityDTO);
  }

  @Transactional(readOnly = true)
  public AuthorityDTO getByAuthority(AuthorityDTO authorityDTO) {
    return authorityMapper.getByAuthority(authorityDTO);
  }

  public void post(AuthorityDTO authorityDTO) {
    authorityMapper.post(authorityDTO);
  }

  public void put(AuthorityDTO authorityDTO) {
    authorityMapper.put(authorityDTO);
  }
}
