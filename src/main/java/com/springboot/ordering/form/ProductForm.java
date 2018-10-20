package com.springboot.ordering.form;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * ��������Ʒǰ̨����
 */
public class ProductForm {
    /**
     * ��Ʒid
     */
    private String productId;

    /**
     * ��Ʒ����
     */
    @NotEmpty(message = "��Ʒ���Ʋ���Ϊ��")
    private String productName;

    /**
     * ��Ʒ����
     */
    private BigDecimal productPrice;

    /**
     * ��Ʒ���
     */
    private Integer productStock;

    /**
     * ��Ʒ����
     */
    private String productDescription;

    /**
     * ��ƷСͼ
     */
    private String productIcon;

    /**
     * ��Ʒ��Ŀ
     */
    private Integer categoryType;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }
}
