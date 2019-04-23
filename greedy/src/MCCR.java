public class MCCR {
        public static int MCCR(EdgeWeightedGraph G) {
            // TODO
          /*
            HashSet<Integer> vertices: set of vertices
            HashSet<Edge>[] edges: array of hashsets of each vertex's edges
            int numberOfV: returns # of vertices
            addEdge(Edge e): adds an edge e and its vertices
            Iterable<Edge> edges(int v): returns all of v's edges
            RETURN THE MINIMUM COST OF THE ROAD
          */
            int cost = 0;
            int[] keys = new int[G.numberOfV()];
            Boolean[] mstBool = new Boolean[G.numberOfV()];
            for(int i=0; i<G.numberOfV(); i++) {
                keys[i] = Integer.MAX_VALUE;
                mstBool[i] = false;
            }
            keys[0] = 0;
            for(int j=0; j<G.numberOfV()-1; j++) {
                int minKey = smolKey(keys, mstBool, G);
                mstBool[minKey] = true;
                Iterable<Edge> e = G.edges(minKey);
                for(Edge k : e) {
                    if(!mstBool[k.other(minKey)]) {
                        keys[k.other(minKey)] = Math.min(keys[k.other(minKey)],k.weight());
                    }
                }
            }
            for(int m=0; m<keys.length; m++) {
                cost += keys[m];
            }

            return cost;
        }

        private static int smolKey(int[] keys, Boolean[] mstBool, EdgeWeightedGraph G) {
            int smol = Integer.MAX_VALUE;
            int mindex = -1;
            for(int i=0; i<G.numberOfV(); i++) {
                if(mstBool[i] == false && keys[i]<smol) {
                    smol = keys[i];
                    mindex = i;
                }
            }
            return mindex;
        }

    }

