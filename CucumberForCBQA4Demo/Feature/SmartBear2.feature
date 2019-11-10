Feature: Automate CMSe Application
@regression
Scenario Outline: Prepaid Card Pin Change	
When Click cards and pin link
When Click update
When Enter new PIN "<ReenterPIN>"
When Re enter new pin "<newPIN>"
When Click update pin submit 
Then Validate PIN Change

Examples:
|newPIN|ReenterPIN|
|1234|1234|

@regression
Scenario Outline: Card Information update
When Click Card information link
When Click Card info update link
When Update address "<updateaddress1>"
When Click Card info Continue buuton
When Click Card info Submit Button 
When Validate the Card info update

Examples:
|updateaddress1|
|123 Main Street|



