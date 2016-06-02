package de.htwg.se.strategyPattern;


public class Context { 

    // Instanzvariable für die Strategy (Komposition) 
    // vom Typ des Interfaces -> Implementierungunabhängigkeit 
    // Defaultverhalten: ConcreteStrategyA 
    private IStrategy _strategy = new ConcreteStrategyA(); 

    public void execute() { 
        //delegiert Verhalten an Strategy-Objekt 
        _strategy.executeAlgorithm(); 
    } 

    public void setStrategy(IStrategy strategy) { 
        _strategy = strategy; 
    } 

    public IStrategy getStrategy() { 
        return _strategy; 
    } 
}
