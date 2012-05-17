import static org.junit.Assert.*;

import java.util.Date;

import models.FinancialTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;

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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void newTransaction() {
		FinancialTransaction ff =new FinancialTransaction(new Date(),"Some Reason",FinancialTransaction.TYPE.INCOME,55.34);
		ff.save();
		FinancialTransaction retrieved = FinancialTransaction.find("byDate", ff.date).first();
		assertNotNull(retrieved);
		assertTrue(ff.equals(retrieved));
				
	}

}
