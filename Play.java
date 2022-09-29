import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

class Play extends Save_Location
{
    public static void main() throws java.io.FileNotFoundException {
        int arr[] = new int [100];
        
        Scanner sc = null;
        try{
            sc = new Scanner(new BufferedReader(new FileReader(file_source)));
        } catch (Exception e){
            System.out.println("GeneratedList.txt NOT FOUND. Have you used \"Random_Gen\" to create a number list?");
            System.exit(1);
        }
        
        Scanner ob = new Scanner(System.in);
        for (int i=0; i<100; i++) {
            arr[i] = Integer.parseInt(sc.nextLine().trim());
        }
        System.out.print("");
        for(int i = 0; i<100; i++){
            String mod = "";
            i=i+1;
            switch(i%10){
                case 1 :
                    mod = "st";
                    break;
                case 2:
                    mod = "nd";
                    break;
                case 3:
                    mod = "rd";
                    break;
                default:
                    mod = "th";
            }
            System.out.print((i==11 || i==12 || i==13)? i+"th no. : ": i+mod+" no. : ");
            System.out.print(arr[--i]+"\n");
            String s = ob.nextLine();
        }
    }
}