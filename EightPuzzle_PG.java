import java.util.Scanner;
class EightPuzzle_PG {
  public static void main(String[] args) {
    System.out.println("Program now starts!");
    Scanner sc = new Scanner(System.in);
    System.out.println(" Enter Dimension Size ! ");
    int dimension = Integer.parseInt(sc.nextLine());
    int [][] block = new int [dimension][dimension];
    System.out.println(" Dimensions Entered Now Enter the numbers ! ");
    Stopwatch sw = new Stopwatch();
    for (int i = 0; i < dimension; i++){
      //System.out.println("Inside first loop");
        for (int j = 0; j < dimension; j++)
          {//System.out.println("Inside second loop");
            block[i][j] = sc.nextInt();}
    }
    //System.out.println("Numbers Entered! Computing");
    Board initial = new Board(block);
    if (!initial.isSolvable()) System.out.println("No solution possible");
    else {
      Solver sol = new Solver(initial);
      System.out.println("Minimum number of moves = " + sol.moves());
      for (Board b : sol.solution()){
        System.out.println(b);
      }
    }
    System.out.println("running time: "+sw.elapsedTime());
  }
}