package pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class JSONMain {

    @JsonIgnore
    String name;
    @JsonProperty("Content-addons-final-empty")
    List<SubCategory> sub_category;

    public JSONMain(){
        sub_category = new ArrayList<>();
    }

    public void addCategory(SubCategory cat){
        sub_category.add(cat);
    }
}
