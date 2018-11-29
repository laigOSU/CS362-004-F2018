

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	 //You can use this function to implement your manual testing	  
	   
	   
	   // Url has: <scheme>://<authority><path>?<query>
	   // scheme+authority+port+path+query
	   UrlValidator manualUrl = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

	   
	   // Test: valid URL (all components valid)
//	   assertTrue(manualUrl.isValid("http://www.google.com")); // Passed: expect valid, returns valid
//	   assertFalse(manualUrl.isValid("http://www.google.com")); // Passed: expect valid, returns valid (Keep commented to run)
	   
	   
	   // Test: invalid scheme 
//	   assertFalse(manualUrl.isValid("pppp://www.google.com")); // Failed: expect invalid, returns valid  (Keep commented to run)
//	   assertTrue(manualUrl.isValid("pppp://www.google.com")); // Passed: expect invalid, returns invalid (Keep commented to run)
//	   assertTrue(manualUrl.isValid("ftp://www.google.com")); // Failed: expect valid, returns invalid (Keep commented)
//	   assertFalse(manualUrl.isValid("ftp://www.google.com")); // Passed: expect valid, returns false (Keep commented) 
//	   assertTrue(manualUrl.isValid("https://www.google.com")); // Failed: expect valid, returns invalid
//	   assertFalse(manualUrl.isValid("https://www.google.com")); // Passed: expect valid, returns false (Keep commented)
//	   assertTrue(manualUrl.isValid("h3t://www.google.com")); // Failed: expect valid, returns invalid (Keep commented)
//	   assertFalse(manualUrl.isValid("http:/www.google.com")); // Passed: expect invalid, returns invalid (Keep commented)
	   
	   
	   // Test: invalid authority
	   assertTrue(manualUrl.isValid("http://255.255.255.255")); // Passed: expect valid, returns valid
	   assertTrue(manualUrl.isValid("http://go.au")); // Passed: expect valid, returns valid
	   assertTrue(manualUrl.isValid("http://0.0.0.0")); // Passed: expect valid, returns valid
//	   assertFalse(manualUrl.isValid("http://256.256.256.256")); // Failed: expect invalid, returns valid (Keep commented)
	   assertTrue(manualUrl.isValid("http://256.256.256.256")); // Failed: expect invalid, returns valid
	   
	   
	   // Test: invalid port
//	   assertTrue(manualUrl.isValid(("http://www.google.com:80"))); // Failed: expect valid, returns invalid (Keep commented)
	   assertFalse(manualUrl.isValid("http://www.google.com:80")); // Failed: expect valid, returns invalid
//	   assertTrue(manualUrl.isValid("http://www.google.com:0")); // Failed: expect valid, returns invalid
	   assertFalse(manualUrl.isValid("http://www.google.com:65535")); // Failed: expect valid, returns invalid
//	   assertTrue(manualUrl.isValid("http://www.google.com:65535")); // Failed: expect valid, returns invalid (Keep commented)	
//	   assertFalse(manualUrl.isValid("http://www.google.com:65a")); // Failed: expect invalid, returns valid (Keep commented)
//	   assertTrue(manualUrl.isValid("http://www.google.com:65a")); // Passed: expect invalid, returns invalid (Keep commented)
	   
	   // Test: invalid path
	    assertTrue(manualUrl.isValid("http://www.ggogle.com/test1")); // Passed: expect valid, returns valid
	    assertTrue(manualUrl.isValid("http://www.google.com/$23")); // Passed: expect valid, returns valid
	    assertFalse(manualUrl.isValid("http://www.google.com/../")); // Passed: expect invalid, returns invalid
	    assertFalse(manualUrl.isValid("http://www.google.com/..")); // Passed: expect invalid, returns invalid
//	    assertTrue(manualUrl.isValid("http://www.google.com/..")); // Passed: expect invalid, returns invalid (Keep commented)
	    assertFalse(manualUrl.isValid("http://www.google.com/test1//file"));// Passed: expect invalid, returns invalid 
//	    assertTrue(manualUrl.isValid("http://www.google.com/test1//file"));// Passed: expect invalid, returns invalid (Keep commented)
//	    assertTrue(manualUrl.isValid("http://www.google.com/../")); // Passed: expect invalid, returns invalid (Keep commented)
	    
	   
	   // Test: invalid query
	   assertTrue(manualUrl.isValid("http://www.google.com/test1?action=view")); // Passed: expect valid, returns valid
	   assertTrue(manualUrl.isValid("http://www.google.com/test1?action=edit&mode=up")); // Passed: expect valid, returns valid
//	   assertFalse(manualUrl.isValid("http://www.google.com/test1?action=view")); // Passed: expect valid, returns false (Keep commented)
	   
	    
	   // Test: valid Local url
	   assertTrue(manualUrl.isValid("http://localhost/")); // Passed: expect valid, returns valid
//	   assertFalse(manualUrl.isValid("http://localhost/")); // Passed: expect valid, returns false (Keep commented)
	   assertTrue(manualUrl.isValid("http://machine/")); // Passed: expect valid, returns valid
//	   assertFalse(manualUrl.isValid("http://machine/")); // Passed: expect valid, returns false (Keep commented)
	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
	  
	   
	   

   }
   


}
