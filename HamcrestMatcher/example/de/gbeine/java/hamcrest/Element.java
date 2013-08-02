package de.gbeine.java.hamcrest;

public class Element {

    private final String name;
    private final String value;
    
    public Element(final String pName, final String pValue) {
        this.name = pName;
        this.value = pValue;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getValue() {
        return this.value;
    }
}
