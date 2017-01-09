package fr.ichida.domain;

import javax.persistence.*;

/**
 * Created by shoun on 04/01/2017.
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
public class StoryCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String actor;
    private String description;
    private String imageUrl;
    @OneToOne
    private CharacterExtraData extraData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public CharacterExtraData getExtraData() {
        return extraData;
    }

    public void setExtraData(CharacterExtraData extraData) {
        this.extraData = extraData;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
