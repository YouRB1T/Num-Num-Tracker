package numnumtracker.model.dto.report.resoponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import numnumtracker.model.dto.response.user.UserResponseDto;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckCaloryReportResponseDto {
    @JsonProperty("user")
    private UserResponseDto user;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("isComplete")
    private Boolean isComplete;
}
