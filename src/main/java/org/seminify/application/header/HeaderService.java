package org.seminify.application.header;

import java.util.List;

import org.seminify.application.authority.AuthorityDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class HeaderService {
    private final HeaderMapper headerMapper;

    public void delete(HeaderDTO headerDTO) {
        headerMapper.delete(headerDTO);
    }

    @Transactional(readOnly = true)
    public List<HeaderDTO> get() {
        return headerMapper.get();
    }

    @Transactional(readOnly = true)
    public List<HeaderDTO> getByAuthorities(List<AuthorityDTO> authorities) {
        return headerMapper.getByAuthorities(authorities);
    }

    public void post(HeaderDTO headerDTO) {
        headerMapper.post(headerDTO);
    }
}
