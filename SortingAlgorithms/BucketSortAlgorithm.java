package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

//hashing
public class BucketSortAlgorithm {
    public static void main(String[] args) {
        float arr[] = {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};

        ArrayList<Float> res1 = bucketSort1(arr);
        System.out.println("Res1 : "+res1);
        System.out.println("****************************************************************************");

        ArrayList<Float> res2 = bucketSort2(arr);
        System.out.println("Res1 : "+res2);
        System.out.println("****************************************************************************");

    }

    private static float findMax(float[] arr) {
        float maximum = Float.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maximum = Math.max(maximum, arr[i]);
        }
        return maximum;
    }

    private static ArrayList<Float> bucketSort1(float[] arr) {
        if (arr.length == 0){
            return new ArrayList<>();
        }

        //find the bucket size
        float maxElement = findMax(arr);
        int maxIndex = (int) (maxElement * arr.length);
        int bucketSize = maxIndex + 1;

        //Init Bucket List
        ArrayList<Float> buckets[] = new ArrayList[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new ArrayList<>();
        }

        //Insert element into the bucket
        for (int i = 0; i < arr.length; i++) {
            int index = (int) (arr[i] * arr.length);
            buckets[index].add(arr[i]);
        }

        //sort the buckets
        for (int i = 0; i < bucketSize; i++) {
            Collections.sort(buckets[i]);
        }

        //store the elements into result list
        ArrayList<Float> res = new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) {
            System.out.println("Buckets["+i+"] -> "+buckets[i]);
            for (Float element : buckets[i]){   //0
                res.add(element);
            }
        }

        return res;
    }

    private static ArrayList<Float> bucketSort2(float[] arr) {
        if (arr.length == 0){
            return new ArrayList<>();
        }

        //find the bucket size
        float maxElement = findMax(arr);
        int maxIndex = (int) (maxElement * arr.length);
        int bucketSize = maxIndex + 1;

        //Init Bucket List
        ArrayList<Float> buckets[] = new ArrayList[bucketSize];
        for (int i = 0; i < bucketSize; i++) {  //N
            buckets[i] = new ArrayList<>();
        }

        //Insert element into the bucket
        for (int i = 0; i < arr.length; i++) {  //N^2
            int index = (int) (arr[i] * arr.length);
//            buckets[index].add(arr[i]);
            //Insertion Sort
            int targetIndex = 0;
            while (targetIndex < buckets[index].size() && arr[i] > buckets[index].get(targetIndex)){
                targetIndex++;
            }
            buckets[index].add(targetIndex, arr[i]);
        }

        //store the elements into result list
        ArrayList<Float> res = new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) {  //N*M+k
            System.out.println("Buckets["+i+"] -> "+buckets[i]);
            for (Float element : buckets[i]){   //0
                res.add(element);
            }
        }

        return res;
    }
}
