package org.nomanspace.Entity;

public class Tree extends Entity implements Blockable {
    @Override
    public String getAvatar() {
        return "[ T ] ";
    }


    @Override
    public String toString() {
        return "Tree";
    }


}
