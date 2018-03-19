
package finalprojectB;

import junit.framework.TestCase;
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
	   UrlValidator urlVal = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   //Test on a few examples we know should be true
	   assertTrue(urlVal.isValid("http://www.google.com"));
	   assertTrue(urlVal.isValid("http://oregonstate.instructure.com"));
	   assertTrue(urlVal.isValid("http://oregonstate.instructure.com/myfile"));
	   assertTrue(urlVal.isValid("http://oregonstate.instructure.com/myFile?action=view"));
	   assertTrue(urlVal.isValid("http://sdjfkahfjashd.jdskjf32424/ajsdfkakj?asjdf=2"));
	   assertTrue(urlVal.isValid("http://ksdjflkj.dsf/ksd"));
	   assertTrue(urlVal.isValid("http://www.startfitness.co.uk/"));
	   
	   //Test examples we know should be false
	   assertFalse(urlVal.isValid(""));
	   assertFalse(urlVal.isValid(" "));
	   assertFalse(urlVal.isValid("http://oregonstate.instru:cture.com/myFile?action=view"));
	   assertFalse(urlVal.isValid(null));
	   assertFalse(urlVal.isValid("sfjkdflksjf"));
	  //assertFalse(urlVal.isValid("http://"));
	   assertFalse(urlVal.isValid("http/oregonstate.instructure.com"));	   	   
	  
	   //Test with different schemes
	   String[] schemes = {"https","ftp"};
	   UrlValidator urlValScheme = new UrlValidator(schemes,0);
	   
	   assertFalse(urlValScheme.isValid("http://orego:nstate.instructure.com"));
	   assertFalse(urlValScheme.isValid("http:/dksfklajdfal.eduudkl"));
	   
	//   assertTrue(urlValScheme.isValid("ftp://oregonstate.instructure.com"));
	 //  assertTrue(urlValScheme.isValid("https://google.com"));
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	
	 //Partitioning into 
	 UrlValidator urlVal = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
	 
	 String test_scheme1 = "http://";
	 String test_scheme2 = "https://";
	 String test_scheme3 = "ftp://";
	 String test_scheme4 = "h3t://";
	 String test_scheme_incorrect = ":/";
	 
	 String test_authority1 = "myWebsite.isCool.org";
	 String test_port1 = "";
	 String test_path1 = "/#/my_file";
	 String test_query1 = "?action=edit";
	 String empty_string = "";
	 String null_string = null;
	 
	 //Create strings with empty strings in each of the componenets of the url
	 String test_url1 = test_scheme1 + test_authority1 +test_port1+test_path1+test_query1;
	 String test_url2 = empty_string +test_authority1 +test_port1+test_path1+test_query1;
	 String test_url3 = test_scheme3 + test_authority1 +test_port1+test_path1+test_query1;
	 String test_url4 = test_scheme4 + test_authority1 +test_port1+test_path1+test_query1;
	 String test_url5 = test_scheme_incorrect + test_authority1 +test_port1+test_path1+test_query1;
	 
	 String test_url6 = test_scheme1 + test_authority1 + test_port1 + test_path1 + empty_string;
	 String test_url7 = test_scheme2 + empty_string + empty_string + test_port1 + test_path1 + test_query1;
	 String test_url8 = test_scheme3 + test_authority1 + empty_string + test_path1 + test_query1;
	 String test_url9 = test_scheme4 + test_authority1 +test_port1 + empty_string +empty_string;
	 String test_url10 = test_scheme_incorrect + test_authority1 + test_port1 + test_path1 + empty_string;
	 String test_url11= empty_string + empty_string + empty_string + empty_string + empty_string +empty_string;

	 assertTrue(urlVal.isValid(test_url1));
	 assertFalse(urlVal.isValid(test_url2));
	// assertTrue(urlVal.isValid(test_url3));
//	 assertTrue(urlVal.isValid(test_url4));
	 assertFalse(urlVal.isValid(test_url5));
	 assertTrue(urlVal.isValid(test_url6));
