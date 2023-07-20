/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ufes.acesso_usuarios.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class TelaBuscarUsuariosView extends javax.swing.JFrame {

    /**
     * Creates new form TelaBuscarUsuarios
     */
    public TelaBuscarUsuariosView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        inputPesquisa = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        btnAutorizarUsuarios = new javax.swing.JButton();
        btnEnviarNotificacoes = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        jPanelRodape = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JLabel();
        txtTipoUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtQtdNotificacoes = new javax.swing.JLabel();
        btnAbrirNotificacoes = new javax.swing.JButton();
        opcoes = new javax.swing.JMenuBar();
        menuOpcoes = new javax.swing.JMenu();
        opcaoConfigurar = new javax.swing.JMenuItem();
        opcaoAlterarSenha = new javax.swing.JMenuItem();
        opcaoSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscar");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nome de usuário:");

        inputPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Data de Cadastro", "Status", "Notificações Enviadas", "Notificações Lidas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableUsuarios.getTableHeader().setResizingAllowed(false);
        tableUsuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableUsuarios);

        btnAutorizarUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAutorizarUsuarios.setText("Autorizar Usuário");
        btnAutorizarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorizarUsuariosActionPerformed(evt);
            }
        });

        btnEnviarNotificacoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEnviarNotificacoes.setText("Enviar Notificações");

        btnNovo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNovo.setText("Novo");

        btnFechar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFechar.setText("Fechar");

        btnVisualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVisualizar.setText("Visualizar");

        jPanelRodape.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRodape.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Usuário:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tipo:");

        txtNomeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTipoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Notificações:");

        txtQtdNotificacoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQtdNotificacoes.setText("0");

        btnAbrirNotificacoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAbrirNotificacoes.setText("Abrir Notificações");

        javax.swing.GroupLayout jPanelRodapeLayout = new javax.swing.GroupLayout(jPanelRodape);
        jPanelRodape.setLayout(jPanelRodapeLayout);
        jPanelRodapeLayout.setHorizontalGroup(
            jPanelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRodapeLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(125, 125, 125)
                .addGroup(jPanelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAbrirNotificacoes, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRodapeLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtdNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(37, 37, 37))
        );
        jPanelRodapeLayout.setVerticalGroup(
            jPanelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRodapeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(jPanelRodapeLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTipoUsuario)))
                    .addGroup(jPanelRodapeLayout.createSequentialGroup()
                        .addComponent(txtNomeUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtQtdNotificacoes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAbrirNotificacoes)))
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

        opcoes.add(menuOpcoes);

        setJMenuBar(opcoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVisualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(btnAutorizarUsuarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviarNotificacoes)
                        .addGap(33, 33, 33))))
            .addComponent(jPanelRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGap(33, 33, 33)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo)
                    .addComponent(btnFechar)
                    .addComponent(btnVisualizar)
                    .addComponent(btnEnviarNotificacoes)
                    .addComponent(btnAutorizarUsuarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jPanelRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(136, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAutorizarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorizarUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAutorizarUsuariosActionPerformed

    //GETS
    public JButton getBtnAbrirNotificacoes() {
        return btnAbrirNotificacoes;
    }

    public JButton getBtnAutorizarUsuarios() {
        return btnAutorizarUsuarios;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnEnviarNotificacoes() {
        return btnEnviarNotificacoes;
    }

    public JButton getBtnFechar() {
        return btnFechar;
    }

    public JButton getBtnNovo() {
        return btnNovo;
    }

    public JButton getBtnVisualizar() {
        return btnVisualizar;
    }

    public JTextField getInputPesquisa() {
        return inputPesquisa;
    }

    public JTable getTableUsuarios() {
        return tableUsuarios;
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
    private javax.swing.JButton btnAutorizarUsuarios;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEnviarNotificacoes;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JTextField inputPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelRodape;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenuItem opcaoAlterarSenha;
    private javax.swing.JMenuItem opcaoConfigurar;
    private javax.swing.JMenuItem opcaoSair;
    private javax.swing.JMenuBar opcoes;
    private javax.swing.JTable tableUsuarios;
    private javax.swing.JLabel txtNomeUsuario;
    private javax.swing.JLabel txtQtdNotificacoes;
    private javax.swing.JLabel txtTipoUsuario;
    // End of variables declaration//GEN-END:variables
}
