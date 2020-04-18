package com.example.cj.perfectj.mapper;

import com.example.cj.perfectj.domain.UserDomain;
import com.example.cj.perfectj.domain.UserDomainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

// @Repository可不写
@Repository
public interface UserDomainMapper {
    long countByExample(UserDomainExample example);

    int deleteByExample(UserDomainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserDomain record);

    int insertSelective(UserDomain record);

    List<UserDomain> selectByExample(UserDomainExample example);

    UserDomain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserDomain record, @Param("example") UserDomainExample example);

    int updateByExample(@Param("record") UserDomain record, @Param("example") UserDomainExample example);

    int updateByPrimaryKeySelective(UserDomain record);

    int updateByPrimaryKey(UserDomain record);
}