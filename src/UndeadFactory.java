public interface UndeadFactory {
    /*Фабрика — это шаблон проектирования, который помогает решить проблему создания различных объектов в зависимости от некоторых условий
    * */
    undead createInstance();
    undead createInstance(String name,int level,int abcnt) throws vampire.VampiresLevel,wizard.WizardsLevel;
}
