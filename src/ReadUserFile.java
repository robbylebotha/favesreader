import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Class to read the text files
 */
public class ReadUserFile{

    public ReadUserFile(){
        System.out.println("Reading User file...");
    }

    /**Return a hashmap of users
     * @return HashMap<userID,userName>
     */
    public HashMap<String,String> getUsers(){
        HashMap<String,String> userMap = new HashMap<>();

        try{
            FileInputStream fis = new FileInputStream(".\\data\\users.txt");       
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
            System.out.println("Size of map is: "
            + userMap.size());
            // System.out.println(userMap);
            return userMap;

        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }

        
    }

}