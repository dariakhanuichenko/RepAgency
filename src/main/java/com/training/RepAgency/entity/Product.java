package com.training.RepAgency.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Long price;


    //    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable( name="order_product", joinColumns =@JoinColumn(name="product_id"), inverseJoinColumns = @JoinColumn(name="order_id"))
    @OneToMany(mappedBy = "product")
    private Collection<ProductOrder> order;
}
