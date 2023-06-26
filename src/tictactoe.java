import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class tictactoe {
	static String[] duska;
	static String red;
	
	static String pobeditel() {
		for (int i = 0; i<8; i++) {
			String l = null;
			
			switch(i) {
			case 0:
				l=duska[0]+duska[1]+duska[2];
				break;
			case 1:
			    l=duska[3]+duska[4]+duska[5];
			    break;
			case 2:
				l=duska[6]+duska[7]+duska[8];
				break;
			case 3:
				l=duska[0]+duska[3]+duska[6];
				break;
			case 4:
				l=duska[1]+duska[4]+duska[7];
				break;
			case 5:
				l=duska[2]+duska[5]+duska[8];
				break;
			case 6:
				l=duska[0]+duska[4]+duska[8];
				break;
			case 7:
				l=duska[2]+duska[4]+duska[6];
				break;
			}
			
			if(l.equals("XXX")) {
				return "X";
			}
			
			else if(l.equals("OOO")) {
				return "O";
			}
		}
		
		for (int i = 0; i <9; i++) {
			if(Arrays.asList(duska).contains(String.valueOf(i+1))) {
				break;
			}
			
			else if(i==8) {
				return "na ravno";
			}
		}
		
		System.out.println("Сега е на" + " " + red + " "+"реда; Напиши число"+ red);
		return null;
	}
	
	static void printiraneNaDuska() {
		System.out.println("| " + duska[0] + " | "
                + duska[1] + " | " + duska[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + duska[3] + " | "
                + duska[4] + " | " + duska[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + duska[6] + " | "
                + duska[7] + " | " + duska[8]
                + " |");
	}
	public static void main (String[] args) {
		Scanner scan = new Scanner (System.in);
		duska = new String[9];
		red="X";
		String pobeditel = null;
		
		for (int i = 0; i <9; i++) {
			duska[i]=String.valueOf(i + 1);
		}
		System.out.println("Игра на морски шах");
		printiraneNaDuska();
		
		System.out.println("Първо е Х, въведи число");
		while(pobeditel == null) {
			int n;
			
			try {
				n=scan.nextInt();
				if(!(n>0 && n<=9)) {
					System.out.println("Неправилни данни, опитай пак");
					continue;
				}
			}
			catch
				(InputMismatchException e) {
					System.out.println("Неправилми данни, опитай пак");
					continue;
				}
				if (duska[n-1].equals(String.valueOf(n))) {
					duska[n-1]=red;
			}
				if (red.equals("X")) {
					red = "O";
				}
				else {
					red = "X";
				}
				printiraneNaDuska();
				pobeditel = pobeditel();
		}
			System.out.println("Полето е заето, напиши наново");
	if(pobeditel.equalsIgnoreCase("ravno")) {
		System.out.println("Играта е изравнена, Благодаря ви, че играхте");
	}
	else { 
		System.out.println("ЧЕСТИТО"+ pobeditel);
	}
	scan.close();
	}
}
