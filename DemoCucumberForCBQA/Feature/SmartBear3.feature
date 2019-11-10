Feature: Automate CMSe Application
Scenario Outline: Product ID Creation and Linking to Card Number
When Click product id tab  
When Enter instituion id in product id search  "<ProdINSId>"
When Click Add product id
When Enter the name of product id  "<NewProdName>"
When Enter the product id description "<NewProdIdDesc>"
When Click Continue button in add product id page 
When Click Service Charge link
When Click Network transaction
When Click ATM Deposit
When Click No value added in Deposit ONUS
When Enter the Deposit ONUS SVC Fee  "<ONUSSVCFee>"
When Click Plus symbol in Deposit ONUS
When Click No value added in Deposit Foreign
When Enter the Deposit Foreign SVC Fee  "<ForeignSVCFee>"
When Click Plus symbol in Deposit Foreign
When Click Continue button in Add Product ID Page
When Click Submit button in Review Product id page
Then Validate the product id creation is success

Examples:
|ProdINSId|NewProdName|NewProdIdDesc|ONUSSVCFee|ForeignSVCFee|
|00548|prod47|prod47|2.00|3.00|
