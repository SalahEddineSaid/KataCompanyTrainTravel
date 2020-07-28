package fr.adlere.companytrain.billing.utlis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import fr.adlere.companytrain.billing.exceptions.NoSuchElementInFileException;
import fr.adlere.companytrain.billing.exceptions.ValidateDayTravelException;
import fr.adlere.companytrain.billing.input.DayTravel;
import fr.adlere.companytrain.billing.output.Summary;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class InOutJsonValidateFiles {

    public InOutJsonValidateFiles() {
    }

    public static DayTravel readAndValidateFile(String filePath) throws IOException {

        File inputFile = new File(filePath);

        if (inputFile.exists() && inputFile.isFile() && inputFile.length()!=0)
        {
            DayTravel dayTravel =  new ObjectMapper().readValue(inputFile, DayTravel.class);
            ValidateDayTravelException valid=new ValidateDayTravelException();
            valid.ValidateDayTravelException(dayTravel);
            return dayTravel;
        }else if(!inputFile.exists() ){
            throw new NoSuchElementInFileException("the file input not exist.");
        }else{
            throw new NoSuchElementInFileException("the file input must be not null.");
        }
    }


    public static void writeInputFile(String filePath, Summary summary) throws IOException {

        if (Files.isDirectory(Paths.get(filePath))) {
            throw new NoSuchElementInFileException("Path file is a directory please add the name file");
        }else if (Files.notExists(Paths.get(filePath))){
            throw new NoSuchElementInFileException("Output file does not exist");
        }else {
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            String jsonOutput = mapper.writeValueAsString(summary);
            Files.write(Paths.get(filePath),jsonOutput.getBytes());
        }

    }}
