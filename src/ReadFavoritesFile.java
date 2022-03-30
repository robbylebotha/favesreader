import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class to read the text files
 */
public class ReadFavoritesFile{
    String favouritesFileLocation;

    public ReadFavoritesFile(String favouritesFileLocation){
        this.favouritesFileLocation = favouritesFileLocation;
        System.out.println("Reading Favorites file...");
    }

    /**
     * Return a hashmap of iserIDs and voted color
     * @return HashMap<userID,color>
     */
    public HashMap<String,String> getAllFavorites(){
        /**
         * The goal here is to read the txt file line by line,
         * split the string line by spaces and insert the values
         * into a <Key,Value> pair structure. This is specific to the
         * txt file structure, if the structure changes, an exception will be
         * thrown.
         */
        HashMap<String,String> favesMap = new HashMap<>();

        try{
            FileInputStream fis = new FileInputStream(favouritesFileLocation);       
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
            System.out.println("Total Votes: "
            + favesMap.size());
            // System.out.println(favesMap);
            return favesMap;

        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }

    }
    
}