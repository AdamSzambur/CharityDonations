package pl.coderslab.charity.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categories")
public class Category extends AbstractEntity{

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Donation> donations;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }
}
