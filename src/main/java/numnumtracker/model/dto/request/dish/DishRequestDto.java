package numnumtracker.model.dto.request.dish;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DishRequestDto {

    @JsonProperty("name")
    @NotBlank(message = "Name is required")
    private String name;
}

