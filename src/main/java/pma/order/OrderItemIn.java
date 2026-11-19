package pma.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record OrderItemIn(

    @NotBlank String productId,
    @Positive int quantity

) {

}
