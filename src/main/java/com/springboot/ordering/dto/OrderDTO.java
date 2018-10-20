package com.springboot.ordering.dto;


import java.math.BigDecimal;
import java.util.List;

import com.springboot.ordering.model.OrderDetail;

/**
 * ������Ϣ����
 */
public class OrderDTO {

    /**
     * ����id.
     */
    private String orderId;

    /**
     * �������.
     */
    private String buyerName;

    /**
     * ����ֻ���.
     */
    private String buyerPhone;

    /**
     * ��ҵ�ַ.
     */
    private String buyerAddress;

    /**
     * ���΢��Openid.
     */
    private String buyerOpenid;

    /**
     * �����ܽ��.
     */
    private BigDecimal orderAmount;

    /**
     * ����״̬, Ĭ��Ϊ0���µ�.
     */
    private Integer orderStatus;

    /**
     * ֧��״̬, Ĭ��Ϊ0δ֧��.
     */
    private Integer payStatus;

    /**
     * ����ʱ��.
     */
    private long createTime;

    /**
     * ����ʱ��.
     */
    private long updateTime;
    /**
     * ���������б�
     */
    private List<OrderDetail> orderDetails;


    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", buyerPhone='" + buyerPhone + '\'' +
                ", buyerAddress='" + buyerAddress + '\'' +
                ", buyerOpenid='" + buyerOpenid + '\'' +
                ", orderAmount=" + orderAmount +
                ", orderStatus=" + orderStatus +
                ", payStatus=" + payStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", orderDetails=" + orderDetails +
                '}';
    }
}

