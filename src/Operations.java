public class Operations {

    public void sendCupon(Message message) {
        CuponMktService cupon = new CuponMktService();
        cupon.sendAD(Integer.toString(message.getCustomerID()),message.getCustomerEmail());
    }

    public void sendMessage(Message message){
        getAuditChain().logProcess(AuditModule.TT_DEPOSIT_TV_10000,message);
    }

    private AuditModule getAuditChain() {
        AuditModule depositOverTenthousand = new AuditDeposit(AuditModule.TT_DEPOSIT_TV_10000);
        depositOverTenthousand.nextAuditModule(null);
        return depositOverTenthousand;
    }
}
