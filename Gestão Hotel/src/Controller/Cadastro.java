package Controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Cliente;

public class Cadastro {

    public boolean cadastrar(List<Cliente> clientes, Cliente cl) {


        if (emailValid(cl)) {

            if (clientes.size() == 0) {
                clientes.add(cl);
                return true;
            } else {
                for (int i = 0; i < clientes.size(); i++) {

                    if (clientes.get(i).getEmail().equals(cl.getEmail())) {
                        System.out.println("Email já cadastrado");
                        return false;
                    }

                }
            }
        } else {
            System.out.println("Email inválido");
            return false;
        }

        clientes.add(cl);
        return true;

    }

    public boolean emailValid(Cliente cl) {

        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cl.getEmail());

        return matcher.matches();

    }

}
