/*
https://www.reddit.com/r/dailyprogrammer/comments/bqy1cf/20190520_challenge_378_easy_the_havelhakimi/
It was a dark and stormy night. Detective Havel and Detective Hakimi arrived at the scene of the crime.

Other than the detectives, there were 10 people present. They asked the first person, "out of the 9 other people here,
 how many had you already met before tonight?" The person answered "5". They asked the same question of the second person,
 who answered "3". And so on. The 10 answers they got from the 10 people were:

5 3 0 2 6 2 0 7 2 5
The detectives looked at the answers carefully and deduced that there was an inconsistency, and that somebody must be lying.
 (For the purpose of this challenge, assume that nobody makes mistakes or forgets, and if X has met Y, that means Y has also
 met X.)

Your challenge for today is, given a sequence of answers to the question "how many of the others had you met before tonight?"
, apply the Havel-Hakimi algorithm to determine whether or not it's possible that everyone was telling the truth.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Main {

    public static void main(String[] args){
        //warmup 1
        ArrayList<Integer> wt1 = new ArrayList<>(Arrays.asList(5, 3, 0, 2, 6, 2, 0, 7, 2, 5));
        System.out.println(warmup1(wt1));
        ArrayList<Integer> wt2 = new ArrayList<>(Arrays.asList(4, 0, 0, 1, 3));
        System.out.println(warmup1(wt2));
        ArrayList<Integer> wt3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(warmup1(wt3));
        ArrayList<Integer> wt4 = new ArrayList<>(Arrays.asList(0, 0, 0));
        System.out.println(warmup1(wt4));
        ArrayList<Integer> wt5 = new ArrayList<>(Collections.emptyList());
        System.out.println(warmup1(wt5));
        //warmup 2
        System.out.println("------------------------");
        ArrayList<Integer> wi1 = new ArrayList<>(Arrays.asList(5, 1, 3, 4, 2));
        System.out.println(warmup2Alt(wi1));
        ArrayList<Integer> wi2 = new ArrayList<>(Arrays.asList(0, 0, 0, 4, 0));
        System.out.println(warmup2Alt(wi2));
        ArrayList<Integer> wi3 = new ArrayList<>(Collections.singletonList(1));
        System.out.println(warmup2Alt(wi3));
        ArrayList<Integer> wi4 = new ArrayList<>(Collections.emptyList());
        System.out.println(warmup2Alt(wi4));
        //warmup 3
        System.out.println("------------------------");
        ArrayList<Integer> wj1 = new ArrayList<>(Arrays.asList(6, 5, 5, 3, 2, 2, 2));
        System.out.println(warmup3(7,wj1));
        ArrayList<Integer> wj2 = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5));
        System.out.println(warmup3(5,wj2));
        ArrayList<Integer> wj3 = new ArrayList<>(Arrays.asList(5, 5, 5, 5));
        System.out.println(warmup3(5,wj3));
        ArrayList<Integer> wj4 = new ArrayList<>(Arrays.asList(1, 1));
        System.out.println(warmup3(3,wj4));
        ArrayList<Integer> wj5 = new ArrayList<>(Collections.emptyList());
        System.out.println(warmup3(1,wj5));
        ArrayList<Integer> wj6 = new ArrayList<>(Collections.emptyList());
        System.out.println(warmup3(0,wj6));
        //warmup 4
        System.out.println("------------------------");
        ArrayList<Integer> wk1 = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        System.out.println(warmup4(4,wk1));
        ArrayList<Integer> wk2 = new ArrayList<>(Arrays.asList(14, 13, 13, 13, 12, 10, 8, 8, 7, 7, 6, 6, 4, 4, 2));
        System.out.println(warmup4(11,wk2));
        ArrayList<Integer> wk3 = new ArrayList<>(Arrays.asList(10, 10, 10));
        System.out.println(warmup4(1,wk3));
        ArrayList<Integer> wk4 = new ArrayList<>(Arrays.asList(10, 10, 10));
        System.out.println(warmup4(3,wk4));
        ArrayList<Integer> wk5 = new ArrayList<>(Collections.singletonList(1));
        System.out.println(warmup4(1,wk5));
        //final task
        System.out.println("------------------------");
        ArrayList<Integer> hh1 = new ArrayList<>(Arrays.asList(5, 3, 0, 2, 6, 2, 0, 7, 2, 5));
        System.out.println(hh(hh1));
        ArrayList<Integer> hh2 = new ArrayList<>(Arrays.asList(4, 2, 0, 1, 5, 0));
        System.out.println(hh(hh2));
        ArrayList<Integer> hh3 = new ArrayList<>(Arrays.asList(3, 1, 2, 3, 1, 0));
        System.out.println(hh(hh3));
        ArrayList<Integer> hh4 = new ArrayList<>(Arrays.asList(16, 9, 9, 15, 9, 7, 9, 11, 17, 11, 4, 9, 12, 14, 14, 12, 17, 0, 3, 16));
        System.out.println(hh(hh4));
        ArrayList<Integer> hh5 = new ArrayList<>(Arrays.asList(14, 10, 17, 13, 4, 8, 6, 7, 13, 13, 17, 18, 8, 17, 2, 14, 6, 4, 7, 12));
        System.out.println(hh(hh5));
        ArrayList<Integer> hh12 = new ArrayList<>(Arrays.asList(15, 18, 6, 13, 12, 4, 4, 14, 1, 6, 18, 2, 6, 16, 0, 9, 10, 7, 12, 3));
        System.out.println(hh(hh12));
        ArrayList<Integer> hh6 = new ArrayList<>(Arrays.asList(6, 0, 10, 10, 10, 5, 8, 3, 0, 14, 16, 2, 13, 1, 2, 13, 6, 15, 5, 1));
        System.out.println(hh(hh6));
        ArrayList<Integer> hh7 = new ArrayList<>(Arrays.asList(2, 2, 0));
        System.out.println(hh(hh7));
        ArrayList<Integer> hh8 = new ArrayList<>(Arrays.asList(3, 2, 1));
        System.out.println(hh(hh8));
        ArrayList<Integer> hh9 = new ArrayList<>(Arrays.asList(1, 1));
        System.out.println(hh(hh9));
        ArrayList<Integer> hh10 = new ArrayList<>(Collections.singletonList(1));
        System.out.println(hh(hh10));
        ArrayList<Integer> hh11 = new ArrayList<>(Collections.emptyList());
        System.out.println(hh(hh11));




    }

    /**
     * Removes all 0s from sequence
     * @param sequence arraylist of the data
     * @return arraylist without any 0s
     */
    private static ArrayList<Integer> warmup1(ArrayList<Integer> sequence){


        Iterator itr = sequence.iterator();
        while(itr.hasNext()){
            int x = (int) itr.next();
            if(x==0){
                itr.remove();
            }
        }
        return sequence;
    }

    /**
     * reverse sort arraylist
     * @param sequence arraylist of the data
     * @return arraylist in reverse sorted
     */
    private static ArrayList<Integer> warmup2(ArrayList<Integer> sequence){
        Collections.sort(sequence);
        Collections.reverse(sequence);
        return sequence;
    }

    /**
     * reverse bubble sort
     * @param sequence arraylist of the data
     * @return arraylist in reverse sorted
     */
    private static ArrayList<Integer> warmup2Alt(ArrayList<Integer> sequence){

        for (int i=0; i<sequence.size();i++){

            for (int j=1; j<sequence.size()-i;j++){
                // if current is bigger than next
                if (sequence.get(j) > sequence.get(j-1)){
                    //swap
                    int temp = sequence.get(j-1);
                    sequence.set(j-1,sequence.get(j));
                    sequence.set(j,temp);
                }
            }

        }

        return sequence;
    }

    /**
     * Given a number N and a sequence of answers, return true if N is greater than the number of answers
     * @param n value to check against
     * @param sequence arraylist of data
     * @return true if n > size of arraylist, false otherwise
     */
    private static boolean warmup3(int n, ArrayList<Integer> sequence){

        return n > sequence.size();
    }

    /**
     * Given a number N and a sequence in descending order, subtract 1 from each of the first N answers in the sequence,
     * and return the result.
     * @param n number of elementss to subtract 1 from
     * @param sequence arraylist of data
     * @return arraylist after operation
     */
    private static ArrayList<Integer> warmup4(int n, ArrayList<Integer> sequence){

        for (int i = 0; i<n; i++){
            sequence.set(i,sequence.get(i)-1);
        }
        return sequence;
    }

    /**
     * Perform the Havel-Hakimi algorithm on a given sequence of answers. This algorithm will
     * return true if the answers are consistent (i.e. it's possible that everyone is telling the truth) and
     * false if the answers are inconsistent (i.e. someone must be lying):
     * @param sequence arraylist of data
     * @return true if answers consistent according to algorithm, false otherwise
     */
    private static boolean hh(ArrayList<Integer> sequence){
        //1. Remove all 0s from sequence
        sequence = warmup1(sequence);
        //2. if sequence is empty return true
        if (sequence.isEmpty()){
            return true;
        }
        //3. Sort the sequence in descending order
        sequence=warmup2(sequence);
        //4. Remove the first answer (largest) from sequence and call it n
        int n = sequence.get(0);
        sequence.remove(0);
        //5. If n is greater than the length of new sequence return false
        if(warmup3(n,sequence)){
            return false;
        }
        //6. Subtract 1 from each of the first n elements
        sequence = warmup4(n,sequence);
        //7. Continue from step 1
        return hh(sequence);
        // eventually will either return true in step 2 or false in step 5
    }



}

