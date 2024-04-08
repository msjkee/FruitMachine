package griffith;

import java.util.Random;
import java.util.Scanner;

public class FruitMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n" + "Welcome to the Fruit Machine Slot!!! Please indicate your balance: ");
        int balance = input.nextInt();
        if (balance > 0) {
            System.out.println("You are welcome! <3" + "\n");
        }
        else {
            while (balance < 0) {
                System.out.println("Error! Please input correct balance!");
                balance = input.nextInt();
                if (balance > 0) {
                    System.out.println("You are welcome!" + "\n");
                }
            }
        }

        while(true) {
            //Menu
            System.out.println("MENU:" + "\n" +
                    "-----------------------------" + "\n" +
                    "| 1. START GAME             |" + "\n" +
                    "| 2. YOUR BALANCE           |" + "\n" +
                    "| 3. RULES                  |" + "\n" +
                    "| 4. EXIT GAME              |" + "\n" +
                    "-----------------------------");

            int command = input.nextInt();

            //Input different commands
            if (command == 1) {
                balance = Game(balance);
            }
            else if (command == 2) {
                if (balance < 100) {
                    System.out.println("_______________________" + "\n" +
                            " Your balance is " + balance + "€" + "\n" +
                            "‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾" + "\n" +
                            "Sorry, but you do not have enough money to play this slot :(");
                    break;
                }
                else {
                    System.out.println("_______________________" + "\n" +
                            " Your balance is " + balance + "€" + "\n" +
                            "‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
                }
            }
            else if (command == 3) {
                int languageChoice;
                do {
                    System.out.println("Input 1 if you want English language or input 2 if you want Russian language: ");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        input.next(); // consume the invalid input
                    }
                    languageChoice = input.nextInt();
                } while (languageChoice != 1 && languageChoice != 2);

                Rules(languageChoice);
            }
            else if (command == 4) {
                System.out.println("Bye Bye! Have a good day! Comeback later!");
                break;
            }
        }
    }
    //Method for choosing rules (English language or Russian language)
    public static void Rules(int lang_choice) {
        //English rules
        if (lang_choice == 1) {
            System.out.println("\n" + "Fruit Machine Rules: "
            + "\n" + "You pay 100€ for each spin and you win if you have 2-2-2, 3-3-3, 4-4-4, 5-5-5, 6-6-6 and 7-7-7 combinations!" + "\n" +
                    "If you do not see any of these combinations, unfortunately, it means you lose your 100€" + "\n\n" +
                    "Payouts for different combos:" + "\n" +
                    "For 7-7-7 you will get 350€. For 6-6-6 250€. For 5-5-5 200€. For 4-4-4 150€. For 3-3-3 100€. For 2-2-2 50€." + "\n" +
                    "Enjoy it!" + "\n");
        }
        //Russian rules
        else if (lang_choice == 2) {
            System.out.println("\n" + "Правила слот машины: " + "\n" +
                    "Вы платите 100€ за каждый спин и выигрываете в том случае, если видите комбинацию 2-2-2, 3-3-3, 4-4-4, 5-5-5, 6-6-6 и 7-7-7!" + "\n" +
                    "Если вы не видите ни одну из этих комбинаций, к сожалению, вы проиграли 100€" + "\n\n" +
                    "Выплаты за различные комбинации:" + "\n" +
                    "За 7-7-7 вы получите 350€. За 6-6-6 250€. За 5-5-5 200€. За 4-4-4 150€. За 3-3-3 100€.За 2-2-2 50€." + "\n" +
                    "Наслаждайтесь игрой!" + "\n");
        }
    }
    //Method for slot. Checks if the combination is winning, then adds the winnings to the balance. If the combination is losing, it takes money from the balance
    public static int Game(int bal) {
        Scanner input = new Scanner(System.in);
        while (true) {
            //Slot menu
            System.out.println();
            System.out.println("***************************");
            System.out.println("*  Fruit Machine Slot    *");
            System.out.println("*  Your Balance: " + bal + "€  *");
            System.out.println("***************************");
            System.out.println("1. Roll");
            System.out.println("2. Currently balance");
            System.out.println("3. Exit");

            int command = input.nextInt();

            if (command == 1) {
                if (bal < 100) {
                    System.out.println("Sorry, but you do not have enough money for the spin :(");
                    break;
                }
                Random random = new Random();

                int firstNumber = random.nextInt(1,7);
                int secondNumber = random.nextInt(1,7);
                int thirdNumber = random.nextInt(1,7);

                System.out.println("Spinning...");
                System.out.println("Combination: " + firstNumber + "/" + secondNumber + "/" + thirdNumber);

                if (firstNumber == 7 && secondNumber == 7 && thirdNumber == 7) {
                    System.out.println("WOW! Congratulations! You have won a jackpot!");
                    bal += 350;
                    System.out.println("Your balance now is: " + bal + "€");
                }
                else if (firstNumber == 6 && secondNumber == 6 && thirdNumber == 6) {
                    System.out.println("NIIIIICE!");
                    bal += 250;
                    System.out.println("Your balance now is: " + bal + "€");
                }
                else if (firstNumber == 5 && secondNumber == 5 && thirdNumber == 5) {
                    System.out.println("GREAT!");
                    bal += 200;
                    System.out.println("Your balance now is: " + bal + "€");
                }
                else if (firstNumber == 4 && secondNumber == 4 && thirdNumber == 4) {
                    System.out.println("Easiest 150€ ever!");
                    bal += 150;
                    System.out.println("Your balance now is: " + bal + "€");
                }
                else if (firstNumber == 3 && secondNumber == 3 && thirdNumber == 3) {
                    System.out.println("Nothing serious! Just a comeback of yours 100€");
                    bal += 100;
                    System.out.println("Your balance now is: " + bal + "€");
                }
                else if (firstNumber == 2 && secondNumber == 2 && thirdNumber == 2) {
                    System.out.println("Unlucky :( Try the next one!");
                    bal += 50;
                    System.out.println("Your balance now is: " + bal + "€");
                }
                else {
                    bal -= 100;
                    System.out.println("Your balance now is: " + bal + "€");
                }
            }

            if (command == 2) {
                System.out.println("Currently balance is: " + bal + "€");
            }

            if (command == 3) {
                System.out.println("Game is over! You leave with the " + bal + "€");
                break;
            }
        }
        return bal;
    }
}