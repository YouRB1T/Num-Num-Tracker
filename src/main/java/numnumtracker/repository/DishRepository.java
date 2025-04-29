package numnumtracker.repository;

import numnumtracker.model.entity.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {
    @Query("SELECT d FROM Dish d WHERE d.name = :name")
    Optional<Dish> findByName(@Param("name") String name);
}
