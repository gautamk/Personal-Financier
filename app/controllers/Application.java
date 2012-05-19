package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void transactions(){
    	Calendar date = Calendar.getInstance();
		date.set(2012, Calendar.MAY, 18);
		List<FinancialTransaction> transactions = FinancialTransaction.getByDate(date);
		renderJSON(transactions);
    }

}