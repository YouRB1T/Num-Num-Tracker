package numnumtracker.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import numnumtracker.model.enums.Gender;
import numnumtracker.model.enums.Target;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data

@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private Integer age;

    @Column
    private Double height;

    @Column
    private Double weight;

    @Enumerated(EnumType.STRING)
    @Column
    private Target target;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Meal> meals = new ArrayList<>();
}
