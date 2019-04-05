import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Random m = new Random();
        Scanner scan = new Scanner(System.in);
        int buffer[]={0,0,0,0};

        System.out.print("Enter the number of rows:");
        try {
            buffer[0] = scan.nextInt();
        }
        catch (InputMismatchException e){
            e.getMessage();
            System.out.println("\nInvalid value! Restart the programm & try again.");
            Thread.sleep(10000);
            System.exit(0);
        }
        System.out.print("Enter the number of columns:");
        try {
            buffer[1] = scan.nextInt();
        }
        catch (InputMismatchException e){
            e.getMessage();
            System.out.println("\nInvalid value! Restart the programm & try again.");
            Thread.sleep(10000);
            System.exit(0);
        }

        if(buffer[0]%2==0||buffer[1]%2==0||buffer[0]<3||buffer[1]<3){
            System.out.println("\nIncorrect values of matrix size!\n Values must be odd & bigger than 2.");
            Thread.sleep(10000);
            System.exit(0);
        }


        System.out.print("Enter the maximum value:");
        try {
            buffer[2] = scan.nextInt();
        }
        catch (InputMismatchException e){
            e.getMessage();
            System.out.println("\nInvalid value! Restart the programm & try again.");
            Thread.sleep(10000);
            System.exit(0);
        }
        System.out.print("Enter the minimum value:");
        try {
            buffer[3] = scan.nextInt();
        }
        catch (InputMismatchException e){
            e.getMessage();
            System.out.println("\nInvalid value! Restart the programm & try again.");
            Thread.sleep(10000);
            System.exit(0);
        }

        int cash=buffer[2]+buffer[3];

        if(     buffer[2]<buffer[3] ||
                (cash-buffer[3]!=buffer[2])||
                (cash-buffer[2]!=buffer[3]) )
        {
            System.out.println("\nData overflow error!\n Restart the programm & try another values.");
            Thread.sleep(10000);
            System.exit(0);
        }

        Matrix a = new Matrix(buffer[0], buffer[1], buffer[2], buffer[3]);
        System.out.println("\nSource matrix.\n");
        a.show();
        double sum1=0;
        double sum2=0;
        for(int i =0;i<a.high;i++){
            for(int j =0; j<a.wight;j++){
                if(i==j){
                    sum1+=a.getItem(i+1,j+1);
                }
                if(i+j==a.wight){
                    sum2+=a.getItem(i+1,j+1);
                }
        }}
        double cash2=Double.max(sum1/a.wight,sum2/a.wight);
        int cash3=(int)cash2;
        a.setItem(a.high/2+1,a.wight/2+1,(int)((cash2)>=((double)cash3+0.5)?cash2+1:cash2));
        System.out.println("\nCurrent matrix.\n");
        a.show();
        scan.next();
    }
}
