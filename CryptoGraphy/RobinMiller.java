/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robin.miller;

import java.util.Scanner;
import static javafx.scene.input.KeyCode.P;

/**
 *
 * @author user
 */
public class RobinMiller {

    /**
     * @param args the command line arguments
     */
    static boolean checkPrime(int p) {

        Scanner input = new Scanner(System.in);
        int b, m;
        b = ((p - 1) / 2);

        m = (int) ((p - 1) / Math.pow(2, b));

        System.out.println("Enter a random number a that is less than p ");
        int a = input.nextInt();

        while (true) {

            if (a < p) {
                break;
            }
            else
                System.out.println("a must be less than p.... please try again");
        }
        
        int j = 0;
        int z = (int) (Math.pow(a,m) % p);
        
        if(z == 1 || z == (p - 1) ){
            
            System.out.println(p + " passes the test and may be prime");
            return true;
        }
        
         if(j > 0 && z == 1){
            System.out.println(p + " is not prime");
          }
        
        while(true){
            
          j = j + 1;
          
          if(j < b && j != p - 1){
              
              z = (z*z) % p;
          }
          
          if(j > 0 && z == 1){
            System.out.println(p + " passes the test and may be prime");
            return true;
          }
          else if(j == b && z != p - 1){
               System.out.println(p + " is not prime");
               return false;
          }
          
        }
        
        
    }

    public static void main(String[] args) {
        // TODO code application logic here

        int p, b;
        System.out.println("Enter the value of p");
        Scanner input = new Scanner(System.in);

        p = input.nextInt();

        checkPrime(p);
    }

}
