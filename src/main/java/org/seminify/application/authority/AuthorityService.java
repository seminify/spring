package org.seminify.application.authority;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorityService {
    private final AuthorityMapper authorityMapper;

    @Transactional(readOnly = true)
    public List<AuthorityDTO> get() {
        return authorityMapper.get();
    }

    public void post(AuthorityDTO authorityDTO) {
        authorityMapper.post(authorityDTO);
    }

    @Transactional(readOnly = true)
    public AuthorityDTO getByAuthority(AuthorityDTO authorityDTO) {
        return authorityMapper.getByAuthority(authorityDTO);
    }

    public void delete(AuthorityDTO authorityDTO) {
        authorityMapper.delete(authorityDTO);
    }
}
