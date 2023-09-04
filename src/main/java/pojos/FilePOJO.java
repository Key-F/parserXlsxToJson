package pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FilePOJO {

    private String title;
    private String size;
    private String version;
    private String downloadUrl;
    private String instructions;

    public FilePOJO (Map<String, String> map){
        this.title = map.get("title");
        this.size = map.get("size");
        this.version = map.get("version");
        this.downloadUrl = map.get("downloadUrl");
        this.instructions = map.get("instructions");
    }
}
