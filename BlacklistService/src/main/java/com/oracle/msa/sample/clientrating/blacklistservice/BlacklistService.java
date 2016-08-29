package com.oracle.msa.sample.clientrating.blacklistservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blacklist")
public class BlacklistService {
	@Autowired
    private BlacklistBean blacklistBean;

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public String getCustomerStatus(@PathVariable("customerId") Integer customerId) {
        return blacklistBean.getCustomerStatus(customerId).name();
    }
}
