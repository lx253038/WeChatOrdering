package com.springboot.ordering.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ������ϸ��Ϣ
 */
@Entity
public class OrderDetail {

    @Id
    private String detailId;

    /**
     * ����id.
     */
    private String orderId;

    /**
     * ��Ʒid.
     */
    private String productId;

    /**
     * ��Ʒ����.
     */
    private String productName;

    /**
     * ��Ʒ����.
     */
    private BigDecimal productPrice;

    /**
     * ��Ʒ����.
     */
    private Integer productQuantity;

    /**
     * ��ƷСͼ.
     */
    private String productIcon;


    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

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

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }
}
