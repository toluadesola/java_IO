package configParserTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ConfigParser {
    private static String name;
    private static HashMap<String, String> map;
    private static String[] keyValue;
    protected static boolean isWrong = false;


    //the configparser constructor
    public ConfigParser(String name) {
        loadFile(name); //loads the method loadFile
    }

    private static void loadFile(String filename){
        /*
        The load file method checks the string variable
        recieved from the constructor and uses it to assign the proper
        name variable before passing it to the saveToHashMap method
         */
        if(filename.equals("production")){
            name = "config.txt";
        }else if(filename.equals("staging")){
            name = "config.txt.staging";
        }else if(filename.equals("development")){
            name = "config.txt.dev";
        }
        saveToHashMap(name);
    }

    private static void saveToHashMap(String file){
        map = new HashMap<>();
        //attach the name variable containing the appropriate file name to the path
        String path = "src/main/resources/InputOutput.Resource/" + file;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String input;
            String header = "";

            while ((input = reader.readLine()) != null){
                input = input.trim();

                //check for empty line
                if(input.length() == 0){
                    //if there's an empty line, the header variable should change to empty
                    header = "";
                    continue;
                }

                //check for headers
                if(input.startsWith("[") && input.endsWith("]")){
                    //get the string between the square brackets and save to variable header
                    header = input.substring(input.indexOf("[")+1, input.indexOf("]")) + ".";
                    continue;
                }else{
                    keyValue = input.split("=");
                    //if the key exists, it should not save
                    if(!(map.containsKey(header+keyValue[0]))){
                        map.put(header+keyValue[0], keyValue[1]);
                    }
                }
            }
        } catch (IOException e) {
            isWrong = true;
//            System.out.println(e.getMessage());
            System.out.println("Wrong Argument!!! You can only use one of the following: production, staging, development");
        }
    }

    public String get(String key){
        try {
            return map.get(key);
        } catch (NullPointerException e){
            return null;
        }
    }
}
