
import java.util.Scanner;

class Game{
    int playerHP =15 ;
    int monsterHP = 15;
    String playerWeapon;
    String playerName;
    Scanner myScanner= new Scanner(System.in);
    Scanner enterScanner = new Scanner(System.in);
    int choice;
    int silverRing;



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
             if(silverRing==1){
               ending();
             }else{
                 System.out.println(" Guard:Hello there Stranger.  \nSo your name is " + playerName + " ? \n Sorry but we cannot let Stranger enter our town.");
                 enterScanner.nextLine();//
                 townGate();
             }

        }
        if(choice == 2){
            playerHP =playerHP-1;
            System.out.println("Guard: Hey don't be Stupid \n The guard hit you so hard and you gave up \n  (Your receive 1 damage)");
            System.out.println("Your HP: "+ playerHP);
            townGate();
        }
        if(choice == 3){
            System.out.println(" ");
           crossRoad();
        }
        else {
            townGate();
        }

    }
    public void crossRoad(){
        System.out.println("\n------------------------------------------");
        System.out.println("You are at a crossroad");
       System.out.println("1:GO north");
       System.out.println("2:GO east");
       System.out.println("3:Go south");
       System.out.println("4:Go west");
       System.out.println("\n------------------------------------------");
        choice = myScanner.nextInt();
        if(choice==1){
            north();
        }
        if(choice==2){
          east();
        }
        if(choice==3){
          townGate();
        }
        if(choice==4){
            west();
        }
        else {
            crossRoad();
        }

    }

    public void north() {
        System.out.println("\n-----------------------------------------");
        System.out.println("there is a river . You drink the water and rest at the riverside");
        System.out.println("You HP is recovered");
        playerHP = playerHP +1;
        System.out.println(" Your HP : " + playerHP);
        System.out.println("\n\n1: GO back to the crossroad");
        System.out.println("\n------------------------------------------");
        choice = myScanner.nextInt();
        if(choice==1){
            crossRoad();
        }
        else {
            north();
        }
    }
    public void east() {
        System.out.println("\n ------------------------------------");
        System.out.println("You walked into a forest and found a long Sword!");
        playerWeapon ="Long Sword";
        System.out.println("\n ------------------------------------");
        System.out.println("\n\n1: GO back to the crossroad");
        System.out.println("\n------------------------------------------");
        choice = myScanner.nextInt();
        if(choice==1){
            crossRoad();
        }
        else {
            north();
        }
    }

    public  void west() {
        System.out.println("\n ------------------------------------");
        System.out.println("you encounter a goblin!");
        System.out.println("1:Fight");
        System.out.println("2:Run");
        System.out.println("\n ------------------------------------");

        choice = myScanner.nextInt();

        if (choice==1){
            fight();

        }
        if(choice==2){
            crossRoad();
        }
        else {
            west();
        }
    }
    public void fight() {
        System.out.println("\n ------------------------------------");
        System.out.println("Your HP " + playerHP);
        System.out.println("Monster HP" + monsterHP);
        System.out.println("\n: Attack");
        System.out.println("2: Run");
        System.out.println("\n ------------------------------------");
        choice = myScanner.nextInt();
        if (choice == 1) {
            attack();
        }
        if (choice == 2) {
            crossRoad();
        } else {
            fight();
        }
    }
    public void attack(){
        int playerDamage =0;

        if(playerWeapon.equals("knife")) {
            playerDamage =new java.util.Random().nextInt(5);
        }
        if (playerWeapon.equals("Long Sword")){
            playerDamage =new java.util.Random().nextInt(8);
        }
        System.out.println("you attacked the monster and gave " + playerDamage + "Damage!" );

        monsterHP =monsterHP - playerDamage;

        System.out.println("Monster HP"+monsterHP);
        if (monsterHP<1){
            win();
        }
        if (monsterHP>0){
            int monsterDamage =0;
            monsterDamage =new java.util.Random().nextInt(4);

            System.out.println("The Monster attacked you and gave"+ monsterDamage + "Damage!");

            System.out.println("Player HP" +playerHP);

            if(playerHP<1){
                dead();
            }
            if (playerHP>0){
                fight();
            }
        }
    }

    public void dead(){
        System.out.println("\n--------------------------------\n");
        System.out.println("\n--------------------------------\n");
        System.out.println("you are dead!!");
        System.out.println("\n GAME OVER");
        System.out.println("\n--------------------------------\n");
        System.out.println("\n--------------------------------\n");
    }
    public void win(){
        System.out.println("\n-------------------------------\n");
        System.out.println("You killed the Monster");
        System.out.println("the monster dropped a ring!");
        System.out.println("you obtained a silver ring!\n\n");
        System.out.println("1: Go east");
        System.out.println("\n-------------------------------\n");
        silverRing =1;
        choice = myScanner.nextInt();
        if(choice==1){
            crossRoad();
        }
        else {
            win();
        }

        }
    public void ending() {
        System.out.println("\n-------------------------------\n");
        System.out.println(" Guard: oh you killed that goblin?? Great");
        System.out.println("Guard : it seems you are a trustworthy guy Welcome  to our town!");
        System.out.println("\n\n");
        System.out.println("\n-------------------------------\n");

    }
    }
