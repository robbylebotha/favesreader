import java.util.HashMap;

public class App {

    public static void print(String s){
        System.out.println(s);
    }
    public static void main(String args[]) {
        
        //read txt file of users and save in hashmap
        ReadUserFile users = new ReadUserFile(".\\data\\users.txt");
        HashMap<String,String> userMap = users.getUsers();

        //read txt file of votes and save in hashmap
        ReadFavoritesFile faves = new ReadFavoritesFile(".\\data\\favourites.txt");
        HashMap<String,String> faveMap = faves.getAllFavorites();

        //get fave color by  votes and print a list of all users
        //who voted
        FavouriteColor faveCol = new FavouriteColor(faveMap,userMap);
        String bestColor = faveCol.bestColor;

        //write results to textfile in data folder
        WriteResultsFile writeResultsFile = new WriteResultsFile();
        writeResultsFile.writeToFile(bestColor, faveCol.fullUsernamesList);

        //print list of users who voted for best color
        System.out.println("\n\nBest Color: "+bestColor);
        
        for(String winners : faveCol.fullUsernamesList){
            System.out.println("\n"+winners);
        }
        System.out.println("\n\n\nDONE!");

      }
}
