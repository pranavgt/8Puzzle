/******************************************************************************
 *  Name:   Pranav Guhathakurta
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

14. 2 Project Content and Submission - 8 Puzzle
Write a program to solve the 8-puzzle problem (and its natural generalizations) using the A* search algorithm.

/******************************************************************************
 *  Explain briefly how you implemented the Board data type.
 *****************************************************************************/

There are three instance variables in total. The dimension of the problem is stored in dimension.
The position of space in the block array is recorded by transforming the 2D input matrix into a 1D array and storing it in block blank.
Methods that return the number of blocks out of place and the total of Manhattan distances between blocks and target are available.
There are a few ways to tell if the board is the goal board.
I also provide a mechanism for comparing two boards, as well as a method for generating all conceivable boards by swapping the blank space.
To allow the board to be printed, I use the toString method.
I came up with three different helpful methods. A method for converting a one-dimensional array to a two-dimensional array.
In 1D, a method returns the row and column position of a value.


/******************************************************************************
 *  Explain briefly how you represented a search node
 *  (board + number of moves + previous search node).
 *****************************************************************************/

A search node has four instance variables.
The board in the node is represented by a board.
The total of moves + hamming or Manhattan of the board, as well as a reference to the 
previous node, represents how many moves we need to take to acquire the board priority.




/******************************************************************************
 *  Explain briefly how you detected unsolvable puzzles.
 *
 *  What is the order of growth of the running time of your isSolvable()
 *  method as function of the board size n? Recall that with order-of-growth
 *  notation, you should discard leading coefficients and lower-order terms,
 *  e.g., n log n or n^3.

 *****************************************************************************/

Description:

I count how many inverse pairs of numbers there are.
Because each move can modify two inverses in a puzzle with an odd number of inverses, 
the puzzle is unsolvable if it has an odd number of inverses and solvable if it has an even number of inverses.

If the number of inverses plus the row of blank space is an odd number for a puzzle with an even dimension, it is solvable.
It is insolvable if the number of inverses plus the row of blank space is an even number.

Order of growth of running time:

The order of growth is n^4. There are 2 for loops. Each loop is looping for n*n times. 
n^2*n^2 = n^4

/******************************************************************************
 *  For each of the following instances, give the minimum number of moves to
 *  solve the instance (as reported by your program). Also, give the amount
 *  of time your program takes with both the Hamming and Manhattan priority
 *  functions. If your program can't solve the instance in a reasonable
 *  amount of time (say, 5 minutes) or memory, indicate that instead. Note
 *  that your program may be able to solve puzzle[xx].txt even if it can't
 *  solve puzzle[yy].txt even if xx > yy.
 *****************************************************************************/


                 min number          seconds
     instance     of moves     Hamming     Manhattan
   ------------  ----------   ----------   ----------
   puzzle28.txt    28          0.740            0.596
   puzzle30.txt    30          1.131            0.487
   puzzle32.txt    32          43.212           1.192
   puzzle34.txt    34   running time too long, out of memory     0.931
   puzzle36.txt    36   running time too long, out of memory     2.210
   puzzle38.txt    38   running time too long, out of memory     7.603
   puzzle40.txt    40   running time too long, out of memory     1.399
   puzzle42.txt    42   running time too long, out of memory     3.786



/******************************************************************************
 *  If you wanted to solve random 4-by-4 or 5-by-5 puzzles, which
 *  would you prefer: a faster computer (say, 2x as fast), more memory
 *  (say 2x as much), a better priority queue (say, 2x as fast),
 *  or a better priority function (say, one on the order of improvement
 *  from Hamming to Manhattan)? Why?
 *****************************************************************************/


With a better priority function, the program can choose boards more quickly and with less memory. 
We'll be able to check for fewer boards than we can with the current program. 
So I prefer a better priority function. 



/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/

No bugs

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/


From watcing the videos. 


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/

None

/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/

I did not have a a partner





/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
Spent a lot of time!
