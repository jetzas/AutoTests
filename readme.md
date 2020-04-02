To  install project 
1. add new project  from  Git 
2. If project didn`t set as  maven  project  add it
3. Reimport all dependency 



Frameworks  exist 
 1. Report
 2. Ui
    1. AllListeners (TestNg  listener)
    2. Events (All methods  fore  js wait and  debug reports)
    3. Initial Driver (Create all drivers for run tests)
    3. Selenium Element (Exist all elements to write UI tests)
 3. Web

Frameworks has two reports
One report id for Debug Extent Report
Allure report for customer or manager

Test writes in by two steps
First is part of test write in source page Folder Pages
Ex:

    public class Pages{
    public static final By locator = By.id("id");
    new Fields field= new Fields();
    public void action(String text)
    {
        field.type(locator,text)
    }
Test  write in folder test
Ex:

    public class TestClass extends Listener {
	@Test
	public void testMethods(){
	    Pages page= new Pages();
	    page.action("TEST");
	}
To Generate Allure Report on local machine type in CMD
**allure serve**


Or  you can  type mvn allure:serve  in Idea terminal

    
2. To parallel :
    methods set parallel="methods" -parallel all  methods in class
    methods set parallel="classes"-parallel all  class in class
    methods set parallel="tests"-parallel all  tests in class
    methods set parallel="true"-parallel all 
    
3. To set thread 
 Set  <test name="google" parallel="methods" thread-count="5">
  
  
Settings  for project:
    All Settings exist in **resources**
Default settings  for auto test exist in GF_autoSettings:
   1.  browser.driver=CHROME
   2.  driver.version=2.46
   3.  element.wait=30
   4.  element.poling=250
   5.  element.exist=3
To set users data to data.properties
 all data in  Base 

	public static Setring yourSettings = Long.parseLong(new PropertiesRead().getPropValues("yourData","data.properties"));
