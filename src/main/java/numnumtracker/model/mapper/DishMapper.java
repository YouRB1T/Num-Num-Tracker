package numnumtracker.model.mapper;

import numnumtracker.model.dto.request.dish.DishRegisterRequestDto;
import numnumtracker.model.dto.request.dish.DishRequestDto;
import numnumtracker.model.dto.request.dish.DishUpdateRequestDto;
import numnumtracker.model.dto.response.dish.DishResponseDto;
import numnumtracker.model.dto.response.dish.DishUpdateResponseDto;
import numnumtracker.model.entity.Dish;

public class DishMapper {

    public static Dish toEntity(DishRegisterRequestDto dto) {
        return new Dish(
                null,
                dto.getName(),
                dto.getCalories(),
                dto.getFats(),
                dto.getProteins(),
                dto.getCarbohydrates()
        );
    }

    public static Dish toEntity(DishRequestDto dto) {
        return new Dish(
                null,
                dto.getName(),
                null,
                null,
                null,
                null
        );
    }

    public static Dish toEntity(DishUpdateRequestDto dto) {
        return new Dish(
                null,
                dto.getName(),
                dto.getCalories(),
                dto.getFats(),
                dto.getProteins(),
                dto.getCarbohydrates()
        );
    }

    public static DishResponseDto toResponseDto(Dish dish) {
        return new DishResponseDto(
                dish.getName(),
                dish.getCalories()
        );
    }

    public static DishUpdateResponseDto toUpdateResponseDto(Dish dish) {
        return new DishUpdateResponseDto(
                dish.getName(),
                dish.getCalories(),
                dish.getFats(),
                dish.getProteins(),
                dish.getCarbohydrates()
        );
    }

    public static void updateEntityFromDto(DishUpdateRequestDto dto, Dish entity) {
        if (dto.getCalories() != null) {
            entity.setCalories(dto.getCalories());
        }
        if (dto.getFats() != null) {
            entity.setFats(dto.getFats());
        }
        if (dto.getProteins() != null) {
            entity.setProteins(dto.getProteins());
        }
        if (dto.getCarbohydrates() != null) {
            entity.setCarbohydrates(dto.getCarbohydrates());
        }
    }
}

