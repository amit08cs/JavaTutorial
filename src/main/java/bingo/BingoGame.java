package bingo;

import java.util.ArrayList;

public class BingoGame {
	
	
	public static void bingoCard(){

    int [][]card=new int [5][5];
    ArrayList<Integer> alreadyUsed = new ArrayList<Integer>();
    boolean valid = false;
    int tmp = 0;

    for(int row=0; row < card.length; row++){
        while(!valid){
            tmp = (int)(Math.random()*15)+1;
            if(!alreadyUsed.contains(tmp)){
                valid = true;
                alreadyUsed.add(tmp);
            }
        }
        card[row][0]= tmp;
        valid = false;
    }

    for(int row=0;row<card.length;row++){
        while(!valid){
            tmp = (int)(Math.random()*15)+16;
            if(!alreadyUsed.contains(tmp)){
                valid = true;
                alreadyUsed.add(tmp);
            }
        }
        card[row][1]= tmp;
        valid = false;
    }

    for(int row=0;row<card.length;row++){
        while(!valid){
            tmp = (int)(Math.random()*15)+31;
            if(!alreadyUsed.contains(tmp)){
                valid = true;
                alreadyUsed.add(tmp);
            }
        }
        card[row][2]= tmp;
        valid = false;
    }

    card[2][2]=0;

    for(int row=0;row<card.length;row++){
        while(!valid){
            tmp = (int)(Math.random()*15)+46;
            if(!alreadyUsed.contains(tmp)){
                valid = true;
                alreadyUsed.add(tmp);
            }
        }
        card[row][3]= tmp;
        valid = false;
    }

    for(int row=0;row<card.length;row++){
        while(!valid){
            tmp = (int)(Math.random()*15)+61;
            if(!alreadyUsed.contains(tmp)){
                valid = true;
                alreadyUsed.add(tmp);
            }
        }
        card[row][4]= tmp;
        valid = false;
    }

    //create array to make title.  
    String title []={"B","I","N","G","O"};

    for(int i=0;i<title.length;i++){
        System.out.print(title[i]+ "\t");
    }

    System.out.println();

    for(int row=0;row<card.length;row++){
        for(int col=0;col<card[row].length;col++){
            System.out.print(card[row][col]+ "\t");
        }

        System.out.println();
    }
 }
	
	public static void main(String[] args) {
		BingoGame.bingoCard();
	}
}

