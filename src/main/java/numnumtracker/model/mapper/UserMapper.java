package numnumtracker.model.mapper;

import numnumtracker.model.dto.request.user.UserRegisterRequestDto;
import numnumtracker.model.dto.request.user.UserRequestDto;
import numnumtracker.model.dto.request.user.UserUpdateRequestDto;
import numnumtracker.model.dto.response.user.UserResponseDto;
import numnumtracker.model.dto.response.user.UserUpdateResponseDto;
import numnumtracker.model.entity.User;

import java.util.ArrayList;

public class UserMapper {

    public static User toEntity(UserRegisterRequestDto dto) {
        return new User(
                null,
                dto.getName(),
                dto.getEmail(),
                dto.getAge(),
                dto.getHeight(),
                dto.getWeight(),
                dto.getTarget(),
                dto.getGender(),
                new ArrayList<>()
        );
    }

    public static User toEntity(UserRequestDto dto) {
        return new User(
                null,
                dto.getName(),
                dto.getEmail(),
                null,
                null,
                null,
                null,
                null,
                new ArrayList<>()
        );
    }

    public static User toEntity(UserUpdateRequestDto dto) {
        return new User(
                null,
                dto.getName(),
                dto.getEmail(),
                dto.getAge(),
                dto.getHeight(),
                dto.getWeight(),
                dto.getTarget(),
                null,
                new ArrayList<>()
        );
    }

    public static UserResponseDto toResponseDto(User user) {
        return new UserResponseDto(
                user.getName(),
                user.getEmail()
        );
    }

    public static UserUpdateResponseDto toUpdateResponseDto(User user) {
        return new UserUpdateResponseDto(
                user.getName(),
                user.getAge(),
                user.getEmail(),
                user.getTarget(),
                user.getHeight(),
                user.getWeight()
        );
    }

    public static void updateEntityFromDto(UserUpdateRequestDto dto, User entity) {
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getAge() != null) {
            entity.setAge(dto.getAge());
        }
        if (dto.getHeight() != null) {
            entity.setHeight(dto.getHeight());
        }
        if (dto.getWeight() != null) {
            entity.setWeight(dto.getWeight());
        }
        if (dto.getTarget() != null) {
            entity.setTarget(dto.getTarget());
        }
    }
}


