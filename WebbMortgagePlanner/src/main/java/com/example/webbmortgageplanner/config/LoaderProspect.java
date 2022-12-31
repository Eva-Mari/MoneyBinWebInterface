package com.example.webbmortgageplanner.config;


import com.example.webbmortgageplanner.models.Prospect;
import com.example.webbmortgageplanner.mortgageplanning.FileHandler;
import com.example.webbmortgageplanner.mortgageplanning.MortgageModel;
import com.example.webbmortgageplanner.repositories.ProspectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoaderProspect implements CommandLineRunner {

    @Autowired
    ProspectRepo prospectRepo;

    @Override
    public void run(String... args) throws Exception {

        loadData();

    }

    /**
    * Method to load data. If the database is empty, the data will be fetched
     * from the prospects.txt file. Based on this info, prospect/customer objects will be created
     * and saved to the database.
    * */

    public void loadData(){

        FileHandler fileHandler = new FileHandler("prospects.txt");
        List<String> result = fileHandler.readFromFile();
        List<Prospect> customers = fileHandler.createCustomerList(result);

        if(prospectRepo.count()== 0){


            System.out.println("No prospects in repo found, fetching from prospects file");

            for(Prospect prospect:customers){

                MortgageModel mortgageModel = new MortgageModel(prospect.getInterest(),
                        prospect.getTotalLoan(),
                        prospect.getYears());

                prospect.setMonthlyPayment(mortgageModel.calculateMortgageFormula());
                prospectRepo.save(prospect);


                System.out.println("added prospect: "+ prospect.toString());
            }

        }
        System.out.println("Current number of prospects: "+ prospectRepo.count());


    }
}
