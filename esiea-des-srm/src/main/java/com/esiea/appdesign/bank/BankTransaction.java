package com.esiea.appdesign.bank;

import java.util.Date;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BankTransaction {
	long idclient;
	String firstname;
	String lastname;
	Date birthday;
	String telephone;
	String transactionid;
	int amount;
	String banksource;
	Date transactdate;
		 
	
	
	public static BankTransaction jsonTransactionToObject(String payload) {

		 BankTransaction    bankTransaction = new BankTransaction  ();
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
		true);
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		try {
		 bankTransaction = objectMapper.readValue(payload, BankTransaction.class);
		 //bankTransaction.getFirstname();
		}catch(Exception e) {
			//--
			 e.printStackTrace();
		}
		return bankTransaction;
	}
	
	public long getIdclient() {
		return idclient;
	}


	public void setIdclient(long idclient) {
		this.idclient = idclient;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getTransactionid() {
		return transactionid;
	}


	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getBanksource() {
		return banksource;
	}


	public void setBanksource(String banksource) {
		this.banksource = banksource;
	}


	public Date getTransactdate() {
		return transactdate;
	}


	public void setTransactdate(Date transactdate) {
		this.transactdate = transactdate;
	}

}
