import java.util.Arrays;
import java.util.Objects;

public class vampire implements undead{
    String name;
    int health;

    static String[] abilities = {"Вызвать галлюцинации", "Определение характера","Непреодолимая дремота","Вампирическое обаяние",
            "Сверхъестественная скорость","Вызывать потребности","Вампирическая сила","Создание вампиров"};

    /*String[][] abilities = {{"Вызвать галлюцинации","1"}, {"Определение характера","1"}, {"Непреодолимая дремота","2"},{"Вампирическое обаяние","3"},
            {"Сверхъестественная скорость","3"}, {"Вызывать потребности","4"}, {"Вампирическая сила","4"},  {"Создание вампиров","5"}};*/
    int[] abilities_damage= {1, 1, 2, 3, 3, 4, 4, 5};
    int abilities_count;
    int level;
    static String[] level_name = {"Младший вампир","Опытный вампир","Повелитель вампиров",
    "Великий магистр"};
    int level_point;
    public class VampiresLevel extends Exception {

        public VampiresLevel(String message) {
            super(message);
        }
    }
    public class NotInIndex extends RuntimeException {

        public NotInIndex(String message) {
            super(message);
        }
    }
    public vampire(String name,int level,int abcnt) throws VampiresLevel{
        this.name = name;
        if (level>4 || level<1) throw new VampiresLevel("Такого уровня вампира не может быть!");
        this.level = level;
        this.abilities_count = abcnt;
        this.level_point = 0;
        this.health = 100;
    }
    public vampire(){}
    public static void ykys_vampire(){}

    @Override
    public String toString() {
        return "Вампир " +
                 name + '\'' +
                ", Здоровье = " + health +
                ", Количество способностей = " + abilities_count +
                ", " + level + " уровень " + level_name[level] +
                ", Прогресс уровня = " + level_point ;
    }
    public  int use_abilities() throws NotInIndex {

        int use=(int) (Math.random()*(this.level+1));
        if (use>=8) throw new NotInIndex("Выход за пределы");
        this.level_point+=this.abilities_damage[use];
        if (this.level_point>200 && this.level<4) {this.level++;this.level_point-=200;};
        System.out.println(this.abilities[use]);
        return this.abilities_damage[use];
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        vampire vampire = (vampire) o;
        return health == vampire.health && abilities_count == vampire.abilities_count && level == vampire.level && Objects.equals(name, vampire.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, abilities_count, level);
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAbilities() {
        return abilities;
    }

    public void setAbilities(String[] abilities) {
        this.abilities = abilities;
    }

    public int getAbilities_count() {
        return abilities_count;
    }

    public void setAbilities_count(int abilities_count) {
        this.abilities_count = abilities_count;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String[] getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String[] level_name) {
        this.level_name = level_name;
    }

    public int getLevel_point() {
        return level_point;
    }

    /*public void setLevel_point(int level_point) {
        this.level_point = level_point;
    }
    */
}
