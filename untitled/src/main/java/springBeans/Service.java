package springBeans;

public class Service {

    private Dao dao;

    public Service(Dao dao){
        this.dao= dao;
    }

    public void test(){
        dao.test();
    }

}
