package numnumtracker.service.report;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import numnumtracker.model.dto.report.request.CheckCaloryReportRequestDto;
import numnumtracker.model.dto.report.request.DailyReportRequestDto;
import numnumtracker.model.dto.report.resoponse.CheckCaloryReportResponseDto;
import numnumtracker.model.dto.report.resoponse.DailyReportResponseDto;
import numnumtracker.model.entity.User;
import numnumtracker.model.mapper.UserMapper;
import numnumtracker.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckCaloryReportService implements ReportService<CheckCaloryReportRequestDto, CheckCaloryReportResponseDto> {

    private final DailyReportService dailyReportService;
    private final UserRepository userRepository;

    @Override
    public CheckCaloryReportResponseDto getReport(CheckCaloryReportRequestDto request) {
        DailyReportResponseDto dailyReport = dailyReportService.getReport(
                new DailyReportRequestDto(request.getUser().getEmail(), request.getDate())
        );

        User user = userRepository.findByEmail(request.getUserEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        boolean isComplete = dailyReport.getDailyCalories() >= user.getDailyCalorieTarget();

        return CheckCaloryReportResponseDto.builder()
                .user(UserMapper.toResponseDto(user))
                .date(request.getDate())
                .isComplete(isComplete)
                .build();
    }
}
