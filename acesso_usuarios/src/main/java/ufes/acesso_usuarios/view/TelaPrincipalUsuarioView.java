/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ufes.acesso_usuarios.view;

import javax.swing.JLabel;
import javax.swing.JMenu;

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
        jMenuBar1 = new javax.swing.JMenuBar();
        opcaoConfigurar = new javax.swing.JMenu();
        opcaoAlterarSenha = new javax.swing.JMenu();
        opcaoSair = new javax.swing.JMenu();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQtdNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
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
                    .addComponent(txtTipoUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        opcaoConfigurar.setText("Configurar");
        opcaoConfigurar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuBar1.add(opcaoConfigurar);

        opcaoAlterarSenha.setText("Alterar senha");
        opcaoAlterarSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuBar1.add(opcaoAlterarSenha);

        opcaoSair.setText("Sair");
        opcaoSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuBar1.add(opcaoSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 223, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //GETS
    public JMenu getOpcaoAlterarSenha() {
        return opcaoAlterarSenha;
    }

    public JMenu getOpcaoConfigurar() {
        return opcaoConfigurar;
    }

    public JMenu getOpcaoSair() {
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu opcaoAlterarSenha;
    private javax.swing.JMenu opcaoConfigurar;
    private javax.swing.JMenu opcaoSair;
    private javax.swing.JLabel txtNomeUsuario;
    private javax.swing.JLabel txtQtdNotificacoes;
    private javax.swing.JLabel txtTipoUsuario;
    // End of variables declaration//GEN-END:variables
}
