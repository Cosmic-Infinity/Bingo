import java.util.Random;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

class Random_Gen extends Save_Location
{
    public static void main(int range){
        int per_set=range;
        int result[] = new int[per_set];
        generate(range, per_set, result);
        write(per_set, result);
    }

    private static void generate(int range, int per_set, int[]result){
        
        ArrayList<Integer> list = new ArrayList<Integer>(range);
        for(int i = 1; i <= range; i++) {
            list.add(i);
        }
        int x = 0;
        Random rand = new Random();
        while(list.size() > 0) {
            int index = rand.nextInt(list.size());
            result[x++]=list.remove(index);
        }
    }

    private static void write(int per_set, int[]result){
        //----------------------file creation and writing data---------------------------
        try {
            File ftx = new File(file_source);
            if (ftx.createNewFile()) {
                System.out.println("File created: " + ftx.getName());
            } else {
                System.out.println("File already exists. It will be overridden.");
            }

        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
        try{
            FileWriter writer = new FileWriter(file_source);
            for (int i = 0; i < per_set; i++)
                writer.write(result[i]+"\n");
            writer.close();
        }catch(Exception e)
        {
            System.out.println("An error occured while writing");
        }
    }
}