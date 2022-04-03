public class Solver {
    private Board initial;
    private Board goal;
    private int dimension;
    private MinPQ<SearchNode> queue;
    private class SearchNode implements Comparable<SearchNode> {
        private Board board;
        private int moves;
        private int priority;
        private SearchNode previous;
        public SearchNode(Board board, int moves, SearchNode previous) {
            this.board = board;
            this.moves = moves;
            priority = moves + board.manhattan();
            this.previous = previous;
        }
        public int compareTo(SearchNode temp) {
            return (this.priority - temp.priority);
        }
    }
    public Solver(Board initial){
      if(!initial.isSolvable()) throw new java.lang.IllegalArgumentException("Puzzle Not Solvable");
      if(initial == null) throw new  NullPointerException();
      this.initial = initial;
      dimension = initial.size();
      queue = new MinPQ<SearchNode>();
      int[][] GoalBoard = new int[dimension][dimension];
      int temp = 1 ;
      for (int i = 0; i < dimension; i++){
        for (int j = 0; j < dimension; j++) {
          GoalBoard[i][j] = temp;
          temp++;
        }
      }
        GoalBoard[dimension-1][dimension-1] = 0;
        goal = new Board(GoalBoard);
        SearchNode PriorityNode;
        queue.insert(new SearchNode(initial, 0, null));
        while(!queue.min().board.equals(goal)) {
            PriorityNode = queue.min();
            queue.delMin();
            for (Board neighbor: PriorityNode.board.neighbors()) {
                if (PriorityNode.moves == 0 ||!neighbor.equals(PriorityNode.previous.board) ) {
                    queue.insert(new SearchNode(neighbor, PriorityNode.moves+1, PriorityNode));
                }
            }
          }
      
    }           // find a solution to the initial board (using the A* algorithm)
    public int moves(){
      if (!initial.isSolvable()) return -1;
      return queue.min().moves;
    }                     // min number of moves to solve initial board
    public Iterable<Board> solution(){
      if(!initial.isSolvable()) return null;
      Stack<Board> steps = new Stack<Board>();
      SearchNode temp = queue.min();
      while (temp.previous!=null) {
            steps.push(temp.board);
            temp = temp.previous;
        }
      steps.push(initial);
      return steps;
    }      // sequence of boards in a shortest solution
    public static void main(String[] args){} // solve a slider puzzle (given below) 
}