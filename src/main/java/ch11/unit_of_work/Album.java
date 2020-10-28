package ch11.unit_of_work;

import ch11.unit_of_work.mock.MockIdGenerator;

public class Album extends DomainObject {
    private String title;

    public Album(Object nextId, String name) {

    }

    public static Album create(String name) {
        Album album = new Album(MockIdGenerator.nextId(), name);
        album.markNew();
        return album;
    }

    public void setTitle(String title) {
        this.title = title;
        markDirty();
    }
}
