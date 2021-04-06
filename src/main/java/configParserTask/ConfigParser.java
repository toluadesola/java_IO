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


    public ConfigParser(String name) {
        loadFile(name);
    }

    private static void loadFile(String filename){
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
        String path = "src/main/resources/InputOutput.Resource/" + file;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String input;
            String header = "";

            while ((input = reader.readLine()) != null){
                input = input.trim();

                //check for empty line
                if(input.length() == 0){
                    header = "";
                    continue;
                }

                //check for headers
                if(input.startsWith("[") && input.endsWith("]")){
                    header = input.substring(input.indexOf("[")+1, input.indexOf("]")) + ".";
                    continue;
                }else{
                    keyValue = input.split("=");
                    if(!(map.containsKey(header+keyValue[0]))){
                        map.put(header+keyValue[0], keyValue[1]);
                    }
                }
            }
        } catch (IOException e) {
            isWrong = true;
            System.out.println(e.getMessage());
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
