package view;

import dto.RequestDTO;
import dto.ResponseDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Menu {
    ArrayList<String> operacoes;


    public Menu() {

        ArrayList<String> operacoes = new ArrayList<>();

        try {
            Path dirpath = Paths.get("C:\\Users\\Usuario\\Desktop\\CalcProjeto (1)\\CalcProjeto\\src\\model\\operation");

            try(Stream<Path> filePaths = Files.list(dirpath)){
                filePaths.forEach(filePath -> {
                    try {
                        File file = filePath.toFile();

                        Method getNameMethod = File.class.getMethod("getName");

                        String fileName = getNameMethod.invoke(file).toString();

                        String[] nomeArquivo = fileName.split("\\.");

                        if(!fileName.equals("IOperation.java")){
                            operacoes.add(nomeArquivo[0]);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                this.operacoes = operacoes;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public RequestDTO show(){
        this.showMenu();
        return this.captureValues();
    }

    private RequestDTO captureValues (){

        Scanner input = new Scanner(System.in);
        int opcao = input.nextInt();

        System.out.println("Informe o primeiro valor:");
        int valor1 = input.nextInt();

        System.out.println("Informe o segundo valor:");
        int valor2 = input.nextInt();

        return new RequestDTO(this.operacoes.get(opcao-1),valor1,valor2);
    }

    private void showMenu(){

        System.out.println("Escolha sua operação: ");
        int index = 1;

        for(String op: this.operacoes){
            System.out.println(index + " - " + op);
            index++;
        }

        System.out.println(index + " - Sair ...");
    }

    public void showResult (ResponseDTO responseDTO){
        System.out.println("O Resultado é: "+responseDTO.getResult());
    }


}
