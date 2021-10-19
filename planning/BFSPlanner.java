// package planning;
// import representation.*;
// import java.util.*;

// public class BFSPlanner implements Planner{
//     protected Map<Variable, Object> etatInit;
//     protected Set<Action> ensembleAction;
//     protected Goal buts;

//     public BFSPlanner(Map<Variable, Object> etatInit, Set<Action> ensembleAction, Goal buts){
//         this.etatInit = etatInit;
//         this.ensembleAction = ensembleAction;
//         this.buts = buts;
//     }

//     public List<Action> plan(){
//         HashSet<Map<Variable, Object>> closed = new HashSet<Map<Variable, Object>>(this.etatInit);
//         Deque<Map<Variable, Object>> open = new LinkedList<Map<Variable, Object>>(this.etatInit);
//         List<Action> plan = new ArrayList<Action>();
//         HashMap<Map<Variable, Object>, Map<Variable, Object>> father = new HashMap<Map<Variable, Object>, Map<Variable, Object>>();
//         father.put(this.etatInit, null);
//         if(this.etatInit.isSatisfiedBy(this.buts)){
//             return null;
//         }
//         while(!open.isEmpty()){
//             Map<Variable, Object> instantiation= open.pop();
//             closed.push(instantiation);
//             for(Action a : this.ensembleAction){
//                 if(a.isApplicable(instantiation)){
//                     Map<Variable, Object> next= a.successor(instantiation);
//                     if(!((closed.contains(next))&&(open.contains(next)))){
//                         father.put(next, instantiation);
//                         plan.add(a);
//                         if(this.buts.isSatisfiedBy(next)){
//                             return bfs(father,plan);
//                         }
//                         else{
//                             open.addLast(next);
//                         }
//                     }
//                 }
//             }
//         }
//         return null;

//     }
//     public Map<Variable, Object> getInitialState(){
//         return this.etatInit;
//     }
//     public Set<Action> getActions(){
//         return this.ensembleAction;
//     }
//     public Goal getGoal(){
//         return this.buts;
//     }

//     public List<Action> bfs(HashMap<Map<Variable, Object>, Map<Variable, Object>> father, List<Action> plan){
//         return null;
//     }

// }