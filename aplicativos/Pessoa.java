package aplicativos;

import java.util.InputMismatchException;

public class Pessoa {

    public static final int length = 0;
    public final String getBreve = null;
    private String nome;
    private String cpf;

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getCpf() {
    return cpf;
}

public void setCpf(String cpf) {

if (cpf != null && cpf.length()== 11 && cpf.matches("[0-9]{11}")){
this.cpf= cpf;
}
else{
    throw new InputMismatchException("CPF deve conter 11 números! ");
}
}
}