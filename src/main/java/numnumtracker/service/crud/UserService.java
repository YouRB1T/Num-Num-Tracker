package numnumtracker.service.crud;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import numnumtracker.model.dto.request.user.UserRegisterRequestDto;
import numnumtracker.model.dto.request.user.UserRequestDto;
import numnumtracker.model.dto.request.user.UserUpdateRequestDto;
import numnumtracker.model.dto.response.user.UserResponseDto;
import numnumtracker.model.dto.response.user.UserUpdateResponseDto;
import numnumtracker.model.entity.User;
import numnumtracker.model.mapper.UserMapper;
import numnumtracker.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements EntityCrudService<
        UserRegisterRequestDto, UserRequestDto, UserUpdateRequestDto, UserRequestDto,
        UserResponseDto, UserResponseDto, UserUpdateResponseDto, UserResponseDto> {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserResponseDto add(UserRegisterRequestDto request) {
        User user = UserMapper.toEntity(request);
        user = userRepository.save(user);
        return UserMapper.toResponseDto(user);
    }

    @Override
    @Transactional
    public UserResponseDto get(UserRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return UserMapper.toResponseDto(user);
    }

    @Override
    @Transactional
    public UserUpdateResponseDto update(UserUpdateRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        UserMapper.updateEntityFromDto(request, user);
        return UserMapper.toUpdateResponseDto(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserResponseDto delete(UserRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        userRepository.delete(user);
        return UserMapper.toResponseDto(user);
    }
}
