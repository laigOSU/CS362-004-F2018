import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Random;
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
	   assertTrue(manualUrl.isValid("http://www.google.com")); // Passed: expect valid, returns valid
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
//	   assertTrue(manualUrl.isValid("http://www.google.com:0")); // Failed: expect valid, returns invalid (Keep commented)
	   assertFalse(manualUrl.isValid("http://www.google.com:65535")); // Failed: expect valid, returns invalid
//	   assertTrue(manualUrl.isValid("http://www.google.com:65535")); // Failed: expect valid, returns invalid (Keep commented)	
//	   assertFalse(manualUrl.isValid("http://www.google.com:65a")); // Failed: expect invalid/false, returns not false (Keep commented)
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
//	   assertFalse(manualUrl.isValid("http://www.google.com/test1?action=view")); // Passed: expect valid/true, returns not false (Keep commented)
	   
	    
	   // Test: valid Local url
	   assertTrue(manualUrl.isValid("http://localhost/")); // Passed: expect valid, returns valid
//	   assertFalse(manualUrl.isValid("http://localhost/")); // Passed: expect valid/true, returns not false (Keep commented)
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
	   System.out.println("Programming Based Testing");
	   //Using the testIsValid method from URLValidatorCorrect as a template
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   //Using dynamic array that I learned and used as template from here
	   //https://www.geeksforgeeks.org/arraylist-in-java/
	   ArrayList <String> isValidArray = new ArrayList<String>();
	   ArrayList <String> isInValidArray = new ArrayList<String>();
	   ArrayList <String> errorArray = new ArrayList<String>();
	   String[] urlSchemeTrue = {"", "http://", "ftp://", "https://"};
	   String[] urlSchemeFalse = {"....", "http:\\", "ftp:\\", ":"};
	   String[] urlAuthorityTrue = {"www.github.com", "hackerrank.com", "www.twitter.com", "youtube.com"};
	   String[] urlAuthorityFalse = {"---.co", "*/dfs", "-google.com", "-999youtube.com"};
	   String[] urlPortTrue = {":3000", ":8080", ":9999", ":0"};
	   String[] urlPortFalse = {":3000000000", ":-9999", "-2", ":1a"};
	   String[] urlPathTrue = {"/lol", "/maps/@37.3346993,-121.8828223,16z", "/cs362-004", "/test"};
	   String[] urlPathFalse = {"//maps", ".maps", "/maps//gmail", "/...................../"};
	   int upperbound, lowerbound, passed, failed, errorFailed;
	   upperbound = 4;
	   lowerbound = 0;
	   passed = 0;
	   failed = 0;
	   errorFailed = 0;

	   System.out.println("Now testing correct urls");
	   System.out.println("-------------------------------------------------------------------");
	   //Now building and testing urls that are correct
	   for (int index = 0; index < 50; index++)
	   {
		   Random r = new Random();
		   boolean result;
		   //using this to use randomally index array
		   //https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#nextInt--
		   String urlBuilder = urlSchemeTrue[r.nextInt(upperbound-lowerbound) + lowerbound] + urlAuthorityTrue[r.nextInt(upperbound-lowerbound) + lowerbound] +
			urlPortTrue[r.nextInt(upperbound-lowerbound) + lowerbound] + urlPathTrue[r.nextInt(upperbound-lowerbound) + lowerbound];
		   try 
		   {
			   result = urlVal.isValid(urlBuilder);
			   if (result == true)
			   {
				   passed++;
				   isValidArray.add(urlBuilder);
			   }
			   else
			   {
				   failed++;
				   isInValidArray.add(urlBuilder);
			   }
		   }
		   catch (Error err)
		   {
			   errorFailed++;
			   errorArray.add(urlBuilder);
		   }

	   }
	   System.out.println("Test that passed: " + passed);
	   System.out.println("-------------------------------------------------------------------");
	   for (int index = 0; index < isValidArray.size(); index++)
	   {
		   System.out.println(isValidArray.get(index));
	   }
	   System.out.println("-------------------------------------------------------------------");
	   System.out.println("Test that failed: " + failed);
	   System.out.println("-------------------------------------------------------------------");
	   for (int index = 0; index < isInValidArray.size(); index++)
	   {
		   System.out.println(isInValidArray.get(index));
	   }
	   System.out.println("-------------------------------------------------------------------");
	   System.out.println("Test that had error thrown: " + errorFailed);
	   System.out.println("-------------------------------------------------------------------");
	   for (int index = 0; index < errorArray.size(); index++)
	   {
		   System.out.println(errorArray.get(index));
	   }
	   
	   passed = 0;
	   failed = 0;
	   errorFailed = 0;
	   isValidArray.clear();
	   isInValidArray.clear();
	   errorArray.clear();
	   System.out.println("-------------------------------------------------------------------");
	   System.out.println("Now testing totally incorrect urls");
	   System.out.println("-------------------------------------------------------------------");
	   //Now building and testing urls that have every part be incorrect
	   for (int index = 0; index < 50; index++)
	   {
		   Random r = new Random();
		   boolean result;
		   String urlBuilder = urlSchemeFalse[r.nextInt(upperbound-lowerbound) + lowerbound] + urlAuthorityFalse[r.nextInt(upperbound-lowerbound) + lowerbound] +
			urlPortFalse[r.nextInt(upperbound-lowerbound) + lowerbound] + urlPathFalse[r.nextInt(upperbound-lowerbound) + lowerbound];
		   try 
		   {
			   result = urlVal.isValid(urlBuilder);
			   if (result == false)
			   {
				   passed++;
				   isValidArray.add(urlBuilder);
			   }
			   else
			   {
				   failed++;
				   isInValidArray.add(urlBuilder);
			   }
		   }
		   catch (Error err)
		   {
			   errorFailed++;
			   errorArray.add(urlBuilder);
		   }

	   }
	   System.out.println("Test that passed: " + passed);
	   System.out.println("-------------------------------------------------------------------");
	   for (int index = 0; index < isValidArray.size(); index++)
	   {
		   System.out.println(isValidArray.get(index));
	   }
	   System.out.println("-------------------------------------------------------------------");
	   System.out.println("Test that failed: " + failed);
	   System.out.println("-------------------------------------------------------------------");
	   for (int index = 0; index < isInValidArray.size(); index++)
	   {
		   System.out.println(isInValidArray.get(index));
	   }
	   System.out.println("-------------------------------------------------------------------");
	   System.out.println("Test that had error thrown: " + errorFailed);
	   System.out.println("-------------------------------------------------------------------");
	   for (int index = 0; index < errorArray.size(); index++)
	   {
		   System.out.println(errorArray.get(index));
	   }
	   passed = 0;
	   failed = 0;
	   errorFailed = 0;
	   isValidArray.clear();
	   isInValidArray.clear();
	   errorArray.clear();
	   System.out.println("-------------------------------------------------------------------");
	   System.out.println("Now testing urls that only have incorrect scheme");
	   System.out.println("-------------------------------------------------------------------");
	   //Now building and testing urls that are correct
	   for (int index = 0; index < 50; index++)
	   {
		   Random r = new Random();
		   boolean result;
		   //using this to use randomally index array
		   //https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#nextInt--
		   String urlBuilder = urlSchemeFalse[r.nextInt(upperbound-lowerbound) + lowerbound] + urlAuthorityTrue[r.nextInt(upperbound-lowerbound) + lowerbound] +
			urlPortTrue[r.nextInt(upperbound-lowerbound) + lowerbound] + urlPathTrue[r.nextInt(upperbound-lowerbound) + lowerbound];
		   try 
		   {
			   result = urlVal.isValid(urlBuilder);
			   if (result == false)
			   {
				   passed++;
				   isValidArray.add(urlBuilder);
			   }
			   else
			   {
				   failed++;
				   isInValidArray.add(urlBuilder);
			   }
		   }
		   catch (Error err)
		   {
			   errorFailed++;
			   errorArray.add(urlBuilder);
		   }

	   }
	   System.out.println("Test that passed: " + passed);
	   System.out.println("-------------------------------------------------------------------");
	   for (int index = 0; index < isValidArray.size(); index++)
	   {
		   System.out.println(isValidArray.get(index));
	   }
	   System.out.println("-------------------------------------------------------------------");
	   System.out.println("Test that failed: " + failed);
	   System.out.println("-------------------------------------------------------------------");
	   for (int index = 0; index < isInValidArray.size(); index++)
	   {
		   System.out.println(isInValidArray.get(index));
	   }
	   System.out.println("-------------------------------------------------------------------");
	   System.out.println("Test that had error thrown: " + errorFailed);
	   System.out.println("-------------------------------------------------------------------");
	   for (int index = 0; index < errorArray.size(); index++)
	   {
		   System.out.println(errorArray.get(index));
	   }
	   
	   passed = 0;
	   failed = 0;
	   errorFailed = 0;
	   isValidArray.clear();
	   isInValidArray.clear();
	   errorArray.clear();
	   System.out.println("-------------------------------------------------------------------");
	   System.out.println("Now testing urls that only have correct scheme but everything else false");
	   System.out.println("-------------------------------------------------------------------");
	   //Now building and testing urls that are correct
	   for (int index = 0; index < 50; index++)
	   {
		   Random r = new Random();
		   boolean result;
		   //using this to use randomally index array
		   //https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#nextInt--
		   String urlBuilder = urlSchemeTrue[r.nextInt(upperbound-lowerbound) + lowerbound] + urlAuthorityFalse[r.nextInt(upperbound-lowerbound) + lowerbound] +
			urlPortFalse[r.nextInt(upperbound-lowerbound) + lowerbound] + urlPathFalse[r.nextInt(upperbound-lowerbound) + lowerbound];
		   try 
		   {
			   result = urlVal.isValid(urlBuilder);
			   if (result == false)
			   {
				   passed++;
				   isValidArray.add(urlBuilder);
			   }
			   else
			   {
				   failed++;
				   isInValidArray.add(urlBuilder);
			   }
		   }
		   catch (Error err)
		   {
			   errorFailed++;
			   errorArray.add(urlBuilder);
		   }

	   }
	   System.out.println("Test that passed: " + passed);
	   System.out.println("-------------------------------------------------------------------");
	   for (int index = 0; index < isValidArray.size(); index++)
	   {
		   System.out.println(isValidArray.get(index));
	   }
	   System.out.println("-------------------------------------------------------------------");
	   System.out.println("Test that failed: " + failed);
	   System.out.println("-------------------------------------------------------------------");
	   for (int index = 0; index < isInValidArray.size(); index++)
	   {
		   System.out.println(isInValidArray.get(index));
	   }
	   System.out.println("-------------------------------------------------------------------");
	   System.out.println("Test that had error thrown: " + errorFailed);
	   System.out.println("-------------------------------------------------------------------");
	   for (int index = 0; index < errorArray.size(); index++)
	   {
		   System.out.println(errorArray.get(index));
	   }
   }
   


}