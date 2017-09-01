package main.repository;

import main.model.Dish;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Андрей on 08.08.2017.
 */
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@Repository
@Transactional(readOnly = true)
public class DishRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Dish save (Dish dish, int restId){
        if (dish == null)
            return null;
        //dish.setRestaurant(.get(restId));//make restaurantService!!
        if (dish.getId() == null) {
            entityManager.persist(dish);
            return dish;
        } else if(get(dish.getId(), restId) != null &&  get(dish.getId(), restId).getRestaurant().getId() == restId){
            return entityManager.merge(dish);
        }
        return null;
    }

    public Dish get(int id, int restId) {
        Dish dish = entityManager.find(Dish.class, id);
        if (dish == null || dish.getRestaurant().getId() != restId)
            return null;
        return dish;
    }

    public List<Dish> getAll(int restId) {
        return entityManager.createQuery("SELECT d FROM Dish d WHERE d.restaurant.id =:restId")
                .setParameter("restId", restId).getResultList();
    }

    @Transactional
    public boolean delete(int id, int restId) {
        return entityManager.createQuery("DELETE FROM Dish d WHERE d.id=:id AND d.restaurant.id=:restId")
                .setParameter("id", id)
                .setParameter("restId", restId)
                .executeUpdate() != 0;
    }

}
