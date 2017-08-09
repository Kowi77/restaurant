package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Андрей on 07.08.2017.
 */
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @Column(name = "restId")
    @GeneratedValue
    @NotNull
    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;

   /* @OneToMany(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "dishId")
    private List<Dish> dishesForLunch;

    @OneToMany(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "userId")
    private List<RegularUser> votedUsers;*/

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
