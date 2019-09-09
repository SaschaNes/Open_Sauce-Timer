/*
        A Open Sauce Timer written in Java
        File: Timer.java
        Author: Sascha Nesterovic
        Date: 09. September 2019
        - Written in Netbeans 8.2 with Java 1.8 Update 112
*/

package timer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Timer {

    public static void main(String[] args) {
        
        // create a new Scanner to insert an String 
        Scanner in = new Scanner(System.in);
        System.out.print("Insert an number: ");
        String s = in.nextLine();
        int seconds = 0;
        
        // Parse the String s into an integer
        try {
            seconds = Integer.parseInt(s);
        } catch (Exception e) {
            System.err.println("Not an Integer! Please input an number: ");
        }
        
        // check if integer is not 0 seconds and then begin to count down
        // thread.sleep is 999ms to weight output on screen with time
        if (seconds != 0) {
            for (int i = 0; i <= seconds; i++) {
                clearScreen();          // <- work in progress
                
                System.out.println(i);
                
                try {
                    Thread.sleep(999);
                } catch (Exception e) {
                    System.err.println("Error: Program will be closed!");
                    System.exit(1);
                }
                
                if (i == seconds) {
                    playSound();
                }
            }
        }
            
    }
    
        // WIP
        public static void clearScreen () {  
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
        }
    
        
        // play a soung in this case (alarm ringtone)
        public static void playSound () {
            String gongFile = "C:\\Users\\neste\\Documents\\NetBeansProjects\\Timer\\src\\timer\\alarm_clock.au";
            try {
                InputStream in = new FileInputStream(gongFile);
                AudioStream audioStream = new AudioStream(in);
                AudioPlayer.player.start(audioStream);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
}
    



