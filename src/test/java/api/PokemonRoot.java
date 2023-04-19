package api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonRoot {
    public Integer getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer weight;

    private String name;

}
