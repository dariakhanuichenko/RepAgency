package com.training.RepAgency.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long payment;
    private LocalDateTime dateTime;
}
