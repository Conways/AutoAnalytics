package com.conways.autoanalytics.plugin.click;

import java.util.Arrays;

public class MethodUnit {

    private final int id;

    private final String owner;

    private final String name;

    private final String des;

    private final int agentOpcode;

    private final String agentOwner;

    private final String agentName;

    private final int[] loadOpcodes;

    public MethodUnit(int id, String owner, String name, String des, int agentOpcode, String agentOwner, String agentName, int[] loadOpcodes) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.des = des;
        this.agentOpcode = agentOpcode;
        this.agentOwner = agentOwner;
        this.agentName = agentName;
        this.loadOpcodes = loadOpcodes;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public int getAgentOpcode() {
        return agentOpcode;
    }

    public String getAgentOwner() {
        return agentOwner;
    }

    public String getAgentName() {
        return agentName;
    }

    public int[] getLoadOpcodes() {
        return loadOpcodes;
    }

    @Override
    public String toString() {
        return "MethodUnit{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", agentOpcode=" + agentOpcode +
                ", agentOwner='" + agentOwner + '\'' +
                ", agentName='" + agentName + '\'' +
                ", loadOpcodes=" + Arrays.toString(loadOpcodes) +
                '}';
    }
}
