package br.edu.ifsp.class02;

public class Person {
    private String cpf;
    private String name;
    private int age;
    private String studentEnrollment;

    public Person(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
        this.age = 0;
        this.studentEnrollment = "SC000";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentEnrollment() {
        return studentEnrollment;
    }

    public void setStudentEnrollment(String studentEnrollment) {
        this.studentEnrollment = studentEnrollment;
    }

    public void setName(String name) {
        this.name = name;
    }
}
