package pma.order;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record OrderItemOut(

    String productId,
    String name,
    int quantity,
    BigDecimal unitPrice,
    BigDecimal subtotal

) {

}
