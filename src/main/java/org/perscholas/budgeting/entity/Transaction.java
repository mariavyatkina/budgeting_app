package org.perscholas.budgeting.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/*Transaction class represents user entity in the application's database 
with instance fields corresponding to columns of the table in the database*/
@Entity
@Table(name="transaction")
public class Transaction {
	
	/* instance fields of Transaction class that correspond to columns in user table 
	 * with appropriate validation annotation*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	@NotNull(message="Enter the amount")
	@Min(value =(long) 0.01, message="The amount has to be greater than 0.01")
	private double amount;
	private String description;
	@NotNull(message="Enter the date of transaction")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfTransaction;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateAdded;
	@ManyToOne(cascade=CascadeType.ALL)
	private TransactionCategory category;
	
	/*
	 * constructors
	 */	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
		this.dateAdded = java.time.LocalDate.now();
	}
	
	
	public Transaction(int transactionId, double amount, String description, LocalDate dateOfTransaction,
			TransactionCategory category) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.description = description;
		this.dateOfTransaction = dateOfTransaction;
		this.category = category;
		this.dateAdded = java.time.LocalDate.now();
		
	}

	/*
	 * getters and setters
	 */	
	public int getTransactionId() {
		return transactionId;
	}
	public void settransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}


	public TransactionCategory getCategory() {
		return category;
	}


	public void setCategory(TransactionCategory category) {
		this.category = category;
	}
	

	public LocalDate getDateAdded() {
		return dateAdded;
	}


	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	/* hashcode() and equals() methods overriding */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result + ((dateOfTransaction == null) ? 0 : dateOfTransaction.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + transactionId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (dateOfTransaction == null) {
			if (other.dateOfTransaction != null)
				return false;
		} else if (!dateOfTransaction.equals(other.dateOfTransaction))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}

	/*
	 * toString() method overriding
	 */	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", description=" + description
				+ ", dateOfTransaction=" + dateOfTransaction + ", dateAdded=" + dateAdded + ", category=" + category
				+ "]";
	}


	
	

}
