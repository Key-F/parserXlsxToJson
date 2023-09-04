package pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AddonTutorial {
    private String description;
    private String commands;
    private List<String> images;


    public AddonTutorial(Map<String, String> map){
        this.description = map.get("description");
        this.commands = map.get("commands");
        images = new ArrayList();
        setImages(map);
    }

    public void setImages(Map<String, String> map){
        addImage(map.get("imageUrl1"));
        addImage(map.get("imageUrl2"));
        addImage(map.get("imageUrl3"));
        addImage(map.get("imageUrl4"));
        addImage(map.get("imageUrl5"));
        addImage(map.get("imageUrl6"));
        addImage(map.get("imageUrl7"));
    }

    private void addImage(String text){
        if(!text.isEmpty())
            this.images.add(text);
    }

}
