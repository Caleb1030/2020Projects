import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class GuessWhoRunner{
    //sets up an object of random and an object of scanner to call their functions later
    Random r = new Random();
    Scanner s = new Scanner(System.in);

    //creates the boards so each player has the same characters on their board
    private static Board board1 = new Board();
    private static Board2 board2 = new Board2();
    ///creates all the variables to be used later on
    private boolean p1, win1 = false, win2=false, vsPC;
    private int guess;
    private String p1Char, p2Char, p1GuessChar, p2GuessChar, guessString;
    //creates arrayList to be filled with data as the game is played
    private static ArrayList<String> p1CharInfo = new ArrayList<String>();
    private static ArrayList<String> p2CharInfo = new ArrayList<String>();
    private static ArrayList<String> characters = new ArrayList<String>();
    private static ArrayList<Integer> p1AskedQuestions = new ArrayList<Integer>();
    private static ArrayList<Integer> p2AskedQuestions = new ArrayList<Integer>();
    private static ArrayList<Integer> computerQuestions = new ArrayList<Integer>();
    private static ArrayList<String> p1Questions = new ArrayList<String>();
    private static ArrayList<String> p2Questions = new ArrayList<String>();
    //creates tags allowing the user to input their own questions
    private static String[] questionTags = {"player", "jedi", "droid", "human", "wookie", "dark side", "light sideplay", "bounty", "smuggler", "kessel", "empire", "rebel", "resistance", "first", "seperatist", 
                                            "galactic", "ewok", "fluffy", "slimey", "lightsaber", "tall", "short", "pilot", "annoying", "cute", "bander", "butt", "tauntaun", "living", "limb", "balls" };

    public static void main(String[] args) {
        //board2.setBoard(board1.getBoard());
        //creates the preset questions for backup
        p1Questions.add("1. Guess the opponents character");
        p1Questions.add("2. Is your character a jedi?");
        p1Questions.add("3. Is your character a droid?");
        p1Questions.add("4. Is your character human like?");
        p1Questions.add("5. Is your character a wookie?");
        p1Questions.add("6. Is your character part of the dark side?");
        p1Questions.add("7. Is your character part of the light side?");
        p1Questions.add("8. Is your character a bounty hunter?");
        p1Questions.add("9. Is your character a smuggler?");
        p1Questions.add("10. Does your character has a kessel speed greater than 0?");
        p1Questions.add("11. Is your character part of the empire");
        p1Questions.add("12. Is your character a rebel?");
        p1Questions.add("13. Is your character part of the resistance?");
        p1Questions.add("14. Is your character part of the first order?");
        p1Questions.add("15. Is your character a seperatist?");
        p1Questions.add("16. Is your character part of the Galactic Republic?");
        p1Questions.add("17. Is your character an ewok?");
        p1Questions.add("18. Is your character fluffy?");
        p1Questions.add("19. Is your character slimey?");
        p1Questions.add("20. Does your character have a lightsaber?");
        p1Questions.add("21. Is your character tall?");
        p1Questions.add("22. Is your character short?");
        p1Questions.add("23. Is your character a pilot?");
        p1Questions.add("24. Is your character annoying?");
        p1Questions.add("25. Is your character cute?");
        p1Questions.add("26. Is your character one of Bander's favorites?");
        p1Questions.add("27. Did your character get their butt whooped?");
        p1Questions.add("28. Is your character inside a tauntaun?");
        p1Questions.add("29. Is your character still living?");
        p1Questions.add("30. Did your character lose a limb?");
        p1Questions.add("31. Is your character a space balls character?");
        p2Questions = p1Questions;
        
        /* Test to check
        System.out.println("p1");
        System.out.println(p1Questions);
        System.out.println("p2");
        System.out.println(p2Questions);
        */

        System.out.println(board1.toString());
        System.out.println();
        System.out.println(board2.toString());
        for(Tile[] r: board1.getBoard()){
            for(Tile c: r){
                characters.add(c.getName());
            }
        }
        
        for(int i =0; i<30; i++){
            computerQuestions.add(i);
        }
        GuessWhoRunner game = new GuessWhoRunner();
        game.play();
        //System.out.println(board1.toString());
        System.out.println();
        //System.out.println(board2.toString());
    }

    //main runner for the game, taken from TTT notes
    //runs all the functions for the game while there is no winner
    public void play(){

        gameMenu();
        while(!win1 && !win2){
            makeAMove();
            winning();
            p1= !p1;
        }
        System.out.println(win1 ? "Player 1 Wins" : "Player 2 Wins");
    }

    public void gameMenu(){
        //give the option to for the user on single or two player
        System.out.println("1: for single play\n"+
                           "2: for two players\n"+
                           "3: for quit\n");
        int menuSelection = s.nextInt();
        //finds if the user decided PVC or PVP then lets the user pick its character/characters
        if(menuSelection ==1){
            //used because function is called by game
            System.out.println(characters);
            System.out.print("Player 1 choose your character: ");
            s.nextLine();
            p1Char = s.nextLine();
            p2Char = characters.get(r.nextInt(characters.size()));
            System.out.println("The computer has chosen its character." + p2Char);
            this.vsPC = true;
            setCharInfo(p1Char, p2Char);
            System.out.println("p1Char: " + p1CharInfo);
        }
        else if (menuSelection == 2){
            System.out.println(characters);
            System.out.print("Player 1 choose your character: ");
            s.nextLine();
            p1Char = s.nextLine();
            System.out.println(characters);
            System.out.print("Player 2 choose your character: ");
            p2Char = s.nextLine();
            this.vsPC = false;
            setCharInfo(p1Char, p2Char);
        }
        else{
            System.out.println("Nevermind I guess we aren't playing Guess Who.");
            //the exit() method stops the program, the status tells the JVM why we exited the program
            System.exit(1);
        }
        System.out.println("Press enter to determine who is first (or press enter to begin)");
        String in = s.nextLine();   //stalls the program until I press enter

        setPlayer();
        System.out.println(getPlayer() + " will begin");
        
    }
    /*
        getter and setter to choose which player goes first
    */
    public void setPlayer(){
        //picks a random number(either 1 or 2) for the player to starts
        if(r.nextInt(2)==1){
            p1=true;
        }
        else{
            p1=false;
        }
    }

    //returns what player is actively playing
    public String getPlayer(){
        if(p1){
            return "Player 1";
        }
        else{
            return "Player 2";
        }
    }

    //fills the player 1 and 2 character info array list
    //these lists are used to answer each question yes or no
    public static void setCharInfo(String p1Char, String p2Char){
        for (Tile[] r: board1.getBoard()){
            for (Tile c: r){
                if(c.getName().equals(p1Char)){
                    p1CharInfo = c.getInputArr();
                }
                else if(c.getName().equals(p2Char)){
                    p2CharInfo = c.getInputArr();
                }
            }
        }
    }

    //makeAMove first calls takeMove to get a value for guess
    //once guess is set the program checks if the opponents character is or is not the question asked and updates the board accoringly
    public void makeAMove(){
        takeMove();
        if(p1){
            //when guess is equal to 0 the user is ready to guess a character
            if(guess!= 0){
                if(!p2CharInfo.get(guess).equals("")){
                    board1.updateBoard(guess, false);
                }
                else{
                    board1.updateBoard(guess, true);
                }
            }
            else{
                //allows the user to guess their opponents character 
                System.out.println(board1.toString());
                System.out.print("Enter your guess for player 2's character:");
                p1GuessChar = s.nextLine();
            }
        }
        if(!p1){
            if(guess!= 0){
                if(!p1CharInfo.get(guess).equals("")){
                    board2.updateBoard(guess, false);
                }
                else{
                    board2.updateBoard(guess, true);
                }
            }
            else{
                System.out.println(board2.toString());
                System.out.print("Enter your guess for player 1's character:");
                p2GuessChar = s.nextLine();
            }
        }

    }

    public void takeMove(){
        //this fuction takes the pc's guess randomly out of a list of questions
        if(!p1 && vsPC){
            System.out.println("PC takes a turn");
            guess = computerQuestions.get(r.nextInt(computerQuestions.size()-1));
            computerQuestions.remove(guess);
        }
        //This asks the players to ask their question
        else if(p1){
            System.out.println(board1.toString());
            System.out.println("Player 1's turn.");
            System.out.println("Type in your question to ask(Hint type player when you are ready to guess your opponents character):");
            //System.out.println(p1Questions);
            guess = -1;
            guessString = s.nextLine();
            //this loop goes through a set list of tags to find what attribute the player is asking about
            for(int i=0; i<questionTags.length; i++){
                if(guessString.toLowerCase().contains(questionTags[i])){
                    guess = i;
                }
            }
            //if the question intended to be asked is not found the program uses recursion to try again
            if(p1AskedQuestions.contains(guess) || (guess == -1)){
                System.out.println("You already asked that question. Maybe choose another one. ");
                takeMove();
            }
            //this if statement deals with preset questions
            if (guess!=0){
                p1AskedQuestions.add(guess);
                p1Questions.set(guess, "-");
            }
        }   
        else{
            System.out.println(board2.toString());
            System.out.println("Player 2's turn.");
            System.out.println("Type in your question to ask(Hint type player when you are ready to guess your opponents character): ");
            //System.out.println(p2Questions);
            guess = -1;
            guessString = s.nextLine();
            for(int i=0; i<questionTags.length; i++){
                if(guessString.toLowerCase().contains(questionTags[i])){
                    guess = i;
                }
            }
            
            if(p2AskedQuestions.contains(guess) || (guess == -1)){
                System.out.println("You already asked that question. Maybe choose another one. ");
                takeMove();
            }
            if(guess!=0){
                p2AskedQuestions.add(guess);
                p2Questions.set(guess, "-");
            }
            
        }


    }
    //this function checks to see if there is a winner
    //if it is the players turn and their guess matches their opponents character, they win the game
    public void winning(){
        if(p1 && p2Char.equals(p1GuessChar)){
            win1 = true;
        }
        else if(!p1 && p1Char.equals(p2GuessChar)){
            win2 = true;
        }
        //if you are playing against the computer the computer only wins when it has one character left on its board
        else if(!p1 && vsPC){
            int boardLeft = 0;
            for(Tile[] r: board2.getBoard()){
                for(Tile c: r){
                    if(!c.getName().contains("-")){
                        boardLeft += 1;
                    }
                }
            }
        }
    }
}