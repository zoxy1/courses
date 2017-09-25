package ru.job4j.models;

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

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    @Override
    public boolean equals(Object obj) {
        /* проверяем равны ли ссылки */
        if (obj == this)
            return true;

        /* obj ссылается на null */
        if (obj == null)
            return false;

        /* Удостоверимся, что ссылки имеют тот же самый тип */
        if (!(this.getClass() == obj.getClass()))
            return false;
        else {
            Item tmp = (Item) obj;
            if (this.comments == null && tmp.comments != null) {
                return false;
            }

            if (this.comments != null && tmp.comments == null) {
                return false;
            }

            if (this.comments != null && tmp.comments != null) {
                if (this.comments.length != tmp.comments.length) {
                    return false;
                }

                for (int i = 0; i < this.comments.length; i++) {
                    if (!(this.comments[i].equals(tmp.comments[i]))) {
                        return false;
                    }
                }
            }

            if (this.id.equals(tmp.id) && this.name.equals(tmp.name) && this.desc.equals(tmp.desc)) {
                return true;
            } else {
                return false;
            }
        }
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
}
