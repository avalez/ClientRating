package com.oracle.msa.sample.clientrating.ratingservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
@FeignClient(
    name = "records",
    //url = "${recordsServiceBaseURL}",
    fallback=FinancialRecordsServiceFallback.class)
public interface FinancialRecordsServiceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/records/{customerId}")
    String getRating(@PathVariable("customerId") Integer customerId);
}
