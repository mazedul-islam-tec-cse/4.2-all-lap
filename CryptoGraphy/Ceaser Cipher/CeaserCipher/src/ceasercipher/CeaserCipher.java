/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceasercipher;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class CeaserCipher {

    /**
     * @param args the command line arguments
     */
    Scanner input = new Scanner(System.in);

    String setPlainText() {

        System.out.printf("Enter your Paintext : ");
        String paintText = input.nextLine();

        return paintText;
    }

    String cipherText(String paintText) {

        System.out.printf("Enter key : ");
        int key = input.nextInt();
        String message = paintText;
        String encryptedMessage = "";

        for (int i = 0; i < message.length(); ++i) {
            char ch = message.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch + key);

                if (ch > 'z') {
                    ch = (char) (ch - 'z' + 'a' - 1);
                }

                encryptedMessage += ch;
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + key);

                if (ch > 'Z') {
                    ch = (char) (ch - 'Z' + 'A' - 1);
                }

                encryptedMessage += ch;
            } else {
                encryptedMessage += ch;
            }
        }

        System.out.println("Ciphertext : " + encryptedMessage);

        return encryptedMessage;
    }

    void getPaintText(String cipherText) {

        String message = cipherText;
        String decryptedMessage = "";
        System.out.printf("Enter key : ");
        int key = input.nextInt();

        for (int i = 0; i < message.length(); ++i) {
            char ch = message.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - key);

                if (ch < 'a') {
                    ch = (char) (ch + 'z' - 'a' + 1);
                }

                decryptedMessage += ch;
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch - key);

                if (ch < 'A') {
                    ch = (char) (ch + 'Z' - 'A' + 1);
                }

                decryptedMessage += ch;
            } else {
                decryptedMessage += ch;
            }
        }
        System.out.println("Plaintext = " + decryptedMessage);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        String plainText, cipherText;
        CeaserCipher ob = new CeaserCipher();
        // set paintext
        plainText = ob.setPlainText();

        //Encription
        cipherText = ob.cipherText(plainText);

        //Decription
        ob.getPaintText(cipherText);

    }
}
