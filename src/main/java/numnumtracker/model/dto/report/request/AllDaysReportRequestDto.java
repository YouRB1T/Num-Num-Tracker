package numnumtracker.model.dto.report.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import numnumtracker.model.dto.request.user.UserRequestDto;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllDaysReportRequestDto {
    @NotNull(message = "User cannot be null")
    @JsonProperty("user")
    private UserRequestDto user;

    @NotEmpty(message = "Dates list cannot be empty")
    @JsonProperty("dates")
    private List<LocalDate> dates;
}
