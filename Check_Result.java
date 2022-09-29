import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class Check_Result extends Save_Location{
    public static void main() throws java.io.FileNotFoundException {

        Scanner sc = new Scanner(new BufferedReader(new FileReader(file_source)));
        Scanner ob = new Scanner(System.in);

        System.out.println("Which position have you reached in the announcement?");
        int position = ob.nextInt();
        int arr[] = new int [position];
        int user[] = new int[16];
        System.out.println("Enter user's numbers :");
        for (int i=0; i<position; i++) {
            arr[i] = Integer.parseInt(sc.nextLine().trim());
        }
        int x = 0;
        for(int i=0; i<position;i++){
            int n = ob.nextInt();
            int flag = 0;
            for(int j=0; j<position; j++){
                if(arr[j]==n){
                    flag = 1;
                    user[x++]=arr[j];
                    break;
                }
            }
            if(flag==0){
                System.out.println("MISMATCH");
            }
        }
        System.out.println("SUCCESS");

        for(int i = 0; i<16; i++)
            System.out.println(user[i]);
    }
}
