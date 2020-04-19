package com.example.cj.perfectj.mapper;

import com.example.cj.perfectj.domain.OrderDomain;
import com.example.cj.perfectj.domain.OrderDomainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDomainMapper {
    long countByExample(OrderDomainExample example);

    int deleteByExample(OrderDomainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderDomain record);

    int insertSelective(OrderDomain record);

    List<OrderDomain> selectByExample(OrderDomainExample example);

    OrderDomain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderDomain record, @Param("example") OrderDomainExample example);

    int updateByExample(@Param("record") OrderDomain record, @Param("example") OrderDomainExample example);

    int updateByPrimaryKeySelective(OrderDomain record);

    int updateByPrimaryKey(OrderDomain record);
}