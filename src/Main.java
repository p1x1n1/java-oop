import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            LinkedList<undead> undeads = new LinkedList<>();
            LinkedList<vampire> vampires = new LinkedList<>();
            LinkedList<wizard> wizards = new LinkedList<>();
            boolean b = true;
            while (b){
                System.out.println("Выберите действие: \n" +
                        "1.Создать персонажа \n"+
                        "2.Посмотреть клан \n"+
                        "3.Тест способностей");
                Scanner sc = new Scanner(System.in);
                int i = sc.nextInt();
                switch (i){
                    case 1:
                        System.out.println("Выберите действие: \n" +
                                "1.Создать вампира \n"+
                                "2.Создать волшебника");
                        i= sc.nextInt();
                        System.out.println("Введите имя:");
                        String name= sc.nextLine();
                        name= sc.nextLine();
                        System.out.println("Введите уровень:");
                        int level = sc.nextInt();
                        System.out.println("Введите количество способности:");
                        int abcnt= sc.nextInt();
                        switch (i) {
                            case 1:
                                vampires.add(new vampire(name,level,abcnt));
                                undeads.add(vampires.peekLast());
                                break;
                            case 2:
                                wizards.add(new wizard(name,level,abcnt));
                                undeads.add(wizards.peekLast());
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Выберите действие: \n" +
                                "1.Посмотреть клан вампиров \n"+
                                "2.Посмотреть клан волшебников \n" +
                                "3.Посмотреть клан нежити");
                        i= sc.nextInt();
                        switch (i) {
                            case 1:
                                System.out.println(vampires);
                                break;
                            case 2:
                                System.out.println(wizards);
                                break;
                            case 3:
                                System.out.println(undeads);
                                break;
                        }
                        break;
                    case 3:
                        for (int j = 0,power; j< undeads.size() ; j++) {
                            System.out.println(undeads.get(j));
                            power = undeads.get(j).use_abilities();
                            System.out.println("с силой: "+power);
                            }
                        break;
                }
                System.out.println("Введите true чтобы продолжить, иначе введите false");
                b= sc.nextBoolean();
            }
            /*
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
            //System.out.println(W1.equals(V1) + " " + W1.equals(W2) + " " + W1.equals(W1) + " " + W1.equals(W4));
            //System.out.println(V1.equals(V3) + " " + V1.equals(V1) + " " + V4.equals(V3));
            */
            //5.2.1
            vampire V1 = new vampire("Kaleb", 2, 40);
            wizard W1 = new wizard("Morgan", 3, 33);

            //out
            FileOutputStream fos = new FileOutputStream("C:\\Users\\1\\OneDrive\\Документы\\вуз\\3 курс\\java\\lab4-OOP-sims\\outputstream.txt");//Класс FileOutputStream создаёт объект класса OutputStream, который можно использовать для записи байтов в файл.
            UndeadOutput.output_undead(W1,fos);
            //W1.output(fos);

            //write
            File file = new File("C:\\Users\\1\\OneDrive\\Документы\\вуз\\3 курс\\java\\lab4-OOP-sims\\outputwriter.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            UndeadOutput.writeundead(V1,fw);
            //V1.write(fw);

            //read
            Reader reader = new FileReader(file);
            System.out.println();
            undead v= UndeadOutput.readundead(reader);
            System.out.println(v);

            //input
            DataInputStream dis = new DataInputStream(new FileInputStream("C:\\Users\\1\\OneDrive\\Документы\\вуз\\3 курс\\java\\lab4-OOP-sims\\outputstream.txt"));
            v = UndeadOutput.inputundead(dis);
            System.out.println(v);

            //5.2.2
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\1\\OneDrive\\Документы\\вуз\\3 курс\\java\\lab4-OOP-sims\\save.ser");
            FileInputStream inputStream = new FileInputStream("C:\\Users\\1\\OneDrive\\Документы\\вуз\\3 курс\\java\\lab4-OOP-sims\\save.ser");
            UndeadOutput.serializeUndead(V1,outputStream);
            System.out.println(UndeadOutput.deserializeUndead(inputStream));
        }
        catch (wizard.WizardsLevel e) { System.out.println(e.getMessage());}
        catch (vampire.VampiresLevel e) { System.out.println(e.getMessage());}
        catch (IOException e) { System.out.println(e.getMessage());}
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}