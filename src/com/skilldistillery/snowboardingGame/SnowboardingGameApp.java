package com.skilldistillery.snowboardingGame;

import java.util.Scanner;

public class SnowboardingGameApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		displayMountains();

		startGame();
	}

	public static void startGame() {
		String input;
		boolean go = true;
		while (go) {
			
			System.out.print("  What a beautiful day to snowboard! ");
			System.out.println(Character.toChars(0x1F3C2));
			System.out.print("  Would you like to hit the slopes? type 'Y' for yes or'N' : ");
			input = sc.next();

			if (input.equalsIgnoreCase("Y")) {
				go = false;
				interactGame();
			}
			if (input.equalsIgnoreCase("N")) {
				go = false;
				System.out.println("Goodbye!!!");
			}
		};

		endGame();

	}

	public static void interactGame() {
		Player p = new Player("Player1", 15);
		Pub pub = new Pub();
		Trail t = new Trail();
		OtherGuest og = new OtherGuest();

		Obstacle[] levelNames = new Obstacle[3];
		levelNames[0] = pub;
		levelNames[1] = t;
		levelNames[2] = og;

		System.out.println("\n\t\t\t------------------level 1------------------\n");
		pub.showPub();
		System.out.println("After riding for a while you saw the pub and you decided to stop by. ");
		System.out.println("What would you like to order? Choose from the following: type 1,2,3: ");

		choiceCalculator(p, levelNames[0], "1) Beer\n" + "2) Food\n" + "3) Water\n");

		System.out.println("\n\t\t\t------------------level 2------------------\n");
		t.showTrail();
		System.out.println(
				"You continue down the slope and you come to a fork in the road. Choose your trail difficulty. Type 1,2,3 :  ");
		choiceCalculator(p, levelNames[1], "1) Black\n" + "2) Blue\n" + "3) Green\n");

		System.out.println("\n\t\t\t------------------level 3------------------\n");
		og.showGuest();
		System.out.println("You see another guest guest speeding towards your path.");
		System.out.println("Which direction would like to go? ");
		choiceCalculator(p, levelNames[2], "1) Turn Left\n" + "2) Straigt\n" + "3) Turn right\n");

	}

	public static void choiceCalculator(Player p, Obstacle levelNames, String question) {

		System.out.print(question);
		int userResponseLevel = sc.nextInt();

		if (levelNames instanceof Pub) {
			int counter = 0;
			boolean go = true;
			while (go) {
				responseCalculation(userResponseLevel, p);

				System.out.println("Nice Choice!");
				System.out.println("Would you like more? Type 1,2,3 or 9 for go to next level");
				System.out.println("1) Beer\n" + "2) Food\n" + "3) Water\n");

				userResponseLevel = sc.nextInt();
				counter++;

				if (userResponseLevel == 9) {
					go = false;
					counter = 2;

				} else if (counter == 2) {
					go = false;

				} else {
					//responseCalculation(userResponseLevel, p);

				}
			}

		} else if (levelNames instanceof Trail) {
			System.out.println(p.getHealth() + " current score");
			if (p.getHealth() <= 12) {
				System.out.println(
						"Sorry,You lost the Game! You were too intoxicated! You crashed into a Wild Bear, requiring medical attention!");
				endGame();
			}
			responseCalculation(userResponseLevel, p);

		} else if (levelNames instanceof OtherGuest) {
			if (userResponseLevel == 1) {
				int tempHelth = p.getHealth() - 4;
				p.setHealth(tempHelth);

			} else if (userResponseLevel == 2) {
				System.out.println("Crashed into other guest! You are both in the Hospital!! You lost!");
				endGame();

			} else if (userResponseLevel == 3) {
				System.out.println("Yayyyyyyy you WON !!!");
				displayMedal();
			} else {
				System.out.println("Wrong Choice!");
			}

		} else {
			System.out.println("Wrong choice!!!");
		}

	}

	public static void responseCalculation(int response, Player p) {
		if (response == 1) {
			int tempHelth = p.getHealth() - 2;
			p.setHealth(tempHelth);
			System.out.println("Your health is " + tempHelth);
		} else if (response == 2) {
			int tempHelth = p.getHealth() + 1;
			p.setHealth(tempHelth);
			System.out.println("Your health is " + tempHelth);
		} else {
			int tempHelth = p.getHealth() + 0;
			p.setHealth(tempHelth);
			System.out.println("Your health is " + tempHelth);
		}
	}

	public static void endGame() {
		System.out.println("END");
		System.exit(0);
		sc.close();
	}
	
	public static void displayMountains() {
		System.out.print("\t\t\t\tHello and Welcome to the Death Mountain!!!");
		System.out.println(Character.toChars(0x1F304));
		System.out.print(" \n\n\n");

		System.out.println("                  _\n" + 
				"                     /#\\\n" + 
				"                    /###\\     /\\\n" + 
				"                   /  ###\\   /##\\  /\\\n" + 
				"                  /      #\\ /####\\/##\\\n" + 
				"                 /  /      /   # /  ##\\             _       /\\\n" + 
				"               // //  /\\  /    _/  /  #\\ _         /#\\    _/##\\    /\\\n" + 
				"              // /   /  \\     /   /    #\\ \\      _/###\\_ /   ##\\__/ _\\\n" + 
				"             /  \\   / .. \\   / /   _   { \\ \\   _/       / //    /    \\\\\n" + 
				"     /\\     /    /\\  ...  \\_/   / / \\   } \\ | /  /\\  \\ /  _    /  /    \\ /\\\n" + 
				"  _ /  \\  /// / .\\  ..%:.  /... /\\ . \\ {:  \\\\   /. \\     / \\  /   ___   /  \\\n" + 
				" /.\\ .\\.\\// \\/... \\.::::..... _/..\\ ..\\:|:. .  / .. \\\\  /.. \\    /...\\ /  \\ \\\n" + 
				"/...\\.../..:.\\. ..:::::::..:..... . ...\\{:... / %... \\\\/..%. \\  /./:..\\__   \\\n" + 
				" .:..\\:..:::....:::;;;;;;::::::::.:::::.\\}.....::%.:. \\ .:::. \\/.%:::.:..\\\n" + 
				"::::...:::;;:::::;;;;;;;;;;;;;;:::::;;::{:::::::;;;:..  .:;:... ::;;::::..\n" + 
				";;;;:::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;];;;;;;;;;;::::::;;;;:.::;;;;;;;;:..\n" + 
				";;;;;;;;;;;;;;ii;;;;;;;;;;;;;;;;;;;;;;;;[;;;;;;;;;;;;;;;;;;;;;;:;;;;;;;;;;;;;\n" + 
				";;;;;;;;;;;;;;;;;;;iiiiiiii;;;;;;;;;;;;;;};;ii;;iiii;;;;i;;;;;;;;;;;;;;;ii;;;\n");
		
				System.out.println();
				System.out.println();
}
	public static void displayMedal() {
		System.out.println("@@@@|     |####|\n" + 
				"|@@@@|     |####|\n" + 
				"|@@@@|     |####|\n" + 
				"\\@@@@|     |####/\n" + 
				" \\@@@|     |###/\n" + 
				"  `@@|_____|##'\n" + 
				"       (O)\n" + 
				"    .-'''''-.\n" + 
				"  .'  * * *  `.\n" + 
				" :  *       *  :\n" + 
				": DEATH MOUNTAIN :\n" + 
				": ~ A W A R D ~ :\n" + 
				" :  *       *  :\n" + 
				"  `.  * * *  .'\n" + 
				"    `-.....-'\n");
	}

}
