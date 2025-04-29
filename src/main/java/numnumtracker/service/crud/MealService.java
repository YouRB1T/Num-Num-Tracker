package numnumtracker.service.crud;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import numnumtracker.model.dto.request.meal.MealRegisterRequestDto;
import numnumtracker.model.dto.request.meal.MealRequestDto;
import numnumtracker.model.dto.request.meal.MealUpdateRequestDto;
import numnumtracker.model.dto.response.meal.MealResponseDto;
import numnumtracker.model.dto.response.meal.MealUpdateResponseDto;
import numnumtracker.model.entity.Meal;
import numnumtracker.model.entity.User;
import numnumtracker.model.mapper.MealMapper;
import numnumtracker.repository.MealRepository;
import numnumtracker.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MealService implements EntityCrudService<
        MealRegisterRequestDto, MealRequestDto, MealUpdateRequestDto, MealRequestDto,
        MealResponseDto, MealResponseDto, MealUpdateResponseDto, MealResponseDto> {

    private final MealRepository mealRepository;
    private final UserRepository userRepository;
    private final MealMapper mealMapper;

    @Override
    @Transactional
    public MealResponseDto add(MealRegisterRequestDto request) {
        User user = userRepository.findByEmail(request.getUser().getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Meal meal = mealMapper.toEntity(request);
        meal.setUser(user);
        meal = mealRepository.save(meal);
        return mealMapper.toResponseDto(meal);
    }

    @Override
    @Transactional
    public MealResponseDto get(MealRequestDto request) {
        Meal meal = mealRepository.findByDateAndUserEmail(
                        request.getDate(),
                        request.getUser().getEmail()
                )
                .orElseThrow(() -> new EntityNotFoundException(
                        "Meal not found for date: " + request.getDate() +
                                " and user: " + request.getUser().getEmail())
                );

        return mealMapper.toResponseDto(meal);
    }

    @Override
    @Transactional
    public MealUpdateResponseDto update(MealUpdateRequestDto request) {
        Meal meal = mealRepository.findByDateAndUserEmail(
                        request.getDate(),
                        request.getUser().getEmail()
                )
                .orElseThrow(() -> new EntityNotFoundException("Meal not found"));

        mealMapper.updateEntityFromDto(request, meal);
        meal = mealRepository.save(meal);
        return mealMapper.toUpdateResponseDto(meal);
    }

    @Override
    @Transactional
    public MealResponseDto delete(MealRequestDto request) {
        Meal meal = mealRepository.findByDateAndUserEmail(
                        request.getDate(),
                        request.getUser().getEmail()
                )
                .orElseThrow(() -> new EntityNotFoundException("Meal not found"));

        mealRepository.delete(meal);
        return mealMapper.toResponseDto(meal);
    }
}
