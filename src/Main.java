import java.util.Scanner;

class Game{
    int playerHP =15 ;
    String playerWeapon;
    String playerName;
    Scanner myScanner= new Scanner(System.in);
    Scanner enterScanner = new Scanner(System.in);
    int choice;


    public static  void main(String[] args){
        Game game = new Game();
        game.playerSetup();//method without static we can call
        game.townGate();
    }
    public  void playerSetup(){
        playerWeapon ="knife";
        System.out.println("You hp:"+playerHP);
        System.out.println("Your Weapon:"+playerWeapon);
        System.out.println("please enter your name:");
        playerName =myScanner.nextLine();
        System.out.println("Hello "+playerName+"  ,let's start your adventure!");
    }

    public void townGate() {
        System.out.println(" ");
        System.out.println("----------------------------------------------");
        System.out.println(" ");
        System.out.println("you are at the gate of the town");
        System.out.println(" ");
        System.out.println("A guard is standing in front of you");
        System.out.println(" ");
        System.out.println("what is do you want to do?");
        System.out.println(" ");
        System.out.println(" ---------------------------------------------");
        System.out.println(" ");
        System.out.println("1: take to the guard");
        System.out.println("2: attack the guard");
        System.out.println("3: leave");
        System.out.println("Enter you choice");
        choice = myScanner.nextInt();
        if (choice == 1) {
            System.out.println(" Guard:Hello there Stranger.  \nSo your name is " + playerName + " ? \n Sorry but we cannot let Stranger enter our town.");
            enterScanner.nextLine();//
          townGate();
        }
        if(choice == 2){
            playerHP =playerHP-1;
            System.out.println("Guard: Hey don't be Stupid \n The guard hit you so hard and you gave up \n  (Your receive 1 damage)");
            System.out.println("Your HP: "+ playerHP);
            townGate();
        }
        if(choice == 3){
            System.out.println(" ");

        }
    }
}