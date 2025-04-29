package numnumtracker.service.report;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import numnumtracker.model.dto.report.request.AllDaysReportRequestDto;
import numnumtracker.model.dto.report.resoponse.AllDaysReportResponseDto;
import numnumtracker.model.dto.response.meal.MealResponseDto;
import numnumtracker.model.entity.Meal;
import numnumtracker.model.entity.User;
import numnumtracker.model.mapper.UserMapper;
import numnumtracker.repository.MealRepository;
import numnumtracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AllDaysReportService implements ReportService<AllDaysReportRequestDto, AllDaysReportResponseDto> {

    private final MealRepository mealRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional()
    public AllDaysReportResponseDto getReport(AllDaysReportRequestDto request) {
        User user = userRepository.findByEmail(request.getUserEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        List<Meal> meals = mealRepository.findAllByUserAndDateBetween(
                user,
                Collections.min(request.getDates()),
                Collections.max(request.getDates())
        );

        return AllDaysReportResponseDto.builder()
                .user(UserMapper.toResponseDto(user))
                .dates(request.getDates())
                .meals(meals.stream()
                        .map(meal -> MealResponseDto.builder()
                                .name(meal.getName())
                                .date(meal.getDate())
                                .build())
                        .toList())
                .build();
    }
}
