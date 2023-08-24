package com.company;

public class PrimeNumber {

    public boolean isPrime(int num){
        boolean result = true;
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PrimeNumber pm = new PrimeNumber();
        for(int i=1;i<100000;i++){
            if(pm.isPrime(i)){
                System.out.println(i+" 是质数");
            }

        }
    }
}
