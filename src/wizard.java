import java.io.*;
import java.util.Iterator;
import java.util.Objects;

public class wizard implements undead,Serializable,Iterable<String>{//Serializable Сериализация — это процесс сохранения состояния объекта в последовательность байт.
    @Serial
    private static final long serialVersionUID = 1L;//уникальный идентификатор версии сериализованного класса
    /*
    *  При сериализации объекта сериализуются все объекты, на которые он ссылается в своих переменных экземпляра. И если те объекты тоже ссылаются на третьи объекты, они тоже сериализуются. И так до бесконечности.
    * Все классы в этой цепочке должны быть Serializable, иначе их невозможно будет сериализовать и будет выброшено исключение.
    * Это поле тоже обязательно иначе не получится десерелизовать объект
    * */
    String name;
    int health;
    /*String[][] abilities = {{"Копиато","5"}, {"Обессмертие","5"}, {"Распроклят","4"},
            {"Послушанти","4"},{"Холодрыго","3"},{"Некроценоз","2"},{"Электризз","1"},{"Инферно","1"}};*/
    static String[] abilities = {"Инферно","Электризз","Некроценоз","Холодрыго","Послушанти","Распроклят","Обессмертие","Копиато"};
    transient int[]abilities_damage = {1,1,2,3,4,4,5,5};

    //"Починио","Чиститти","Лакомиццо","Цветтенио",
    //    "Телепортиум","Тираж","Зеленцо","Репатриацио","Обряд вознесения"
   // String[] This_ability;
    int abilities_count;
    int level;
    static String[] level_name={"Подмастерье","Новичок","Приверженец",
    "Эксперт","Знаток","Виртуоз"};
    int level_point;
    String[] info = new String[3];
    @Override
    public Iterator<String> iterator() {
        return new UndeadUterable<>(info);
    }

    public static class WizardsLevel extends Exception {

        public WizardsLevel(String message) {
            super(message);
        }
    }
    public static class NotInIndex extends RuntimeException {

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
        this.info[0] = name;
        this.info[1]= level_name[level];
        this.info[2]= abcnt+"";
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
    //5.2
    public void output(OutputStream out) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        String line = "Wizard"+' '+this.getName()+' '+this.getLevel()+' '+this.getAbilities_count()+' ';
        byte[] buffer = line.getBytes();
        bos.write(buffer);
        bos.writeTo(out);

    }
    public void write(Writer out) throws IOException {
        BufferedWriter bw = new BufferedWriter(out);
        String line = "Wizard"+' '+this.getName()+' '+this.getLevel()+' '+this.getAbilities_count()+' ';
        bw.write(line);
        bw.close();
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

   /* public void setLevel_point(int level_point) {
        this.level_point = level_point;
    }
    */
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
    /*
    public void setAbilities_damage(int[] abilities_damage) {
        this.abilities_damage = abilities_damage;
    }
    */
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


}
