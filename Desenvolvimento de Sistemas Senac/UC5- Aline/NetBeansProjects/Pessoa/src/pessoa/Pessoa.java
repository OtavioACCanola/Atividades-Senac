/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

//tjz dv zizu
package pessoa;

public class Pessoa { //Define a classe Pessoa como publica
    private String nome; // Cria uma variável para essa classe chamada 'nome'
    private int idade;
    private String cpf;
    private String genero;
    private float peso;
    private float altura;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura; /*O .this define/diferencia os campos da classe que são globais ou locais, ou seja, o 'altura' depois do this é 
                                global (da para usar em outros projetos), e o 'altura' depois é local (não dá para usaer em outros projetos) */
    }                     
}
     


