import java.io.*;

public class UndeadOutput {
    // записи в байтовый потоk
    public static void output_undead(undead o, OutputStream out) throws IOException {
        o.output(out);
    }
    //- чтения из байтового потока 
    public static undead inputundead(InputStream in)  throws IOException , vampire.VampiresLevel,wizard.WizardsLevel{//undead
        undead u = null;
        String line = new String(in.readAllBytes());
        System.out.println(line);
        String[] parts = line.split(" ");
        if (parts[0].equals("Vampire")) {u=new vampire(parts[1],Integer.parseInt (parts[2]),Integer.parseInt(parts[3]));}
        if (parts[0].equals("Wizard")) {u=new wizard(parts[1],Integer.parseInt (parts[2]),Integer.parseInt(parts[3])); }
       // System.out.println(line);
        return u ;
    }
    ///- записи в символьный поток
    public static void writeundead (undead o, Writer out) throws IOException{
        o.write(out);
    }
    ///- чтения из символьного потока
    public static undead readundead(Reader in) throws IOException , vampire.VampiresLevel,wizard.WizardsLevel {//undead
        BufferedReader bufferedReader = new BufferedReader(in);
        undead u = null;
        String line = bufferedReader.readLine();
        System.out.println(line);
        bufferedReader.close();
        String[] parts = line. split(" ");
        if (parts[0].equals("Vampire")) {u=new vampire(parts[1],Integer.parseInt (parts[2]),Integer.parseInt(parts[3]));}
        if (parts[0].equals("Wizard")) {u=new wizard(parts[1],Integer.parseInt (parts[2]),Integer.parseInt(parts[3])); }
        return u;
    }
}
