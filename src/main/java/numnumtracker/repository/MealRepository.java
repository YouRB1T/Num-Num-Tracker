package numnumtracker.repository;

import numnumtracker.model.entity.Meal;
import numnumtracker.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {
    @Query("SELECT m FROM Meal m WHERE m.date = :date AND m.user.email = :userEmail")
    Optional<Meal> findByDateAndUserEmail(
            @Param("date") LocalDate date,
            @Param("userEmail") String userEmail
    );

    @Query("""
        SELECT m FROM Meal m
        WHERE m.user = :user
        AND m.date BETWEEN :startDate AND :endDate
        ORDER BY m.date ASC
        """)
    List<Meal> findAllByUserAndDateBetween(
            @Param("user") User user,
            @Param("startDate") LocalDate start,
            @Param("endDate") LocalDate end
    );
}
