import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.io.File;

public class Board2{

    private static Tile board[][] = new Tile[4][6];
    /*{
        {new Tile(), new Tile(), new Tile(),new Tile(), new Tile(), new Tile()},
        {new Tile(), new Tile(), new Tile(),new Tile(), new Tile(), new Tile()},
        {new Tile(), new Tile(), new Tile(),new Tile(), new Tile(), new Tile()},
        {new Tile(), new Tile(), new Tile(),new Tile(), new Tile(), new Tile()}
    };*/
    private ArrayList<Tile> boardItems = new ArrayList<Tile>();
    private ArrayList<String> testList = new ArrayList<String>();
    
    public Board2(){
        //System.out.println("Test One");
        try{
            //System.out.println("Test Two");
            //Scanner loops through the csv file with all the characters and brings in their properties
            Scanner sc = new Scanner(new File("GuessWhoChars.csv"));
            //this is supposed to find the line number to eliminate the first line in the csv with all the titles
            int lineNum =1;
            //System.out.println("Test Three");
            //loops through the csv file
            while(sc.hasNext()){
                if(lineNum>1){
                    //this takes in each line of the csv
                    String temp = sc.nextLine();
                    //System.out.println(temp);
                    //this splits each of the properties into an array
                    String[] info = temp.split(",");
                    //temporary array list
                    ArrayList<String> tempList = new ArrayList<String>();
                    //converts the info array into the templist
                    for (String s: info){
                        tempList.add(s);
                    }
                    //the .split stopped taking in information after the last x so I created this to add blank strings so the arrays with properties were all the same length
                    for(int i= tempList.size(); i<31; i++){
                        tempList.add("");
                    }
                    //System.out.println("Array Length" + info.length);
                    //System.out.println(info);
                    //this creates a Tile arrayList with all of the characters in the csv as the array loops through
                    boardItems.add(new Tile(tempList));
                }
                
                lineNum += 1;
            }

        } catch (Exception e) { System.out.println("Error pulling star wars characters" + e);  }

        //deletes the blank character in the first row of the spreadsheet
        boardItems.remove(0);
        //fills the board with random characters by pulling random characters off the board items list
        int boardNum = 0;
        for (int r=0; r<board.length; r++){
            for(int c=0; c<board[r].length; c++){
                //finds a random index that is less than the size of the board items array
                //int randIndex = (int) (Math.random()*boardItems.size());
                //assigns the tile to the board
                board[r][c] = boardItems.get(boardNum);
                //deletes the character so it will not appear on the board twice
                //boardItems.remove(randIndex);
                boardNum ++;

            }
        }

    }

    public void setBoard(Tile[][] boardIn){
        board = boardIn;
    }

    public Tile[][] getBoard(){
        return board;
    }

   public String toString(){
        String s = "-----------\n";
        for(Tile[] r: board){
            for(Tile c: r){
                s+= ("[" + c.getName() + "] ");
            }
            s+= "\n-----------\n";
        }
    //return string s that is a print out of the board
    return s;
   } 

   public static void updateBoard(int questionAsked, Boolean yesAnswer){
       for(Tile[] r: board){
           for (Tile c: r){
                ArrayList<String> tileCharacteristics = c.getInputArr();
                if(!yesAnswer){
                    if (tileCharacteristics.get(questionAsked).equals("")){
                        c.setName("-------");
                    }
                }
                else{
                    if (!tileCharacteristics.get(questionAsked).equals("")){
                        c.setName("-------");
                    }
                }
                
           }
       }
        

   }
}