package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Андрей on 07.08.2017.
 */
@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @Column(name = "dishId")
    @GeneratedValue
    @NotNull
    private Integer id;

    @Column(name = "price")
    @NotNull
    private int price;

    @Column(name = "description")
    @NotNull
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restId")
    private Restaurant restaurant;

    public Dish(int price, String description, Restaurant restaurant) {
        this.price = price;
        this.description = description;
        this.restaurant = restaurant;
    }

    public Dish() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", restaurant=" + restaurant +
                '}';
    }
}
