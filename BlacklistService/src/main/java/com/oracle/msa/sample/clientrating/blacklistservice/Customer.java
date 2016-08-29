package com.oracle.msa.sample.clientrating.blacklistservice;

import javax.persistence.*;

@Entity
@NamedQuery(name = "getCustomer", query = "select c from Customer c where c.id = :customerId")
public class Customer {
    public static enum Status {BLACKLISTED, WHITELISTED}

    @Id
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Integer getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public Customer(Integer id, Status status) {
		this.id = id;
		this.status = status;
    }

    Customer() { // jpa only
    	
    }
}