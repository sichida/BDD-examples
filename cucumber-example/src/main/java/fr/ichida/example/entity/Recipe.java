package fr.ichida.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a recipe. It's described by a name and a description.
 * Additionally, a mark can be set representing the average mark of the recipe.
 *
 * @author shoun
 * @since 10/12/2015
 */
@Entity
public class Recipe {
    /**
     * Identifier of the conference
     */
    private Integer id;

    /**
     * The name of the recipe
     */
    private String name;
    /**
     * The description of the recipe
     */
    private String description;
    /**
     * The average mark of the recipe
     */
    private Double mark;

    /**
     * The all marks of the conference
     */
    private List<Double> markHistory = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @ElementCollection
    public List<Double> getMarkHistory() {
        return markHistory;
    }

    public void setMarkHistory(List<Double> markHistory) {
        this.markHistory = markHistory;
    }

    public void addMark(double mark) {
        if (null == markHistory) {
            markHistory = new ArrayList<>();
        }
        markHistory.add(mark);
        setMark(markHistory.stream().mapToDouble(a -> a).average().getAsDouble());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id) &&
                Objects.equals(name, recipe.name) &&
                Objects.equals(description, recipe.description) &&
                Objects.equals(mark, recipe.mark) &&
                Objects.equals(markHistory, recipe.markHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, mark, markHistory);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Recipe{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", mark=").append(mark);
        sb.append(", markHistory=").append(markHistory);
        sb.append('}');
        return sb.toString();
    }
}
