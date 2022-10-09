package com.jsp_app.entities;

public class Note {
    private int note_id;
    private String title;
    private String content;
    private String created;
    private int user_id;

    public Note(int note_id, String title, String content,
                String created, int user_id) {
        this.note_id = note_id;
        this.title = title;
        this.content = content;
        this.created = created;
        this.user_id = user_id;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Note{" +
                "note_id=" + note_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created='" + created + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
