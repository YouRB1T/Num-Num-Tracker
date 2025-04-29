package numnumtracker.model.dto.response.meal;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import numnumtracker.model.dto.response.dish.DishUpdateResponseDto;
import numnumtracker.model.dto.response.user.UserUpdateResponseDto;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealUpdateResponseDto {
    private String name;
    private LocalDate date;
    private UserUpdateResponseDto user;
    private List<DishUpdateResponseDto> dishes;
}

