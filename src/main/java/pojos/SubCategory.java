package pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SubCategory {
    String sub_category;
    List<Item> items;

    public SubCategory(){
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

}
