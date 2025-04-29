package numnumtracker.model.dto.report.resoponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import numnumtracker.model.dto.response.meal.MealResponseDto;
import numnumtracker.model.dto.response.user.UserResponseDto;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyReportResponseDto {
    @JsonProperty("user")
    private UserResponseDto user;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("dailyCalories")
    private Double dailyCalories;

    @JsonProperty("meals")
    private List<MealResponseDto> meals;
}
