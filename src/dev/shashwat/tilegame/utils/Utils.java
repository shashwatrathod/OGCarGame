package dev.shashwat.tilegame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null ){
                builder.append(line + "\n");
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return builder.toString();
    }

    public static int parseInt(String integer){
        try{
            return Integer.parseInt(integer);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }
}
