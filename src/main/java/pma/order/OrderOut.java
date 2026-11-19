package pma.order;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import lombok.Builder;

@Builder
public record OrderOut(

    String id,
    String accountId,
    BigDecimal total,
    Instant createdAt,
    List<OrderItemOut> items

) {

}
