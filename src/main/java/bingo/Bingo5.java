package bingo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Bingo5{
	public static void main(String[]args)throws IOException{
		int card[][]=new int[5][5];
		int mark[][]=new int[5][5];mark[2][2]=1;
		int ball[][]=new int[15][5];
		int bingo[][]=new int[150][150];
		String pattern[]={"DARK STAR","OUTSIDE 4 CORNERS","INSIDE 4 CORNERS","OUTSIDE DIAMOND","INSIDE DIAMOND","HOLLOW DIAMOND","OUTSIDE FRAME","INSIDE FRAME","CHECKER BOARD","TIC TAC TOE", "TURTLE"};
		int[][] bingo00={{0,1,1,1,0},{1,0,1,0,1},{0,0,1,0,0},{1,0,1,0,1},{0,1,1,1,0}};
		int bingo01[][]={{1,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{1,0,0,0,1}};
		int bingo02[][]={{0,0,0,0,0},{0,1,0,1,0},{0,0,0,0,0},{0,1,0,1,0},{0,0,0,0,0}};
		int bingo03[][]={{0,0,1,0,0},{0,0,0,0,0},{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		int bingo04[][]={{0,0,0,0,0},{0,0,1,0,0},{0,1,0,1,0},{0,0,1,0,0},{0,0,0,0,0}};
		int bingo05[][]={{0,0,1,0,0},{0,1,0,1,0},{1,0,0,0,1},{0,1,0,1,0},{0,0,1,0,0}};
		int bingo06[][]={{1,1,1,1,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,1,1,1,1}};
		int bingo07[][]={{0,0,0,0,0},{0,1,1,1,0},{0,1,0,1,0},{0,1,1,1,0},{0,0,0,0,0}};
		int bingo08[][]={{1,0,1,0,1},{0,1,0,1,0},{1,0,1,0,1},{0,1,0,1,0},{1,0,1,0,1}};
		int bingo09[][]={{0,1,0,1,0},{1,0,1,0,1},{0,1,0,1,0},{1,0,1,0,1},{0,1,0,1,0}};
		int bingo10[][]={{0,0,1,0,0},{1,1,1,1,1},{0,1,1,1,0},{0,1,1,1,0},{1,0,0,0,1}};
		int[][]bingo0[]={bingo00,bingo01,bingo02,bingo03,bingo04,bingo05,bingo06,bingo07,bingo08,bingo09,bingo10};
		int col=0,row=0,counter=0,done=0,num,pattern_count=0,mark_count=0;
		String pattern_name="";
		Random rn=new Random();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		do{
			try{
				System.out.println();
				for(counter=0;counter<pattern.length;counter++)
					System.out.println("["+counter+"]"+pattern[counter]);
				System.out.print("\nSelect WINNING PATTERN: ");
				num=Integer.parseInt(br.readLine());
				if(num>=0&&num<=10){
					done=1;
					bingo=bingo00;
					pattern_name=pattern[num];
				}
				else{
					done=0;
					System.out.println("\nInput must be from 0 to 10 only...");
					continue;
				}
				pattern_count=0;
				for(row=0;row<5;row++){
					for(col=0;col<5;col++)
						if(bingo[row][col]==1)pattern_count++;
				}
			}catch(NumberFormatException e){System.out.println("Input must be an Integer...");}
		}while(done==0);

		counter=0;
		do{
			num=rn.nextInt(75)+1;
			if(num>=1&&num<=15)col=0;
			else if(num>=16&&num<=30)col=1;
			else if(num>=31&&num<=45)col=2;
			else if(num>=46&&num<=60)col=3;
			else if(num>=61&&num<=75)col=4;
			else {continue;}
				for(row=0;row<5;row++){
					if(row==2&&col==2)row++;
					if(card[row][col]==num)break;
					if(card[row][col]==0){
						card[row][col]=num;
						counter++;
						break;
					}
				}
		}while(counter<24);
		System.out.println("\nLet's Play BINGO...");

		done=0;
		counter=0;
		do{
			System.out.println("--------------------------------------");
			System.out.println(pattern_name+"("+pattern_count+")");
			System.out.println("--------------------------------------");
			System.out.println(" WINNING\t CARD");
			System.out.println(" PATTERN\t MARKS");
			System.out.println(" BINGO\t BINGO");
			System.out.println(" ------------\t ----------");
			for(row=0;row<5;row++){
				for(col=0;col<10;col++){
					if(col<5){
						if(col==0) System.out.print(" ");
						if(bingo[row][col]==0) System.out.print("- ");
						else System.out.print("* ");
					}
					else{
						if(col==5) System.out.print("\t ");
						if(row==2&&col-5==2) System.out.print("F ");
						else if(mark[row][col-5]==0) System.out.print("- ");
						else System.out.print("* ");
					}
				}
				System.out.println();
			}
			mark_count=0;
			for(row=0;row<5;row++){
				for(col=0;col<5;col++)
					if(bingo[row][col]==1&&mark[row][col]==1) mark_count++;
			}
			if(pattern_count-mark_count==1) System.out.println("----WAITING FOR ONE MORE NUMBER!----");
			else if(pattern_count-mark_count==0) System.out.println("----BINGO!----BINGO!----BINGO!");
			else System.out.println("--------------------------");
			System.out.println("\nB\tI\tN\tG\tO");
			System.out.println("--------------------------");
			for(row=0;row<5;row++){
				for(col=0;col<5;col++){
					if(row==2&&col==2) System.out.print("F\t");
					else if(card[row][col]<10) System.out.print("0"+card[row][col]+"\t");
					else System.out.print(card[row][col]+"\t");
				}
				System.out.println();
			}
			System.out.println("--------------------------"); 
			System.out.println("\nB\tI\tN\tG\tO");
			System.out.println("--------------------------"); 
			for(row=0;row<15;row++){
				for(col=0;col<5;col++){
					if(ball[row][col]==0) System.out.print("--\t");
					else if(ball[row][col]<10) System.out.print("0"+ball[row][col]+"\t");
					else System.out.print(ball[row][col]+"\t");
				}
			}
			System.out.println("--------------------------"); 
			System.out.println("TOTAL DRAWN NUMBERS: "+counter);

			done=1;
			for(row=0;row<5;row++){
				for(col=0;col<5;col++)
					if(bingo[row][col]==1&&bingo[row][col]!=mark[row][col]) done=0;
			}

			if(done==0){
				try{
					System.out.print("\nInput DRAWN NUMBER: ");
					num=Integer.parseInt(br.readLine());
					if(num>=1&&num<=15)col=0;
					else if(num>=16&&num<=30)col=1;
					else if(num>=31&&num<=45)col=2;
					else if(num>=46&&num<=60)col=3;
					else if(num>=61&&num<=75)col=4;
					else{
						System.out.println("Input must be from 1 to 75 only...");
						continue;
					}

					for(row=0;row<15;row++){
						if(ball[row][col]==num){
							System.out.println(""+num+" already exist in DRAWN NUMBERS...");
							break;
						}
						else if(ball[row][col]==0){
							ball[row][col]=num;
							counter++;
							break;
						}
					}

					for(row=0;row<5;row++){
						if(card[row][col]==num&&mark[row][col]==0){
							mark[row][col]=1;
							break;
						}
					}
				}catch(NumberFormatException e){System.out.println("Input must be an Integer");}
			}
		}while(done==0);
		System.out.println("BINGO!");
		System.out.println("LAST DRAWN NUMBER: "+num);
		System.out.print("WINNING NYMBERS: ");
		for(col=0;col<5;col++){
			for(row=0;row<5;row++){
				if(row==2&&col==2) continue;
				if(bingo[row][col]==1&&bingo[row][col]==mark[row][col]) System.out.print(card[row][col]+" ");
			}
		} 
		System.out.println();
	}
}
