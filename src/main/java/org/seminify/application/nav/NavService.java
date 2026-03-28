package org.seminify.application.nav;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.seminify.application.authority.AuthorityDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NavService {

  private final NavMapper navMapper;

  public void delete(NavDTO headerDTO) {
    navMapper.delete(headerDTO);
  }

  @Transactional(readOnly = true)
  public List<NavDTO> get() {
    return navMapper.get();
  }

  @Transactional(readOnly = true)
  public NavDTO getById(NavDTO navDTO) {
    return navMapper.getById(navDTO);
  }

  @Transactional(readOnly = true)
  public List<NavDTO> getByAuthorities(List<AuthorityDTO> authorities) {
    return navMapper.getByAuthorities(authorities);
  }

  public void post(NavDTO headerDTO) {
    navMapper.post(headerDTO);
  }

  public void put(NavDTO navDTO) {
    navMapper.put(navDTO);
  }
}
