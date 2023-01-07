package com.whizlab.java.thread;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public static List<Thread> setDogsOnStartLine() {
        Thread vizsla = new Thread(new Dog(), "Hungarian Vizsla");
        Thread weimaraner = new Thread(new Dog(), "Weimaraner");
        Thread greyHound = new Thread(new Dog(), "GreyHound");
        Thread borzoi = new Thread(new Dog(), "Borzoi");
        Thread dalmatian = new Thread(new Dog(), "Dalmatian");
        Thread afghanHound = new Thread(new Dog(), "Afghan Hound");
        List<Thread> dogs = new ArrayList<>();
        dogs.add(vizsla);
        dogs.add(weimaraner);
        dogs.add(greyHound);
        dogs.add(borzoi);
        dogs.add(dalmatian);
        dogs.add(afghanHound);
        return dogs;
    }
}
