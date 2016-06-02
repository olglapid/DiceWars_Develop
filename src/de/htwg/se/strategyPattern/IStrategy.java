package de.htwg.se.strategyPattern;

interface IStrategy { 

    public void executeAlgorithm(); 

} 

class Felderz�hlen implements IStrategy { 

    public void executeAlgorithm() { 
        System.out.println("Concrete Strategy A"); 
    } 

} 

class Wuerfelverteilen implements IStrategy { 

    public void executeAlgorithm() { 
        System.out.println("Concrete Strategy B"); 
    } 

} 
