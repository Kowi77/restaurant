package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Андрей on 07.08.2017.
 */
@Entity
@Table(name = "users")
public class RegularUser extends AbstractUser {

    @Id
    @Column(name = "userId")
    @GeneratedValue
    @NotNull
    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restId")
    private Restaurant restaurant;

    public RegularUser(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public RegularUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "RegularUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
