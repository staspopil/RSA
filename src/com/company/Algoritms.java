package com.company;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Algoritms {

    ArrayList<Character> Alphabet = new ArrayList<Character>();
    public Algoritms(){
        initAlphabet();
        System.out.println(Alphabet);
    }

    public void initAlphabet(){
        Alphabet.clear();
        for (int i = 97; i<123; i++){
            Alphabet.add((char)i);
        }
    }
    public ArrayList<Long> list = new ArrayList<Long>();
    public ArrayList<Integer> e = new ArrayList<Integer>();
    public ArrayList<Integer> mes = new ArrayList<Integer>();
    public ArrayList<Long> EncryptedMes = new ArrayList<Long>();
    public ArrayList<Character> DecryptedMes = new ArrayList<Character>();
    String s;


    public void ShowIntList(ArrayList<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");

        }
    }

    public void ShowLongList(ArrayList<Long> list) {
        for (Long i : list) {
            System.out.print(i + " ");
        }
    }

    public void ShowCharList(ArrayList<Character> list){
        for (Character i : list) {
            System.out.print(i + " ");
        }
    }

    public void FormList(Long a, int b, int m) {
        s = Integer.toBinaryString(b);
        System.out.println(s);
        list.add(a);
        Long k;
        for (int i = 0; i < s.length(); i++) {
          //  System.out.println(list.get(i)+" "+i);
            k = (list.get(i) * list.get(i)) % m;
            list.add(k);
        }
    }

    public Long FastModPow(Long a, int b, int m) {
        FormList(a, b, m);
        Long res = Long.valueOf(1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                System.out.print(res+"*"+list.get(s.length() - i - 1)+"=");
                res *= list.get(s.length() - i - 1);
                System.out.println(res);
            }
        }
        System.out.println(res % Long.valueOf(m));
        list.clear();
        return res % Long.valueOf(m);
    }

    public int Evclid(int a, int b) {
        int c;
        int k;
        if (a > b) {
            c = b;
            k = a;
        } else {
            c = a;
            k = b;
        }

        int t;
        while (c != 0) {
            t = c;
            c = k % c;
            k = t;
        }
        return k;
    }

    public void EvclidToArray(int b) {
        for (int i = 2; i < b; i++) {
            if (Evclid(i, b) == 1) {
                e.add(i);
            }
        }
    }



    public int getPriaveteExp(int f ,int e){
        int c = gcd(f,e);
        return f+c;
    }

        public int getRandomPublicExp(ArrayList<Integer> num){
         int res =0;
            final Random random = new Random();
            res = random.nextInt(num.size());
            res = num.get(res);
         return res;
        }



    public int RecursEvclid( int x , int y )
    {
        if ( y == 0 )
            return x;
        else if ( x >= y && y > 0)
            return RecursEvclid ( y , x % y );
        else return RecursEvclid ( y , x );
    }


    public void getMessage(String s){
        int k = 0;
        s=s.toLowerCase(Locale.ROOT);
        s=s.replaceAll(" ","");
        for(int i = 0; i < s.length(); i++){
            if(Alphabet.contains(s.charAt(i)))
               k = Alphabet.indexOf(s.charAt(i))+1;
           // mes.add(s.charAt(i));
            mes.add(k);
        }
    }

    public void toEncryptMessage(int b , int m){
        Long k;
        for (Integer c : mes){
            k = FastModPow(Long.valueOf((int)c),b,m);
            System.out.println(Long.valueOf((int)c)+" В Степени "+b+"%"+m+" = "+k);
            System.out.println("-------------");
            EncryptedMes.add(k);
        }
    }

    public void toDecryptMessage(int b, int m){
       long k;
        for(Long c : EncryptedMes){
            k = FastModPow(c,b,m);
            System.out.println(c+" В Степени "+b+"%"+m+" = "+k);
            DecryptedMes.add(Alphabet.get((int)k-1));
        }
    }

    public int gcd(int a, int b){
        ArrayList<Integer> y = new ArrayList<Integer>();
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> q = new ArrayList<Integer>();
        ArrayList<Integer> r = new ArrayList<Integer>();
        x.add(1);
        x.add(0);
        y.add(0);
        y.add(1);
        q.add(null);
        if (a > b) {
            r.add(a);
            r.add(b);
        } else {
            r.add(b);
            r.add(a);
        }
        q.add(r.get(0)/r.get(1));
        int i = 1;
        while(r.get(i)!=1) {
            i++;
        x.add(x.get(i-2)-q.get(i-1)*x.get(i-1));
        y.add(y.get(i-2)-q.get(i-1)*y.get(i-1));
        r.add(r.get(i-2)%r.get(i-1));
        q.add(r.get(i-1)/r.get(i));
        }
        int index = r.size()-1;
        //System.out.println("y="+ y.get(index)+" x="+x.get(index)+"q="+q.get(index));
        return y.get(index);
    }

}