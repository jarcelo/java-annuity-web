
package business;

import java.text.NumberFormat;


public class AnnuityMonth
{
    private int month;
    private double beginningBalance, deposit, interestEarned, endingBalance;
    private NumberFormat currency = NumberFormat.getCurrencyInstance();
    
    public AnnuityMonth(){
        month = 0;
        beginningBalance =0;
        deposit =0;
        interestEarned = 0;
        endingBalance = 0;
    }
    
    public AnnuityMonth(int month, double bb, double dep, double ie, double eb) {
        this.month = month;
        beginningBalance = bb;
        deposit = dep;
        interestEarned = ie;
        endingBalance = eb;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }
    
    public String getBeginningBalance()
    {
        return currency.format(beginningBalance);
    }

    public void setBeginningBalance(double beginningBalance)
    {
        this.beginningBalance = beginningBalance;
    }

    public String getDeposit()
    {
        return currency.format(deposit);
    }
    public void setDeposit(double deposit)
    {
        this.deposit = deposit;
    }

    public String getInterestEarned()
    {
        return currency.format(interestEarned);
    }

    public void setInterestEarned(double interestEarned)
    {
        this.interestEarned = interestEarned;
    }

    public String getEndingBalance()
    {
        return currency.format(endingBalance);
    }

    public void setEndingBalance(double endingBalance)
    {
        this.endingBalance = endingBalance;
    }
}
