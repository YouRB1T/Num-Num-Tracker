package numnumtracker.model.mapper;

import numnumtracker.model.dto.request.dish.DishUpdateRequestDto;
import numnumtracker.model.dto.request.meal.*;
import numnumtracker.model.dto.response.meal.*;
import numnumtracker.model.entity.Dish;
import numnumtracker.model.entity.Meal;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MealMapper {

    public Meal toEntity(MealRegisterRequestDto dto) {
        if (dto == null) return null;

        return Meal.builder()
                .name(dto.getName())
                .date(LocalDate.now())
                .user(UserMapper.toEntity(dto.getUser()))
                .dishes(dto.getDishes().stream()
                        .map(DishMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public Meal toEntity(MealRequestDto dto) {
        if (dto == null) return null;

        return Meal.builder()
                .name(dto.getName())
                .date(LocalDate.now())
                .user(UserMapper.toEntity(dto.getUser()))
                .dishes(dto.getDishes().stream()
                        .map(DishMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public Meal toEntity(MealUpdateRequestDto dto) {
        if (dto == null) return null;

        return Meal.builder()
                .name(dto.getName())
                .user(UserMapper.toEntity(dto.getUser()))
                .dishes(dto.getDishes().stream()
                        .map(DishMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public MealResponseDto toResponseDto(Meal meal) {
        if (meal == null) return null;

        return MealResponseDto.builder()
                .name(meal.getName())
                .date(meal.getDate())
                .user(UserMapper.toResponseDto(meal.getUser()))
                .dishes(meal.getDishes().stream()
                        .map(DishMapper::toResponseDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public MealUpdateResponseDto toUpdateResponseDto(Meal meal) {
        if (meal == null) return null;

        return MealUpdateResponseDto.builder()
                .name(meal.getName())
                .date(meal.getDate())
                .user(UserMapper.toUpdateResponseDto(meal.getUser()))
                .dishes(meal.getDishes().stream()
                        .map(DishMapper::toUpdateResponseDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public static void updateEntityFromDto(MealUpdateRequestDto dto, Meal entity) {
        Objects.requireNonNull(dto, "MealUpdateRequestDto cannot be null");
        Objects.requireNonNull(entity, "Meal entity cannot be null");

        if (dto.getName() != null && !dto.getName().isBlank()) {
            entity.setName(dto.getName());
        }

        if (dto.getDate() != null) {
            entity.setDate(dto.getDate());
        }

        if (dto.getDishes() != null && !dto.getDishes().isEmpty()) {
            updateDishes(entity, dto.getDishes());
        }
    }

    private static void updateDishes(Meal meal, List<DishUpdateRequestDto> dishDtos) {
        Map<String, Dish> existingDishes = meal.getDishes().stream()
                .collect(Collectors.toMap(Dish::getName, Function.identity()));

        meal.getDishes().clear();

        for (DishUpdateRequestDto dishDto : dishDtos) {
            Dish dish = existingDishes.getOrDefault(dishDto.getName(), new Dish());
            DishMapper.updateEntityFromDto(dishDto, dish);
            meal.getDishes().add(dish);
        }
    }
}