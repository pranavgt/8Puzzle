import java.lang.Math;
import java.util.Arrays;
public class Board {
    private int dimension;
    private int []block;
    private int blank;
  
    public Board(int[][] blocks){
      dimension = blocks.length;
      block = new int[dimension*dimension];
      int count = 0;
      for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++) {
                block[count] = blocks[i][j];
                if (blocks[i][j] == 0) 
                  blank = count;
                count++;
            }
        }
      
    }           // construct a board from an N-by-N array of blocks
                                           // (where blocks[i][j] = block in row i, column j)
    public int row(int a){
      return a/dimension;
    } // return row

    public int col(int a){
      return a%dimension;
    } // return column
    public int size(){
      return dimension;
    }                      // board size N
    public int hamming(){
     int count = 0;
     int value = 1;
      for(int i =0;i<dimension*dimension;i++){
        if(block[i]!=value && block[i]!=0)
          count++;
        value++;
      }
      return count;
    }                   // number of blocks out of place
    public int manhattan(){
      int count = 0;
      for(int i =0;i<dimension*dimension;i++){
        if(block[i]==0) continue;
        int rd = Math.abs(row(block[i]) - row(i+1)); //row difference
        int cd = Math.abs(col(block[i]) - col(i+1)); //column difference
        count = count+rd+cd;
      }
      return count;
    }                 // sum of Manhattan distances between blocks and goal
    public boolean isGoal() {
      for (int k = 0 ; k < dimension * dimension - 2; k++) {
            if (block[k] > block[k + 1] || block[k]==0) return false;
        }
      return true;
    }               // is this board the goal board?
    public boolean isSolvable(){
      int count =0;
      for (int i = 0; i < dimension*dimension-1; i++){
        for (int j = i + 1; j < dimension*dimension; j++){
            if(block[i]==0 ||block[j]==0) continue;
            if (block[i] > block[j] ) count++;
          }
        }
      if(dimension%2!=0) return count%2==0;
      count+=row(blank);
      //System.out.println(count);
      return count%2==1;
    }            // is this board solvable?
    public boolean equals(Object y) {
      Board tmp = (Board) y;
      return Arrays.equals(this.block, tmp.block);
    }       // does this board equal y?
    public Iterable<Board> neighbors(){
       Stack<Board> neighbors = new Stack<Board>();
        int [] neighbor;
        if(row(blank) != 0) { //swap up
            neighbor = block.clone();
            int temp = neighbor[blank];
            neighbor[blank] = neighbor[blank-dimension];
            neighbor[blank-dimension] = temp;
            Board neighborBoard = new Board(twoD(neighbor));
            neighbors.push(neighborBoard);
        }
        if(row(blank) != dimension-1) { //swap down
            neighbor = block.clone();
            int temp = neighbor[blank];
            neighbor[blank] = neighbor[blank+dimension];
            neighbor[blank+dimension] = temp;
            Board neighborBoard = new Board(twoD(neighbor));
            neighbors.push(neighborBoard);
        }
        if(col(blank) != 0) { //swap left
            neighbor = block.clone();
            int temp = neighbor[blank];
            neighbor[blank] = neighbor[blank-1];
            neighbor[blank-1] = temp;
            Board neighborBoard = new Board(twoD(neighbor));
            neighbors.push(neighborBoard);
        }
        if(col(blank) != dimension-1) { //swap right
            neighbor = block.clone();
            int temp = neighbor[blank];
            neighbor[blank] = neighbor[blank+1];
            neighbor[blank+1] = temp;
            Board neighborBoard = new Board(twoD(neighbor));
            neighbors.push(neighborBoard);
        }
        return neighbors;
    }     // all neighboring boards
    public String toString() {
      String s =Integer.toString(dimension)+"\n";
      int[][]blocks = twoD(block);
      
      for(int i =0;i<dimension;i++){
        for(int j = 0;j<dimension;j++){
          s=s+Integer.toString(blocks[i][j])+" ";
        }
        s=s+"\n";
      }
      return s;
    }              // string representation of this board (in the output format specified below)
   private int[][] twoD(int[] oneD) {
        int k = 0 ;
        int[][] blocks = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++) {
            blocks[i][j] = oneD[k];
            k++;
        }
        return blocks;
    }


    
    public static void main(String[] args){
      
    } // unit tests (not graded)
}