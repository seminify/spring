package org.seminify.application.header;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HeaderMapper {
    void delete(HeaderDTO headerDTO);

    List<HeaderDTO> get();

    void post(HeaderDTO headerDTO);
}
