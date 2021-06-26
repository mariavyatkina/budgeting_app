package org.perscholas.budgeting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*TransactionCategory class represents user entity in the application's database 
with instance fields corresponding to columns of the table in the database*/
@Entity
public class TransactionCategory {
	/* instance fields of TransactionCategory class that correspond to columns in transactionCategory table 
	 * with appropriate validation annotation*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	private String categoryName;
	private String categoryType;
	
	/* constructors */
	public TransactionCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionCategory(int categoryId, String categoryName, String categoryType) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.setCategoryType(categoryType);
	}
	
	/* getters and setters */
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	
	/*
	 * hashcode() and equals() methods overriding
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((categoryType == null) ? 0 : categoryType.hashCode());
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
		TransactionCategory other = (TransactionCategory) obj;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (categoryType == null) {
			if (other.categoryType != null)
				return false;
		} else if (!categoryType.equals(other.categoryType))
			return false;
		return true;
	}
	
	/*
	 * toString() method overriding
	 */
	@Override
	public String toString() {
		return "TransactionCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryType="
				+ categoryType + "]";
	}
	
	
	
	
	
	

}
