/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ufes.acesso_usuarios.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Gabriel
 */
public class TelaPrincipalUsuarioView extends javax.swing.JFrame {

    /**
     * Creates new form VisualizacaoUsuarioView
     */
    public TelaPrincipalUsuarioView() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JLabel();
        txtTipoUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQtdNotificacoes = new javax.swing.JLabel();
        btnAbrirNotificacoes = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuOpcoes = new javax.swing.JMenu();
        opcaoConfigurar = new javax.swing.JMenuItem();
        opcaoAlterarSenha = new javax.swing.JMenuItem();
        opcaoSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Usuário:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tipo:");

        txtNomeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTipoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Notificações:");

        txtQtdNotificacoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQtdNotificacoes.setText("0");

        btnAbrirNotificacoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAbrirNotificacoes.setText("Abrir Notificações");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAbrirNotificacoes)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtdNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeUsuario)
                    .addComponent(jLabel3)
                    .addComponent(txtQtdNotificacoes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTipoUsuario)
                    .addComponent(btnAbrirNotificacoes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuOpcoes.setText("Opções");
        menuOpcoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        opcaoConfigurar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        opcaoConfigurar.setText("Configurar Log");
        menuOpcoes.add(opcaoConfigurar);

        opcaoAlterarSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        opcaoAlterarSenha.setText("Alterar Senha");
        menuOpcoes.add(opcaoAlterarSenha);

        opcaoSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        opcaoSair.setText("Sair");
        menuOpcoes.add(opcaoSair);

        jMenuBar2.add(menuOpcoes);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 217, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //GETS
    public JButton getBtnAbrirNotificacoes() {
        return btnAbrirNotificacoes;
    }

    public JMenuItem getOpcaoAlterarSenha() {
        return opcaoAlterarSenha;
    }

    public JMenuItem getOpcaoConfigurar() {
        return opcaoConfigurar;
    }

    public JMenuItem getOpcaoSair() {
        return opcaoSair;
    }

    public JLabel getTxtNomeUsuario() {
        return txtNomeUsuario;
    }

    public JLabel getTxtQtdNotificacoes() {
        return txtQtdNotificacoes;
    }

    public JLabel getTxtTipoUsuario() {
        return txtTipoUsuario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirNotificacoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenuItem opcaoAlterarSenha;
    private javax.swing.JMenuItem opcaoConfigurar;
    private javax.swing.JMenuItem opcaoSair;
    private javax.swing.JLabel txtNomeUsuario;
    private javax.swing.JLabel txtQtdNotificacoes;
    private javax.swing.JLabel txtTipoUsuario;
    // End of variables declaration//GEN-END:variables
}
