package sqlQueries.entity;

import java.time.LocalDate;
import java.util.Date;

public class Person {

    private Integer id;
    private String name;
    private Double weight;
    private String moto;
    private LocalDate creationDate;

    public Person() {
    }

    public Person(Integer id, String name, Double weight, String moto, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.moto = moto;
        this.creationDate = creationDate;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getMoto() {
        return moto;
    }

    public void setMoto(String moto) {
        this.moto = moto;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", moto='").append(moto).append('\'');
        sb.append(", creationDate=").append(creationDate);
        sb.append('}');
        return sb.toString();
    }
}
