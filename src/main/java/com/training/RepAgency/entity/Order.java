package com.training.RepAgency.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @NonNull
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private Long paid;
    //@ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "order")
    @OneToMany(mappedBy = "order")
    private Collection<ProductOrder> product;


}
