@quotePre
Feature: Quote Predefined

  Background: open the url
    Given I open url "https://skryabin.com/market/quote.html"
    Then I should see page title as "Get a Quote"

  @quotePre1
  Scenario:  Responsive UI behavior validation
    #PC
    When I maximize window
    Then element with xpath "//b[@id='location']" should be displayed
    And element with xpath "//b[@id='currentDate']" should be displayed
    And element with xpath "//b[@id='currentTime']" should be displayed
    #ipad mini
    When I resize window to 768 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    And element with xpath "//b[@id='currentDate']" should be displayed
    And element with xpath "//b[@id='currentTime']" should be displayed
    #iphone12
    When I resize window to 390 and 844
    Then element with xpath "//b[@id='location']" should not be displayed
    And element with xpath "//b[@id='currentDate']" should not be displayed
    And element with xpath "//b[@id='currentTime']" should not be displayed

  @quotePre2
  Scenario: smoke test for required fields
    #Name
    When I click on element with xpath "//input[@id='name']"
    And I type "Jessie" into element with xpath "//input[@id='firstName']"
    And I type "M" into element with xpath "//input[@id='middleName']"
    And I type "Smith" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    #Username
    When I type "Jessie" into element with xpath "//input[@name='username']"
    #Email
    When I type "jessie@gmail.com" into element with xpath "//input[@name='email']"
    #Password and Confirm Password
    When I type "abcde123" into element with xpath "//input[@id='password']"
    And  I type "abcde123" into element with xpath "//input[@id='confirmPassword']"
    #Check Privacy Policy
    When  I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    #Submit
    When I click on element with xpath "//button[@id='formSubmit']"
    #Assertion, page direct to result page
    Then I wait for element with xpath "//div[@id='quotePageResult']" to be present

  @quotePre3
  Scenario: error massages validation for required fields
    #Submit
    When I click on element with xpath "//button[@id='formSubmit']"
    #Assertion
    Then element with xpath "//label[@id='name-error']" should have text as "This field is required."
    And element with xpath "//label[@id='username-error']" should have text as "This field is required."
    And element with xpath "//label[@id='email-error']" should have text as "This field is required."
    And element with xpath "//label[@id='password-error']" should have text as "This field is required."
    And element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should contain text "Must check!"

  @quotePre4
  Scenario: Option fields validation
    #Country Of Origin
    When I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//option[contains(text(),'United States of America')]"
    #Address
    When I type "1995 Don Ave, Santa Clara, CA" into element with xpath "//textarea[@id='address']"
    #3rd part agreement
    When I click on element with xpath "//button[@id='thirdPartyButton']"
    Then I accept alert
    #Phone Number
    When I type "4080001234" into element with xpath "//input[@name='phone']"
    #Date of Birth (input directly)
    When I type "01/01/2000" into element with xpath "//input[@id='dateOfBirth']"
    #Gender
    When I click on element with xpath "//input[contains(@value,'male')]"
    #Car Make
    When I click on element with xpath "//option[contains(text(),'Ford')]"
    #Allow to contact
    When I click on element with xpath "//input[@name='allowedToContact']"
    #Additional Information
    When I switch to iframe with xpath "//iframe[@name='additionalInfo']"
    And I type "Kiki" into element with xpath "//input[@id='contactPersonName']"
    And I type "4081111234" into element with xpath "//input[@id='contactPersonPhone']"
    And I switch to default content

  @quotePre5
  Scenario: Data verification after submission
    #Name
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "Jessie" into element with xpath "//input[@id='firstName']"
    And I type "M" into element with xpath "//input[@id='middleName']"
    And I type "Smith" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    #Username
    When I type "Jessie" into element with xpath "//input[@name='username']"
    #Email
    When I type "jessie@gmail.com" into element with xpath "//input[@name='email']"
    #Password and Confirm Password
    When  I type "abcde123" into element with xpath "//input[@id='password']"
    And  I type "abcde123" into element with xpath "//input[@id='confirmPassword']"
    #Accept Privacy Policy
    When  I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    #Country Of Origin
    When I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//option[contains(text(),'United States of America')]"
    #Address
    When I type "1995 Don Ave, Santa Clara, CA" into element with xpath "//textarea[@id='address']"
    #Phone Number
    When I type "4080001234" into element with xpath "//input[@name='phone']"
    #Date of Birth (input directly)
    When I type "01/01/2000" into element with xpath "//input[@id='dateOfBirth']"
    #Gender
    When I click on element with xpath "//input[contains(@value,'male')]"
    #Car Make
    When I click on element with xpath "//option[contains(text(),'Ford')]"
    #Allow to contact
    When I click on element with xpath "//input[@name='allowedToContact']"
    #Additional Information
    When I switch to iframe with xpath "//iframe[@name='additionalInfo']"
    And I type "Kiki" into element with xpath "//input[@id='contactPersonName']"
    And I type "4081111234" into element with xpath "//input[@id='contactPersonPhone']"
    And I switch to default content
    #Submit
    When I click on element with xpath "//button[@id='formSubmit']"
    And I wait for 1 sec
    #Assertion
    Then I wait for element with xpath "//div[@id='quotePageResult']" to be present
    #Name
    Then element with xpath "//b[@name='firstName']" should have text as "Jessie"
    And element with xpath "//b[@name='middleName']" should have text as "M"
    And element with xpath "//b[@name='lastName']" should have text as "Smith"
    And element with xpath "//b[@name='name']" should have text as "Jessie M Smith"
    #Username
    Then element with xpath "//b[@name='username']" should have text as "Jessie"
    #Email
    Then element with xpath "//b[@name='email']" should have text as "jessie@gmail.com"
    #Password encryption
    Then element with xpath "//b[@name='password']" should have text as "[entered]"
    #Agree Privacy Policy
    Then element with xpath "//b[@name='agreedToPrivacyPolicy']" should have text as "true"
    #Country Of Origin
    Then element with xpath "//b[@name='countryOfOrigin']" should have text as "USA"
    #Address
    Then element with xpath "//b[@name='address']" should have text as "1995 Don Ave, Santa Clara, CA"
    #Phone
    Then element with xpath "//b[@name='phone']" should have text as "4080001234"
    #Date Of Birth
    Then element with xpath "//b[@name='dateOfBirth']" should have text as "01/01/2000"
    #Gender
    Then element with xpath "//b[@name='gender']" should have text as "male"
    #Car Make
    Then element with xpath "//b[@name='carMake']" should have text as "Ford"
    #Allow To Contact
    Then element with xpath "//b[@name='allowedToContact']" should have text as "true"
    #Contact Information
    Then element with xpath "//b[@name='contactPersonName']" should have text as "Kiki"
    And element with xpath "//b[@name='contactPersonPhone']" should have text as "4081111234"

  @quotePre6
  Scenario: Name validation
    #First Name field can be empty
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "M" into element with xpath "//input[@id='middleName']"
    And I type "Smith" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "M Smith"
    And I clear element with xpath "//input[@id='name']"
    #Middle Name field can be empty
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "Jessie" into element with xpath "//input[@id='firstName']"
    And I type "Smith" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Jessie Smith"
    And I clear element with xpath "//input[@id='name']"
    #Last Name field can be empty
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "Jessie" into element with xpath "//input[@id='firstName']"
    And I type "M" into element with xpath "//input[@id='middleName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Jessie M"

  @quotePre7
  Scenario:Username length validation
    #Username field length less than 2, error message validation
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//input[@id='password']"
    Then element with xpath "//label[@id='username-error']" should contain text "Please enter at least 2 characters."
    And I clear element with xpath "//input[@name='username']"
    #Username field length equal 2, no error message validation
    When I type "ab" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//input[@id='password']"
    Then element with xpath "//label[@id='username-error']" should not be displayed
    And I clear element with xpath "//input[@name='username']"
    #Username field length greater than  2, no error message validation
    When I type "abc" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//input[@id='password']"
    Then element with xpath "//label[@id='username-error']" should not be displayed

  @quotePre8
  Scenario: Email format validation
    #Email Address does not have domain, error message validation
    When I type "abc" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//input[@id='password']"
    Then element with xpath "//label[@id='email-error']" should contain text "Please enter a valid email address."
    And I clear element with xpath "//input[@name='email']"
    #Email Address does not have full domain, error message validation
    When I type "abc@" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//input[@id='password']"
    Then element with xpath "//label[@id='email-error']" should contain text "Please enter a valid email address."
    And I clear element with xpath "//input[@name='email']"
    #HERE IS A BUG
    #When I type "abc@de" into element with xpath "//input[@name='email']"
    #And I click on element with xpath "//input[@id='password']"
    #Then element with xpath "//label[@id='email-error']" should contain text "Please enter a valid email address."
    #And I clear element with xpath "//input[@name='email']"
    When I type "abc@de." into element with xpath "//input[@name='email']"
    And I click on element with xpath "//input[@id='password']"
    Then element with xpath "//label[@id='email-error']" should contain text "Please enter a valid email address."
    And I clear element with xpath "//input[@name='email']"
    #Email Address has prefix and domain, no error message validation
    When I type "abc@de.com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//input[@id='password']"
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @quotePre9
  Scenario: Password length validation
    #Password length less than 5 characters,error message validation
    # 1 character
    When I type "a" into element with xpath "//input[@id='password']"
    And I click on element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='password-error']" should have text as "Please enter at least 5 characters."
    And I clear element with xpath "//input[@id='password']"
    # 4 characters
    When I type "abcd" into element with xpath "//input[@id='password']"
    And I click on element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='password-error']" should have text as "Please enter at least 5 characters."
    And I clear element with xpath "//input[@id='password']"
    #Password length equals and greater than 5 characters, no error message validation
    # 5 characters
    When I type "abcde" into element with xpath "//input[@id='password']"
    And I click on element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='password-error']" should not be displayed
    And I clear element with xpath "//input[@id='password']"
    # 6 characters
    When I type "abcdef" into element with xpath "//input[@id='password']"
    And I click on element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='password-error']" should not be displayed

  @quotePre10
  Scenario: ConfirmPassword validation
    #Confim Password default disabled validation
    Then element with xpath "//input[@id='confirmPassword']" should be disabled
    #Enter Password, Confirm Password enabled validation
    When  I type "abcde" into element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled
    #Confirm Password mismatch Password, error message validation
    When  I type "abcdf" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='confirmPassword-error']" should have text as "Passwords do not match!"
    And I clear element with xpath "//input[@id='confirmPassword']"
    #Confirm Password length validation
    # 1 character
    When I type "a" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='confirmPassword-error']" should have text as "Please enter at least 5 characters."
    And I clear element with xpath "//input[@id='confirmPassword']"
    # 4 character
    When I type "abcd" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='confirmPassword-error']" should have text as "Please enter at least 5 characters."
    And I clear element with xpath "//input[@id='confirmPassword']"
    # 5 character
    When I type "abcde" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='confirmPassword-error']" should not be displayed

  @quotePre11
  Scenario: File Upload/Download functionality validation
    #Choose file
    When I upload "/Users/kurt/IdeaProjects/java-webdriver-cucumber/src/test/resources/support/test.txt" to element with xpath "//input[@id='attachment']"
    Then element with xpath "//input[@id='attachment']" should have attribute "value" as "C:\fakepath\test.txt"
    #Download
    When I click on element with xpath "//a[contains(@download,'Documents.pdf')]"
    And I wait for 2 sec
    Then I wait to download file "Documents.pdf" is on download directory
    And I delete file "Documents.pdf" on download directory

  @quotePre12
  Scenario: Text validation
    #Save Location,Date,Time text on home page
    When I save key is element with "//div[@id='quotePageForm']//span[text()='Location']" and text of element with xpath "//b[@id='location']"
    And I save key is element with "//span[text()='Date']" and text of element with xpath "//b[@id='currentDate']"
    And I save key is element with "//span[text()='Time']" and text of element with xpath "//b[@id='currentTime']"
    #Finish required fields
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "aa" into element with xpath "//input[@id='firstName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    And I type "ab" into element with xpath "//input[@name='username']"
    And I type "abc@de.com" into element with xpath "//input[@name='email']"
    And  I type "abcde" into element with xpath "//input[@id='password']"
    And  I type "abcde" into element with xpath "//input[@id='confirmPassword']"
    And  I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    And I wait for 1 sec
    #Assertion
    Then I wait for element with xpath "//div[@id='quotePageResult']" to be present
    And text which key is "Location" is same as text of element with xpath "//b[@name='location']"
    And text which key is "Date" is same as text of element with xpath "//b[@name='currentDate']"
    And text which key is "Time" is same as text of element with xpath "//b[@name='currentTime']"
    And I clear properties content

  @quotePre13
  Scenario: Document functionality validation
    #Related documents
    When I click on element with xpath "//button[contains(text(),'Related documents (click)')]"
    Then I switch to new window
    And I wait for 1 sec
    Then I should see page title as "Documents Page"
    And element with xpath "//h4[contains(text(),'Documents List:')]" should be displayed
    When I switch to base window and close current window
    And I wait for 1 sec
    #View documents
    When I click on element with xpath "//a[@id='link']"
    Then I switch to new window
    And I wait for 1 sec
    Then I should see page title as "Documents Page"
    And element with xpath "//h4[contains(text(),'Documents List:')]" should be displayed

  @quotePre14
  Scenario: Date of Birth date picker validation
    #Date picker is displayed
    When I click on element with xpath "//input[@id='dateOfBirth']"
    Then I wait for element with xpath "//div[@id='ui-datepicker-div']" to be present
    #Check previous and next button
    When I click on element with xpath "//span[contains(text(),'Prev')]"
    Then element with xpath "//select[@class='ui-datepicker-month']/option[@selected='selected']" should contain text "Sep"
    When I click on element with xpath "//span[contains(text(),'Next')]"
    Then element with xpath "//select[@class='ui-datepicker-month']/option[@selected='selected']" should contain text "Oct"
    #Choose month
    When I click on element with xpath "//select[@class='ui-datepicker-month']"
    And I click on element with xpath "//option[text()='Jan']"
    #Choose year
    When I click on element with xpath "//select[@class='ui-datepicker-year']"
    And I click on element with xpath "//option[text()='1990']"
    #Choose day
    And I click on element with xpath "//a[text()='1']"
    And I wait for 1 sec
    #Assertion
    #Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "01/01/1990"
    Then element with xpath "//b[@name='dateOfBirth'][contains(text(),'01/01/1990')]" should be present

  @quotePre15
  Scenario: Accepting Privacy Policy Validation
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should contain text "Must check!"
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not contain text "Must check!"

  @quotePre16
  Scenario: Reset Button Validation
    #Finish form
    #Name
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "Jessie" into element with xpath "//input[@id='firstName']"
    And I type "M" into element with xpath "//input[@id='middleName']"
    And I type "Smith" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    #Username
    When I type "Jessie" into element with xpath "//input[@name='username']"
    #Email
    When I type "jessie@gmail.com" into element with xpath "//input[@name='email']"
    #Password and Confirm Password
    When  I type "abcde123" into element with xpath "//input[@id='password']"
    And  I type "abcde123" into element with xpath "//input[@id='confirmPassword']"
    #Accept Privacy Policy
    When  I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    #Country Of Origin
    When I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//option[contains(text(),'United States of America')]"
    #Address
    When I type "1995 Don Ave, Santa Clara, CA" into element with xpath "//textarea[@id='address']"
    #Phone Number
    When I type "4080001234" into element with xpath "//input[@name='phone']"
    #Date of Birth (input directly)
    When I type "01/01/2000" into element with xpath "//input[@id='dateOfBirth']"
    #Gender
    When I click on element with xpath "//input[contains(@value,'male')]"
    #Car Make
    When I click on element with xpath "//option[contains(text(),'Ford')]"
    #Allow to contact
    When I click on element with xpath "//input[@name='allowedToContact']"
    #Additional Information
    When I switch to iframe with xpath "//iframe[@name='additionalInfo']"
    And I type "Kiki" into element with xpath "//input[@id='contactPersonName']"
    And I type "4081111234" into element with xpath "//input[@id='contactPersonPhone']"
    And I switch to default content
    #Reset
    When I click on element with xpath "//button[@id='formReset']"
    #Assertion
    #Name is persisted
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Jessie M Smith"
    #Contact Person Name and Contact Person Phone are persisted
    When I switch to iframe with xpath "//iframe[@name='additionalInfo']"
    Then element with xpath "//input[@id='contactPersonName']" should have attribute "value" as "Kiki"
    And element with xpath "//input[@id='contactPersonPhone']" should have attribute "value" as "4081111234"
    And I switch to default content
    #Others back to default
    #Username
    Then element with xpath "//input[@name='username']" should have attribute "value" as ""
    #Email
    And element with xpath "//input[@name='email']" should have attribute "value" as ""
    #Password and Confirm Password
    And element with xpath "//input[@id='password']" should have attribute "value" as ""
    And element with xpath "//input[@id='confirmPassword']" should have attribute "value" as ""
    #Phone Number
    And element with xpath "//input[@name='phone']" should have attribute "value" as ""
    #Date Of Birth
    And element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as ""
    #Country of Origin
    And element with xpath "//select[@name='countryOfOrigin']/option[contains(text(),'Please Select...')]" should be present
    #Gender
    #Then element with xpath "//input[@name='gender'][@value='male']" should not be selected
    #And element with xpath "//input[@name='gender'][@value='female']" should not be selected
    And element with xpath "//input[@name='gender']" should not be selected
    #Allow To Contact
    And element with xpath "//input[@name='allowedToContact']" should not be selected
    #Addrees
    And element with xpath "//textarea[@id='address']" should have attribute "value" as ""
    #Car Make
    And element with xpath "//select[@name='carMake']" should not be selected
    #Accept Privacy Policy
    And element with xpath "//input[@name='agreedToPrivacyPolicy']" should not be selected

  @quotePre17
  Scenario: Refresh Button Validation
    #Finish form
    #Name
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "Jessie" into element with xpath "//input[@id='firstName']"
    And I type "M" into element with xpath "//input[@id='middleName']"
    And I type "Smith" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    #Username
    When I type "Jessie" into element with xpath "//input[@name='username']"
    #Email
    When I type "jessie@gmail.com" into element with xpath "//input[@name='email']"
    #Password and Confirm Password
    When  I type "abcde123" into element with xpath "//input[@id='password']"
    And  I type "abcde123" into element with xpath "//input[@id='confirmPassword']"
    #Accept Privacy Policy
    When  I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    #Country Of Origin
    When I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//option[contains(text(),'United States of America')]"
    #Address
    When I type "1995 Don Ave, Santa Clara, CA" into element with xpath "//textarea[@id='address']"
    #Phone Number
    When I type "4080001234" into element with xpath "//input[@name='phone']"
    #Date of Birth (input directly)
    When I type "01/01/2000" into element with xpath "//input[@id='dateOfBirth']"
    #Gender
    When I click on element with xpath "//input[contains(@value,'male')]"
    #Car Make
    When I click on element with xpath "//option[contains(text(),'Ford')]"
    #Allow to contact
    When I click on element with xpath "//input[@name='allowedToContact']"
    #Additional Information
    When I switch to iframe with xpath "//iframe[@name='additionalInfo']"
    And I type "Kiki" into element with xpath "//input[@id='contactPersonName']"
    And I type "4081111234" into element with xpath "//input[@id='contactPersonPhone']"
    And I switch to default content
    #Refresh
    When I click on element with xpath "//button[@id='formRefresh']"
    #Assertion back to default
    #Name 
    Then element with xpath "//input[@id='name']" should have attribute "value" as ""
    #Username
    Then element with xpath "//input[@name='username']" should have attribute "value" as ""
    #Email
    And element with xpath "//input[@name='email']" should have attribute "value" as ""
    #Password and Confirm Password
    And element with xpath "//input[@id='password']" should have attribute "value" as ""
    And element with xpath "//input[@id='confirmPassword']" should have attribute "value" as ""
    #Phone Number
    And element with xpath "//input[@name='phone']" should have attribute "value" as ""
    #Date Of Birth
    And element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as ""
    #Country of Origin
    And element with xpath "//select[@name='countryOfOrigin']/option[contains(text(),'Please Select...')]" should be present
    #Gender
    #Then element with xpath "//input[@name='gender'][@value='male']" should not be selected
    #And element with xpath "//input[@name='gender'][@value='female']" should not be selected
    And element with xpath "//input[@name='gender']" should not be selected
    #Allow To Contact
    And element with xpath "//input[@name='allowedToContact']" should not be selected
    #Addrees
    And element with xpath "//textarea[@id='address']" should have attribute "value" as ""
    #Car Make
    And element with xpath "//select[@name='carMake']" should not be selected
    #Contact Person Name and Contact Person Phone are persisted
    When I switch to iframe with xpath "//iframe[@name='additionalInfo']"
    Then element with xpath "//input[@id='contactPersonName']" should have attribute "value" as ""
    And element with xpath "//input[@id='contactPersonPhone']" should have attribute "value" as ""
    And I switch to default content
    #Accept Privacy Policy
    And element with xpath "//input[@name='agreedToPrivacyPolicy']" should not be selected

  @quotePre18
  Scenario: back button on result page validation
    #Name
    When I click on element with xpath "//input[@id='name']"
    And I type "Jessie" into element with xpath "//input[@id='firstName']"
    And I type "M" into element with xpath "//input[@id='middleName']"
    And I type "Smith" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    #Username
    When I type "Jessie" into element with xpath "//input[@name='username']"
    #Email
    When I type "jessie@gmail.com" into element with xpath "//input[@name='email']"
    #Password and Confirm Password
    When I type "abcde123" into element with xpath "//input[@id='password']"
    And  I type "abcde123" into element with xpath "//input[@id='confirmPassword']"
    #Check Privacy Policy
    When  I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    #Submit
    When I click on element with xpath "//button[@id='formSubmit']"
    Then I wait for element with xpath "//div[@id='quotePageResult']" to be present
    #Return
    When I click on element with xpath "//button[@id='return']"
    #Assertion
    Then I should see page title as "Get a Quote"











      





