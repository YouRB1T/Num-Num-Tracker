package numnumtracker.service.crud;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import numnumtracker.model.dto.request.dish.DishRegisterRequestDto;
import numnumtracker.model.dto.request.dish.DishRequestDto;
import numnumtracker.model.dto.request.dish.DishUpdateRequestDto;
import numnumtracker.model.dto.response.dish.DishResponseDto;
import numnumtracker.model.dto.response.dish.DishUpdateResponseDto;
import numnumtracker.model.entity.Dish;
import numnumtracker.model.mapper.DishMapper;
import numnumtracker.repository.DishRepository;
import numnumtracker.repository.MealRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishService implements EntityCrudService<
        DishRegisterRequestDto, DishRequestDto, DishUpdateRequestDto, DishRequestDto,
        DishResponseDto, DishResponseDto, DishUpdateResponseDto, DishResponseDto> {

    private final DishRepository dishRepository;
    private final MealRepository mealRepository;

    @Override
    @Transactional
    public DishResponseDto add(DishRegisterRequestDto request) {
        Dish dish = DishMapper.toEntity(request);
        dish = dishRepository.save(dish);
        return DishMapper.toResponseDto(dish);
    }

    @Override
    @Transactional
    public DishResponseDto get(DishRequestDto request) {
        Dish dish = dishRepository.findByName(request.getName())
                .orElseThrow(() -> new EntityNotFoundException("Dish not found with name: " + request.getName()));
        return DishMapper.toResponseDto(dish);
    }

    @Override
    @Transactional
    public DishUpdateResponseDto update(DishUpdateRequestDto request) {
        Dish dish = dishRepository.findByName(request.getName())
                .orElseThrow(() -> new EntityNotFoundException("Dish not found with name: " + request.getName()));

        DishMapper.updateEntityFromDto(request, dish);
        dish = dishRepository.save(dish);
        return DishMapper.toUpdateResponseDto(dish);
    }

    @Override
    @Transactional
    public DishResponseDto delete(DishRequestDto request) {
        Dish dish = dishRepository.findByName(request.getName())
                .orElseThrow(() -> new EntityNotFoundException("Dish not found with name: " + request.getName()));

        dishRepository.delete(dish);
        return DishMapper.toResponseDto(dish);
    }
}
