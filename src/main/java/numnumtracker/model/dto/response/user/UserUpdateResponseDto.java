package numnumtracker.model.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import numnumtracker.model.enums.Target;

@Data
@AllArgsConstructor
public class UserUpdateResponseDto {
    private String name;
    private Integer age;
    private String email;
    private Target target;
    private Double height;
    private Double weight;
}
