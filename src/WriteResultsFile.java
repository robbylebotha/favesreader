import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.Desktop;

public class WriteResultsFile{

    /**
     * Write output to txt file
     * @param color most voted for color
     * @param users List of users who voted for color
     */
    public void writeToFile(String color,ArrayList<String> users){
        try{
            File file = new File(".\\data\\results.txt");
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("\n\nBest Color: "+color); 
            fileWriter.write("\n\nVoted by:\n\n");
            for(String winners : users){
                
                fileWriter.write(winners+"\n");
            }
            fileWriter.write("\nEOF :)");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Wrote results.txt file success");
            openResultFile(file);
        }catch(Exception e){
            System.out.println(e.toString()+"\nFailed to write txt file");
        }
    }

    /**
     * Open the file in default text editor after writing
     * @param file newly created file
     */
    private void openResultFile(File file){
        try{
            if(Desktop.isDesktopSupported()){
                Desktop.getDesktop().edit(file);
            }else{
                System.out.println("Destop is not supported.");  
            }
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
}