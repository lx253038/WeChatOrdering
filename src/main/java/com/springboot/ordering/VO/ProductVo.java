package com.springboot.ordering.VO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ��Ʒ������Ŀ
 */
public class ProductVo {
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductInfoVo> getProductInfoVoList() {
        return productInfoVoList;
    }

    public void setProductInfoVoList(List<ProductInfoVo> productInfoVoList) {
        this.productInfoVoList = productInfoVoList;
    }
}
