public abstract class AuditModule{

    public static final int FILTER = 1;
    public static final int FILE = 1;

    protected int level;
    protected AuditModule nextAudit;
    protected static String filePath = System.getProperty("user.dir")+"/src/DEPOSITSTOREVIEW-02212018.txt";

    public void nextAuditModule(AuditModule auditModule){
        this.nextAudit = auditModule;
    }

    public void logProcess(int level, Message message){
        if(this.level <= level){
            processMessage(message);
        }
        if(nextAudit != null){
            nextAudit.logProcess(level,message);
        }
    }
    public abstract void processMessage(Message message);
}
