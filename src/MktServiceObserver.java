public class MktServiceObserver implements Observer {

    Dispatcher dispatcher;

    public MktServiceObserver(Dispatcher dispatcher){
        this.dispatcher = dispatcher;
        dispatcher.registerObserver(this);
    }

    @Override
    public void update(Message message) {
        CuponMktService cupon = new CuponMktService();
        cupon.sendAD(Integer.toString(message.getCustomerID()),message.getCustomerEmail());
    }
}
