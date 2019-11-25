package com.training.RepAgency.entity;

import com.training.RepAgency.dto.BoxWithProductNameDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table    @NamedNativeQuery(
        name = "getBoxListByCurrentLoad",
        query = "SELECT p.name, b.id, b.total_capasity  " +
                "FROM Box b " +
                "inner join Product p on p.id= b.id_product " +
                "WHERE b.current_load=? ;",
        resultSetMapping = "BoxWithProductNameDTO"
)

@SqlResultSetMapping(
        name = "BoxWithProductNameDTO",
        classes = @ConstructorResult(
                targetClass = BoxWithProductNameDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "total_capasity", type = Integer.class),
                }
        )
)
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
