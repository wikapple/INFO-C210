Name: Java Bank Management System
Course: INFO-C210 Project
Last Updated: 11/30/2021
Author: William Applegate

*********************************************************************************************************************************************************************************************

Description: 
  BankManagementSystem is a java programming project designed to simulate a banking computer system. It uses the terminal to communicate with the user. 

*********************************************************************************************************************************************************************************************

Installation: 
  BankManagement System requires the Java Development Kit, and imports from standard Java libraries. No additional .Jar files or file paths are required. BankManagement system was created and tested in the Eclipse IDE, though it should run the same in other environments.

*********************************************************************************************************************************************************************************************

Usage:
  Program runs in the terminal only. The program begins with welcome output and asks user to press enter to continue to the main menu. The main menu will open with the press of the enter key in order to more easily separate and understand tasks in the terminal. The menu gives the user options to create, destroy, and view accounts. it also allows the user to add withdraws and deposits, apply monthly adjustments, and to recieve general bank statistics. There is currently no read or write capabilities to this program, so the account list will be empty upon starting the program each time. Once the user is finished, they can end the main menu by pressing '0' and the program will end. 

*********************************************************************************************************************************************************************************************

Design Notes:

  bankmanagementsystem Package:
    All .java files for this project are contained in the bankmanagementsystem package.

  Account.java:
    Abstract class that provides a baseline for the CheckingAccount, GoldAccount and RegularAccount to extend from. Account balances are made using the BigDecimal class. This is to provide decimal point precision without the floating point precision issues that double would have provided. In order to maintain the most accuracy possible, the balance is never rounded aside from what BigDecimal 32-bit integer scale will round. The toString output of balance rounds what the user reads to the second deciaml place to replicate dollars and cents. All Accounts have a composition relationship with AccountLedger.java, as they are contained within AccountLedger objects. 

  CheckingAccount.java, GoldAccount.java and RegularAccount.java:
    All three classes extend from Account.java. They are designed to meet their individual requirements outlines in the project instructions.  

  AccountLedger.java:
    The AccountLedger class contains an ArrayList of Account objects. The AccountLedger class is responsible for retrieving information from that ArrayList and manipulating the list when called to do so by another class. The AccountLedger has a composition relationship with the main method from Test.java. AccountLedger also has an aggregate relationship with BankOperator.java because the AccountLedger's reference variable is passed to the BankOperator so it can call on the ledger.

  BankOperator.java:
    The BankOperator class provides a menu for the user to select from. The menu repeatedly calls upon other methods or loops through itself again until the user quits the program. BankOperator provides instructions to the user on what information it needs to edit the AccountLedger. BankOperator calls on UserInput.java to obtain user input, then uses that input to call on the AccountLedger object. 

  UserInput.Java:
    This simple class cannot be instantiated. It provides a short list of static methods to obtain all user input for the program. It also includes the projects only Scanner as a static data field. This is done to prevent opening multiple Scanner objects and to eliminate redundancy when obtaining user input and checking whether input is valid.  

  Test.java: 
    The program runs from the Test class, which includes the main method. The main method instantiates an AccountLedger object. The main method instantiates a BankOperator object that takes the AccountLedger as a parameter (passes reference variable). From there, the main class calls the BankOperator object's runMenu method to begin interacting with the user.





