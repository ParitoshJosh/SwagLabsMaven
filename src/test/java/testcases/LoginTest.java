package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void PositiveLogin() throws FilloException {

		Recordset recordset = connection.executeQuery("select * from data where TestName='PositiveTest'");
		recordset.next();

		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");

		LoginPage loginObj = new LoginPage(driver);
		loginObj.LoginFunction(UserName, Password);
		
		String ActUrl = driver.getCurrentUrl();
		String ExpUrl = "https://www.saucedemo.com/inventory.html";
	
		Assert.assertEquals(ActUrl, ExpUrl);

	}
	
	@Test
	public void NegativeLogin() throws FilloException, InterruptedException {

		Thread.sleep(10000);
		Recordset recordset = connection.executeQuery("select * from data where TestName='NegativeTest'");
		recordset.next();

		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.LoginFunction(UserName, Password);
	
		
		String ActErr = loginObj.getErrorMsg();
		System.out.println("error message is : "+ ActErr);
		String ExpErr = recordset.getField("ErrorMsg");
	
		Assert.assertEquals(ActErr, ExpErr);

	}
}
