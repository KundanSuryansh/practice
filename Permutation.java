package com.railticket.Driver;

import java.util.HashMap;

public class Permutation {

    public static String nextPermutation(String s)
    {
        String answer="";
        char ch[]=s.toCharArray();
        int i=ch.length-1;


        //iterate from the right end and find the pointer until the left side number is smaller than right side.
        while(i>0 && ch[i-1]>=ch[i]) {
            i--;
        }

        //if pointer has reached the leftmost side then no next permutation possible..example such as 4321
        if(i<=0)
        {
            answer="NO next permutation";
        }
        else
        {
            int j=ch.length-1;

            //start j pointer from right most and compare with i pointer value and iterate until you find i pointer data smaller than j pointer data.
            while(ch[j]<=ch[i-1])
            {
                j--;
            }

            //swap data of i and j pointer
            char temp=ch[i-1];
            ch[i-1]=ch[j];
            ch[j]=temp;


            j=ch.length-1;

            //arrange the data,which is present after the i pointer in ascending order.
            while(i<j)
            {
                temp=ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
                i++;
                j--;

            }

            answer=String.valueOf(ch);

        }
        return answer;
    }
    public static void main(String[] args) {

        String s="12345";
        System.out.println(s);
        while(true)
        {
            String out=nextPermutation(s);
            if(out.equals("NO next permutation"))
                break;
            System.out.println(out);

            s=out;
        }
    }

}
