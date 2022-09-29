import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Generate_Ticket extends Save_Location
{
    public static void ticket(int how_many_tickets,int per_ticket_row, int per_ticket_column , int range) throws java.io.FileNotFoundException {
        /*
         * The progrm by default tries to create a square matrix of numbers, i.e, same number of rows and columns.
         * Eg : per_ticket_size of 16 will give you a ticket of size 4*4
         * If a custom size is required, use the column and row variables below
         */
        int per_ticket_size = per_ticket_row * per_ticket_column;
        String file_source = ticket_source;
        try {
            File ftx = new File(file_source);
            if (ftx.createNewFile()) {
                System.out.println("File created: " + ftx.getName());
            } else {
                System.out.println("File already exists. It has be overridden.");
            }
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }

        int block16_1[] = new int[per_ticket_size];
        int block16_2[] = new int[per_ticket_size];
        int ticket_no=0;
        try{
            FileWriter writer = new FileWriter(file_source);
            for(int i = 0; i<how_many_tickets; i=i+2){
                generating(range, per_ticket_size, block16_1);
                generating(range, per_ticket_size, block16_2);
                //for (int j = 0; j < 16; j++)
                //System.out.println(block16_1[j]);
                //System.out.println("-------------------");
                //for (int j = 0; j < 16; j++)
                //System.out.println(block16_2[j]);
                //System.out.println("-------------------");
                writer.write("Ticket: "+ ++ticket_no +"");
                for(int c = 0; c<per_ticket_column; c++)
                    writer.write(",");
                writer.write("Ticket: "+ ++ticket_no +"\n");
                for (int j = 0; j < per_ticket_row; j++){
                    for(int k=0; k < per_ticket_column; k++){
                        writer.write(block16_1[(j*per_ticket_column)+k]+",");
                    }
                    for(int k=0; k < per_ticket_column; k++){
                        writer.write((k>0?",":"")+block16_2[(j*per_ticket_column)+k]);
                    }
                    writer.write("\n");
                }
            }
            writer.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private static void generating(int range, int per_set, int[]block){

        ArrayList<Integer> list = new ArrayList<Integer>(range);
        for(int i = 1; i <= range; i++) 
            list.add(i);

        int x = 0;
        Random rand = new Random();
        while(list.size() > 0) {
            int index = rand.nextInt(list.size());
            block[x++]=list.remove(index);
            if(x==per_set)
                break;
        }

        /*
        int mapping[] = new int[range];
        Random rb=new Random();

        for(int i=0;i<range;i++)
        mapping[i]=i+1;

        int result[] = new int[range];
        int random_scope=range;
        for(int i=0;i<range;i++){
        int r = rb.nextInt(random_scope);
        result [i] = mapping[r];
        mapping[r] = random_scope;
        random_scope--;
        }

        if(range>15){
        for(int i=range-1; i>range-10; i--){
        int temp = result[i];
        int temp_pos = rb.nextInt(range);
        result[i] = result[temp_pos];
        result[temp_pos]=temp;
        }
        }

        for(int i=0; i<per_set; i++){
        int temp_pos = rb.nextInt(range);
        block[i] = result[temp_pos];
        }
         */
    }
}