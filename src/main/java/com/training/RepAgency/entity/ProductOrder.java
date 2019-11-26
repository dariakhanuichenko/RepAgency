package com.training.RepAgency.entity;


import com.training.RepAgency.dto.OrderDTO;
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
@NamedNativeQuery(
        name = "getBoxListByOrder",
        query = "SELECT b.id, (pr.number + b.current_load) as number1 " +
                "FROM Box b " +
                "inner join Product_Order pr on pr.product_id= b.id_product " +
                "WHERE pr.order_id=? ;",
        resultSetMapping = "OrderDTO"
)

@SqlResultSetMapping(
        name = "OrderDTO",
        classes = @ConstructorResult(
                targetClass = OrderDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "number1", type = Integer.class)
                }
        )
)
public class ProductOrder {

    @EmbeddedId
    ProductOrderKey id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    Order order;

    @Column(name = "number")
    int number;

    // standard constructors, getters, and setters
}

