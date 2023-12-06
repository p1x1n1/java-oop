import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public interface undead {
    int use_abilities();
    //5.2
    void output(OutputStream out) throws IOException;
    void write(Writer out)  throws IOException;


    int getLevel_point();
    void setName(String name);
    String getName();
    void setAbilities(String[] abilities);
    String[] getAbilities();
    int getAbilities_count();
    void setAbilities_count(int abilities_count);
    int getLevel();
    void setLevel(int level);
    String[] getLevel_name();
    int[] getAbilities_damage();
    int getHealth();
    void setHealth(int health);
}
// void setLevel_point(int level_point);
