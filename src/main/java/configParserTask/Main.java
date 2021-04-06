package configParserTask;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String environmentVariable;
        Scanner inputText = new Scanner(System.in);
        if(args.length>0){
            environmentVariable= args[0];
        }else {
            environmentVariable = "production";
        }

        //run with production, staging, development
        ConfigParser config = new ConfigParser(environmentVariable);
        if(!config.isWrong){
            System.out.println("Please Input The Key String You want To Get Its Value below:");
            System.out.println(config .get(inputText.next()));
        }

    }
}
