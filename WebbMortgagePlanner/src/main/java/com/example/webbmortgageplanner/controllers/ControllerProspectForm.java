package com.example.webbmortgageplanner.controllers;

import com.example.webbmortgageplanner.models.Prospect;
import com.example.webbmortgageplanner.mortgageplanning.MortgageModel;
import com.example.webbmortgageplanner.repositories.ProspectRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerProspectForm {

    @Autowired
    private ProspectRepo prospectRepo;

    /**
     * Method to create a new prospect based on data from the user input.
     * The method will validate the user input, and either send the user to an error-page
     * or save the prospect object to the db. Then it will redirect to the index page.
     * */

    @PostMapping("/prospect")
    public String createProspect(@Valid Prospect prospect, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "add-prospect";
        }

        if(!inputValidator(prospect)){

            System.out.println("New prospect: invalid input");
            return "error";

        }

      MortgageModel mortgageModel = new MortgageModel(prospect.getInterest(),
                prospect.getTotalLoan(), prospect.getYears());
        prospect.setMonthlyPayment(mortgageModel.calculateMortgageFormula());

        prospectRepo.save(prospect);

        System.out.println("New prospect added");
        return "redirect:/";
    }

    /**
     * Method for displaying the add prospect html file.
     * */

    @GetMapping("/create-prospect")
    public String showProspectcreateForm(Prospect prospect){

        System.out.println("Opening add-prospect html-page");
        return "add-prospect";
    }


    /**
    * Method for deleting all content in the db.
     * Will then redirect user to the index page.
    * */

    @GetMapping("/deleteAll")
    public String deleteAll(Model model){

        prospectRepo.deleteAll();
       return "redirect:/";
    }

    /**
    * Method to validate the input.
     * The name-field should not be empty, and the total loan, interest and years
     * should be greater than zero.
     *
    * */

    public boolean inputValidator(Prospect prospect){

        if(prospect.getName().isEmpty()){
            return false;
        }else if(!(prospect.getTotalLoan() >0) ||
        !(prospect.getYears() >0) ||
        !(prospect.getInterest() >0)){
            return false;
        }
        return true;
    }
}