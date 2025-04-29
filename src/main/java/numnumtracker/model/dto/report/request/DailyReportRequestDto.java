package numnumtracker.model.dto.report.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import numnumtracker.model.dto.request.user.UserRequestDto;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyReportRequestDto {
    @NotNull(message = "User cannot be null")
    @JsonProperty("user")
    private UserRequestDto user;

    @NotNull(message = "Date cannot be null")
    @JsonProperty("date")
    private LocalDate date;
}
