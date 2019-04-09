/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to find a path to the goal
 */

import java.util.*;

public class Solver {

    public int minMoves = -1;
    private State solutionState;
    private boolean solved = false;
    private State init;
    private List<State> visited = new LinkedList<>();

    /**
     * State class to make the cost calculations simple
     * This class holds a board state and all of its attributes
     */
    private class State {
        // Each state needs to keep track of its cost and the previous state
        private Board board;
        private int moves; // equal to g-cost in A*
        public int cost; // equal to f-cost in A*
        private State prev;

        public State(Board board, int moves, State prev) {
            compy comparator = new compy();
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            // TODO
            cost = board.manhattan() + moves;
            if (prev == null) {
                init = this;
            }
        }

        @Override
        public boolean equals(Object s) {
            if (s == this) return true;
            if (s == null) return false;
            if (!(s instanceof State)) return false;
            return ((State) s).board.equals(this.board);
        }

        private class compy implements Comparator<State> {
            @Override
            public int compare(State lop, State pop) {
                return lop.cost - pop.cost;
            }
        }
    }

    /*
     * Return the root state of a given state
     */
    private State root(State state) {
        // TODO: Your code here
        return init;
    }

    /*
     * A* Solver
     * Find a solution to the initial board using A* to generate the state tree
     * and a identify the shortest path to the the goal state
     */

    public Solver(Board initial) {
        // TODO: Your code here
        solutionState = new State(initial,0,null);
        State.compy vamoos = solutionState.new compy();
        PriorityQueue<State> options = new PriorityQueue(vamoos);
        HashMap<State,State> open = new HashMap<>();
        HashMap<State,State> closed = new HashMap<>();
        if(isSolvable()) {
            while (solutionState.board.manhattan()!=0) {
                System.out.println(options.size());
                if(solutionState.board.isGoal()){
                    return;
                }
                for (Board bitch: solutionState.board.neighbors()) {
                    State bleh = new State(bitch,solutionState.moves+1,solutionState);
                    if(open.containsKey(bleh)){
                        if(open.get(bleh).cost>bleh.cost){
                            closed.put(bleh,open.get(bleh));
                            open.put(bleh,bleh);
                            options.add(bleh);
                            continue;
                        }
                    }
                    else if(closed.containsKey(bleh)){
                        if(closed.get(bleh).cost>bleh.cost){
                            open.put(bleh,bleh);
                            options.add(bleh);
                            continue;
                        }
                    }
                    else {
                        open.put(bleh, bleh);
                        options.add(bleh);
                    }
                }
                if(options.size()>0) {
                    solutionState = options.poll();
                    open.remove(solutionState);
                    closed.put(solutionState,solutionState);
                }
            }
            State temp = new State(new Board(Board.copyOf(solutionState.board.tiles)),solutionState.moves,solutionState.prev);
            while(temp!=null){
                minMoves+=1;
                temp=temp.prev;
            }

        }
    }

    public void  printer(State j){
        for(int[] blo: j.board.tiles){
            for(int k: blo){
                System.out.print(k);
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
     * Is the input board a solvable state
     * Research how to check this without exploring all states
     */
    public boolean isSolvable() {
        // TODO: Your code here
        if(solutionState.board.solvable()){
            return true;
        }
        return false;
    }

    /*
     * Return the sequence of boards in a shortest solution, null if unsolvable
     */
    public Iterable<Board> solution() {
        // TODO: Your code here
        List<Board> steps = new LinkedList<>();
        for (State s: visited){
            steps.add(s.board);
        }
        return steps;
    }

    public State find(Iterable<State> iter, Board b) {
        for (State s : iter) {
            if (s.board.equals(b)) {
                return s;
            }
        }
        return null;
    }

    /*
     * Debugging space
     */
    public static void main(String[] args) {
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board initial = new Board(initState);

        Solver solver = new Solver(initial);
    }


}