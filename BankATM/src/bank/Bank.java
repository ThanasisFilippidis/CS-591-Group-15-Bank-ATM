/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */

/*
*registerButton.setOnAction(event -> {
            Person tmpPerson = new Person(firstName.getText(), lastName.getText());
            registerNewCustomer(tmpPerson);
            replyMessage.setFill(Color.GREEN);
            replyMessage.setText("Successful registration! Now head back to log in..");
        });
 *
 *
 * loginButton.setOnAction(event -> {
            Person tmpPerson = new Person(firstName.getText(), lastName.getText());
            currentCustomer = loginCustomer(tmpPerson);
            if (currentCustomer != null){
                setupCustomerGUI();
                primaryStage.getScene().setRoot(customerHomePage);
            }else{
                replyMessage.setFill(Color.FIREBRICK);
                replyMessage.setText("Account not found.");
            }
        });
 *
 *
 * currencySelector.setOnAction(event -> {
            //System.out.println(currencySelector.getValue().toString());
            newCurrency[0] = new Currency(currencySelector.getValue().toString());
            selectedAccount.setCurrency(newCurrency[0]);
            tmpCurr[0] = selectedAccount.getCurrency().toString();
            balance.setText(selectedAccount.getBalanceInLocalCurrency()*Currency.getRate(tmpCurr[0]) + tmpCurr[0]);
        });
*
*
* submitBtn.setOnAction(event -> {
            try {
                amount[0] = Float.parseFloat(strAmount.getText());
                if (amount[0] >= 0){
                    try {
                        int accountN = Integer.parseInt(strAccountN.getText());
                        try {
                            int routingN = Integer.parseInt(strRoutingN.getText());
                            Float amountInDollars = account.getCurrency().convertTo("USD", amount[0]);
                            if (currentCustomer.withdrawTransferAmount(amountInDollars, account.getCurrency(), account.getAccountNumber(), account.getRoutingNumber(), accountN, routingN)){
                                if (findTransfersReceiverAcc(amountInDollars, account.getCurrency(), account.getAccountNumber(), account.getRoutingNumber(), accountN, routingN)){
                                    replyMessage.setFill(Color.GREEN);
                                    Float tmpRate = Currency.getRate(account.getCurrency().toString());
                                    replyMessage.setText("Transfer successful. Your new account balance is: " + account.getBalanceInLocalCurrency()*tmpRate + " " + account.getCurrency().toString());
                                }else{
                                    replyMessage.setFill(Color.FIREBRICK);
                                    replyMessage.setText("Transfer unsuccessful. Target account was not found.");
                                    currentCustomer.cancelLastTransferWithdrawal();
                                }
                            }else{
                                amountReplyMessage.setFill(Color.FIREBRICK);
                                amountReplyMessage.setText("Transfer unsuccessful. Insufficient balance.");
                            }
                        }catch (NumberFormatException e){
                            routingNReplyMessage.setFill(Color.FIREBRICK);
                            routingNReplyMessage.setText("Transfer unsuccessful. Routing number has to be a number.");
                        }
                    }catch (NumberFormatException e){
                        accountNReplyMessage.setFill(Color.FIREBRICK);
                        accountNReplyMessage.setText("Transfer unsuccessful. Account number has to be a number.");
                    }
                }else{
                    amountReplyMessage.setFill(Color.FIREBRICK);
                    amountReplyMessage.setText("Only positive amounts requests permitted.");
                }
            }catch (NumberFormatException e){
                amountReplyMessage.setFill(Color.FIREBRICK);
                amountReplyMessage.setText("Please insert only numbers in the amount field.");
            }
        });
*
*
* submitBtn.setOnAction(event -> {
            try {
                amount[0] = Float.parseFloat(strAmount.getText());
                if (amount[0] >= 0){
                    Float amountInDollars = account.getCurrency().convertTo("USD", amount[0]);
                    if (currentCustomer.depositAmount(amountInDollars, account.getCurrency(), account.getAccountNumber(), account.getRoutingNumber())){
                        replyMessage.setFill(Color.GREEN);
                        Float tmpRate = Currency.getRate(account.getCurrency().toString());
                        replyMessage.setText("Deposit successful. Your new account balance is: " + account.getBalanceInLocalCurrency()*tmpRate + " " + account.getCurrency().toString());

                        strAmount.setText("");
                        //System.out.println(amount[0]);
                        //System.out.println(tmpCurrency[0].toString());
                    }else{
                        replyMessage.setFill(Color.FIREBRICK);
                        replyMessage.setText("Deposit unsuccessful. Your account was not found.");
                    }
                }else{
                    replyMessage.setFill(Color.FIREBRICK);
                    replyMessage.setText("Only positive amounts requests permitted.");
                }
            }catch (NumberFormatException e){
                //System.out.println("Typed command was not a number. Please type again:");
                replyMessage.setFill(Color.FIREBRICK);
                replyMessage.setText("Please insert only numbers in the amount field.");
            }
        });
*
*
* submitBtn.setOnAction(event -> {
            try {
                amount[0] = Float.parseFloat(strAmount.getText());
                if (amount[0] >= 0){
                    Float amountInDollars = account.getCurrency().convertTo("USD", amount[0]);
                    if (currentCustomer.withdrawAmount(amountInDollars, account.getCurrency(), account.getAccountNumber(), account.getRoutingNumber())){
                        replyMessage.setFill(Color.GREEN);
                        replyMessage.setText("Withdrawal successful. Please standby to receive your: " + amount[0].toString() + " " + account.getCurrency().toString());

                        strAmount.setText("");
                        //System.out.println(amount[0]);
                        //System.out.println(tmpCurrency[0].toString());
                    }else{
                        replyMessage.setFill(Color.FIREBRICK);
                        replyMessage.setText("Withdrawal unsuccessful. Not sufficient balance.");
                    }
                }else{
                    replyMessage.setFill(Color.FIREBRICK);
                    replyMessage.setText("Only positive amounts requests permitted.");
                }
            }catch (NumberFormatException e){
                //System.out.println("Typed command was not a number. Please type again:");
                replyMessage.setFill(Color.FIREBRICK);
                replyMessage.setText("Please insert only numbers in the amount field.");
            }
        });
*
*
* submitBtn.setOnAction(event -> {
            try {
                amount[0] = Float.parseFloat(strAmount.getText());
                if (amount[0] >= 0){
                    if (currentCustomer.addNewLoan(amount[0], tmpCurrency[0])){
                        replyMessage.setFill(Color.GREEN);
                        replyMessage.setText(amount[0].toString() + " " + tmpCurrency[0].toString() + " loan successfully granted!");

                        strAmount.setText("");
                        //System.out.println(amount[0]);
                        //System.out.println(tmpCurrency[0].toString());
                    }else{
                        replyMessage.setFill(Color.FIREBRICK);
                        replyMessage.setText("Not enough collateral.");
                    }
                }else{
                    replyMessage.setFill(Color.FIREBRICK);
                    replyMessage.setText("Only positive amounts requests permitted.");
                }
            }catch (NumberFormatException e){
                //System.out.println("Typed command was not a number. Please type again:");
                replyMessage.setFill(Color.FIREBRICK);
                replyMessage.setText("Please insert only numbers in the amount field.");
            }
        });
*
*
*
*
*
*
 */
