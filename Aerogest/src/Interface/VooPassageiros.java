/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VooPassageiros.java
 *
 * Created on 2/Jun/2011, 2:33:03
 */

package Interface;

import Classes.Passageiro;
import Classes.VooComercial;
import aerogest.AerogestSistema;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author goku
 */
public class VooPassageiros extends javax.swing.JDialog {

    private static String codVoo;
    private static AerogestSistema as;
    private static GregorianCalendar da;
    /** Creates new form VooPassageiros */
    public VooPassageiros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    private void init(){
        if (as.getVoosPorDia(da).get(codVoo).getClass() == VooComercial.class)
            jButton_Substituir_Pass.setVisible(false);

        jLabel_Codigo.setText(codVoo);
        jList2.setListData(as.getVoosPorDia(da).get(codVoo).getPassageiros().toArray());
        jLabel_Num_Passageiros.setText(""+as.getVoosPorDia(da).get(codVoo).getPassageiros().size());
        jLabel_Pass_Embarcados.setText(""+as.getVoosPorDia(da).get(codVoo).getPassageirosEmbarcados().size());
        jButton_Embarcar_Select.setEnabled(false);
        jButton_Substituir_Pass.setEnabled(false);
    }

    private void actualizar(){
        jLabel_Pass_Embarcados.setText(""+as.getVoosPorDia(da).get(codVoo).getPassageirosEmbarcados().size());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Embarcar_Todos = new javax.swing.JButton();
        jLabel_Num_Passageiros = new javax.swing.JLabel();
        jButton_Embarcar_Select = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton_Voltar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Pass_Embarcados = new javax.swing.JLabel();
        jLabel_Codigo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        jButton_Substituir_Pass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jButton_Embarcar_Todos.setText("Embarcar Todas");
        jButton_Embarcar_Todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Embarcar_TodosActionPerformed(evt);
            }
        });

        jLabel_Num_Passageiros.setText("jLabel2");

        jButton_Embarcar_Select.setText("Embarcar Seleccionado");
        jButton_Embarcar_Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Embarcar_SelectActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero de Passageiros:");

        jButton_Voltar.setText("Voltar");
        jButton_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VoltarActionPerformed(evt);
            }
        });

        jLabel5.setText("Passageiros Embarcados:");

        jLabel1.setText("Codigo do Voo :");

        jLabel_Pass_Embarcados.setText("jLabel2");

        jLabel_Codigo.setText("jLabel2");

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel8.setText("Passageiros");

        jButton_Substituir_Pass.setText("Substituir Passageiro");
        jButton_Substituir_Pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Substituir_PassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton_Voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(jLabel_Num_Passageiros, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(jLabel_Pass_Embarcados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton_Embarcar_Todos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Embarcar_Select, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Substituir_Pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_Codigo))
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel_Num_Passageiros))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel_Pass_Embarcados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Substituir_Pass)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_Voltar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_Embarcar_Select)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Embarcar_Todos)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_VoltarActionPerformed

    private void jButton_Embarcar_TodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Embarcar_TodosActionPerformed
        if (as.getVoosPorDia(da).get(codVoo).getPassageiros().size() ==
                as.getVoosPorDia(da).get(codVoo).getPassageirosEmbarcados().size())
            JOptionPane.showMessageDialog(rootPane, "Passageiros já embarcados");
        else
            as.getVoosPorDia(da).get(codVoo).embarquePassageiroALL();
        actualizar();
    }//GEN-LAST:event_jButton_Embarcar_TodosActionPerformed

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        Passageiro p = (Passageiro) jList2.getSelectedValue();
        ArrayList<String> ss = as.getVoosPorDia(da).get(codVoo).getPassageirosEmbarcados();
        if (!ss.contains(p.getCodPassageiro())){
            jButton_Substituir_Pass.setEnabled(true);
            jButton_Embarcar_Select.setEnabled(true);
        } else {
            jButton_Substituir_Pass.setEnabled(false);
            jButton_Embarcar_Select.setEnabled(false);
        }
    }//GEN-LAST:event_jList2MouseClicked

    private void jButton_Embarcar_SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Embarcar_SelectActionPerformed
        Passageiro s = (Passageiro)jList2.getSelectedValue();
        ArrayList<Passageiro> ss = as.getVoosPorDia(da).get(codVoo).getPassageiros();

        as.getVoosPorDia(da).get(codVoo).embarquePassageiro(s);

        actualizar();
        jList2.setSelectedValue(null, false);
        jButton_Embarcar_Select.setEnabled(false);
        jButton_Substituir_Pass.setEnabled(false);

         if (as.getVoosPorDia(da).get(codVoo).getPassageiros().size() ==
                as.getVoosPorDia(da).get(codVoo).getPassageirosEmbarcados().size())
            JOptionPane.showMessageDialog(rootPane, "Passageiros já embarcados");
    }//GEN-LAST:event_jButton_Embarcar_SelectActionPerformed

    private void jButton_Substituir_PassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Substituir_PassActionPerformed
        Passageiro a = (Passageiro) jList2.getSelectedValue();

        VooComercial v = (VooComercial) as.getVoosPorDia(da).get(codVoo);
        String opcoes = "Passageiros Substitutos: \n";

        ArrayList<Passageiro> pp = v.getPassageirosSubstitutos();

        for (Passageiro p : pp) {
            opcoes += p.getCodPassageiro() + "\n";
        }
        String escolha = JOptionPane.showInputDialog(opcoes);
        v.anulaPassageiro(a);

        boolean found = false;
        for(int i = 0 ; i< pp.size() && !found ; i++)
            if (pp.get(i).getCodPassageiro().equals(escolha)){
                found = true;
                v.adicionaPassageiro(pp.get(i));
            }
        
        actualizar();
    }//GEN-LAST:event_jButton_Substituir_PassActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String codVoo, AerogestSistema as,GregorianCalendar da) {
        VooPassageiros.codVoo = codVoo;
        VooPassageiros.as = as;
        VooPassageiros.da = da;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VooPassageiros dialog = new VooPassageiros(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Embarcar_Select;
    private javax.swing.JButton jButton_Embarcar_Todos;
    private javax.swing.JButton jButton_Substituir_Pass;
    private javax.swing.JButton jButton_Voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Codigo;
    private javax.swing.JLabel jLabel_Num_Passageiros;
    private javax.swing.JLabel jLabel_Pass_Embarcados;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
