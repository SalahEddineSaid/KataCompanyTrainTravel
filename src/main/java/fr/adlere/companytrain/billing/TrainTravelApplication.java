package fr.adlere.companytrain.billing;

import fr.adlere.companytrain.billing.billingService.CalculBillingDay;
import fr.adlere.companytrain.billing.exceptions.NoSuchElementInFileException;
import fr.adlere.companytrain.billing.input.DayTravel;
import fr.adlere.companytrain.billing.output.Summary;
import fr.adlere.companytrain.billing.utlis.InOutJsonValidateFiles;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TrainTravelApplication {

    public static void main(String[] args) throws IOException {

       if (args[0] == null && args[1]== null) {
            System.out.println("input and output are missing ");
        }else if (args[0].trim().isEmpty()) {
            System.out.println("input file is not defined");
        }else if (args[1] == null || args[1].trim().isEmpty()) {
            System.out.println("you should defined the output file");
        } else {

              String fileInput = args[0];
              String fileOutPut=args[1];
              InOutJsonValidateFiles inputOutFile = new InOutJsonValidateFiles();
              DayTravel dayTravel = inputOutFile.readAndValidateFile(fileInput);
              CalculBillingDay calculBilling = new CalculBillingDay();
              Summary summary=calculBilling.calculSummary(dayTravel);
              new InOutJsonValidateFiles().writeInputFile(fileOutPut,summary);

       }
    }

}