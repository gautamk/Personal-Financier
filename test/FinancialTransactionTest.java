import models.FinancialTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.test.UnitTest;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * 
 */

/**
 * @author gautam
 *
 */
public class FinancialTransactionTest extends UnitTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Calendar date = Calendar.getInstance();
		FinancialTransaction ff ;
		Random rnd = new Random();
		for(int i=0;i<50;i++) {
			ff = new FinancialTransaction(date, "Reason "+ FinancialTransaction.TYPE.INCOME, FinancialTransaction.TYPE.INCOME,rnd.nextDouble() );
			ff.save();
			ff = new FinancialTransaction(date, "Reason "+ FinancialTransaction.TYPE.EXPENSE, FinancialTransaction.TYPE.EXPENSE,rnd.nextDouble() );
			ff.save();
			date.add(Calendar.DATE, -1);
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		FinancialTransaction.deleteAll();
	}


	public void newTransaction() {
		FinancialTransaction ff =new FinancialTransaction(Calendar.getInstance(),"Some Reason",FinancialTransaction.TYPE.INCOME,55.34);
		ff.save();
		FinancialTransaction retrieved = FinancialTransaction.find("byId", ff.id).first();
		assertNotNull(retrieved);
		assertTrue(ff.equals(retrieved));
		ff.delete();
	}
	
	@Test
	public void getByDate() {
		Calendar date = Calendar.getInstance();
		date.set(2012, Calendar.MAY, 18);
		
		date.clear(Calendar.HOUR);
		date.clear(Calendar.HOUR_OF_DAY);
		date.clear(Calendar.MINUTE);
		date.clear(Calendar.SECOND);
		date.clear(Calendar.MILLISECOND);
		
		List<FinancialTransaction> transactions = FinancialTransaction.getByDate(date);
		for(FinancialTransaction transaction: transactions) {
			assertEquals(date.get(Calendar.YEAR), transaction.date.get(Calendar.YEAR));
			assertEquals(date.get(Calendar.MONTH), transaction.date.get(Calendar.MONTH));
			assertEquals(date.get(Calendar.DATE), transaction.date.get(Calendar.DATE));
			
		}
	}

}
