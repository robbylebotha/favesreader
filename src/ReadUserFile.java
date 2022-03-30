import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Class to read the text files
 */
public class ReadUserFile{
    String userFileLocation;

    public ReadUserFile(String userFileLocation){
        this.userFileLocation = userFileLocation;
        System.out.println("Reading User file...");
    }

    /**Return a hashmap of users
     * @return HashMap<userID,userName>
     */
    public HashMap<String,String> getUsers(){
        /**
         * The goal here is to read the txt file line by line,
         * split the string line by spaces and insert the values
         * into a <Key,Value> pair structure. This is specific to the
         * txt file structure, if the structure changes, an exception will be
         * thrown.
         * 
         * Step 1: read the txt file line by line ie. 18 Robby Lebotha
         * Step 2: trim leading & trailing white spaces.
         * Step 3: convert to all lowercase to make comparisons easier
         * Step4: split the string by spaces into an array ie. [18],[Robby],[Lebotha]
         * Step 5: insert into a Map<K,V> where K=user id and V=username
         * Step 6: return the map
         */
        HashMap<String,String> userMap = new HashMap<>();

        try{
            FileInputStream fis = new FileInputStream(userFileLocation);       
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine()){
                String currLine = sc.nextLine().trim().toLowerCase();
                // System.out.println(currLine);
                String[] line = currLine.split("\\s");
                String userID = line[0];
                String userFirstName = line[1];
                String userLastName = line[2];
                userMap.put(userID, userFirstName+" "+userLastName);
            }  
            sc.close();
            System.out.println("User Count: "
            + userMap.size());
            // System.out.println(userMap);
            return userMap;

        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }

        
    }

}