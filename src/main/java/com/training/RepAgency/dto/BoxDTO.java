package com.training.RepAgency.dto;


import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter

@NoArgsConstructor
public class BoxDTO {

    @NotNull(message = "{not.null}")
    Long id;

    @NotNull(message = "{not.null}")
    Integer quantity;
}
