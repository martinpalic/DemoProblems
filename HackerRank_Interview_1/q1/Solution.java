package q1;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;


class Result {

    /*
     * Complete the 'featuredProduct' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY products as parameter.
     */

    public static String featuredProduct(List<String> products) {
        HashMap<String, Integer> resolveMap = new HashMap<>();
        List<String> results = new ArrayList<>();
        int topCount = 0;


        for (String item : products) {
            Integer total = resolveMap.get(item);
            if (total == null) {
                resolveMap.put(item, 0);
                continue;
            } else {
                resolveMap.replace(item, ++total);
            }

            if (topCount == total){
                results.add(item);
            }else if(topCount < total){
                topCount = total;
                results.clear();
                results.add(item);
            }
        }
        Collections.sort(results, Collections.reverseOrder());
        return results.get(0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int productsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> products = IntStream.range(0, productsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        String result = Result.featuredProduct(products);


        bufferedReader.close();
    }
}
