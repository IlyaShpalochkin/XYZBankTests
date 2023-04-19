package api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private String link;


}
