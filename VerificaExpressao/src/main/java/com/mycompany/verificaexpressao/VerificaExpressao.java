/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.verificaexpressao;
import javax.swing.JOptionPane;
import java.util.Stack;
/**
 *
 * @author thuts
 */

public class VerificaExpressao {
    public static void main(String[] args) {
        String expressao = JOptionPane.showInputDialog("Digite a expressão:");

        if (verificarParametrizacao(expressao)) {
            JOptionPane.showMessageDialog(null, "Expressão correta!");
        } else {
            JOptionPane.showMessageDialog(null, "Expressão incorreta!");
        }
    }

    private static boolean verificarParametrizacao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char caractere : expressao.toCharArray()) {
            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty() || !parametros(pilha.pop(), caractere)) {
                    return false;
                }
            }
        }

        return pilha.isEmpty();
    }

    private static boolean parametros(char aberto, char fechado) {
        return (aberto == '(' && fechado == ')') ||
               (aberto == '[' && fechado == ']') ||
               (aberto == '{' && fechado == '}');
    }
}
