package com.springboot.ordering.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by ��ʦ��
 * 2017-06-11 17:20
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /** ����id. */
    private String orderId;

    /** ��Ʒid. */
    private String productId;

    /** ��Ʒ����. */
    private String productName;

    /** ��Ʒ����. */
    private BigDecimal productPrice;

    /** ��Ʒ����. */
    private Integer productQuantity;

    /** ��ƷСͼ. */
    private String productIcon;
}
