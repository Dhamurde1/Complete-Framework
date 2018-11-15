package com.ticketit.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ticketit.qa.base.TestBase;
import com.ticketit.qa.pages.DepartmentPage;
import com.ticketit.qa.pages.HomePage;
import com.ticketit.qa.pages.LoginPage;
import com.ticketit.qa.testutil.TestUtil;

public class DepartmentTest extends TestBase

{

	LoginPage loginpage;

	HomePage homepage;

	DepartmentPage departmentpage;

	String sheetName = "Department";

	public DepartmentTest()

	{
	super();
    }

	@BeforeClass()
	public void setUp()

	{

    initialization();

    departmentpage = new DepartmentPage();
    loginpage = new LoginPage();
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	homepage.clickOnAdminLink();
	homepage.clickonDepartmentLink();

	}

	@Test(priority = 1)

	public void verifyDepartmentPageLabelTest()

	{

	Assert.assertTrue(departmentpage.verfiyDepartmentPageLabel(), "DepartmenT Page Level Missing");

	}

	@Test(priority = 2)
	public void clickOnDeptTest()

	{

		departmentpage.clickOnAddDepartmentButton();

	}

	@DataProvider
	public Object[][] getTicketItTestData() {
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;

	}

	@Test(priority = 3, dataProvider = "getTicketItTestData")
	public void validateCreateNewDepartment(String DepartmentName, String Sla, String ShortCode,String DepartmentDescription) {

		departmentpage.createNewDepartment(DepartmentName, (int) Double.parseDouble(Sla), ShortCode,
		DepartmentDescription);
	}

	
	@Test(priority = 4)
	public void validateAddedDepartment() throws InterruptedException {
	String text = departmentpage.verifyAddedDepartment();
	Assert.assertEquals(text, "Development");
	}

	@AfterClass()

	public void tearDown() {

	}

}
