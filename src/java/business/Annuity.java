package business;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Annuity {
   private double deposit1, depositEndOfMonth, rate;
   private int term;
   private double[] bbal, iearn, ebal;
   private boolean built;
   private NumberFormat currency = NumberFormat.getCurrencyInstance();

   public Annuity() {
       this.deposit1 = 0;
       this.rate = 0;
       this.term = 0;
       this.built = false;
   }
   
   public Annuity(double deposit1, double rate, int term) {
       this.deposit1 = deposit1;
       this.rate = rate;
       this.term = term;
       buildAnnuity();
   }
   
   public Annuity(double deposit1, double depositEndOfMonth, double rate, int term) {
       this.deposit1 = deposit1;
       this.depositEndOfMonth = depositEndOfMonth;
       this.rate = rate;
       this.term = term;
       buildAnnuity();
   }

//   public double getDeposit() {
//       return this.deposit;
//   }
   
   public String getDeposit() {
       return currency.format(this.deposit1);
   }

   public double getRate() {
       return this.rate;
   }

   public int getTerm() {
       return this.term;
   }
   public double getFinalValue() {
       if (!built) {
           buildAnnuity();
       }
       return ebal[term-1];
   }
   public double getBegBal(int m) {
       if (!built) {
           buildAnnuity();
       }
       return this.bbal[m-1];
   }
   public double getIntEarn(int m) {
       if (!built) {
           buildAnnuity();
       }
       return this.iearn[m-1];
   }
   public double getEndBal(int m) {
       if (!built) {
           buildAnnuity();
       }
       return this.ebal[m-1];
   }
   // for deposits at the beginning of the month
   private void buildAnnuity() {
       bbal = new double[term];
       iearn = new double[term];
       ebal = new double[term];

       bbal[0] = 0;
       for (int i=0; i < this.term; i++) {
           if (i > 0) {
               bbal[i] = ebal[i-1];
           }
           iearn[i] = (bbal[i] + this.deposit1) * (this.rate / 12.0);
           ebal[i] = (bbal[i] + this.deposit1 + iearn[i]);
       }
       built = true;
       //return ;
   }

    public void setDeposit(double deposit1)
    {
        this.deposit1 = deposit1;
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
                    (i+1), this.bbal[i], this.deposit1,
                    this.iearn[i], this.ebal[i]);
            months.add(m);
        }
        return months;
    }
}
