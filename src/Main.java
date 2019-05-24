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
import java.util.Iterator;

public class Main {

    public static void main(String[] args){
        ArrayList<Integer> wt1 = new ArrayList<Integer>(Arrays.asList(5, 3, 0, 2, 6, 2, 0, 7, 2, 5));
        System.out.println(warmup1(wt1));
        ArrayList<Integer> wt2 = new ArrayList<Integer>(Arrays.asList(4, 0, 0, 1, 3));
        System.out.println(warmup1(wt2));
        ArrayList<Integer> wt3 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        System.out.println(warmup1(wt3));
        ArrayList<Integer> wt4 = new ArrayList<Integer>(Arrays.asList(0,0,0));
        System.out.println(warmup1(wt4));
        ArrayList<Integer> wt5 = new ArrayList<Integer>(Arrays.asList());
        System.out.println(warmup1(wt5));


    }

    /**
     * Removes all 0s from sequence
     * @param sequence
     * @return
     */
    public static ArrayList<Integer> warmup1(ArrayList<Integer> sequence){


        Iterator itr = sequence.iterator();
        while(itr.hasNext()){
            int x = (int) itr.next();
            if(x==0){
                itr.remove();
            }
        }
        return sequence;
    }


}

