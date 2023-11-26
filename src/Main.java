import java.util.LinkedList;
//import java.io.IOException;
public class Main {

    public static void main(String[] args) {
        try {
            vampire V1 = new vampire("Kaleb", 2, 40);
            vampire V2 = new vampire("Lilit", 2, 36);
            vampire V3 = new vampire("Vladislavus", 2, 56);

            wizard W1 = new wizard("Morgan", 3, 33);
            wizard W2 = new wizard("Faba", 4, 43);
            wizard W3 = new wizard("Ozervald", 5, 55);

            //equals
            wizard W4 = new wizard("Morgan", 3, 33);
            vampire V4 = new vampire("Vladislavus", 2, 56);
            //exception
            //vampire V5 = new vampire("Drak",7,22);
            //wizard W5 = new wizard("Merlin",-1,222);
            //
            undead[] undeads = {V1, W1, V2, W2, V3, W3};
            LinkedList<undead> undeads_abilities_strong = new LinkedList<>();
            //
            vampire[] vampires = new vampire[3];
            wizard[] wizards = new wizard[3];
            //
            for (int i = 0, v = 0, w = 0, power; i < 6; i++) {
                //1 ,2
                power = undeads[i].use_abilities();
                if (power > 2) undeads_abilities_strong.addLast(undeads[i]);
                System.out.println(undeads[i]);
                //3
                if (undeads[i].getClass() == vampire.class) {
                    vampires[v] = (vampire) undeads[i];
                    v++;
                }
                if (undeads[i].getClass() == wizard.class) {
                    wizards[w] = (wizard) undeads[i];
                    w++;
                }
            }
            System.out.println(undeads_abilities_strong);
            //equals
            System.out.println(W1.equals(V1) + " " + W1.equals(W2) + " " + W1.equals(W1) + " " + W1.equals(W4));
            System.out.println(V1.equals(V3) + " " + V1.equals(V1) + " " + V4.equals(V3));
        }
        catch (wizard.WizardsLevel e) {
            System.out.println(e.getMessage());
        }
        catch (vampire.VampiresLevel e) {
            System.out.println(e.getMessage());
        }
    }
}