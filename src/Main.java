import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final int phase1 = 1;
        final int phase2 = 2;

        long u1Cost;
        long u2Cost;
        int phase1Rockets;
        int phase2Rockets;

        ArrayList<Item> phase1Item;
        ArrayList<Item> phase2Item;

        Simulation simulation = new Simulation();

        System.out.println("LOADING....................");
        phase1Item = simulation.loadItems(phase1);

        
        System.out.println("=====Simulating Phase 1=====Simulating Phase 1=====Simulating Phase 1=====");
        simulation.runSimulation(simulation.loadU1(phase1Item), 1);
        System.out.println("=====Simulation Done=====Simulation Done=====Simulation Done=====\n");
        phase1Rockets = U1.getRocketU1Counter();
        System.out.println("Rockets used for phase 1: " + phase1Rockets);

        System.out.println("A total of " + U1.getRocketU1Counter() + " U1 rockets was used.");
        u1Cost = totalCost(1);

        
        System.out.println("=====Simulating Phase 1=====Simulating Phase 1=====Simulating Phase 1=====");
        simulation.runSimulation(simulation.loadU2(phase1Item), 2);
        System.out.println("=====Simulation Done=====Simulation Done=====Simulation Done=====\n");
        phase1Rockets = U2.getRocketU2Counter();
        System.out.println("Rockets used for phase 1: " + phase1Rockets);

        System.out.println("A total of " + U2.getRocketU2Counter() + " U2 rockets was used." + "\n");
        u2Cost = totalCost(2);

        System.out.println("\nTotal budget needed for U1 rockets is: " + u1Cost);
        System.out.println("Total budget needed for U2 rockets is: " + u2Cost);

        if (u1Cost > u2Cost) {
            System.out.println("Using U2 rockets is cheaper in this simulation");
        } else {
            System.out.println("Using U1 rockets is cheaper in this simulation");
        }

    }

    public static long totalCost(int i) {
        return (i == 1) ? U1.getTotalCost() : U2.getTotalCost();
    }
}
