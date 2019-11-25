package com.training.RepAgency.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer currentLoad;
    private Integer totalCapasity;

    @OneToOne
    @JoinColumn(name = "id_product")
    private Product product;
}
