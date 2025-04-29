package numnumtracker.model.dto.response.dish;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DishResponseDto {
    private String name;
    private Double calories;
}

