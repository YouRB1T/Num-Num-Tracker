package numnumtracker.model.dto.request.dish;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DishRegisterRequestDto {

    @JsonProperty("name")
    @NotBlank(message = "Name is required")
    private String name;

    @JsonProperty("calories")
    @NotNull
    @DecimalMin("0.0")
    private Double calories;

    @JsonProperty("fats")
    @NotNull
    @DecimalMin("0.0")
    private Double fats;

    @JsonProperty("proteins")
    @NotNull
    @DecimalMin("0.0")
    private Double proteins;

    @JsonProperty("carbohydrates")
    @NotNull
    @DecimalMin("0.0")
    private Double carbohydrates;
}

