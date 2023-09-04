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
public class Item {

    private String id;
    private String title;
    private String createdby;
    private String sourceUrl;
    private String shortDescription;
    private String detailedDescription;
    private List<String> images;
    private List<String> screenshots;
    private AddonTutorial addonTutorial;
    private List<FilePOJO> files;

    public Item (Map<String, String> map){
        this.id = map.get("id");
        this.title = map.get("title");
        this.createdby = map.get("createdby");
        this.sourceUrl = map.get("sourceUrl");
        this.shortDescription = map.get("shortDescription");
        this.detailedDescription = map.get("detailedDescription");
        this.images = new ArrayList();
        this.screenshots = new ArrayList();
        this.files = new ArrayList();
    }

    public void addFile(FilePOJO filePOJO){
        this.files.add(filePOJO);
    }

    public void setImages(Map<String, String> map){
        addImage(map.get("imageUrl1"));
        addImage(map.get("imageUrl2"));
        addImage(map.get("imageUrl3"));
        addImage(map.get("imageUrl4"));
        addImage(map.get("imageUrl5"));
    }

    public void setScreenshots(Map<String, String> map){
        this.screenshots.add(map.get("imageUrl1"));
        this.screenshots.add(map.get("imageUrl2"));
        this.screenshots.add(map.get("imageUrl3"));
    }

    private void addImage(String text){
        if(!text.isEmpty())
            this.images.add(text);
    }

}
