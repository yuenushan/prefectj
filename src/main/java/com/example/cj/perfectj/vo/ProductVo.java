package com.example.cj.perfectj.vo;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created on 2020-04-19
 */
public class ProductVo {
    @NotBlank(message = "名称不能为空")
    private String name;
    @Min(value = 0, message = "库存数不能小于0")
    private int stock;
    @NotNull(message = "价格必须指定")
    @Min(value = 0, message = "价格不能小于0")
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
