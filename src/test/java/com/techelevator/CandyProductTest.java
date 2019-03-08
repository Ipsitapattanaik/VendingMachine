package com.techelevator;

	import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyProductTest {
	
	CandyProduct newproduct; 
	
	@Before
	public void setup() {
		newproduct = new CandyProduct(); 
	}
	
	@After
	public void teardown() {
		System.out.println("teardown");
	}
	
	@Test
	public void test_get_and_set_names() {
		newproduct.setName("fido");
		Assert.assertEquals("fido", newproduct.getName().trim()); 
		
	}
	
	@Test
	public void test_get_and_set_price() {
		newproduct.setPrice(10.00);
		Assert.assertEquals(10.00, newproduct.getPrice() , 0.0001d);
		
	}
	
	@Test
	public void test_purchase_when_quantity_greater_than_zero() {
		newproduct.purchase();
		Assert.assertEquals(4, newproduct.getQuantity());
	
	}
	
	@Test
	public void test_purchase_when_quantity_less_than_zero() {
		newproduct.purchase();
		newproduct.purchase();
		newproduct.purchase();
		newproduct.purchase();
		newproduct.purchase();
		newproduct.purchase();
		Assert.assertEquals(0, newproduct.getQuantity());
	
	}
	
}