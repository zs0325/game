
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Question3 {
    static int[] score={0,0,0,0,0,0,0,0,0,0};
   
    public void rounds(int n){ //initialises answer and round name which is used in compare method
        String round=null, ans=null;
        if(n==1){round="animal"; ans="mouse";}
        if(n==2){round="fruit"; ans= "cherry";}
        if(n==3){round="vegtable"; ans="carrot";}
        if(n==4){round="number"; ans="seventeen";}
        if(n==5){round="name"; ans="joshua";}
        if(n==6){round="app"; ans="youtube";}
        if(n==7){round="colour"; ans="red";}
        if(n==8){round="shape"; ans="diamond";}
        if(n==9){round="country"; ans="australia";}
        if(n==10){round="season"; ans="summer";}
        compare(n,round,ans);
    }
    
    public void compare(int n, String round,String ans){
      boolean correct=false;
      int guess=1;
      System.out.println("Round "+n+": "+round+"\n");
      while(correct==false&&guess!=4){ //while answer isnt correct and 3 guesses havent been used
        int dist=0;
        System.out.print("\tAnswer "+guess+": ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int lmax= Math.max(ans.length(),input.length());
        int lmin= Math.min(ans.length(),input.length());
        if(ans.length()!=input.length())  //when input and ans length are not equal meaning the strings are not the sam
            dist=lmax-lmin;              // dist becomes the difference between their lengths
        for(int k=0; k<lmin;k++){
           if (input.charAt(k)<ans.charAt(k) || input.charAt(k)>ans.charAt(k))
             dist+=1;}      //increment dist when character at the same position of input and ans are not equal   
        if(dist==0){
            System.out.println("\tcorrect\n");
            correct=true;}
        else System.out.println("\tincorrect -> "+dist+"\n");
        score[n-1]+=dist;
        guess++;
        }
      if(n==10){ return; }
      rounds(++n);
    }
    public static void main(String args[]){
        Question3 q= new Question3();
        q.rounds(1);
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Insert name: ");
        String name= scan2.nextLine();
        try {
            File file = new File(name+".txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(name+".txt");
            int finalScore=0;
            for(int i=0;i<10;i++){
            writer.write("Round "+(i+1)+": "+score[i]+"\n");  //score at the end of each round
            finalScore+= score[i]; }
            writer.write("Final score: "+finalScore);
            writer.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
          }
    }
}
