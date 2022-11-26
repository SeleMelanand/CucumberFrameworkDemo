Feature: Login Functionality for LambdaTest Allpication 

Background: 
	Given Launch the url and Navigate to login Page 
	
@positive 
Scenario: Login to LambdaTest and validate login is success (positive testcase) 
	Then Enter valid Username 
	And Select login button 

@negative1 @common 
Scenario: Login to LambdaTest and validate login is success (negative1testcase) 
	Then  Enter valid Username 
	And  Select login button 
	
@Basetest 
Scenario: Login to LambdaTest and validate login is success (positive testcase) 
	Given  Launch the url and Navigate to login Page 
	Then  Enter valid Username as 'sampletest001@gmail.com' 
	And  Enter Password as "Qwerty@0000" 
	And  Select login button 
	Then  Validate login is success 
	
@Basetest 
Scenario: Login to Invalid LambdaTest and validate error message (Negativetestcase) 
	Given  Launch the url and Navigate to login Page 
	Then  Enter valid Username as 'sampletest001@gmail.com' 
	And  Enter Password as 'sdasdasd@0000' 
	And  Select login button 
	Then  Validate proper error message is getting displayed or not 
	
@negative2 @common 
Scenario: Login to LambdaTest and validate login is success (negative2 testcase) 
	Then  Enter valid Username 
	And  Select login button 
	
	
@endtoend
Scenario Outline: Login and validate login sing multiple set of testdata (negative testcase)
	And Enter valid Username as <username>
	And Enter Password as <password>
	Then Select login button

Examples:
|username|password|
|'sampletest001@gmail.com'|'Qwerty@0000'|
|'sampletest001@gmail.com'|'sdasdasd@0000'|




