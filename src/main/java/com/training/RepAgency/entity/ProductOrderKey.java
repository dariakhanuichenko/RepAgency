package com.training.RepAgency.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Embeddable
public class ProductOrderKey implements Serializable {

    @Column(name = "product_id")
    Long productId;

    @Column(name = "order_id")
    String orderId;
}
