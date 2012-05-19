package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class FinancialTransaction extends Model {
	public static enum TYPE {
		INCOME,EXPENSE;
		@Override 
		public String toString() {
			   //only capitalize the first letter
			   String s = super.toString();
			   return s.substring(0, 1) + s.substring(1).toLowerCase();
		 }

	};
	@Temporal(TemporalType.DATE)
	public Calendar date;
	@Required
	public String reason;
	@Required
	public TYPE type;
	@Required
	public double value;
	/**
	 * @param date
	 * @param reason
	 * @param type
	 * @param value
	 */
	public FinancialTransaction(Calendar date, String reason, TYPE type,
			double value) {
		super();
		this.date = date;
		this.reason = reason;
		this.type = type;
		this.value = value;
	}
	
	
	
	public static List<FinancialTransaction> getByDate(final Calendar date) {
		JPAQuery jpaq = FinancialTransaction.find("date=?", date);
		List<FinancialTransaction>lst = jpaq.fetch();
		return lst;
	}
	
	
	
	@Override
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
	
	public String toString() {
		return this.type+" by "+this.reason+" on " +this.date.getTime()+" of "+this.value;
	}
	
    
}
