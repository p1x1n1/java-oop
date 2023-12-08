public class WizardFactory implements UndeadFactory{
    @Override
    public undead createInstance() {
        return new wizard();
    }

    @Override
    public undead createInstance(String name, int level, int abcnt) throws wizard.WizardsLevel{
        return new wizard(name,level,abcnt);
    }
}
