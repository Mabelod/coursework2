package comexamplecoursework2.service;

import comexamplecoursework2.entity.Question;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int[]array = new int[10];
        System.out.println(Arrays.toString(array));
        int a = 0;
        int b = 3;
        while (true) {
            if (a < b) {
                int number = random.nextInt(0, array.length);
                System.out.println(number);
                a++;
            }
        }
    }
}
