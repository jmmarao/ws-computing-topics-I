package br.edu.ifsp.class02.task;

public class Customer {
    private Integer id;
    private String name;
    private String cpf;

    public Customer(Integer id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Customer #" + id +
                "\n\t" + name +
                " | " + cpf;
    }
}
