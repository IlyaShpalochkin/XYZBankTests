package api.pojoClass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PokemonRoot {
    private Integer weight;

    private String name;

    private List<AbilityWrapper> abilities;

}
