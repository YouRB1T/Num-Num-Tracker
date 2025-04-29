package numnumtracker.model.dto.request.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import numnumtracker.model.enums.Target;

@Data
@AllArgsConstructor
public class UserUpdateRequestDto {
    @NotBlank(message = "Name cannot be blank")
    @JsonProperty("name")
    private String name;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")
    @JsonProperty("email")
    private String email;

    @NotNull(message = "Age is required")
    @Min(0)
    @Max(150)
    @JsonProperty("age")
    private Integer age;

    @NotNull(message = "Target is required")
    @JsonProperty("target")
    private Target target;

    @NotNull(message = "Height is required")
    @DecimalMin("20.0")
    @JsonProperty("height")
    private Double height;

    @NotNull(message = "Weight is required")
    @DecimalMin("5.0")
    @JsonProperty("weight")
    private Double weight;
}
