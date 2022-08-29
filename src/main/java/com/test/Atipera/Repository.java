package com.test.Atipera;

public final class Repository {

    public String name;
    public Owner owner;
    public boolean fork;

    public Repository(String name, Owner owner, boolean fork) {
        this.name = name;
        this.owner = owner;
        this.fork = fork;
    }

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean isFork() {
        return fork;
    }
}
