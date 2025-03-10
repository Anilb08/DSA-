  // #.Kruskal's Algorithm --> 
      /*
      ye algorithm mst find karne me kam aati hai 
      ye Greedy approach ko follow karti hai 
       * 
       */

      import java.util.*;
       public class KruskalAlgo{
        static class Edge implements Comparable<Edge>{
          int src; 
          int dest; 
          int wt; 
          
          public Edge(int s, int d, int w){
            this.src = s; 
            this.dest = d; 
            this.wt = w; 
          }
    
          @Override
          public int compareTo(Edge e2){
            return this.wt - e2.wt;
          }
        }
    
        public static void createGraph(ArrayList<Edge>edges){
          // edges
          edges.add(new Edge(0, 1, 10));
          edges.add(new Edge(0, 2, 15));
          edges.add(new Edge(0, 3, 30));
          edges.add(new Edge(1, 3, 40));
          edges.add(new Edge(2, 3, 50));
    
        }
    
        static int n = 4; 
        static int par[] = new int[n];
        static int rank[] = new int[n];
    
        public static void init(){
          for(int i=0; i<n; i++){
            par[i] = i; 
          }
        }
    
        public static int  find(int x){
          if(par[x] == x){ 
            return x;
          }
          return par[x] = find(par[x]);
        }
    
        public static void union(int a, int b){
          int parA = find(a);
          int parB = find(b);
    
          if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
          } else if(rank[parA] < rank[parB]){
            par[parA] = parB;
          }else{
            par[parB] = parA;
          }
        }
    
        // function for Kruskal's algorithm
        public static void kruskalsMST(ArrayList<Edge>edges, int v){  // tc O(V+ELogE)
          init();
          // step 1. sort the edges
          Collections.sort(edges); //in ascending  O(ElogE)
          int mstCost = 0 ;
          int count = 0; 
    
          for(int i=0; count<v-1; i++){  // O(V)
             Edge e = edges.get(i);
             
             // check if src and dest has same parents or not if same it means they are included in mst and now the comming edge is a cycle
    
             int parA = find(e.src);
             int parB = find(e.dest);
            if (parA != parB) {  // condition for not cycle 
               union(e.src, e.dest);
               mstCost += e.wt;
               count++;
            }
          }
          System.out.println(mstCost);
        }
        public static void main(String[] args) {
          int v = 4; 
          ArrayList<Edge> edges = new ArrayList<>(); 
          createGraph(edges);
          kruskalsMST(edges, v);
        }
      }     
    
    