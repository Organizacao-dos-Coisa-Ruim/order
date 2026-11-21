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
    /** PENDING enquanto o evento order-created não foi processado; CONFIRMED depois (gargalo #77). */
    String status,
    Instant createdAt,
    /** Quando o processamento assíncrono terminou; null enquanto PENDING. */
    Instant confirmedAt,
    List<OrderItemOut> items

) {

}
