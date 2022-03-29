import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class to read the text files
 */
public class ReadFavoritesFile{

    public ReadFavoritesFile(){
        System.out.println("Reading Favorites file...");
    }

    /**Return a hashmap of users
     * @return HashMap<userID,userName>
     */
    public HashMap<String,String> getAllFavorites(){
        HashMap<String,String> favesMap = new HashMap<>();

        try{
            FileInputStream fis = new FileInputStream(".\\data\\favourites.txt");       
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine()){
                String currLine = sc.nextLine().trim().toLowerCase(); //avoid mistakes
                // System.out.println(currLine);
                String[] line = currLine.split("\\s");
                String userID = line[0];
                String color = line[1];
                favesMap.put(userID, color);
            }  
            sc.close();
            // System.out.println("Size of map is: "
            // + favesMap.size());
            // System.out.println(favesMap);
            return favesMap;

        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }

        
    }
    
}