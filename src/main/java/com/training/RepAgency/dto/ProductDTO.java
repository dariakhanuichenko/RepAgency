package com.training.RepAgency.dto;

import com.training.RepAgency.entity.Box;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDTO {
    @NotNull(message = "{not.null}")
    private Long id;

    @NotNull(message = "{not.null}")
    private String name;

    @NotNull(message = "{not.null}")
    private Long price;

    @NotNull(message = "{not.null}")
    private Integer currentLoad;
}
