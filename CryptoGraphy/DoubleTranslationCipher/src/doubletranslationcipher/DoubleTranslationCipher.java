/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doubletranslationcipher;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class DoubleTranslationCipher {

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
        System.out.println("\nEnter the number of row and column for transposition : ");
        row = input.nextInt();
        column = input.nextInt();
        char[][] transposition = new char[row][column];

        System.out.println("\nTransposition array : ");

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

    String getCipherText(char[][] transposition) {
        ArrayList cipherText = new ArrayList();

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {

                if (transposition[j][i] == '!') {
                    continue;
                } else {
                    cipherText.add(transposition[j][i]);
                }
            }

        }
        System.out.print(" Ciphertext : ");

        String ct = "";
        for (Object ch : cipherText) {
            ct = ct + ch;
        }
        return ct;

    }

    public static void main(String[] args) {
        // TODO code application logic here

        String plainText1, cipherText1, cipherText2;
        char[][] transposition1, transposition2;
        DoubleTranslationCipher ob = new DoubleTranslationCipher();

        plainText1 = ob.setPlainText();

        //1st transposition array
        transposition1 = ob.getTransposition(plainText1);

        //Ciphertext1
        cipherText1 = ob.getCipherText(transposition1);
        System.out.println("Ciphertext1 : "+cipherText1);

        //2st transposition array
        transposition2 = ob.getTransposition(cipherText1);
        
         //Ciphertext2
        cipherText2 = ob.getCipherText(transposition2);
        System.out.println("Ciphertext2 : "+cipherText2);

    }

}
//DEPARTMENTOFCOMPUTERSCIENCEANDENGINEERING
