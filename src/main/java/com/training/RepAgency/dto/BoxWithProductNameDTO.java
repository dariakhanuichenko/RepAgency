package com.training.RepAgency.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BoxWithProductNameDTO {

    private Long id;
    private String name;
    private Integer totalCapasity;
}
