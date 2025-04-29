package numnumtracker.model.dto.request.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "Name cannot be blank")
    @JsonProperty("name")
    private String name;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")
    @JsonProperty("email")
    private String email;
}
