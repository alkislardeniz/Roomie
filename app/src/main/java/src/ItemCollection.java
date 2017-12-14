package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import src.Enums.StatType;

/**
 * Created by eliztekcan on 26.10.2017.
 */
public class ItemCollection
{
    private static final int MAX_ITEM = 12;
    private Item[] items;
    private Stats boost;
    private static final String FILE_NAME= "/src/Other/Backpack.txt";

    public ItemCollection()
    {
        items = new Item[MAX_ITEM];
        boost = new Stats();

        //Add items to collection
        createCollection();
    }

    private void setBoostArray(int health, int sociality, int grades, int money)
    {
        boost.setStatByIndex(StatType.HEALTH, health);
        boost.setStatByIndex(StatType.SOCIALITY, sociality);
        boost.setStatByIndex(StatType.GRADES, grades);
        boost.setStatByIndex(StatType.MONEY, money);
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public static int getMaxItem() {
        return MAX_ITEM;
    }

    public Stats getBoost() {
        return boost;
    }

    public void createCollection()
    {
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(FILE_NAME);
            br = new BufferedReader(fr);

            String sCurrentLine;
            int index = 0;
            while ((sCurrentLine = br.readLine()) != null && index < MAX_ITEM)
            {
                int starInd = sCurrentLine.indexOf('*');

                setBoostArray(Integer.parseInt(sCurrentLine.substring(starInd+1,starInd+3).replaceAll("\\s+","")),
                        Integer.parseInt(sCurrentLine.substring(starInd+4,starInd+6).replaceAll("\\s+","")),
                        Integer.parseInt(sCurrentLine.substring(starInd+7,starInd+9).replaceAll("\\s+","")),
                        Integer.parseInt(sCurrentLine.substring(starInd+10,starInd+12).replaceAll("\\s+","")));
                items[index] = new Item(sCurrentLine.substring(0,starInd), null, boost);
                index++;
                boost.makeStatsZero();
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

    //for testing
    public static void main(String[] args){
        ItemCollection i = new ItemCollection();
        for(int k = 0; k< 12; k++)
            System.out.println(i.items[k]);
    }
}