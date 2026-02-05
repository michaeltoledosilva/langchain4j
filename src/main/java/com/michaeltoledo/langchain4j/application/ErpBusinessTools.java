package com.michaeltoledo.langchain4j.application;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class ErpBusinessTools {

    @Tool("Calcula multa por atraso de pagamento de título financeiro")
    public String calculateLateFee(int daysLate) {

        double dailyRate = 2.5; // exemplo ERP
        double total = daysLate * dailyRate;

        return "Multa calculada: R$ " + total + " para " + daysLate + " dias de atraso.";
    }
}
