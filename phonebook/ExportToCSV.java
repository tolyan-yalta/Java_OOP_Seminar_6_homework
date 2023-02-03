package phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.*;

public class ExportToCSV {
    String FILE_PATH = "./phonebook/Data/";
    String FILE_NAME_EXPORT = "Data.csv";
    String FILE_PATH_FULL = FILE_PATH+FILE_NAME_EXPORT;
    
    public void fileExport(ArrayList<Persona> pb){
        LoggerClass.logger.log(Level.INFO, "Data is written to the file");
        try(FileWriter writer = new FileWriter(FILE_PATH + FILE_NAME_EXPORT, false))
        {
            // запись всей строки
            for(Persona i: pb){
                String text = i.getName()+";"+i.getPhone()+";"+i.getCity();
                writer.write(text);
                // запись по символам
                writer.append('\n');
                // writer.append('E');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
