package ru.job4j.start;

import java.util.Arrays;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    public Item(String id, String name, String desc, long created, String[] comments) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.comments = comments;
    }

    public Item(String id) {
        this.id = id;
    }

    public Item() {
    }

    public Item(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public Item(String id, String name, String desc, long created) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }

        Item item = (Item) o;

        if (!id.equals(item.id)) {
            return false;
        }
        if (!getName().equals(item.getName())) {
            return false;
        }
        if (!getDesc().equals(item.getDesc())) {
            return false;
        }
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getComments(), item.getComments());
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDesc().hashCode();
        result = 31 * result + (int) (getCreated() ^ (getCreated() >>> 32));
        result = 31 * result + Arrays.hashCode(getComments());
        return result;
    }
}
