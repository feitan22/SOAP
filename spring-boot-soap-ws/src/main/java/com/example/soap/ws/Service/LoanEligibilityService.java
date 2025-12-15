package com.example.soap.ws.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.soap.ws.loaneligibility.Acknowledgement;
import com.example.soap.ws.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {

    public Acknowledgement checkLoanEligibility(CustomerRequest request) {
        
        Acknowledgement acknowledgement = new Acknowledgement();
        List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();
        
        // --- Début de la logique de vérification ---
        
        // 1. Vérification de l'âge
        if (!(request.getAge() > 30 && request.getAge() <= 60)) { 
            mismatchCriteriaList.add("Person age should in between 30 to 60");
        } 
        
        // 2. Vérification du revenu
        if (!(request.getYearlyIncome() > 200000)) { 
            mismatchCriteriaList.add("minimum income should be more than 200000");
        }
        
        // 3. Vérification du score CIBIL
        if (!(request.getCibilScore() > 500)) { 
            mismatchCriteriaList.add("Low CIBIL Score please try after 6 month");
        }
        
        // --- Détermination de l'éligibilité ---
        if (mismatchCriteriaList.isEmpty()) { // Utilisez isEmpty() ou size() > 0
            acknowledgement.setApprovedAmount(500000);
            acknowledgement.setIsEligible(true);
            mismatchCriteriaList.clear(); // Optionnel si déjà vide, mais maintient la logique
        } else {
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        }
        
        return acknowledgement;  
    } 
}

