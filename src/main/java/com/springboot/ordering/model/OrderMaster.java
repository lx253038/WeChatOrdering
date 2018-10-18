package com.springboot.ordering.model;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ��ʦ��
 * 2017-06-11 17:08
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /** ����id. */
    @Id
    private String orderId;

    /** �������. */
    private String buyerName;

    /** ����ֻ���. */
    private String buyerPhone;

    /** ��ҵ�ַ. */
    private String buyerAddress;

    /** ���΢��Openid. */
    private String buyerOpenid;

    /** �����ܽ��. */
    private BigDecimal orderAmount;

    /** ����״̬, Ĭ��Ϊ0���µ�. */
    private Integer orderStatus ;

    /** ֧��״̬, Ĭ��Ϊ0δ֧��. */
    private Integer payStatus ;

    /** ����ʱ��. */
    private Date createTime;

    /** ����ʱ��. */
    private Date updateTime;

}
