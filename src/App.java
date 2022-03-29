import java.util.HashMap; 

public class App {

    public static void print(String s){
        System.out.println(s);
    }
    public static void main(String args[]) {
        print("Started");
        //read txt file of users and save in hashmap
        ReadUserFile users = new ReadUserFile();
        HashMap<String,String> userMap = users.getUsers();

        //read txt file of votes and save in hashmap
        ReadFavoritesFile faves = new ReadFavoritesFile();
        HashMap<String,String> faveMap = faves.getAllFavorites();

        //get fave color by  votes and print a list of all users
        //who voted
        FavouriteColor faveCol = new FavouriteColor();
        String bestColor = faveCol.getFavouriteColor(faveMap);

        //print list of users who voted for best color
        System.out.println("\n\nBest Color: "+bestColor);
        System.out.println();
        for(String winners : faveCol.getFaveColorVoters(userMap)){
            System.out.println("\n"+winners);
        }
        System.out.println("\n\n\nDONE!");

      }
}
