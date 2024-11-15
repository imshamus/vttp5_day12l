package sg.edu.nus.iss.vttp5a_day12l.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_day12l.model.Item;


@Repository // annotated components
public class ItemRepo {

    private List<Item> itemList;

    public List<Item> getItems(){

        itemList = new ArrayList<>();

        Item itm = new Item("Apple", 5);
        itemList.add(itm);

        itm = new Item("Orange", 20);
        itemList.add(itm);

        itm = new Item("Pear",30 );
        itemList.add(itm);

        itm = new Item("Kiwi", 10);
        itemList.add(itm);

        itm = new Item("Mango", 55);
        itemList.add(itm);

        return itemList;

    }

    
}
