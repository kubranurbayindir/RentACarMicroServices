package com.appsdeveloperblog.rentacar.users.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "corporate_customer")
@PrimaryKeyJoinColumn(name = "customer_id")
public class CorporateCustomer  extends Customer{
	
	@Column(name = "tax_number",unique = true)
	private String taxNumber;
	
	@Column(name = "company_name")
	private String companyName;

}
