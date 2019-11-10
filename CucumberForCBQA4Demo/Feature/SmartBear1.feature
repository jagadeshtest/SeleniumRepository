Feature: Automate CMSe Application
@sanity
Scenario Outline: Login Page
Given Open the browser
When Navigate into the CMSe application "<url>"
When Enter username  "<username>"
When Enter password  "<password>"
When Click Login
Then Validate Login Page

Examples:
|url|username|password|
|http://vlcapweb03.fisdev.local:12143/main/cmse/Home|W951fsx|Jaga$903|

@sanity
Scenario Outline: Open Card
When Enter Institution ID  "<InsID>"
When Click Open Card
When Click Prefix number
When Click Generate Card
When Enter Name   "<name>"
When Enter Address "<address>"
When Enter City  "<city>"
When Enter State "<state>"
When Enter ZIP  "<zip>"
When Enter Offset "<offset>"
When Click continue button
When Click finalContinue button
When Click submitFinal
Then Get the card number

Examples:
|InsID|name|address|city|state|zip|offset|
|00548|Roger Stanly|First Street|Milwaukee|WI|12345|1234|


@regression
Scenario: Search Card
When Click Search Button

Scenario Outline: Card Status change
When Click Neg File/Status
When Click Active Check box
When Select Do not add in Exception File Update Code "<Exception File Update Code>"
When Select Do not honor in Exception File Action Code "<Exception File Action Code>"
When Enter Card status change submit

Examples:
|Exception File Update Code|Exception File Action Code|
|Do Not Add|Do Not Honor|

Scenario Outline: Add Fund
When Click Add Fund
When Enter Amount "<amount>"
When Click Add Fund Submit Button 
Then Validate the add fund

Examples:
|amount|
|1000.00|

@regression
Scenario Outline: Card to card transfer
When Click cardtocard transfer
When Enter Transfer Amount "<transferamount>"
#When Click radio button
When Enter funding card number "<fundingcard>"
When click ctoc Submit
Then Validate card to card transfer

Examples:
|transferamount|fundingcard|
|5.00|1002000000009916|