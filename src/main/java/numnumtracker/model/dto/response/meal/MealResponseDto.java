package numnumtracker.model.dto.response.meal;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import numnumtracker.model.dto.response.dish.DishResponseDto;
import numnumtracker.model.dto.response.user.UserResponseDto;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealResponseDto {
    private String name;
    private LocalDate date;
    private UserResponseDto user;
    private List<DishResponseDto> dishes;
}

