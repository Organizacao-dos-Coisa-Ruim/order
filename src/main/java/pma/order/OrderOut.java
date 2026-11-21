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
    List<OrderItemOut> items,
    /**
     * PENDENTE logo depois de criado; CONFIRMADO quando o order-worker processa o evento
     * "pedido criado" da fila (RabbitMQ) e envia a confirmação ao cliente.
     */
    String status,
    /** Quando a confirmação foi enviada (null enquanto PENDENTE). */
    Instant confirmedAt

) {

  public static final String STATUS_PENDENTE = "PENDENTE";
  public static final String STATUS_CONFIRMADO = "CONFIRMADO";

}