package bank;

import java.util.ArrayList;

public class Bank {
    private ArrayList<CustomerAccount> customerAccounts;
    private BankManagerAccount bankManagerAccount;
    //private CustomerAccount currentCustomer; // The user that is currently logged in

    
    public ArrayList<CustomerAccount> getCustomerAccounts() {
		return customerAccounts;
	}



	public Bank(BankManagerAccount bankManagerAccount) {
        this.customerAccounts = new ArrayList<CustomerAccount>();
        this.bankManagerAccount = bankManagerAccount;
    }


    // Checks if newCustomer is already a customer of the bank and if he is returns false
    // Otherwise creates the newCustomer and returns true
    public boolean registerNewCustomer(Person newCustomer){
        for (CustomerAccount customerAccount:
                customerAccounts) {
            if (customerAccount.getPerson().toString().equals(newCustomer.toString())){
                return false;
            }
        }
        customerAccounts.add(new CustomerAccount(newCustomer));
        return true;
    }

    // Returns the customer object associated with this name and surname
    // if this person does not exist return null
    public CustomerAccount loginCustomer(Person personToLogIn){
        for (CustomerAccount customerAccount:
             customerAccounts) {
            if (customerAccount.getPerson().toString().equals(personToLogIn.toString())){
                return customerAccount;
            }
        }
        return null;
    }

