package com.example.cj.perfectj.mapper;

import com.example.cj.perfectj.domain.ProductDomain;
import com.example.cj.perfectj.domain.ProductDomainExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductDomainMapper {
    long countByExample(ProductDomainExample example);

    int deleteByExample(ProductDomainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductDomain record);

    int insertSelective(ProductDomain record);

    List<ProductDomain> selectByExample(ProductDomainExample example);

    ProductDomain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductDomain record, @Param("example") ProductDomainExample example);

    int updateByExample(@Param("record") ProductDomain record, @Param("example") ProductDomainExample example);

    int updateByPrimaryKeySelective(ProductDomain record);

    int updateByPrimaryKey(ProductDomain record);

    int decrStock(long id);
}