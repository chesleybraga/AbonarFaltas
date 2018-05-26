package com.uece.status;

public class Repositorio implements IRepository{

    final static private IRepository repositorio = new Repositorio();


    private Repositorio(){

    }

    static public IRepository getInstance(){
        return repositorio;
    }


    @Override
    public IRepository add(Object instance) {
        return null;
    }

    @Override
    public IRepository remove(Object instance) {
        return null;
    }
}
