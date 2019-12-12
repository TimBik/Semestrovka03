package kpfu.ITIS.Semestrovka1.Java.Daos;

import kpfu.ITIS.Semestrovka1.Java.model.User;

public interface CrudDao<T>{

    void create();
    T find(String by,String eql);
    void update();
    void deleate();
    void save(T model);
}
