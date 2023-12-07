import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class DecoratorUndead implements undead{
    //позволяет динамически добавлять новую функциональность к объектам, не изменяя их исходный код
    undead o;
    public DecoratorUndead(undead o){
        this.o=o;
    }
    public int use_abilities(){
        return o.use_abilities();
    }
    public void output(OutputStream out) throws IOException{
        o.output(out);
    }
    public void write(Writer out)  throws IOException{
        o.write(out);
    }

    public int getLevel_point(){
        return o.getLevel_point();
    }
    public String getName(){
        return o.getName();
    }
    public String[] getAbilities(){
        return o.getAbilities();
    }
    public int getAbilities_count(){
        return o.getAbilities_count();
    }
    public String[] getLevel_name(){
        return o.getLevel_name();
    }
    public int[] getAbilities_damage(){
        return o.getAbilities_damage();
    }
    public int getHealth(){
        return o.getHealth();
    }
    public int getLevel(){
        return o.getLevel();
    }
    public void setName(String name) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Объект нельзя изменять");
    }

    public void setAbilities(String[] abilities){
        throw new UnsupportedOperationException("Объект нельзя изменять");
    }

    public void setAbilities_count(int abilities_count){
        throw new UnsupportedOperationException("Объект нельзя изменять");
    }

    public void setLevel(int level){
        throw new UnsupportedOperationException("Объект нельзя изменять");
    }

    public void setHealth(int health){
        throw new UnsupportedOperationException("Объект нельзя изменять");
    }
}
