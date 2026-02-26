package Graph_Data_Structure;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {


        String[][] equationsArr = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queriesArr = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};

        List<List<String>> equations = new ArrayList<>();
        for (String[] eq : equationsArr) {
            equations.add(Arrays.asList(eq));
        }

        List<List<String>> queries = new ArrayList<>();
        for (String[] q : queriesArr) {
            queries.add(Arrays.asList(q));
        }

        double[] calcEquation = calcEquation(equations, values, queries);
        System.out.println("calcEquation : "+Arrays.toString(calcEquation));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //gen adj map
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double res = values[i];
            if (!map.containsKey(dividend)){
                map.put(dividend, new HashMap<String, Double>());
            }
            if (!map.containsKey(divisor)){
                map.put(divisor, new HashMap<String, Double>());
            }
            map.get(dividend).put(divisor, res);
            map.get(divisor).put(dividend, 1/res);

        }
        double []res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if (!map.containsKey(dividend) || !map.containsKey(divisor)){
                res[i] = -1.0;
            }
            else if (dividend.equals(divisor)){
                res[i] = 1.0;
            }
            else {
                HashSet<String> visited = new HashSet<>();
                res[i] = dfs(dividend, divisor, 1, visited, map);
            }
        }
        return res;
    }

    private static double dfs(String src, String target, double prod,
                       HashSet<String> visited,
                       HashMap<String, HashMap<String, Double>> map) {
        double ret = -1;
        visited.add(src);
        if (map.get(src).containsKey(target)){
            ret = map.get(src).get(target)*prod;
        }
        else {
            for (String neighbour : map.get(src).keySet()){
                if (!visited.contains(neighbour)){
//                    prod = prod * map.get(src).get(neighbour);
                    ret = dfs(neighbour, target, prod*map.get(src).get(neighbour), visited, map);
                    if (ret!=-1){
                        break;
                    }
//                    prod = prod / map.get(src).get(neighbour)
                }
            }
        }
        visited.remove(src);
        return ret;
    }
}