package com.training.RepAgency.dto;

import lombok.*;

import javax.validation.constraints.NotNull;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductBoxDTO {


    @NotNull(message = "{not.null}")
    private String name;

    @NotNull(message = "{not.null}")
    private Long price;

    @NotNull(message = "{not.null}")
    private Integer totalCapasity;
}
