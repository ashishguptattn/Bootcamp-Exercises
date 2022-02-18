import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

class Bank
{
protected double rateOfInterest;
protected String name;
protected int balance = 0;
protected String account_no = "";
    TYPE accType;
public Bank()
{
    rateOfInterest=0;
    name="Bank";
}
void getDetails()
{
    System.out.println("Bank: "+this.name+" Rate of interest: "+this.rateOfInterest);
}
    public void printDetails(){
        System.out.println("Your bank is "+name+", Your balance is"+balance+", Your account no. ="+account_no);
    }

    //adding amount


    public void addAmt(int amount){




        Random r = new Random();
        int number = r.nextInt(100);
        account_no = name+number;
        balance +=amount;


    }

    //deducting amount
    public void withDraw(int withdrawalAmt){

        Scanner sc = new Scanner(System.in);
        System.out.println("From which you want to deduct 1.SAVING 2.CURRENT");
        int i = sc.nextInt();
        int flag = 0;
        switch (i){
            case 1:
                accType = TYPE.SAVINGS;
                break;
            case 2:
                accType = TYPE.CURRENT;
                break;
            default:
                System.out.println("Wrong choice");
        }

        try{
            if(balance < withdrawalAmt){
                flag = -1;
                throw new InsufficientAmountException();
            }

            int beforeWithDrawl = balance;
            balance = balance - withdrawalAmt;
            System.out.println("Amount deducted from "+accType+" account & your current balance: "+balance);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            try{
                FileWriter my=new FileWriter("SBITransactionDetails.txt");
                my.write("The account number is:"+account_no +"\n");
                my.write("The amount in the account :"+beforeWithDrawl+"\n");
                my.write("The amount withdrawl is :"+withdrawalAmt+"\n");
                if(flag==0){
                    my.write("The available amount in the account is :"+balance+"\n");
                    my.write("Transaction successful"+"\n");
                    my.write("Transaction time"+now+"  and date:"+dtf+"\n");


                }
                else
                    my.write("Transaction cancelled");
                my.close();


            }
            catch(IOException e){
                System.out.println("An error occured");
            }


        }
        catch (InsufficientAmountException e){
            System.out.println(e);
        }
    }


    enum TYPE{
        CURRENT,SAVINGS;
    }

    //open account


}
class InsufficientAmountException extends Exception{

    InsufficientAmountException(){
        super("Insufficient Balance to withdraw this amount");
    }

}

class SBI extends Bank{
    public SBI()
    {
        super.name="SBI";
        super.rateOfInterest=6.5;

    }
}
class ICICI extends Bank{
    public ICICI()
    {
        super.name="ICICI";
        super.rateOfInterest=7.5;
    }
}
class BOI extends Bank{
    public BOI()
    {
        super.name="BOI";
        super.rateOfInterest=8.5;
    }
}


public class Run {
    public static void main(String[] args)
    {
        SBI sbi=new SBI();
        ICICI icici=new ICICI();
        BOI boi=new BOI();
        sbi.getDetails();
        icici.getDetails();
        boi.getDetails();

        //printing user detail
        boi.printDetails();
        //Adding amount
        boi.addAmt(200);

        //Deducting amount
        boi.withDraw(100);

        //printing balance
        System.out.println(sbi.balance);

        //deducting amount greater than balance
        boi.withDraw(201);

        //printing user detail
        boi.printDetails();
    }
}
