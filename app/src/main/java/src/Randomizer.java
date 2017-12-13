package src;

import java.util.Random;

/**
 * Created by eliztekcan on 26.10.2017.
 */
public class Randomizer {
    private ItemCollection itemCollection;

    Randomizer(){
        itemCollection = new ItemCollection();
        Random rand = new Random();
    }

    public Item throwItem(){
        Random rand = new Random();
        Item[] items = new Item[itemCollection.getMaxItem()];
        items = itemCollection.getItems();
        return items[rand.nextInt(itemCollection.getMaxItem())];
    }

    public void setItemCollection(ItemCollection itemCollection) {
        this.itemCollection = itemCollection;
    }

    public ItemCollection getItemCollection() {
        return itemCollection;
    }

    //for testing
    /*public static void main(String[] args){
       Randomizer r = new Randomizer();
        for(int k = 0; k< 12; k++)
            System.out.println(r.throwItem());
    }*/
}
