import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FavouriteColor {
    private ArrayList<String> users = null;
    public HashMap<String,String> votedColors;
    private HashMap<String,String> votedUsers;
    public String bestColor = null;
    public ArrayList<String> fullUsernamesList = null;

    public FavouriteColor(HashMap<String,String> votedColors,
    HashMap<String,String> votedUsers){
        this.votedColors = votedColors;
        this.votedUsers = votedUsers;
        getFavouriteColor();
        getFaveColorVoters();
    }

    /**
     * Get fave color
     * @param HashMap<String,String>
     * @return A string representing the most voted for color
     */
    private String getFavouriteColor(){
        /**
         * The goal here is to iterate through the votes map and
         * see which color has been voted the most. We will do this
         * by creating a new KV map where we insert K=color and V=count.
         * Every iteration we will check if color exists, if it does we increment
         * the count, if not we set color and value to 1.
         */

        //to hold current highest voted total
        int highestNum = 0; 
        //hold users who voted for top color
        users = new ArrayList<>(); 
        //this map will hold k=color v=no of time its voted for
        HashMap<String, Integer> freqCount = new HashMap<>();
 
        //iterate over votes map
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

        bestColor = bestColor.toUpperCase()+" voted by "+highestNum+" users";
        return (bestColor);

    }

    /**
     * Get a list of those who voted for the top color
     * @return ArrayList of voters
     */
    private ArrayList<String> getFaveColorVoters(){
        fullUsernamesList = new ArrayList<>();

        try{

            //Compare the userIds of the users who voted for best color
            //to the user hashmap to get the names of the users
            //comparable to SQL statement such as
            //"SELECT users.username FROM users WHERE users.userid = votes.userID"
            for (String user : users) {
                if(votedUsers.keySet().contains(user)){
                    fullUsernamesList.add(votedUsers.get(user));
                }
            }
    
            //sort alphabetically the list of users
            Collections.sort(fullUsernamesList);
    
            return fullUsernamesList;
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
    
}
