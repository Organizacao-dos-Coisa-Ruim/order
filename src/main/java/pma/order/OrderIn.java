package pma.order;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record OrderIn(

    @NotEmpty List<@NotNull @Valid OrderItemIn> items

) {

}
