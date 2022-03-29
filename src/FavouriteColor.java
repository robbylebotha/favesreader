import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FavouriteColor {
    private ArrayList<String> users;

    public FavouriteColor(){
        
    }

    /**
     * Get fave color
     * @return A string representing the most voted for color
     */
    public String getFavouriteColor(HashMap<String,String> votedColors){
        // System.out.println("----------START--------------\n\n");
        int highestNum = 0;
        String bestColor = null;
        users = new ArrayList<>();
        HashMap<String, Integer> freqCount = new HashMap<>();

         // Iterating HashMap through for loop
         for (Map.Entry<String, String> set :
         votedColors.entrySet()) {

            String userID = set.getKey();
            String color = set.getValue();

            if(freqCount.keySet().contains(color)){
                freqCount.put(color, freqCount.get(color)+1);
            }else{
                freqCount.put(color, 1);
            }

            if(freqCount.get(color) > highestNum){
                highestNum = freqCount.get(color);
                bestColor = color;
                users.add(userID);
            }

        }

        // System.out.println(freqCount);
        // System.out.println("----------END--------------");
        System.out.println("Best Color: "+bestColor+" votes: "+highestNum);
        return (bestColor.toUpperCase()+" votes: "+highestNum);

    }

    /**
     * Get a list of those who voted for the top color
     * @return ArrayList of voters
     */
    public ArrayList<String> getFaveColorVoters(HashMap<String,String> votedUsers){
        ArrayList<String> fullUsernamesList = new ArrayList<>();

        for (String user : users) {
            if(votedUsers.keySet().contains(user)){
                fullUsernamesList.add(votedUsers.get(user));
            }
        }

        //sort alphabetically the list of users
        Collections.sort(fullUsernamesList);

        return fullUsernamesList;
    }
    
}
