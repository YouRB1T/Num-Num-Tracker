package numnumtracker.service.report;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import numnumtracker.model.dto.report.request.DailyReportRequestDto;
import numnumtracker.model.dto.report.resoponse.DailyReportResponseDto;
import numnumtracker.model.entity.Meal;
import numnumtracker.model.entity.User;
import numnumtracker.model.mapper.MealMapper;
import numnumtracker.model.mapper.UserMapper;
import numnumtracker.repository.MealRepository;
import numnumtracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyReportService implements ReportService<DailyReportRequestDto, DailyReportResponseDto> {

    private final MealRepository mealRepository;
    private final UserRepository userRepository;
    private final MealMapper mealMapper;

    @Override
    @Transactional
    public DailyReportResponseDto getReport(DailyReportRequestDto request) {
        User user = userRepository.findByEmail(request.getUserEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        List<Meal> meals = mealRepository.findAllByDateAndUser(
                request.getDate(),
                user
        );

        double totalCalories = meals.stream()
                .flatMap(meal -> meal.getDishes().stream())
                .mapToDouble(Dish::getCalories)
                .sum();

        return DailyReportResponseDto.builder()
                .user(UserMapper.toResponseDto(user))
                .date(request.getDate())
                .dailyCalories(totalCalories)
                .meals(meals.stream()
                        .map(mealMapper::toResponseDto)
                        .toList())
                .build();
    }
}
