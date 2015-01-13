package com.company;

import java.util.Stack;

/**
 * Created by Henry on 2014/12/26.
 */

class Animal{
    public int order;
    public Animal(int ord){
        this.order = ord;
    }
}

class Cat extends Animal{
    public Cat(int ord) {
        super(ord);
    }
}


class Dog extends Animal{
    public Dog(int ord) {
        super(ord);
    }
}

public class animal_shelter_3_7 {
    /*
    An animal shelter holds only dogs and cats, and operates on a strictly "first in,
    first out" basis. People must adopt either the "oldest" (based on arrival time) of
    all animals at the shelter, or they can select whether they would prefer a dog or
    a cat (and will receive the oldest animal of that type). They cannot select which
    specificanimal they would like. Create the data structures to maintain this system
    and implement operations such as enqueue, dequeueAny, dequeueDog and
    dequeueCat.You may use the built-in LinkedList data structure.
    */

    Stack<Cat> cs = new Stack<Cat>();
    Stack<Dog> ds = new Stack<Dog>();
    int order = 0;

    public void enQueue(Animal animal){
        animal.order = order++;
        if(animal instanceof Cat){
            cs.push((Cat) animal);
        }
        else if(animal instanceof Dog){
            ds.push((Dog)animal);
        }
    }

    public Dog dequeueDog(){
        if(ds.isEmpty()){
            return null;
        }
        else{
            return ds.pop();
        }
    }

    public Cat dequeueCat(){
        if(cs.isEmpty()){
            return null;
        }
        else{
            return cs.pop();
        }
    }

    public Animal dequeueAny(){
        if(cs.isEmpty()){
            dequeueDog();
        }
        else if(ds.isEmpty()){
            dequeueCat();
        }

        if(cs.peek().order>ds.peek().order){
            return cs.pop();
        }
        else{
            return ds.pop();
        }

    }

}
