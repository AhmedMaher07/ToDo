package com.bal7a.todo;



public class Model {

    int id;
    String note;
    String created_at;

    public Model() {
    }

    // constructors
    public Model(String note, String date) {
        this.note = note;
        this.created_at = date;
    }

    public Model(String note, int status) {
        this.note = note;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}