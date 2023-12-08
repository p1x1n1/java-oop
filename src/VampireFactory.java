public class VampireFactory implements UndeadFactory{
    @Override
    public undead createInstance() {
        return new vampire();
    }

    @Override
    public undead createInstance(String name, int level, int abcnt) throws vampire.VampiresLevel {
        return new vampire(name,level,abcnt);
    }
}
