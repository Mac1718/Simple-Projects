package Practice;
import java.util.Scanner;

class BankDetails
{
    private int accno;
    private String accname;
    private String acctype;
    private int accbalance;
    Scanner sc=new Scanner(System.in);
    public void showAccount()
    {
        System.out.println("Account Number = "+accno);
        System.out.println("Account Name = "+accname);
        System.out.println("Account Type = "+acctype);
        System.out.println("Account Balance = "+accbalance);
    }
    public boolean accsearch(String a)
    {
        if(equals(a))
        {
            showAccount();
            return(true);
        }
        else
        {
            return(false);
        }
    }
    public void accCreate()
    {
        System.out.println("Enter Account Number");
          accno=sc.nextInt();
        System.out.println("Enter Account Name");
          accname=sc.nextLine();
        System.out.println("Enter Account Type");
         acctype=sc.nextLine();
        System.out.println("Account Created Successfully");
    }
    public void withdraw()
    {
        System.out.println("Enter Amount to withdaw");
        int amt=sc.nextInt();
        if(amt>accbalance)
        {
            System.out.println("Insufficient cash");
        }
        else
        {
        System.out.println("Amount Withdrawn Successfully");
        accbalance=amt-accbalance;
        }
        
    }
    public void deposit()
    {
        System.out.println("Enter Amount to Deposit");
        int dep=sc.nextInt();
        accbalance=dep+accbalance;
        System.out.println("Amount Deposited.");
        System.out.println("Balance ="+accbalance);
    }
    public class BankApp
    {
        public static void main(String[] args)
        {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter No of Customer Account to Search");
            int n=sc.nextInt();
            BankDetails obj[]=new BankDetails[n];
            for(int i=0;i<obj.length;i++)
            {
                obj[i]=new BankDetails();
                obj[i].accCreate();
            }
            int ch;
            do
            {
            System.out.println("->->BANKING SYSTEM <-<-");
            System.out.println("1.Display Account Details \n 2.Search By Account Number \n 3.Deposit Amount \n 4.Withdraw amount \n 5.Exit");
            System.out.println("Enter The Option Of Your Choice");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                {
                    for(int i=0;i<obj.length;i++)
                    {
                        obj[i].showAccount();
                    }
                }
                case 2:
                {
                    System.out.println("Enter Your Account Number");
                    String a=sc.nextLine();
                     boolean found = false;
                    for(int i=0;i<obj.length;i++)
                    {
                        found=obj[i].accsearch(a);
                        if(found)
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("Account Not Found");
                        }
                    }
                }
                case 3:
                {
                    System.out.println("Enter the Account Number");
                    String a=sc.nextLine();
                    boolean found=false;
                    for(int i=0;i<obj.length;i++)
                    {
                        found=obj[i].accsearch(a);
                        if(found)
                        {
                            obj[i].deposit();
                        }
                        else
                        {
                            System.out.println("Account Not Found");
                        }
                    }
                }
                case 4:
                {
                    System.out.println("Enter the Account Number");
                    String a=sc.nextLine();
                    boolean found=false;
                    for(int i=0;i<obj.length;i++)
                    {
                        found=obj[i].accsearch(a);
                        if(found)
                        {
                            obj[i].withdraw();
                        }
                        else
                        {
                            System.out.println("Account Not Found");
                        }
                    }
                }
                case 5:
                {
                    System.out.println("Bye");
                }
            }
        }
        while(ch!=5);
        sc.close();
    }
}
}
