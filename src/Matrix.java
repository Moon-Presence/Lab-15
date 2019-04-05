import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

public class Matrix {
    int high=3;
    int wight=3;
    int min=0;
    int max=0;

    ArrayList<ArrayList<Integer>> matrix= new ArrayList<ArrayList<Integer>>();
    Matrix(int w,int h,int mx,int mn) throws InterruptedException {
        high=h;
        wight=w;
        min=mn;
        max=mx;

        Random r = new Random();
        ListIterator<ArrayList<Integer>> itr1= matrix.listIterator();

        for(int x=0;x<high;x++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            ListIterator<Integer> itr2 = row.listIterator();

            try{
            for (int z = 0; z< wight; z++) {
                itr2.add(r.nextInt(max+ 1 - min)  + min);
            }}
            catch(IllegalArgumentException e){
                e.getMessage();
                System.out.println("\nInvalid values of integer array!\n"+
                        " Restart the programm & try another constructors arguments.");
                Thread.sleep(10000);
                System.exit(0);
            }

            itr1.add(row);
        }

    }

    public void setItem(int i, int j,int value) throws InterruptedException {
        try{
            ListIterator<ArrayList<Integer>> itr1 = matrix.listIterator(i-1);
            ArrayList<Integer> row=itr1.next();
            ListIterator<Integer> itr2 = row.listIterator(0);
            for(int z =0; z<wight;z++){
                int f=itr2.next();
                if(z==j-1)
                itr2.set(value);}
        }
        catch(IndexOutOfBoundsException e){
            e.getMessage();
            System.out.println("\nNumber of rows and colums starting from 1!!\n"+
                    " Restart the programm & try again.");
            Thread.sleep(10000);
            System.exit(0);
        }
    }
    public int getItem(int i,int j){
        ListIterator<ArrayList<Integer>> itr1 = matrix.listIterator(i-1);
        ListIterator<Integer> itr2 = itr1.next().listIterator(j-1);
        return itr2.next();
    }
    public int getItem2(int i,int j){
        int row_counter=0;
        int column_counter=0;
        for(ArrayList<Integer> row: matrix){
            for(int value:row){
                if(row_counter==i-1 && column_counter==j-1){
                    return value;
                }
                column_counter++;
            }
            row_counter++;
        }
        return Integer.MIN_VALUE;
    }
    public void show(){
        int row_counter=0;
        for(ArrayList<Integer> row: matrix){
            for(int value:row){
             System.out.print(value+", ");
            }
            row_counter++;
            if(row_counter==high){
                System.out.println("\b\b. ");}
            else{
                System.out.println("\b\b; ");}
        }
    }

}
