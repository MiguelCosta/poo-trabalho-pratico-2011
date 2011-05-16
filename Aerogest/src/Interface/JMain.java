/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JMain.java
 *
 * Created on 3/Mai/2011, 12:16:12
 */
package Interface;

import Classes.CoPiloto;
import Classes.Comandante;
import Classes.Tripulante;
import aerogest.AerogestSistema;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class JMain extends javax.swing.JFrame {

    private DefaultTableModel mapa_voos;
    private DefaultTableModel comandantes;
    private DefaultTableModel copilotos;
    private static AerogestSistema aerogestSistema;

    /** Creates new form JMain */
    public JMain(AerogestSistema a) {
        initComponents();

        aerogestSistema = new AerogestSistema(a);
        mapa_voos = new DefaultTableModel();
        comandantes = new DefaultTableModel();
        copilotos = new DefaultTableModel();

        //actualizarTabelaMapaVoos();
        actualizarTabelaComandantes();
        actualizarTabelaCoPilotos();

    }

    private void actualizarTabelaMapaVoos() {

        //System.out.println("*******Tabela:\n"+aerogestSistema.getHoraActual().toString());
        //System.out.println(aerogestSistema.getHoraActual().toString());

        //String s = aerogestSistema.imprimePortas();
        //System.out.print(s);

        String s = aerogestSistema.imprimeComandantes();
        System.out.print(s);

        jTablePlacard.setModel(new javax.swing.table.DefaultTableModel(
                new String[][]{ //{"v1","braga","14:15:16","pronto"}
                },
                new String[]{
                    "VOO", "DESTINO", "HORA PARTIDA", "ESTADO"
                }));


        /*
        jTablePlacard.setModel(new javax.swing.table.DefaultTableModel(
        new String[][]{
        {"Miguel", "Pinto","Costa"},
        {"Fábio", "Costa",""},
        {"Sofia", "Vieira",""},
        {"Pinto", "Costa",""}
        },
        new String[]{
        "Primeiro Nome", "Meio", "Ultimo Nome"
        }));
         */
        /**
        System.out.println("Nome das Colunas:");
        for (int i = 0; i < jTablePlacard.getColumnCount(); i++) {
        System.out.println(jTablePlacard.getColumnName(i));
        }*/
        // apenas para testar como funcionam as tabelas
        // http://download.oracle.com/javase/tutorial/uiswing/components/table.html
        /*
        System.out.println("\nValores nas celulas:");
        int numLinhas = jTablePlacard.getRowCount();
        int numColunas = jTablePlacard.getColumnCount();
        for (int i = 0; i < numLinhas; i++) {
        for (int j = 0; j < numColunas; j++) {
        System.out.println("Celula("+i+","+j+"): "+jTablePlacard.getValueAt(i, j).toString());
        }
        
        }*/
    }

    /**
     * Actualiza a Tabela com os Comandantes
     */
    private void actualizarTabelaComandantes() {
        comandantes = new DefaultTableModel();
        comandantes.addColumn("Nome");
        comandantes.addColumn("Nacionalidade");
        comandantes.addColumn("Estado");

        Set<Comandante> cms = new HashSet<Comandante>();
        cms = aerogestSistema.getComandantes();

        for (Comandante c : cms) {
            boolean estado = c.getLivre();

            if (estado) {
                String[] livre = {c.getNome(), c.getNacionalidade(), "livre"};
                comandantes.addRow(livre);
            } else {
                String[] ocupado = {c.getNome(), c.getNacionalidade(), "ocupado"};
                comandantes.addRow(ocupado);
            }
        }

        jTableComandantes.setModel(comandantes);
    }

    /**
     * Actualiza a tabela dos CoPilotos
     */
    private void actualizarTabelaCoPilotos() {
        copilotos = new DefaultTableModel();
        copilotos.addColumn("Nome");
        copilotos.addColumn("Nacionalidade");
        copilotos.addColumn("Estado");

        Set<CoPiloto> cps = new HashSet<CoPiloto>();
        cps = aerogestSistema.getCoPilotos();

        for (CoPiloto c : cps) {
            boolean estado = c.getLivre();

            if (estado) {
                String[] livre = {c.getNome(), c.getNacionalidade(), "livre"};
                copilotos.addRow(livre);
            } else {
                String[] ocupado = {c.getNome(), c.getNacionalidade(), "ocupado"};
                copilotos.addRow(ocupado);
            }
        }

        jTableCoPilotos.setModel(copilotos);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedTripulacoes = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePlacard = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanelTripulacaoComandantes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableComandantes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButtonRemoveComandante = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanelTripulacaoCoPilotos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCoPilotos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButtonRemoveCoPiloto = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedTripulacoes.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jTablePlacard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTablePlacard);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedTripulacoes.addTab("Mapa de Voos", jPanel2);

        jPanelTripulacaoComandantes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comandantes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTableComandantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableComandantes);

        jButton1.setText("Adicionar");

        jButtonRemoveComandante.setText("Remover");
        jButtonRemoveComandante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveComandanteActionPerformed(evt);
            }
        });

        jButton3.setText("Editar");

        javax.swing.GroupLayout jPanelTripulacaoComandantesLayout = new javax.swing.GroupLayout(jPanelTripulacaoComandantes);
        jPanelTripulacaoComandantes.setLayout(jPanelTripulacaoComandantesLayout);
        jPanelTripulacaoComandantesLayout.setHorizontalGroup(
            jPanelTripulacaoComandantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTripulacaoComandantesLayout.createSequentialGroup()
                .addGroup(jPanelTripulacaoComandantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTripulacaoComandantesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemoveComandante))
                    .addGroup(jPanelTripulacaoComandantesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanelTripulacaoComandantesLayout.setVerticalGroup(
            jPanelTripulacaoComandantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTripulacaoComandantesLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTripulacaoComandantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoveComandante)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jPanelTripulacaoCoPilotos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CoPilotos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTableCoPilotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTableCoPilotos);

        jButton2.setText("Adicionar");

        jButtonRemoveCoPiloto.setText("Remover");
        jButtonRemoveCoPiloto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveCoPilotoActionPerformed(evt);
            }
        });

        jButton4.setText("Editar");

        javax.swing.GroupLayout jPanelTripulacaoCoPilotosLayout = new javax.swing.GroupLayout(jPanelTripulacaoCoPilotos);
        jPanelTripulacaoCoPilotos.setLayout(jPanelTripulacaoCoPilotosLayout);
        jPanelTripulacaoCoPilotosLayout.setHorizontalGroup(
            jPanelTripulacaoCoPilotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTripulacaoCoPilotosLayout.createSequentialGroup()
                .addGroup(jPanelTripulacaoCoPilotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTripulacaoCoPilotosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemoveCoPiloto))
                    .addGroup(jPanelTripulacaoCoPilotosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanelTripulacaoCoPilotosLayout.setVerticalGroup(
            jPanelTripulacaoCoPilotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTripulacaoCoPilotosLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTripulacaoCoPilotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoveCoPiloto)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelTripulacaoComandantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTripulacaoCoPilotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTripulacaoCoPilotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelTripulacaoComandantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(264, Short.MAX_VALUE))
        );

        jTabbedTripulacoes.addTab("Tripulações", jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jTabbedTripulacoes.addTab("Cargas", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jTabbedTripulacoes.addTab("Aeronaves", jPanel4);

        jMenu1.setText("Ficheiro");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Guardar");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Guardar como...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Sair");
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem4.setText("Acerca");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedTripulacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedTripulacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRemoveComandanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveComandanteActionPerformed
        
        // linha que está seleccionada
        int linha = jTableComandantes.getSelectedRow();
        
        // se alguma linha estiver seleccionada
        if (linha >= 0) {
            int escolha = JOptionPane.showConfirmDialog(rootPane, "Tem a ceteza que prentende remover o comandante seleccionado?", "Remover comandante", 1);
            if (escolha == 0) {
                // nome do comandantes; 1ª coluna
                String nome = (String) jTableComandantes.getValueAt(linha, 0);
                // nacionalidade; 2ª coluna
                String nacionalidade = (String) jTableComandantes.getValueAt(linha, 1);
                // estado; 3ª coluna
                String estado = (String) jTableComandantes.getValueAt(linha, 2);
                
                // Comandante que está seleccionado
                Comandante c = new Comandante(nome, nacionalidade);
                // altera o estado caso seja necessário, porque ele inicialmente está sempre livre
                if (estado.equalsIgnoreCase("ocupado")) {
                    c.setLivre(false);
                }
                
                // remove do Sistema o comandante
                aerogestSistema.removeComandante(c);
                // actualiza a tabela
                actualizarTabelaComandantes();
                JOptionPane.showMessageDialog(rootPane, "Remoção efectuado com sucesso!", "Comandante removido", 1);
            }
        }
    }//GEN-LAST:event_jButtonRemoveComandanteActionPerformed

    private void jButtonRemoveCoPilotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveCoPilotoActionPerformed
        // linha que está seleccionada
        int linha = jTableCoPilotos.getSelectedRow();
        
        // se alguma linha estiver seleccionada
        if (linha >= 0) {
            int escolha = JOptionPane.showConfirmDialog(rootPane, "Tem a ceteza que prentende remover o CoPiloto seleccionado?", "Remover CoPiloto", 1);
            if (escolha == 0) {
                // nome do comandantes; 1ª coluna
                String nome = (String) jTableCoPilotos.getValueAt(linha, 0);
                // nacionalidade; 2ª coluna
                String nacionalidade = (String) jTableCoPilotos.getValueAt(linha, 1);
                // estado; 3ª coluna
                String estado = (String) jTableCoPilotos.getValueAt(linha, 2);
                
                // Comandante que está seleccionado
                CoPiloto c = new CoPiloto(nome, nacionalidade);
                // altera o estado caso seja necessário, porque ele inicialmente está sempre livre
                if (estado.equalsIgnoreCase("ocupado")) {
                    c.setLivre(false);
                }
                
                // remove do Sistema o comandante
                aerogestSistema.removeCoPiloto(c);
                // actualiza a tabela
                actualizarTabelaCoPilotos();
                JOptionPane.showMessageDialog(rootPane, "Remoção efectuado com sucesso!", "CoPiloto removido", 1);
            }
        }
}//GEN-LAST:event_jButtonRemoveCoPilotoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser f = new JFileChooser();
        f.setApproveButtonText("Abrir");
        
        f.showOpenDialog(this);
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * Evento que remove um comandante
     * @param evt 
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            JMain principal = new JMain(aerogestSistema);

            public void run() {

                principal.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonRemoveCoPiloto;
    private javax.swing.JButton jButtonRemoveComandante;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelTripulacaoCoPilotos;
    private javax.swing.JPanel jPanelTripulacaoComandantes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedTripulacoes;
    private javax.swing.JTable jTableCoPilotos;
    private javax.swing.JTable jTableComandantes;
    private javax.swing.JTable jTablePlacard;
    // End of variables declaration//GEN-END:variables
}
