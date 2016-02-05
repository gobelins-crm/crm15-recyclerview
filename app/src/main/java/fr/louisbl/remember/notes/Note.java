package fr.louisbl.remember.notes;

import com.orm.SugarRecord;

public class Note extends SugarRecord {
    String title;
    String description;

    public Note() {

    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Note " + getId() + ", title: " + title;
    }
}
