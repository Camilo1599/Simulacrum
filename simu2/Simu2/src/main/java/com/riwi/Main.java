package com.riwi;

import com.riwi.menu.ClienteMenu;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        while (true){
            String decision = JOptionPane.showInputDialog(null, "Ingresa una opcion: \n\n1: Cliente\n2: Salir");
            switch (decision){
                case ("1")->{
                    ClienteMenu.Menu();
                }
                case ("2")->{
                    return;
                }
            }
        }
    }
}