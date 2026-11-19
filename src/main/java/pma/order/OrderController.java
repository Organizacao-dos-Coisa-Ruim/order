package pma.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

/** Contrato HTTP do Order, compartilhado por clientes Feign e pelo order-service. */
@FeignClient(name = "order", url = "${pma.order.url:http://order:8080}")
public interface OrderController {

  @PostMapping("/orders")
  ResponseEntity<OrderOut> create(@Valid @RequestBody OrderIn in);

  @GetMapping("/orders/health-check")
  ResponseEntity<Void> healthCheck();

}
