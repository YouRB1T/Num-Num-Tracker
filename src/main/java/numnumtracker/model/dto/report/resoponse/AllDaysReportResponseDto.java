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
public class AllDaysReportResponseDto {
    @JsonProperty("user")
    private UserResponseDto user;

    @JsonProperty("dates")
    private List<LocalDate> dates;

    @JsonProperty("meals")
    private List<MealResponseDto> meals;
}
