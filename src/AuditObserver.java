public class AuditObserver implements Observer {

    private Dispatcher dispatcher;

    public AuditObserver(Dispatcher dispatcher){
        this.dispatcher = dispatcher;
        dispatcher.registerObserver(this);
    }

    @Override
    public void update(Message message) {
        getAuditChain().logProcess(AuditModule.FILTER,message);
    }

    private AuditModule getAuditChain() {
        AuditModule messageFilter = new AuditFilter(AuditModule.FILTER);
        messageFilter.nextAuditModule(null);
        return messageFilter;
    }

}
