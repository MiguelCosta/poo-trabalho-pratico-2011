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

import Classes.Aeronave;
import Classes.Carga;
import Classes.CargaAlimentar;
import Classes.CargaAnimal;
import Classes.CargaQuimica;
import Classes.CargaVeiculo;
import Classes.CoPiloto;
import Classes.Comandante;
import Classes.Tripulante;
import Classes.Voo;
import Importer.SaveLoadDB;
import aerogest.AerogestSistema;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
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
    private DefaultTableModel placard;
    private DefaultTableModel comandantes;
    private DefaultTableModel copilotos;
    private DefaultTableModel tripulantesAdicionais;
    private DefaultTableModel cargas;
    private DefaultTableModel aeronaves;
    private static AerogestSistema aerogestSistema;

    /** Creates new form JMain */
    public JMain(AerogestSistema a) {
        initComponents();

        centerOnScreen(this);
        aerogestSistema = new AerogestSistema(a);
        mapa_voos = new DefaultTableModel();
        placard = new DefaultTableModel();
        comandantes = new DefaultTableModel();
        copilotos = new DefaultTableModel();
        tripulantesAdicionais = new DefaultTableModel();
        cargas = new DefaultTableModel();
        aeronaves = new DefaultTableModel();

        actualizarTabelas();
    }

    private void actualizarTabelas() {
        actualizarTabelaComandantes();
        actualizarTabelaCoPilotos();
        actualizarTabelaTrpulantesAdicionais();
        actualizarTabelaCargas();
        actualizarTabelaMapaVoos();
        actualizarTabelaAeronaves();
        actualizarTabelaPlacard();
        actualizarData();
    }

    private void actualizarData() {
        GregorianCalendar d = new GregorianCalendar();
        String s = "Data: ";
        s = s + diaEmString(d);

        jLabelData.setText(s);

        String s1 = diaEmString(d);
        String s2 = horaEmString(d);
        jLabelPlacardHora.setText(s2);
        jLabelPlacardDia.setText(s1);

    }

    private void actualizarTabelaMapaVoos() {
        mapa_voos = new DefaultTableModel();
        mapa_voos.addColumn("Dia");
        mapa_voos.addColumn("Tipo Voo");
        mapa_voos.addColumn("Voo");
        mapa_voos.addColumn("Destino");
        mapa_voos.addColumn("Hora Partida");
        mapa_voos.addColumn("Aeronave");
        mapa_voos.addColumn("Porta");
        mapa_voos.addColumn("Estado");
        mapa_voos.addColumn("Obs");
		// estrutura para o mapa de voos
        TreeMap<GregorianCalendar, TreeMap<String, Voo>> r = new TreeMap<GregorianCalendar, TreeMap<String, Voo>>();
        r = aerogestSistema.getMapaVoos();

        for (GregorianCalendar d : r.keySet()) {
            for (Voo voo : r.get(d).values()) {
                String dia = diaEmString(d);
                String nome_classe = voo.getClass().getName();
                if (nome_classe.equalsIgnoreCase("Classes.VooComercial")) {
                    mapa_voos.addRow(linhaMapaVoos(dia, voo, "Comercial"));
                } else if (nome_classe.equalsIgnoreCase("Classes.VooGovernamental")) {
                    mapa_voos.addRow(linhaMapaVoos(dia, voo, "VooGovernamental"));
                } else if (nome_classe.equalsIgnoreCase("Classes.VooMilitar")) {
                    mapa_voos.addRow(linhaMapaVoos(dia, voo, "Militar"));
                } else if (nome_classe.equalsIgnoreCase("Classes.VooPrivado")) {
                    mapa_voos.addRow(linhaMapaVoos(dia, voo, "Privado"));
                }

            }
        }
        jTableMapaVoos.setModel(mapa_voos);
    }

    /**
     * Devolve a informacao para adicionar uma linha à tabela de mapa de voos
     * @param dia
     * @param voo
     * @param nome_classe
     * @return 
     */
    private String[] linhaMapaVoos(String dia, Voo voo, String nome_classe) {
        String ref = voo.getEntidade() + voo.getCodigoVoo();
        String dst = voo.getDestino();
        String hPa = horaEmString(voo.getHoraPartida());
        String aer = "";
        if (voo.getAeronave() != null) {
            aer = voo.getAeronave().getMatricula();
        }
        String por = "";
        if (voo.getPorta() != null) {
            por = voo.getPorta().getCodPorta();
        }
        String est = voo.getEstado();
        String obs = voo.getObservacoes();
        String[] v = {dia, nome_classe, ref, dst, hPa, aer, por, est, obs};

        return v;
    }

    private void actualizarTabelaPlacard() {
        placard = new DefaultTableModel();
        placard.addColumn("Voo");
        placard.addColumn("Destino");
        placard.addColumn("Partida");
        placard.addColumn("Porta");
        placard.addColumn("Estado");
        placard.addColumn("Obs");

        TreeMap<GregorianCalendar, TreeMap<String, Voo>> r = new TreeMap<GregorianCalendar, TreeMap<String, Voo>>();
        r = aerogestSistema.getMapaVoos();


        for (GregorianCalendar d : r.keySet()) {
            for (Voo voo : r.get(d).values()) {
                String dia = diaEmString(d);
                String nome_classe = voo.getClass().getName();
                if (nome_classe.equalsIgnoreCase("Classes.VooComercial")) {
                    placard.addRow(linhaPlacard(voo));
                }
            }
        }

        jTablePlacard.setModel(placard);
    }

    private String[] linhaPlacard(Voo voo) {
        String ref = voo.getEntidade() + voo.getCodigoVoo();
        String dst = voo.getDestino();
        String hPa = horaEmString(voo.getHoraPartida());

        String por = "";
        if (voo.getPorta() != null) {
            por = voo.getPorta().getCodPorta();
        }
        String est = voo.getEstado();
        String obs = voo.getObservacoes();
        String[] v = {ref, dst, hPa, por, est, obs};

        return v;
    }

    /**
     * Actualiza a Tabela com os Comandantes
     */
    private void actualizarTabelaComandantes() {
        comandantes = new DefaultTableModel();
        comandantes.addColumn("Codigo");
        comandantes.addColumn("Nome");
        comandantes.addColumn("Nacionalidade");
        comandantes.addColumn("Estado");

        Map<String, Comandante> cms = new HashMap<String, Comandante>();
        cms = aerogestSistema.getComandantes();

        for (Comandante c : cms.values()) {
            boolean estado = c.getLivre();

            if (estado) {
                String[] livre = {c.getCodigo(), c.getNome(), c.getNacionalidade(), "livre"};
                comandantes.addRow(livre);
            } else {
                String[] ocupado = {c.getCodigo(), c.getNome(), c.getNacionalidade(), "ocupado"};
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
        copilotos.addColumn("Codigo");
        copilotos.addColumn("Nome");
        copilotos.addColumn("Nacionalidade");
        copilotos.addColumn("Estado");

        Map<String, CoPiloto> cps = new HashMap<String, CoPiloto>();
        cps = aerogestSistema.getCoPilotos();

        for (CoPiloto c : cps.values()) {
            boolean estado = c.getLivre();

            if (estado) {
                String[] livre = {c.getCodigo(), c.getNome(), c.getNacionalidade(), "livre"};
                copilotos.addRow(livre);
            } else {
                String[] ocupado = {c.getCodigo(), c.getNome(), c.getNacionalidade(), "ocupado"};
                copilotos.addRow(ocupado);
            }
        }

        jTableCoPilotos.setModel(copilotos);
    }

    private void actualizarTabelaTrpulantesAdicionais() {
        tripulantesAdicionais = new DefaultTableModel();
        tripulantesAdicionais.addColumn("Funcao");
        tripulantesAdicionais.addColumn("Codigo");
        tripulantesAdicionais.addColumn("Nome");
        tripulantesAdicionais.addColumn("Nacionalidade");
        tripulantesAdicionais.addColumn("Estado");

        Map<String, Tripulante> tri = new HashMap<String, Tripulante>();
        tri = aerogestSistema.getTripulantesAdicionais();

        for (Tripulante t : tri.values()) {
            boolean estado = t.getLivre();

            if (estado) {
                String[] livre = {t.getFuncao(), t.getCodigo(), t.getNome(), t.getNacionalidade(), "livre"};
                tripulantesAdicionais.addRow(livre);
            } else {
                String[] ocupado = {t.getFuncao(), t.getCodigo(), t.getNome(), t.getNacionalidade(), "ocupado"};
                tripulantesAdicionais.addRow(ocupado);
            }
        }

        jTableTripulantes.setModel(tripulantesAdicionais);
    }

    private void actualizarTabelaCargas() {
        cargas = new DefaultTableModel();
        cargas.addColumn("Tipo");
        cargas.addColumn("Codigo");
        cargas.addColumn("Peso");
        cargas.addColumn("Descricao");
        cargas.addColumn("Tempo Carregamento");
        cargas.addColumn("Data Validade");
        cargas.addColumn("Volume");
        cargas.addColumn("Estado");
        cargas.addColumn("Toxidade");
        cargas.addColumn("Tipo Veiculo");

        jTableCargas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        Map<String, Carga> cs = new HashMap<String, Carga>();
        cs = aerogestSistema.getCargas();

        for (Carga c : cs.values()) {
            String s = c.getClass().getName();

            if (s.equalsIgnoreCase("Classes.CargaAlimentar")) {
                CargaAlimentar ca = (CargaAlimentar) c;
                String dia = "" + ca.getdataValidade().get(Calendar.DAY_OF_MONTH);
                String mes = "" + (ca.getdataValidade().get(Calendar.MONTH) + 1);
                String ano = "" + ca.getdataValidade().get(Calendar.YEAR);
                String data = dia + "/" + mes + "/" + ano;
                String codigo = ca.getCodigo();
                String peso = "" + ca.getPeso();
                String descricao = ca.getDescricao();
                String tmp_carr = "" + ca.getTempoCarregamento();
                String[] info = {"Alimentar", codigo, peso, descricao, tmp_carr, data};
                cargas.addRow(info);
            } else if (s.equalsIgnoreCase("Classes.CargaAnimal")) {
                CargaAnimal ca = (CargaAnimal) c;
                String codigo = ca.getCodigo();
                String peso = "" + ca.getPeso();
                String descricao = ca.getDescricao();
                String tmp_carr = "" + ca.getTempoCarregamento();
                String volume = "" + ca.getVolume();
                String[] info = {"Animal", codigo, peso, descricao, tmp_carr, "", volume};
                cargas.addRow(info);
            } else if (s.equalsIgnoreCase("Classes.CargaNormal")) {
                String codigo = c.getCodigo();
                String peso = "" + c.getPeso();
                String descricao = c.getDescricao();
                String tmp_carr = "" + c.getTempoCarregamento();
                String[] info = {"Normal", codigo, peso, descricao, tmp_carr, "", ""};
                cargas.addRow(info);
            } else if (s.equalsIgnoreCase("Classes.CargaQuimica")) {
                CargaQuimica cq = (CargaQuimica) c;
                String codigo = cq.getCodigo();
                String peso = "" + cq.getPeso();
                String descricao = cq.getDescricao();
                String tmp_carr = "" + cq.getTempoCarregamento();
                String estado = cq.getEstado();
                String grau_toxi = cq.getGrauToxicidade();
                String[] info = {"Quimica", codigo, peso, descricao, tmp_carr, "", "", estado, grau_toxi};
                cargas.addRow(info);
            } else if (s.equalsIgnoreCase("Classes.CargaVeiculo")) {
                CargaVeiculo cv = (CargaVeiculo) c;
                String codigo = cv.getCodigo();
                String peso = "" + cv.getPeso();
                String descricao = cv.getDescricao();
                String tmp_carr = "" + cv.getTempoCarregamento();
                String tipo = cv.getTipo();
                String[] info = {"Veiculo", codigo, peso, descricao, tmp_carr, "", "", "", "", tipo};
                cargas.addRow(info);
            }

        }

        jTableCargas.setModel(cargas);

    }

    private void actualizarTabelaAeronaves() {
        aeronaves = new DefaultTableModel();
        aeronaves.addColumn("Matricula");
        aeronaves.addColumn("Designacao");
        aeronaves.addColumn("N.º Passageiros");
        aeronaves.addColumn("Capacidade Carga");
        aeronaves.addColumn("Velocidade Max.");
        aeronaves.addColumn("Estado");
        // ..
        Map<String, Aeronave> ma = new HashMap<String, Aeronave>();
        ma = aerogestSistema.getAeronave_All();

        for (Aeronave a : ma.values()) {
            boolean estado = a.getOcupacao();
            if (estado) {
                String[] livre = {a.getMatricula(), a.getDesignacao(), "" + a.getCapacidadePassageiros(), "" + a.getCapacidadeCarga(), "" + a.getVelocidadeMaxima(), "livre"};
                aeronaves.addRow(livre);
            } else {
                String[] ocupada = {a.getMatricula(), a.getDesignacao(), "" + a.getCapacidadePassageiros(), "" + a.getCapacidadeCarga(), "" + a.getVelocidadeMaxima(), "ocupada"};
                aeronaves.addRow(ocupada);
            }
        }

        jTableAeronaves.setModel(aeronaves);
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
        jTableMapaVoos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanelTripulacaoComandantes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableComandantes = new javax.swing.JTable();
        jButtonAdicionarComandante = new javax.swing.JButton();
        jButtonRemoveComandante = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanelTripulacaoCoPilotos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCoPilotos = new javax.swing.JTable();
        jButtonAdicionarCoPiloto = new javax.swing.JButton();
        jButtonRemoveCoPiloto = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanelTripulacao = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTripulantes = new javax.swing.JTable();
        jButtonAdicionarTripulante = new javax.swing.JButton();
        jButtonRemoveTripulante = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableCargas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableAeronaves = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTablePlacard = new javax.swing.JTable();
        jLabelPlacard = new javax.swing.JLabel();
        jLabelPlacardDia = new javax.swing.JLabel();
        jLabelPlacardHora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jButtonActualizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFicheiro = new javax.swing.JMenu();
        jMenuItemAbrirComo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jMenuItemGuardarComo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedTripulacoes.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jTableMapaVoos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableMapaVoos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
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

        jButtonAdicionarComandante.setText("Adicionar");
        jButtonAdicionarComandante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarComandanteActionPerformed(evt);
            }
        });

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
                        .addComponent(jButtonAdicionarComandante)
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
                    .addComponent(jButtonAdicionarComandante))
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

        jButtonAdicionarCoPiloto.setText("Adicionar");
        jButtonAdicionarCoPiloto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarCoPilotoActionPerformed(evt);
            }
        });

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
                        .addComponent(jButtonAdicionarCoPiloto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemoveCoPiloto))
                    .addGroup(jPanelTripulacaoCoPilotosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTripulacaoCoPilotosLayout.setVerticalGroup(
            jPanelTripulacaoCoPilotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTripulacaoCoPilotosLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTripulacaoCoPilotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoveCoPiloto)
                    .addComponent(jButton4)
                    .addComponent(jButtonAdicionarCoPiloto))
                .addContainerGap())
        );

        jPanelTripulacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Outros Tripulantes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTableTripulantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTableTripulantes);

        jButtonAdicionarTripulante.setText("Adicionar");
        jButtonAdicionarTripulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarTripulanteActionPerformed(evt);
            }
        });

        jButtonRemoveTripulante.setText("Remover");
        jButtonRemoveTripulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveTripulanteActionPerformed(evt);
            }
        });

        jButton5.setText("Editar");

        javax.swing.GroupLayout jPanelTripulacaoLayout = new javax.swing.GroupLayout(jPanelTripulacao);
        jPanelTripulacao.setLayout(jPanelTripulacaoLayout);
        jPanelTripulacaoLayout.setHorizontalGroup(
            jPanelTripulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTripulacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTripulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTripulacaoLayout.createSequentialGroup()
                        .addComponent(jButtonAdicionarTripulante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemoveTripulante))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelTripulacaoLayout.setVerticalGroup(
            jPanelTripulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTripulacaoLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTripulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoveTripulante)
                    .addComponent(jButton5)
                    .addComponent(jButtonAdicionarTripulante))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelTripulacaoComandantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelTripulacaoCoPilotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelTripulacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTripulacaoComandantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelTripulacaoCoPilotos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanelTripulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jTabbedTripulacoes.addTab("Tripulações", jPanel1);

        jTableCargas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableCargas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane5.setViewportView(jTableCargas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedTripulacoes.addTab("Cargas", jPanel3);

        jTableAeronaves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableAeronaves.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane7.setViewportView(jTableAeronaves);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedTripulacoes.addTab("Aeronaves", jPanel4);

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
        jScrollPane6.setViewportView(jTablePlacard);

        jLabelPlacard.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPlacard.setForeground(new java.awt.Color(255, 51, 51));
        jLabelPlacard.setText("Aeroporto de Gualtar");

        jLabelPlacardDia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPlacardDia.setText("placard");

        jLabelPlacardHora.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelPlacardHora.setText("placard");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                            .addComponent(jLabelPlacardDia))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelPlacard)
                        .addGap(234, 234, 234))))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(629, Short.MAX_VALUE)
                    .addComponent(jLabelPlacardHora)
                    .addGap(20, 20, 20)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabelPlacard)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPlacardDia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(389, Short.MAX_VALUE)
                    .addComponent(jLabelPlacardHora)
                    .addGap(21, 21, 21)))
        );

        jTabbedTripulacoes.addTab("Placard", jPanel5);

        jLabel1.setBackground(new java.awt.Color(255, 51, 51));
        jLabel1.setFont(new java.awt.Font("Gungsuh", 0, 18));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Outros/logo.png"))); // NOI18N
        jLabel1.setText("Aerogest");

        jLabelData.setText("Data:");

        jButtonActualizar.setText("ACTUALIZAR");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jMenuFicheiro.setText("Ficheiro");

        jMenuItemAbrirComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAbrirComo.setText("Abrir");
        jMenuItemAbrirComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirComoActionPerformed(evt);
            }
        });
        jMenuFicheiro.add(jMenuItemAbrirComo);
        jMenuFicheiro.add(jSeparator1);

        jMenuItemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemGuardar.setText("Guardar");
        jMenuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarActionPerformed(evt);
            }
        });
        jMenuFicheiro.add(jMenuItemGuardar);

        jMenuItemGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemGuardarComo.setText("Guardar como...");
        jMenuItemGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarComoActionPerformed(evt);
            }
        });
        jMenuFicheiro.add(jMenuItemGuardarComo);
        jMenuFicheiro.add(jSeparator2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Sair");
        jMenuFicheiro.add(jMenuItem3);

        jMenuBar1.add(jMenuFicheiro);

        jMenu2.setText("Ajuda");

        jMenuItemAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemAcerca.setText("Acerca");
        jMenuItemAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAcercaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemAcerca);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedTripulacoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonActualizar)
                        .addGap(170, 170, 170)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedTripulacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelData))
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
                // codigo do tripulante; 1ª coluna
                String codigo = (String) jTableComandantes.getValueAt(linha, 0);
                // nome do comandantes; 2ª coluna
                String nome = (String) jTableComandantes.getValueAt(linha, 1);
                // nacionalidade; 3ª coluna
                String nacionalidade = (String) jTableComandantes.getValueAt(linha, 2);
                // estado; 4ª coluna
                String estado = (String) jTableComandantes.getValueAt(linha, 3);

                // Comandante que está seleccionado
                Comandante c = new Comandante(codigo, nome, nacionalidade);
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
                // codigo do copiloto; 1ª coluna
                String codigo = (String) jTableCoPilotos.getValueAt(linha, 0);
                // nome; 2ª coluna
                String nome = (String) jTableCoPilotos.getValueAt(linha, 1);
                // nacionalidade; 3ª coluna
                String nacionalidade = (String) jTableCoPilotos.getValueAt(linha, 2);
                // estado; 4ª coluna
                String estado = (String) jTableCoPilotos.getValueAt(linha, 3);

                // Comandante que está seleccionado
                CoPiloto c = new CoPiloto(codigo, nome, nacionalidade);
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

    private void jMenuItemGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarComoActionPerformed
        JFileChooser fc = new JFileChooser();

        int returnVal = fc.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String nome = fc.getSelectedFile().getAbsolutePath();
            SaveLoadDB.saveDB(aerogestSistema, nome);
        }

    }//GEN-LAST:event_jMenuItemGuardarComoActionPerformed

    private void jMenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarActionPerformed
        int op = JOptionPane.showConfirmDialog(rootPane, "Pertende guardar a informacao?");
        if (op == 0) {
            SaveLoadDB.saveDB(aerogestSistema, "aeroguest.obj");
            JOptionPane.showMessageDialog(rootPane, "Guardado com sucesso", "", 1);
        }
    }//GEN-LAST:event_jMenuItemGuardarActionPerformed

    private void jMenuItemAbrirComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirComoActionPerformed
        JFileChooser fc = new JFileChooser();

        // opcao de se clicou
        int returnVal = fc.showOpenDialog(this);
        // se se clicou em abrir, vai carregar o ficheiro para o aerogestSistema
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            aerogestSistema = SaveLoadDB.loadDB(file.getAbsolutePath());
            actualizarTabelas();
        }
    }//GEN-LAST:event_jMenuItemAbrirComoActionPerformed

    private void jButtonAdicionarComandanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarComandanteActionPerformed

        String codigo = "" + JOptionPane.showInputDialog("Insira o codigo do comandante:");
        String nome = "" + JOptionPane.showInputDialog("Insira o nome do comandante:");
        String nacionalidade = "" + JOptionPane.showInputDialog("Insira a nacionalidade do comandante:");

        // verifica se todos os campos foram preenchidos
        if (!nacionalidade.equalsIgnoreCase("") && !nome.equalsIgnoreCase("") && !codigo.equalsIgnoreCase("")) {
            // cria um comandante
            Comandante c = new Comandante(codigo, nome, nacionalidade);
            // adiciona o comandante ao sistema
            aerogestSistema.adicionaComandante(c);
            JOptionPane.showMessageDialog(rootPane, "Comandante adicionado com sucesso");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Comandante não adicionado");
        }

        actualizarTabelas();
    }//GEN-LAST:event_jButtonAdicionarComandanteActionPerformed

    private void jButtonAdicionarCoPilotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarCoPilotoActionPerformed
        String codigo = "" + JOptionPane.showInputDialog("Insira o codigo do CoPiloto:");
        String nome = "" + JOptionPane.showInputDialog("Insira o nome do CoPiloto:");
        String nacionalidade = "" + JOptionPane.showInputDialog("Insira a nacionalidade do CoPiloto:");

        // verifica se todos os campos foram preenchidos
        if (!nacionalidade.equalsIgnoreCase("") && !nome.equalsIgnoreCase("") && !codigo.equalsIgnoreCase("")) {
            CoPiloto c = new CoPiloto(codigo, nome, nacionalidade);
            aerogestSistema.adicionaCoPiloto(c);
            JOptionPane.showMessageDialog(rootPane, "CoPiloto adicionado com sucesso");
        } else {
            JOptionPane.showMessageDialog(rootPane, "CoPiloto não adicionado");
        }

        actualizarTabelas();
    }//GEN-LAST:event_jButtonAdicionarCoPilotoActionPerformed

    private void jButtonAdicionarTripulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarTripulanteActionPerformed
        String funcao = "" + JOptionPane.showInputDialog("Insira a função do tripulante:");
        String codigo = "" + JOptionPane.showInputDialog("Insira o codigo do tripulante");
        String nome = "" + JOptionPane.showInputDialog("Insira o nome do tripulante:");
        String nacionalidade = "" + JOptionPane.showInputDialog("Insira a nacionalidade do tripulante:");

        // verifica se todos os campos foram preenchidos
        if (!funcao.equalsIgnoreCase("") && !nacionalidade.equalsIgnoreCase("") && !nome.equalsIgnoreCase("") && !codigo.equalsIgnoreCase("")) {
            Tripulante t = new Tripulante(codigo, funcao, nome, nacionalidade);
            aerogestSistema.adicionaTripulante(t);
            JOptionPane.showMessageDialog(rootPane, "Tripulante adicionado com sucesso");
        } else {
            JOptionPane.showMessageDialog(rootPane, "CoPiloto não adicionado");
        }

        actualizarTabelas();
    }//GEN-LAST:event_jButtonAdicionarTripulanteActionPerformed

    /**
     * Evento que permite remover o tripulante do sistema
     * @param evt 
     */
    private void jButtonRemoveTripulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveTripulanteActionPerformed
        // linha que está seleccionada
        int linha = jTableTripulantes.getSelectedRow();

        // se alguma linha estiver seleccionada
        if (linha >= 0) {
            int escolha = JOptionPane.showConfirmDialog(rootPane, "Tem a ceteza que prentende remover o Tripulante seleccionado?", "Remover Tripulante", 1);
            if (escolha == 0) {
                // codigo; 1ª coluna
                String funcao = (String) jTableTripulantes.getValueAt(linha, 0);
                // codigo; 2ª coluna
                String codigo = (String) jTableTripulantes.getValueAt(linha, 1);
                // nome; 3ª coluna
                String nome = (String) jTableTripulantes.getValueAt(linha, 2);
                // nacionalidade; 4ª coluna
                String nacionalidade = (String) jTableTripulantes.getValueAt(linha, 3);
                // estado; 5ª coluna
                String estado = (String) jTableTripulantes.getValueAt(linha, 4);

                // Comandante que está seleccionado
                Tripulante t = new Tripulante(codigo, funcao, nome, nacionalidade);
                // altera o estado caso seja necessário, porque ele inicialmente está sempre livre
                if (estado.equalsIgnoreCase("ocupado")) {
                    t.setLivre(false);
                }

                // remove do Sistema o comandante
                aerogestSistema.removeTripulante(t);
                // actualiza a tabela
                actualizarTabelas();
                JOptionPane.showMessageDialog(rootPane, "Remoção efectuado com sucesso!", "Tripulante removido", 1);
            }
        }
    }//GEN-LAST:event_jButtonRemoveTripulanteActionPerformed

    private void jMenuItemAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAcercaActionPerformed
        String s = "PROGRAMAÇÃO ORIENTADA AOS OBJECTOS\n\n";
        s = s + "Software criado por:\n";
        s = s + "       * 54746 Miguel Costa\n";
        s = s + "       * 54782 Sofia Vieira\n";
        s = s + "       * 54822 Fábio Costa\n";
        s = s + "\n";
        s = s + "WebSite:\n http://code.google.com/p/poo-trabalho-pratico-2011/\n\n";

        JOptionPane.showMessageDialog(rootPane, s, "Acerca", 1);
    }//GEN-LAST:event_jMenuItemAcercaActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        actualizarTabelas();
    }//GEN-LAST:event_jButtonActualizarActionPerformed

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

    private static void centerOnScreen(final Component target) {
        if (target != null) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension dialogSize = target.getSize();

            if (dialogSize.height > screenSize.height) {
                dialogSize.height = screenSize.height;
            }
            if (dialogSize.width > screenSize.width) {
                dialogSize.width = screenSize.width;
            }

            target.setLocation((screenSize.width - dialogSize.width) / 2,
                    (screenSize.height - dialogSize.height) / 2);
        }
    }

    private static String diaEmString(GregorianCalendar d) {
        String s = "";
        s = s + d.get(Calendar.DAY_OF_MONTH);
        s = s + "/";
        s = s + (d.get(Calendar.MONDAY) + 1);
        s = s + "/";
        s = s + d.get(Calendar.YEAR);
        return s;
    }

    private static String horaEmString(GregorianCalendar d) {
        String s = "";
        s = s + d.get(Calendar.HOUR_OF_DAY);
        s = s + "h";
        s = s + d.get(Calendar.MINUTE);
        s = s + "min";
        return s;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAdicionarCoPiloto;
    private javax.swing.JButton jButtonAdicionarComandante;
    private javax.swing.JButton jButtonAdicionarTripulante;
    private javax.swing.JButton jButtonRemoveCoPiloto;
    private javax.swing.JButton jButtonRemoveComandante;
    private javax.swing.JButton jButtonRemoveTripulante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelPlacard;
    private javax.swing.JLabel jLabelPlacardDia;
    private javax.swing.JLabel jLabelPlacardHora;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFicheiro;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemAbrirComo;
    private javax.swing.JMenuItem jMenuItemAcerca;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenuItem jMenuItemGuardarComo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelTripulacao;
    private javax.swing.JPanel jPanelTripulacaoCoPilotos;
    private javax.swing.JPanel jPanelTripulacaoComandantes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedTripulacoes;
    private javax.swing.JTable jTableAeronaves;
    private javax.swing.JTable jTableCargas;
    private javax.swing.JTable jTableCoPilotos;
    private javax.swing.JTable jTableComandantes;
    private javax.swing.JTable jTableMapaVoos;
    private javax.swing.JTable jTablePlacard;
    private javax.swing.JTable jTableTripulantes;
    // End of variables declaration//GEN-END:variables
}
