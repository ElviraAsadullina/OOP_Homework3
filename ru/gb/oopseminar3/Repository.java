package ru.gb.oopseminar3;


import ru.gb.oopseminar3.add.ANSIConstants;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;


public class Repository {
    public void saveResultsOfSearch(String info) throws FileNotFoundException, UnsupportedEncodingException {
        try(FileWriter fileWriter = new FileWriter("Notes.csv", true)){
            fileWriter.write(info + "\n");
            fileWriter.flush();
            System.out.println(ANSIConstants.ANSI_GREEN +
                    "Информация сохранена в Notes!" + ANSIConstants.ANSI_RESET);
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println(ANSIConstants.ANSI_RED +
                    "При попытке записи возникла ошибка!" + ANSIConstants.ANSI_RESET);
            e.printStackTrace();
        }
    }
    public void clearFile(){
        try(FileWriter fileWriter = new FileWriter("Notes.csv")){
            fileWriter.write("");
            fileWriter.flush();
        }catch (Exception exception){}
    }
}
