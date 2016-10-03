package business;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Annuity {
   private double depositStartOfMonth, depositEndOfMonth, rate, totalInterestEarned;
   private int term;
   private double[] bbalDeposit1, iearnDeposit1, ebalDeposit1, 
           bbalDeposit2, iearnDeposit2, ebalDeposit2;
   private boolean built;
   private NumberFormat currency = NumberFormat.getCurrencyInstance();
   private NumberFormat percent = NumberFormat.getPercentInstance();

   public Annuity() {
       this.depositStartOfMonth = 0;
       this.depositEndOfMonth = 0;
       this.rate = 0;
       this.term = 0;
       this.built = false;
       this.totalInterestEarned = 0;
   }
   
   public Annuity(double depositStartOfMonth, double rate, int term) {
       this.depositStartOfMonth = depositStartOfMonth;
       this.rate = rate;
       this.term = term;
       buildAnnuity();
   }
   
   public Annuity(double depositStartOfMonth, double depositEndOfMonth, double rate, int term) {
       this.depositStartOfMonth = depositStartOfMonth;
       this.depositEndOfMonth = depositEndOfMonth;
       this.rate = rate;
       this.term = term;
       buildAnnuity();
   }

   public double getDepositStartOfMonth() {
       return this.depositStartOfMonth;
   }
   
   public String getFormattedDepositStartOfMonth() {
       return currency.format(getDepositStartOfMonth());
   }
   
   public double getRate() {
       return this.rate;
   }
   
   public String getFormattedRate() {
       percent.setMinimumFractionDigits(1);
       percent.setMaximumFractionDigits(5);
       return percent.format(this.rate);
   }

   public int getTerm() {
       return this.term;
   }
   
   public double getFinalValue() {
       if (!built) {
           buildAnnuity();
       }
       return ebalDeposit1[term-1] + ebalDeposit2[term-1];
   }
   
   public String getFormattedFinalValue(){
       return currency.format(getFinalValue());
   }
   
   public double getBegBal(int m) {
       if (!built) {
           buildAnnuity();
       }
       return this.bbalDeposit1[m-1] + this.bbalDeposit2[m-1];
   }
   public double getIntEarn(int m) {
       if (!built) {
           buildAnnuity();
       }
       return this.iearnDeposit1[m-1] + this.iearnDeposit2[m-1];

   }
   public double getEndBal(int m) {
        if (!built) {
            buildAnnuity();
        }
        return this.ebalDeposit1[m-1] + this.ebalDeposit2[m-1];
   }
   
   private void buildAnnuity() {
        bbalDeposit1 = new double[term];
        bbalDeposit2 = new double[term];
        iearnDeposit1 = new double[term];
        iearnDeposit2 = new double[term];
        ebalDeposit1 = new double[term];
        ebalDeposit2 = new double[term];

        bbalDeposit1[0] = 0;
        bbalDeposit2[0] = 0;

        for (int i=0; i < this.term; i++) {
            if (i > 0) {
               this.bbalDeposit1[i] = this.ebalDeposit1[i-1];
               this.bbalDeposit2[i] = this.ebalDeposit2[i-1];
            }
            this.iearnDeposit1[i] = (bbalDeposit1[i] + this.depositStartOfMonth) * (this.rate / 12.0);
            this.ebalDeposit1[i] = (bbalDeposit1[i] + this.depositStartOfMonth + this.iearnDeposit1[i]);
            this.iearnDeposit2[i] = bbalDeposit2[i] * (this.rate / 12.0);
            this.ebalDeposit2[i] = bbalDeposit2[i] + this.depositEndOfMonth + this.iearnDeposit2[i];
            this.totalInterestEarned += this.iearnDeposit1[i] + iearnDeposit2[i];
        }
        built = true;
   }

    public void setDepositStartOfMonth(double depositStartOfMonth)
    {
        this.depositStartOfMonth = depositStartOfMonth;
    }

    public void setRate(double rate)
    {
        this.rate = rate;
    }

    public void setTerm(int term)
    {
        this.term = term;
    }
    
    public ArrayList<AnnuityMonth> getMonths() {
        ArrayList<AnnuityMonth> months = new ArrayList<>();
        if (!built) {
            buildAnnuity();
        }
        for (int i = 0; i < this.term; i++) {
            AnnuityMonth m = new AnnuityMonth(
                    (i+1), this.bbalDeposit1[i] + this.bbalDeposit2[i], 
                    this.depositStartOfMonth + this.depositEndOfMonth,
                    this.iearnDeposit1[i] + this.iearnDeposit2[i], 
                    this.ebalDeposit1[i] + this.ebalDeposit2[i]);
            months.add(m);
        }
        return months;
    }

    public double getDepositEndOfMonth() {
        return depositEndOfMonth;
    }

    public String getFormattedDepositEndOfMonth() {
        return currency.format(this.depositEndOfMonth);
    }
    
    public void setDepositEndOfMonth(double depositEndOfMonth){
        this.depositEndOfMonth = depositEndOfMonth;
    }

    public String getformattedTotalInterestEarned()
    {
        return currency.format(this.totalInterestEarned);
    }
}

