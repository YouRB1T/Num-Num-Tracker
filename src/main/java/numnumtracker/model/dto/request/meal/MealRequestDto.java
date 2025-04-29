package numnumtracker.model.dto.request.meal;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import numnumtracker.model.dto.request.dish.DishRequestDto;
import numnumtracker.model.dto.request.user.UserRequestDto;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealRequestDto {
    @NotBlank
    @Size(min = 2, max = 100)
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("date")
    private LocalDate date;

    @NotNull
    @JsonProperty("user")
    private @Valid UserRequestDto user;

    @NotEmpty
    @JsonProperty("dishes")
    private List<@Valid DishRequestDto> dishes;
}

