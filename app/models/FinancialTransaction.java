package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class FinancialTransaction extends Model {
	public static enum TYPE {
		INCOME,
		EXPENSE
	};
	public Date date;
	public String reason;
	public TYPE type;
	public double value;
	
	public FinancialTransaction(Date date, String reason, TYPE type,
			double value) {
		super();
		this.date = date;
		this.reason = reason;
		this.type = type;
		this.value = value;
	}	
	
	public boolean equals(Object o) {
		FinancialTransaction ft =  (FinancialTransaction) o;
		if(!ft.date.equals(this.date)) 
			return false;
		if(!ft.reason.equals(this.reason))
			return false;
		if(!ft.type.equals(this.type))
			return false;
		if(ft.value != this.value)
			return false;

		return true;
	}
	
	
    
}
