package br.edu.ifsp.class02.task;

public class Dvd {
    private Integer id;
    private String name;
    private String description;

    public Dvd(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dvd #" + id +
                "\n\t" + name +
                "\n\t   " + description;
    }
}
