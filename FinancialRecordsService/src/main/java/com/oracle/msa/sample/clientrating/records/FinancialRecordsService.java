package com.oracle.msa.sample.clientrating.records;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/records")
public class FinancialRecordsService {
//    @Autowired
//    private FinancialRecordsProxy financialRecords;

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public String getHistoryRating(@PathVariable("customerId") Integer customerId) {
        //return financialRecords.getHistoryRating(customerId).name();
        return FinancialHistoryRating.values()[(int)Math.floor(Math.random() * FinancialHistoryRating.values().length)].name();
    }
}