    // Returns the manager object associated with this name and surname
    // if this person does not exist return null
    public BankManagerAccount loginManager(Person personToLogIn){
        if (bankManagerAccount.getPerson().toString().equals(personToLogIn.toString())){
            return bankManagerAccount;
        }
        return null;
    }

    // Returns all the transactions of all the users
    public ArrayList<Transaction> getAllTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        for (CustomerAccount customerAccount :
                customerAccounts) {
            transactions.addAll(customerAccount.getTransactions());
        }
        return transactions;
    }

    // Was previously used to find the account of the receiver in a money transfer. If found it transfers the amount amount otherwise
    // if the account with routing number receiverRoutingN and account number receiverAccountN does not exist returns false
    public boolean findTransfersReceiverAcc(Float amount, Currency currency, int senderAccN, int senderRoutN, int receiverAccountN, int receiverRoutingN){
        for (CustomerAccount customerAcc :
                customerAccounts) {
            if (customerAcc.depositTransferAmount(amount, currency, senderAccN, senderRoutN, receiverAccountN, receiverRoutingN)){
                return true;
            }
        }
        return false;
    }

//    public void setCurrentCustomer(CustomerAccount currentCustomer) {
//        this.currentCustomer = currentCustomer;
//    }

    public boolean makeTransferIfPossible(Float amount, Currency currency, int senderAccN, int senderRoutN, int receiverAccountN, int receiverRoutingN){
        if (checkIfTransferFeasible(amount, currency, senderAccN, senderRoutN, receiverAccountN, receiverRoutingN)){
            makeTransfer(amount, currency, senderAccN, senderRoutN, receiverAccountN, receiverRoutingN);
        }
        return false;
    }

    public boolean checkIfTransferFeasible(Float amount, Currency currency, int senderAccN, int senderRoutN, int receiverAccountN, int receiverRoutingN){
        if (!checkIfAccountExists(receiverAccountN, receiverRoutingN)){
            return false;
        }
        Float amountInDollars = currency.convertTo("USD", amount);
        if (!checkIfBalanceSufficient(amountInDollars, senderAccN, senderRoutN)){
            return false;
        }
        return true;
    }

    public boolean checkIfAccountExists(int receiverAccountN, int receiverRoutingN){
        for (CustomerAccount customerAcc: customerAccounts) {
            if (customerAcc.checkIfAccountExists(receiverAccountN, receiverRoutingN)){
                return true;
            }
        }
        return false;
    }

    public boolean checkIfBalanceSufficient(Float amount, int senderAccN, int senderRoutN){
        for (CustomerAccount customerAcc: customerAccounts) {
            if (customerAcc.checkIfBalanceSufficientForTransfer(amount, senderAccN, senderRoutN)){
                return true;
            }
        }
        return false;
    }

    public void makeTransfer(Float amount, Currency currency, int senderAccN, int senderRoutN, int receiverAccountN, int receiverRoutingN){
        for (CustomerAccount customerAcc: customerAccounts) {
            if (customerAcc.withdrawTransferAmount(amount, currency, senderAccN, senderRoutN, receiverAccountN, receiverRoutingN)){
                break;
            }
        }
        for (CustomerAccount customerAcc: customerAccounts) {
            if (customerAcc.depositTransferAmount(amount, currency, senderAccN, senderRoutN, receiverAccountN, receiverRoutingN)){
                break;
            }
        }
    }
}
