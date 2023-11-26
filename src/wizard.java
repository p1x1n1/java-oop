import java.util.Objects;

public class wizard implements undead{
    String name;
    int health;
    /*String[][] abilities = {{"Копиато","5"}, {"Обессмертие","5"}, {"Распроклят","4"},
            {"Послушанти","4"},{"Холодрыго","3"},{"Некроценоз","2"},{"Электризз","1"},{"Инферно","1"}};*/
    static String[] abilities = {"Инферно","Электризз","Некроценоз","Холодрыго","Послушанти","Распроклят","Обессмертие","Копиато"};
    int[]abilities_damage = {1,1,2,3,4,4,5,5};

    //"Починио","Чиститти","Лакомиццо","Цветтенио",
    //    "Телепортиум","Тираж","Зеленцо","Репатриацио","Обряд вознесения"
   // String[] This_ability;
    int abilities_count;
    int level;
    static String[] level_name={"Подмастерье","Новичок","Приверженец",
    "Эксперт","Знаток","Виртуоз"};
    int level_point;
    public class WizardsLevel extends Exception {

        public WizardsLevel(String message) {
            super(message);
        }
    }
    public class NotInIndex extends RuntimeException {

        public NotInIndex(String message) {
            super(message);
        }
    }
    public wizard(String name,int level,int abcnt) throws WizardsLevel{
        this.name = name;
        if (level>6 || level<1) throw new WizardsLevel("Такого уровня вошлебника не может быть!");
        this.level = level;
        this.abilities_count = abcnt;
        this.level_point = 0;
        this.health = 100;
    }
    public wizard(){}
    //````````````````````````````````````````````````````````````````````
    public  int use_abilities() throws NotInIndex{
        int use=(int) (Math.random()*(this.level+1));
        if (use>=8) throw new NotInIndex("Выход за пределы");
        this.level_point+=this.abilities_damage[use];
        if (this.level_point>100 && this.level<6) {this.level++;this.level_point-=100;};
        System.out.println(this.abilities[use]);
        return this.abilities_damage[use];
    }
    @Override
    public String toString() {
        return "Чародей " +
                name + '\'' +
                ", Здоровье = " + health +
                ", Количество способностей = " + abilities_count +
                ", " + level + " уровень " + level_name[level] +
                ", Прогресс уровня = " + level_point ;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//сравнение ссылок
        if (o == null || getClass() != o.getClass()) return false;
        wizard wizard = (wizard) o;
        return health == wizard.health && abilities_count == wizard.abilities_count && level == wizard.level && Objects.equals(name, wizard.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, abilities_count, level);
    }

    public int getLevel_point() {
        return level_point;
    }

    public void setLevel_point(int level_point) {
        this.level_point = level_point;
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

    public int[] getAbilities_damage() {
        return abilities_damage;
    }

    public void setAbilities_damage(int[] abilities_damage) {
        this.abilities_damage = abilities_damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setLevel_name(String[] level_name) {
        this.level_name = level_name;
    }
}
