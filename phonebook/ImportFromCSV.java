package phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.*;

public class ImportFromCSV {
    String FILE_PATH = "./phonebook/Data/";
    String FILE_NAME_EXPORT = "Data.csv";
    String FILE_PATH_FULL = FILE_PATH+FILE_NAME_EXPORT;
    
        public void fileImport(ArrayList<Persona> pb){
        LoggerClass.logger.log(Level.INFO, "Data loaded from the file");
        try {
            File file = new File(FILE_PATH_FULL);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] tmp = line.split(";");
                pb.add(new Persona(tmp[0], tmp[1], tmp[2]));
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
