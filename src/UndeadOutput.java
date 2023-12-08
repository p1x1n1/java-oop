import java.io.*;

public class UndeadOutput {
    //5.3.5 Factory
    private static UndeadFactory factory = new VampireFactory();

    public static void setFactory(UndeadFactory factory) {
        UndeadOutput.factory = factory;
    }
    public static undead createInstance(){
        return factory.createInstance();
    }
    public static undead createInstance(String name, int level, int abcnt) throws vampire.VampiresLevel,wizard.WizardsLevel{
        return factory.createInstance(name,level,abcnt);
    }
    // записи в байтовый потоk
    public static void output_undead(undead o, OutputStream out) throws IOException {
        o.output(out);
    }
    //- чтения из байтового потока
    public static undead inputundead(InputStream in)  throws IOException , vampire.VampiresLevel,wizard.WizardsLevel{//undead
        //undead u=null;
        String line = new String(in.readAllBytes());
        System.out.println(line);
        String[] parts = line.split(" ");
        if (parts[0].equals("Vampire")) { factory = new VampireFactory();}
        if (parts[0].equals("Wizard")) { factory = new WizardFactory();}
        //u = createInstance(parts[1],Integer.parseInt (parts[2]),Integer.parseInt(parts[3]));
        //return u ;
        return createInstance(parts[1],Integer.parseInt (parts[2]),Integer.parseInt(parts[3]));
    }
    ///- записи в символьный поток
    public static void writeundead (undead o, Writer out) throws IOException{
        o.write(out);
    }
    ///- чтения из символьного потока
    public static undead readundead(Reader in) throws IOException , vampire.VampiresLevel,wizard.WizardsLevel {//undead
        BufferedReader bufferedReader = new BufferedReader(in);
        //undead u = null;
        String line = bufferedReader.readLine();
        System.out.println(line);
        bufferedReader.close();
        String[] parts = line. split(" ");
        /*
        if (parts[0].equals("Vampire")) {//u=new vampire(parts[1],Integer.parseInt (parts[2]),Integer.parseInt(parts[3]));}
        if (parts[0].equals("Wizard")) {u=new wizard(parts[1],Integer.parseInt (parts[2]),Integer.parseInt(parts[3])); }
        */
        if (parts[0].equals("Vampire")) { factory = new VampireFactory();}
        if (parts[0].equals("Wizard")) { factory = new WizardFactory();}
        return createInstance(parts[1],Integer.parseInt (parts[2]),Integer.parseInt(parts[3]));
    }
    public static  void serializeUndead(undead o,OutputStream out) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);//преобразует объекты в байты
        objectOutputStream.writeObject(o);
        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();

    }
    public static  undead deserializeUndead(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        undead u = (undead) objectInputStream.readObject();
        return u;
    }

    //5.3.3
    public static undead unmodifiableUndead(undead o){
        return new DecoratorUndead(o);
    }

}
