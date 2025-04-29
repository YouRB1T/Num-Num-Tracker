package numnumtracker.model.dto.response.dish;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DishUpdateResponseDto {
    private String name;
    private Double calories;
    private Double fats;
    private Double proteins;
    private Double carbohydrates;
}
