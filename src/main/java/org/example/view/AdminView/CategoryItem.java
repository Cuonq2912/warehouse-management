package org.example.view.AdminView;

public class CategoryItem {
    private final long id;
    private final String name;

    public CategoryItem(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}