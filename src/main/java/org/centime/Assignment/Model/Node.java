package org.centime.Assignment.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Node {
    private String id;
    private String parentId;
    private String value;
    private Node parent;

    private List<Node> children;

    public Node() {
        super();
        this.children = new ArrayList<>();
    }

    public Node(String value, String childId, String parentId) {
        this.value = value;
        this.id = childId;
        this.parentId = parentId;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        if (!this.children.contains(child) && child != null)
            this.children.add(child);
    }

    @Override
    public String toString() {
        return "{ name:" + value + ", Sub Classes:"
                + children + "}";
    }
}