//	 assertFalse(urlVal.isValid(test_url7));
//	 assertTrue(urlVal.isValid(test_url8));
//	 assertTrue(urlVal.isValid(test_url9));
	 assertFalse(urlVal.isValid(test_url10));	
	 assertFalse(urlVal.isValid(test_url11));	
	 
	 assertFalse(urlVal.isValid(null_string));
	 String test_url12 = null_string + test_authority1 + test_port1 + test_path1 + empty_string;
	 String test_url13 = test_scheme1 + null_string + empty_string + test_port1 + test_path1 + test_query1;
	 String test_url14= test_scheme1 + test_authority1 + null_string+ test_path1 + test_query1;
	 String test_url15 = test_scheme1 + test_authority1 +test_port1 + null_string;
	 String test_url16 = test_scheme1 + test_authority1 + test_port1 + test_path1 + null_string;
	 assertFalse(urlVal.isValid(test_url12));	
	 assertTrue(urlVal.isValid(test_url13));
	 assertTrue(urlVal.isValid(test_url14));	
	 assertTrue(urlVal.isValid(test_url15));	
	 assertTrue(urlVal.isValid(test_url16));	
	 	 
	 
	 
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	  
	   UrlValidator urlVal = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
	   String test_scheme1 = "http://";
	   String test_authority1 = "myWebsite.isCool.org";
	   String test_port1 = "";
	   String test_path1 = "/#/my_file";
	   String test_query1 = "?action=edit";
	   String empty_string = "";
	   
	   String test_authority2 = "0.0.0.0";
	   String test_authority3 = ".555.5.1343";
	   String test_authority4 = ".ba\\\b///ab";
	   String test_authority5 = "co.uk";
	   
	   String test_url1 = test_scheme1 + test_authority1 + test_port1 + test_path1 + test_query1;
	   String test_url2 = test_scheme1 + test_authority2 + test_port1 + test_path1 + test_query1;
	   String test_url3 = test_scheme1 + test_authority3 + test_port1 + test_path1 + test_query1;
	   String test_url4 = test_scheme1 + test_authority4 + test_port1 + test_path1 + test_query1;
	   String test_url5 = test_scheme1 + test_authority5 + test_port1 + test_path1 + test_query1;
	   
	   assertTrue(urlVal.isValid(test_url1));
	   assertTrue(urlVal.isValid(test_url2));
	   assertTrue(urlVal.isValid(test_url3));
	   assertFalse(urlVal.isValid(test_url4));
	   assertTrue(urlVal.isValid(test_url5));
   }
   //You need to create more test cases for your Partitions if you need to 
   public void testYourThirdPartition(){
	   UrlValidator urlVal = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
	   String test_scheme1 = "http://";
	   String test_authority1 = "myWebsite.isCool.org";
	   String test_port1 = "";
	   String test_path1 = "/#/my_file";
	   String test_query1 = "?action=edit";
	   
	   String test_path2 = "/0.0.0.0";
	   String test_path3 = "/thisFile.jpg";
	   String test_path4 = "//_af/as";
	   String test_path5 = "/asdafcc/";
	   
	   String test_url1 = test_scheme1 + test_authority1 + test_port1 + test_path1 + test_query1;
	   String test_url2 = test_scheme1 + test_authority1 + test_port1 + test_path2 + test_query1;
	   String test_url3 = test_scheme1 + test_authority1 + test_port1 + test_path3 + test_query1;
	   String test_url4 = test_scheme1 + test_authority1 + test_port1 + test_path4 + test_query1;
	   String test_url5 = test_scheme1 + test_authority1 + test_port1 + test_path5 + test_query1;
	   
	   assertTrue(urlVal.isValid(test_url1));
	   assertTrue(urlVal.isValid(test_url2));
	   assertTrue(urlVal.isValid(test_url3));
	   assertFalse(urlVal.isValid(test_url4));
	   assertFalse(urlVal.isValid(test_url5));
	   
   }
   
   public void testYourFourthPartition(){
	   UrlValidator urlVal = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
	   String test_scheme1 = "http://";
	   String test_authority1 = "myWebsite.isCool.org";
	   String test_port1 = "";
	   String test_path1 = "/my_file";
	   String test_query1 = "?action=edit";
	   
	   String test_query2 = "";
	   String test_query3 = "./?=\t\n\n\n";
	   String test_query4 = "page?myName=Mason&myGroupMember=Ayush";
	   String test_query5 = "-./?=";
	   
	   String test_url1 = test_scheme1 + test_authority1 + test_port1 + test_path1 + test_query1;
	   String test_url2 = test_scheme1 + test_authority1 + test_port1 + test_path1 + test_query2;
	   String test_url3 = test_scheme1 + test_authority1 + test_port1 + test_path1 + test_query3;
	   String test_url4 = test_scheme1 + test_authority1 + test_port1 + test_path1 + test_query4;
	   String test_url5 = test_scheme1 + test_authority1 + test_port1 + test_path1 + test_query5;
	   
	   assertTrue(urlVal.isValid(test_url1));
	   assertTrue(urlVal.isValid(test_url2));
	   assertFalse(urlVal.isValid(test_url3));
	   assertTrue(urlVal.isValid(test_url4));
	   assertFalse(urlVal.isValid(test_url5));
   }
   
   public void testIsValid()
   {
	   String [] schemes = {"http"};
	   UrlValidator urlVal = new UrlValidator(schemes,0);
	   Random random = new Random();
	   char[] characters = {
				' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.',
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	   };
	   for(int j = 0; j < 1000; j++) {
		   String to_test = "";
		   String [] correctSchemes = {"http://"};
		   String [] incorrectSchemes = {"http/:::/", "adjkfafajd://","   "};
		   Boolean expect = false;
		   Boolean path = false;
		   int random_length;
		   String my_random_string;
		   
		   //Add a correct or incorrect scheme
		   if(random.nextBoolean()) {
			   to_test = incorrectSchemes[random.nextInt(incorrectSchemes.length)];
			   expect = false;
		   }else {
			   to_test = correctSchemes[random.nextInt(correctSchemes.length)];
			   expect = true;
		   }
		   
		   // Randomly make an authority for the url
		   random_length = random.nextInt(15);
		   my_random_string = "";
		   for(int i = 0; i < random_length; i++) {
			   my_random_string += characters[random.nextInt(characters.length)];
		   }
		   to_test += my_random_string;
		   if(to_test.contains(" ") || !to_test.contains(".")) {
			   expect = false;
		   }
		   
		   // Randomly add a path to the url
		   random_length = random.nextInt(7);
		   my_random_string = "";
		   for(int i = 0; i < random_length; i++) {
			   my_random_string += characters[random.nextInt(characters.length)];
		   }
		   if(random.nextBoolean()) {
			   to_test += "/"+my_random_string;
			   path = true;
		   } 
		   if(my_random_string.contains(" ")) {
			   expect = false;
		   }
		   
		   //Randomly create a query
		   if(path) {
			   random_length = random.nextInt(7);
			   my_random_string = "";
			   String q = "";
			   for(int i = 0; i < random_length; i++) {
				   my_random_string += characters[random.nextInt(characters.length)];
			   }
			   if(random.nextBoolean()) {
				   q += "?"+my_random_string;
				   random_length = random.nextInt(7);
				   my_random_string = "";
				   for(int i = 0; i < random_length; i++) {
					   my_random_string += characters[random.nextInt(characters.length)];
				   }
				   if(random.nextBoolean()) {
					   q += "=" + my_random_string;
				   }
				   if(my_random_string.contains(" ") ) {
					   expect = false;
				   }	
			   }  
		   to_test += q;
		   }
		   
		   Boolean result = urlVal.isValid(to_test);
		   System.out.println(to_test + "\t" + expect + "\t" + result);
		   assertFalse(result);
		
		   
	   	}
   }	
}

   


