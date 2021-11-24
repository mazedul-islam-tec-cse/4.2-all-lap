/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transposition;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Transposition {

    /**
     * @param args the command line arguments
     */
    Scanner input = new Scanner(System.in);
    int row, column;

    String setPlainText() {

        System.out.println("Enter your plaintext : ");

        return input.nextLine();
    }

    char[][] getTransposition(String plainText) {
        char[] message = plainText.toCharArray();
        System.out.println("Enter the number of row and column for transposition : ");
        row = input.nextInt();
        column = input.nextInt();
        char[][] transposition = new char[row][column];

        System.out.println("Transposition array : ");

        for (int i = 0; i < message.length; i++) {

            for (int j = 0; j < row; j++) {
                for (int k = 0; k < column; k++) {
                    
                    if (i == message.length) {
                        
                        transposition[j][k] = '!';
                        
                    } else {
                        
                        transposition[j][k] = message[i++];
                        System.out.print(" " + transposition[j][k]);
                    }
                }
                System.out.println("");
            }

        }
        return transposition;

    }

    void getCipherText(char[][] transposition) {
        ArrayList cipherText = new ArrayList();

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {

                if(transposition[j][i] == '!'){
                    continue;
                }
                else
                cipherText.add(transposition[j][i]);
            }

        }
        System.out.print(" Ciphertext : ");

        for (Object ch : cipherText) {
            System.out.print(ch);
        }
        System.out.println("");

    }

    public static void main(String[] args) {
        // TODO code application logic here

        String plainText;
        char[][] transposition;
        Transposition ob = new Transposition();

        plainText = ob.setPlainText();

        transposition = ob.getTransposition(plainText);

        ob.getCipherText(transposition);

    }

}
//DEPARTMENTOFCOMPUTERSCIENCEANDENGINEERING
