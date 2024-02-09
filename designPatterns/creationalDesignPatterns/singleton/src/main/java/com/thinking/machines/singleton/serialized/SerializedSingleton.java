package com.thinking.machines.singleton.serialized;

import java.io.Serializable;

public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }
    
    /**
     * The problem with serialized singleton class is that whenever 
     * we deserialize it, it will create a new instance of the class. 
     * 
     * So it destroys the singleton pattern. To overcome this scenario,
     * all we need to do is provide the implementation of readResolve() method.
     *
     */
    
    protected Object readResolve() {
        return getInstance();
    }
}