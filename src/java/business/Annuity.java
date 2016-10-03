package business;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Annuity {
   private double depositStartOfMonth, depositEndOfMonth, rate, totalInterestEarned;
   private int term;
   //private double[] bbal, iearn, ebal;
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
       //return ebal[term-1];
       return ebalDeposit1[term-1] + ebalDeposit2[term-1];
   }
   
   public String getFormattedFinalValue(){
       return currency.format(getFinalValue());
   }
   
   public double getBegBal(int m) {
       if (!built) {
           buildAnnuity();
       }
       //return this.bbal[m-1];
       return this.bbalDeposit1[m-1] + this.bbalDeposit2[m-1];
   }
   public double getIntEarn(int m) {
       if (!built) {
           buildAnnuity();
       }
       //return this.iearn[m-1];
       return this.iearnDeposit1[m-1] + this.iearnDeposit2[m-1];

   }
   public double getEndBal(int m) {
       if (!built) {
           buildAnnuity();
       }
       //return this.ebal[m-1];
       return this.ebalDeposit1[m-1] + this.ebalDeposit2[m-1];
   }
   // for deposits at the beginning of the month
   private void buildAnnuity() {
       //bbal  = new double[term];
       bbalDeposit1 = new double[term];
       bbalDeposit2 = new double[term];
       //iearn = new double[term];
       iearnDeposit1 = new double[term];
       iearnDeposit2 = new double[term];
       //ebal  = new double[term];
       ebalDeposit1 = new double[term];
       ebalDeposit2 = new double[term];
       
       //bbal[0] = 0;
       bbalDeposit1[0] = 0;
       bbalDeposit2[0] = 0;
//       // Annuity Due (Begin of each month)
//       for (int i=0; i < this.term; i++) {
//           if (i > 0) {
//               bbal[i] = ebal[i-1];
//           }
//           iearn[i] = (bbal[i] + this.depositStartOfMonth) * (this.rate / 12.0);
//           ebal[i] = (bbal[i] + this.depositStartOfMonth + iearn[i]);
//       }
       // Ordinary Annuity (End of each month)
//        for (int i = 0; i < this.term; i++) {
//           if (i > 0) {
//               bbal[i] = ebal[i-1];
//           }
//           iearn[i] = ((bbal[i]) * (this.rate / 12.0));// + this.depositStartOfMonth;
//           ebal[i] = (bbal[i] + this.depositStartOfMonth + iearn[i]);
//       }
               // Annuity Due (Begin of each month)
        //double bal1 = 0.0, bal2 = 0.0, interest1 = 0.0, interest2 = 0.0;
       

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
       
       
//        if (this.depositEndOfMonth > 0) {
//            for (int i = 0; i < this.term; i++) {
//                if (i > 0) {
//                   this.bbal[i] = this.ebal[i-1];
//                }
//                this.iearn[i] += this.bbal[i] * (this.rate / 12.0);
//                this.ebal[i] += this.bbal[i] + this.depositEndOfMonth + this.iearn[i];
//
//            }
//        }

       built = true;
       //return ;
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
                    //(i+1), this.bbal[i], this.depositStartOfMonth,
                    //(i+1), this.bbalDeposit1[i], this.depositStartOfMonth,
                    (i+1), this.bbalDeposit1[i] + this.bbalDeposit2[i], 
                    //this.depositEndOfMonth,
                    this.depositStartOfMonth + this.depositEndOfMonth,
                    //this.iearnDeposit1[i], this.ebalDeposit1[i]);
                    this.iearnDeposit1[i] + this.iearnDeposit2[i], 
                    this.ebalDeposit1[i] + this.ebalDeposit2[i]);
            months.add(m);
        }
        return months;
    }

    // TODO: Check if this needs to be converted to a string so it can be formatted
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
        return currency.format(totalInterestEarned);
    }
}

