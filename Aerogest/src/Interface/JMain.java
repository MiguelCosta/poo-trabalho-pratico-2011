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
import Classes.Porta;
import Classes.Tripulacao;
import Classes.Tripulante;
import Classes.Voo;
import Importer.SaveLoadDB;
import aerogest.AerogestSistema;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
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

        alterarTema();

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

    private void alterarTema() {
        /* Temas instalados
        javax.swing.plaf.metal.MetalLookAndFeel
        com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel
        com.sun.java.swing.plaf.motif.MotifLookAndFeel
        com.sun.java.swing.plaf.windows.WindowsLookAndFeel
        com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel
         * 
        UIManager.LookAndFeelInfo[] instalados = UIManager.getInstalledLookAndFeels(); 
        System.out.println(instalados[0].getClassName());
        System.out.println(instalados[1].getClassName());
        System.out.println(instalados[2].getClassName());
        System.out.println(instalados[3].getClassName());
        System.out.println(instalados[4].getClassName());
         * 
         */

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o \"Skin\" padrão. Definindo o padrão original.", "Erro", JOptionPane.ERROR_MESSAGE);
        }


    }

    private void actualizarTabelas() {
        actualizarTabelaComandantes();
        actualizarTabelaCoPilotos();
        actualizarTabelaTrpulantesAdicionais();
        actualizarTabelaCargas();
        actualizarTabelaMapaVoos();
        actualizarTabelaAeronaves();
        actualizarTabelaPlacard();
        actualizarComboBoxs();
        actualizarEstatisticas();
        actualizarData(aerogestSistema.getHoraActual());
        //aerogestSistema.transitaAutomatico();
    }

    private void actualizarEstatisticas(){
        //voos
        jLabel_Voos_Previstos.setText(""+aerogestSistema.getNumVoos());
        jLabel_Voos_Especificados.setText(""+aerogestSistema.getVoosEspecificados());
        jLabel_Voos_P1.setText(""+aerogestSistema.getVoosP1());
        jLabel_Voos_P2.setText(""+aerogestSistema.getVoosP2());
        jLabel_Voos_Atr.setText(""+aerogestSistema.getVoosAtr());
        jLabel_Voos_Ptr.setText(""+aerogestSistema.getVoosPtr());
        jLabel_Voos_ar.setText(""+aerogestSistema.getVoosAr());
        jLabel_Voos_Can.setText(""+aerogestSistema.getVoosCan());
        jLabel_Voos_Conc.setText(""+aerogestSistema.getVoosAr());

        //pass
        jLabel_Pass_total.setText(""+aerogestSistema.getNumPassTotal());
        jLabel_Pass_emb.setText(""+aerogestSistema.getNumPassEmb());
        jLabel_Pass_nemb.setText(""+aerogestSistema.getNumPassNEmb());

        //pass com
        jLabel_Pass_Com_total.setText(""+aerogestSistema.getNumPassComTotal());
        jLabel_Pass_Com_emb.setText(""+aerogestSistema.getNumPassComEmb());
        jLabel_Pass_Com_nemb.setText(""+aerogestSistema.getNumPassComNEmb());

        //carga
        jLabel_Cargas_total.setText(""+aerogestSistema.getNumCargasTotal());
        jLabel_Cargas_emb.setText(""+aerogestSistema.getNumCargasEmb());
        jLabel_Cargas_nemb.setText(""+aerogestSistema.getNumCargasNEmb());

        //cargas peso
        jLabel_Cargas_Peso_total.setText(""+aerogestSistema.getNumCargasPesoTotal());
        jLabel_Cargas_Peso_emb.setText(""+aerogestSistema.getNumCargasPesoEmb());
        jLabel_Cargas_Peso_nemb.setText(""+aerogestSistema.getNumCargasPesoNEmb());
    }

    private void actualizarData(GregorianCalendar data) {
        String s = "Data: ";
        s = s + diaEmString(data);
        s = s + " " + data.get(GregorianCalendar.HOUR_OF_DAY) + ":" + data.get(GregorianCalendar.MINUTE);

        jLabelData.setText(s);

        String s1 = diaEmString(data);
        String s2 = horaEmString(data);
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
        aeronaves.addColumn("Tipo");
        aeronaves.addColumn("Matricula");
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
                String tipo = tipoDeAeronave(a);
                String[] livre = {tipo, a.getMatricula(), "" + a.getCapacidadePassageiros(), "" + a.getCapacidadeCarga(), "" + a.getVelocidadeMaxima(), "livre"};
                aeronaves.addRow(livre);
            } else {
                String tipo = tipoDeAeronave(a);
                String[] ocupada = {tipo, a.getMatricula(), "" + a.getCapacidadePassageiros(), "" + a.getCapacidadeCarga(), "" + a.getVelocidadeMaxima(), "ocupada"};
                aeronaves.addRow(ocupada);
            }
        }

        jTableAeronaves.setModel(aeronaves);
    }

    private String tipoDeAeronave(Aeronave a) {
        String r = a.getClass().getName();

        if (r.equalsIgnoreCase("Classes.AeronaveAviao")) {
            r = "Aviao";
        }
        if (r.equalsIgnoreCase("Classes.AeronaveHelicopetro")) {
            r = "Helicopetro";
        }
        if (r.equalsIgnoreCase("Classes.AeronaveJacto")) {
            r = "Jacto";
        }

        return r;
    }

    private void actualizarComboBoxs() {
        jComboBoxEspecificados.removeAllItems();
        jComboBoxNoAr.removeAllItems();
        jComboBoxPreparacao1.removeAllItems();
        jComboBoxPreparacao2.removeAllItems();
        jComboBoxPreparacao2Atrasado.removeAllItems();
        jComboBoxPronto.removeAllItems();

        TreeMap<GregorianCalendar, TreeMap<String, Voo>> r = new TreeMap<GregorianCalendar, TreeMap<String, Voo>>();
        r = aerogestSistema.getMapaVoos();
        for (GregorianCalendar d : r.keySet()) {
            for (Voo voo : r.get(d).values()) {
                String estado = voo.getEstado();
                if (estado.equalsIgnoreCase(Voo.VooEspecificado)) {
                    jComboBoxEspecificados.addItem(voo.getEntidade() + voo.getCodigoVoo());
                } else if (estado.equalsIgnoreCase(Voo.VooEmPreparacao1)) {
                    jComboBoxPreparacao1.addItem(voo.getEntidade() + voo.getCodigoVoo());
                } else if (estado.equalsIgnoreCase("Voo Em Preparação 2")) {
                    jComboBoxPreparacao2.addItem(voo.getEntidade() + voo.getCodigoVoo());
                } else if (estado.equalsIgnoreCase("Voo Em Preparação 2 com Atraso")) {
                    jComboBoxPreparacao2Atrasado.addItem(voo.getEntidade() + voo.getCodigoVoo());
                } else if (estado.equalsIgnoreCase("Voo Pronto")) {
                    jComboBoxPronto.addItem(voo.getEntidade() + voo.getCodigoVoo());
                } else if (estado.equalsIgnoreCase("Voo no ar")) {
                    jComboBoxNoAr.addItem(voo.getEntidade() + voo.getCodigoVoo());
                }
            }
        }

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
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jComboBoxEspecificados = new javax.swing.JComboBox();
        jButtonEspecificadoAtribuirAeronave = new javax.swing.JButton();
        jButtonEspecificadoAtribuirTripulacao = new javax.swing.JButton();
        jButtonEspecificadoAtribuirPorta = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jComboBoxPreparacao1 = new javax.swing.JComboBox();
        jButtonPreparacao1Transitar = new javax.swing.JButton();
        jButtonPreparacao1Cancelar = new javax.swing.JButton();
        jButtonPreparacao1AtribuirCarga = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jComboBoxPreparacao2 = new javax.swing.JComboBox();
        jButtonPreparacao2Transitar = new javax.swing.JButton();
        jButtonPreparacao2Embarcar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jComboBoxPreparacao2Atrasado = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButtonPreparacao2Embarcar1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jComboBoxPronto = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        jButtonProntoCancelar = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jComboBoxNoAr = new javax.swing.JComboBox();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabelData2 = new javax.swing.JLabel();
        jLabel_Pass_total = new javax.swing.JLabel();
        jLabelData4 = new javax.swing.JLabel();
        jLabel_Pass_emb = new javax.swing.JLabel();
        jLabelData6 = new javax.swing.JLabel();
        jLabel_Pass_nemb = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabelData20 = new javax.swing.JLabel();
        jLabel_Voos_Previstos = new javax.swing.JLabel();
        jLabelData22 = new javax.swing.JLabel();
        jLabel_Voos_Especificados = new javax.swing.JLabel();
        jLabelData24 = new javax.swing.JLabel();
        jLabel_Voos_P1 = new javax.swing.JLabel();
        jLabelData26 = new javax.swing.JLabel();
        jLabel_Voos_P2 = new javax.swing.JLabel();
        jLabelData28 = new javax.swing.JLabel();
        jLabel_Voos_Atr = new javax.swing.JLabel();
        jLabelData30 = new javax.swing.JLabel();
        jLabel_Voos_Ptr = new javax.swing.JLabel();
        jLabelData32 = new javax.swing.JLabel();
        jLabel_Voos_ar = new javax.swing.JLabel();
        jLabelData34 = new javax.swing.JLabel();
        jLabel_Voos_Can = new javax.swing.JLabel();
        jLabelData36 = new javax.swing.JLabel();
        jLabel_Voos_Conc = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabelData8 = new javax.swing.JLabel();
        jLabel_Pass_Com_total = new javax.swing.JLabel();
        jLabelData10 = new javax.swing.JLabel();
        jLabel_Pass_Com_emb = new javax.swing.JLabel();
        jLabelData12 = new javax.swing.JLabel();
        jLabel_Pass_Com_nemb = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabelData18 = new javax.swing.JLabel();
        jLabel_Cargas_total = new javax.swing.JLabel();
        jLabelData38 = new javax.swing.JLabel();
        jLabel_Cargas_emb = new javax.swing.JLabel();
        jLabelData40 = new javax.swing.JLabel();
        jLabel_Cargas_nemb = new javax.swing.JLabel();
        jLabelData44 = new javax.swing.JLabel();
        jLabelData45 = new javax.swing.JLabel();
        jLabel_Cargas_Peso_total = new javax.swing.JLabel();
        jLabel_Cargas_Peso_emb = new javax.swing.JLabel();
        jLabelData49 = new javax.swing.JLabel();
        jLabel_Cargas_Peso_nemb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jButtonActualizar = new javax.swing.JButton();
        jTextField_MINUTOS = new javax.swing.JTextField();
        jTextField_HORA = new javax.swing.JTextField();
        jLabelData1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFicheiro = new javax.swing.JMenu();
        jMenuItemAbrirComo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jMenuItemGuardarComo = new javax.swing.JMenuItem();
        jMenuItemGuardarTexto = new javax.swing.JMenuItem();
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelTripulacaoLayout.setVerticalGroup(
            jPanelTripulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTripulacaoLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jPanelTripulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
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

        jLabelPlacard.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabelPlacard.setForeground(new java.awt.Color(255, 51, 51));
        jLabelPlacard.setText("Aeroporto de Gualtar");

        jLabelPlacardDia.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabelPlacardDia.setText("placard");

        jLabelPlacardHora.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabelPlacardHora.setText("placard");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelPlacardDia)
                        .addContainerGap(689, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelPlacard)
                        .addGap(234, 234, 234))))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(681, Short.MAX_VALUE)
                    .addComponent(jLabelPlacardHora)
                    .addGap(20, 20, 20)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabelPlacard)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelPlacardDia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(390, Short.MAX_VALUE)
                    .addComponent(jLabelPlacardHora)
                    .addGap(21, 21, 21)))
        );

        jTabbedTripulacoes.addTab("Placard", jPanel5);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transicoes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Voos Especificados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jButtonEspecificadoAtribuirAeronave.setText("Atribuir Aeronave");
        jButtonEspecificadoAtribuirAeronave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspecificadoAtribuirAeronaveActionPerformed(evt);
            }
        });

        jButtonEspecificadoAtribuirTripulacao.setText("Atribuir Tripulacao");
        jButtonEspecificadoAtribuirTripulacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspecificadoAtribuirTripulacaoActionPerformed(evt);
            }
        });

        jButtonEspecificadoAtribuirPorta.setText("Atribuir Porta");
        jButtonEspecificadoAtribuirPorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspecificadoAtribuirPortaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jComboBoxEspecificados, 0, 213, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEspecificadoAtribuirTripulacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEspecificadoAtribuirAeronave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEspecificadoAtribuirPorta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jComboBoxEspecificados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEspecificadoAtribuirAeronave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEspecificadoAtribuirTripulacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEspecificadoAtribuirPorta)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Em Preparacao 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jButtonPreparacao1Transitar.setText("Transitar");
        jButtonPreparacao1Transitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreparacao1TransitarActionPerformed(evt);
            }
        });

        jButtonPreparacao1Cancelar.setText("Cancelar");
        jButtonPreparacao1Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreparacao1CancelarActionPerformed(evt);
            }
        });

        jButtonPreparacao1AtribuirCarga.setText("Carga");
        jButtonPreparacao1AtribuirCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreparacao1AtribuirCargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxPreparacao1, 0, 206, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonPreparacao1Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPreparacao1AtribuirCarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPreparacao1Transitar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jComboBoxPreparacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPreparacao1AtribuirCarga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPreparacao1Transitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPreparacao1Cancelar)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Em Preparacao 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jButtonPreparacao2Transitar.setText("Transitar");
        jButtonPreparacao2Transitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreparacao2TransitarActionPerformed(evt);
            }
        });

        jButtonPreparacao2Embarcar.setText("Embarcar Passgeiros");
        jButtonPreparacao2Embarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreparacao2EmbarcarActionPerformed(evt);
            }
        });

        jButton2.setText("Atrasar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxPreparacao2, 0, 224, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPreparacao2Transitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPreparacao2Embarcar))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jComboBoxPreparacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPreparacao2Embarcar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPreparacao2Transitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Em Preparacao 2 com Atraso", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jButton1.setText("Transitar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonPreparacao2Embarcar1.setText("Embarcar Passgeiros");
        jButtonPreparacao2Embarcar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreparacao2Embarcar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPreparacao2Atrasado, 0, 213, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButtonPreparacao2Embarcar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(47, 47, 47))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButton1)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jComboBoxPreparacao2Atrasado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPreparacao2Embarcar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Voo Pronto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jButton6.setText("Take Off");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButtonProntoCancelar.setText("Cancelar");
        jButtonProntoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProntoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jComboBoxPronto, 0, 194, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonProntoCancelar)
                            .addComponent(jButton6))
                        .addGap(69, 69, 69))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jComboBoxPronto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonProntoCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Voo no Ar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxNoAr, 0, 209, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jComboBoxNoAr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedTripulacoes.addTab("Controlo dos Voos", jPanel6);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Passageiros"));

        jLabelData2.setText("Passageiros Previstos Total:");

        jLabel_Pass_total.setText("0");

        jLabelData4.setText("Passageiros Embarcados :");

        jLabel_Pass_emb.setText("0");

        jLabelData6.setText("Passageiros Não Embarcados");

        jLabel_Pass_nemb.setText("0");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabelData2)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel_Pass_total, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabelData4)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel_Pass_emb, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabelData6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Pass_nemb, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData2)
                    .addComponent(jLabel_Pass_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData4)
                    .addComponent(jLabel_Pass_emb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData6)
                    .addComponent(jLabel_Pass_nemb))
                .addGap(23, 23, 23))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Voos"));

        jLabelData20.setText("Voos Previstos :");

        jLabel_Voos_Previstos.setText("0");

        jLabelData22.setText("Voos Especificados :");

        jLabel_Voos_Especificados.setText("0");

        jLabelData24.setText("Voos Preparação1 :");

        jLabel_Voos_P1.setText("0");

        jLabelData26.setText("Voos Preparação2 :");

        jLabel_Voos_P2.setText("0");

        jLabelData28.setText("Voos Atrasados :");

        jLabel_Voos_Atr.setText("0");

        jLabelData30.setText("Voos Prontos :");

        jLabel_Voos_Ptr.setText("0");

        jLabelData32.setText("Voos No Ar :");

        jLabel_Voos_ar.setText("0");

        jLabelData34.setText("Voos Cancelados :");

        jLabel_Voos_Can.setText("0");

        jLabelData36.setText("Voos Concluidos :");

        jLabel_Voos_Conc.setText("0");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelData26)
                    .addComponent(jLabelData28)
                    .addComponent(jLabelData30)
                    .addComponent(jLabelData32)
                    .addComponent(jLabelData34)
                    .addComponent(jLabelData36)
                    .addComponent(jLabelData20)
                    .addComponent(jLabelData22)
                    .addComponent(jLabelData24))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Voos_Previstos, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jLabel_Voos_Especificados, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jLabel_Voos_P1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jLabel_Voos_P2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jLabel_Voos_Atr, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jLabel_Voos_Ptr, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jLabel_Voos_ar, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jLabel_Voos_Can, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jLabel_Voos_Conc, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData20)
                    .addComponent(jLabel_Voos_Previstos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData22)
                    .addComponent(jLabel_Voos_Especificados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Voos_P1)
                    .addComponent(jLabelData24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelData26)
                    .addComponent(jLabel_Voos_P2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelData28)
                    .addComponent(jLabel_Voos_Atr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelData30)
                    .addComponent(jLabel_Voos_Ptr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelData32)
                    .addComponent(jLabel_Voos_ar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelData34)
                    .addComponent(jLabel_Voos_Can))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelData36)
                    .addComponent(jLabel_Voos_Conc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Passageiros (Voos Comerciais)"));

        jLabelData8.setText("Passageiros Previstos Total:");

        jLabel_Pass_Com_total.setText("0");

        jLabelData10.setText("Passageiros Embarcados :");

        jLabel_Pass_Com_emb.setText("0");

        jLabelData12.setText("Passageiros Não Embarcados");

        jLabel_Pass_Com_nemb.setText("0");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelData12)
                    .addComponent(jLabelData8)
                    .addComponent(jLabelData10))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Pass_Com_total, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jLabel_Pass_Com_emb, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jLabel_Pass_Com_nemb, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData8)
                    .addComponent(jLabel_Pass_Com_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData10)
                    .addComponent(jLabel_Pass_Com_emb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData12)
                    .addComponent(jLabel_Pass_Com_nemb))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Carga"));

        jLabelData18.setText("Cargas Previstas:");

        jLabel_Cargas_total.setText("0");

        jLabelData38.setText("Cargas Embarcadas :");

        jLabel_Cargas_emb.setText("0");

        jLabelData40.setText("Cargas Não Embarcados:");

        jLabel_Cargas_nemb.setText("0");

        jLabelData44.setText("(Peso) Cargas Previstas:");

        jLabelData45.setText("(Peso) Cargas Embarcadas :");

        jLabel_Cargas_Peso_total.setText("0");

        jLabel_Cargas_Peso_emb.setText("0");

        jLabelData49.setText("(Peso) Cargas Não Embarcados:");

        jLabel_Cargas_Peso_nemb.setText("0");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelData40)
                    .addComponent(jLabelData18)
                    .addComponent(jLabelData38))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_Cargas_total, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jLabel_Cargas_emb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Cargas_nemb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelData49)
                    .addComponent(jLabelData45)
                    .addComponent(jLabelData44))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Cargas_Peso_total, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jLabel_Cargas_Peso_emb, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jLabel_Cargas_Peso_nemb, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData18)
                    .addComponent(jLabel_Cargas_total)
                    .addComponent(jLabelData44)
                    .addComponent(jLabel_Cargas_Peso_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData38)
                    .addComponent(jLabel_Cargas_emb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData40)
                    .addComponent(jLabel_Cargas_nemb))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData45)
                    .addComponent(jLabel_Cargas_Peso_emb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData49)
                    .addComponent(jLabel_Cargas_Peso_nemb))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel18, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48))
        );

        jTabbedTripulacoes.addTab("Estatisticas", jPanel14);

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

        jTextField_MINUTOS.setText("00");

        jTextField_HORA.setText("00");

        jLabelData1.setText(":");

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

        jMenuItemGuardarTexto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemGuardarTexto.setText("Guardar em texto");
        jMenuItemGuardarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarTextoActionPerformed(evt);
            }
        });
        jMenuFicheiro.add(jMenuItemGuardarTexto);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedTripulacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                        .addComponent(jTextField_HORA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelData1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_MINUTOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonActualizar)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedTripulacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelData)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabelData1)
                        .addComponent(jTextField_MINUTOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_HORA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        int hora = Integer.parseInt(jTextField_HORA.getText());
        int minutos = Integer.parseInt(jTextField_MINUTOS.getText());

        aerogestSistema.setHoraActual(hora,minutos);

         aerogestSistema.updateVoos();
        actualizarTabelas();
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jMenuItemGuardarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarTextoActionPerformed
        JFileChooser fc = new JFileChooser();

        int returnVal = fc.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String nome = fc.getSelectedFile().getAbsolutePath();
            SaveLoadDB.showDBInFile(aerogestSistema, nome);
        }
    }//GEN-LAST:event_jMenuItemGuardarTextoActionPerformed

    private void jButtonEspecificadoAtribuirAeronaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspecificadoAtribuirAeronaveActionPerformed
        String codigo_voo = jComboBoxEspecificados.getSelectedItem().toString();

        if (!codigo_voo.equalsIgnoreCase("") || !codigo_voo.equalsIgnoreCase(null)) {
            boolean temAeronave = aerogestSistema.vooTemAeronave(codigo_voo);
            if (!temAeronave) {
                List<Aeronave> livres = new ArrayList<Aeronave>();
                livres = aerogestSistema.aeronavesLivers();
                String opcoes = "Aeronaves Livres:\n";

                for (Aeronave a : livres) {
                    opcoes += a.getMatricula() + "\n";
                }

                String escolha = JOptionPane.showInputDialog(opcoes);
                aerogestSistema.alteraEstadoAeronave(escolha);
                aerogestSistema.atribui_aeronave_voo(escolha, codigo_voo);

                Voo v = aerogestSistema.getVoo(codigo_voo);

                if (v.getPorta() != null && v.getTripulacao() != null)
                    v.setVooEmPreparacao1(v.getAeronave(),  v.getTripulacao(), v.getPorta(), aerogestSistema.getHoraActual());
            } else {
                JOptionPane.showMessageDialog(rootPane, "O voo " + codigo_voo + " já tem uma aeronave associada!");
            }
        }

    }//GEN-LAST:event_jButtonEspecificadoAtribuirAeronaveActionPerformed

    private void jButtonEspecificadoAtribuirTripulacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspecificadoAtribuirTripulacaoActionPerformed
        String codigo_voo = jComboBoxEspecificados.getSelectedItem().toString();

        if (!codigo_voo.equalsIgnoreCase("") || !codigo_voo.equalsIgnoreCase(null)) {
            boolean temTripulacao = aerogestSistema.vooTemTripulacao(codigo_voo);
            if (!temTripulacao) {
                List<Tripulacao> livres = new ArrayList<Tripulacao>();
                livres = aerogestSistema.tripulacoesLivres();
                String opcoes = "Tripulacoes Livres:\n";

                for (Tripulacao a : livres) {
                    opcoes += a.getCodigo() + "\n";
                }

                String escolha = JOptionPane.showInputDialog(opcoes);
                aerogestSistema.tripulacaoMudaEstado(escolha);
                aerogestSistema.atribui_tripulacao(escolha, codigo_voo);
                Voo v = aerogestSistema.getVoo(codigo_voo);

                if (v.getPorta() != null && v.getTripulacao() != null)
                    v.setVooEmPreparacao1(v.getAeronave(),  v.getTripulacao(), v.getPorta(), aerogestSistema.getHoraActual());
            } else {
                JOptionPane.showMessageDialog(rootPane, "O voo " + codigo_voo + " já tem uma tripulacao associada!");
            }
        }

    }//GEN-LAST:event_jButtonEspecificadoAtribuirTripulacaoActionPerformed

    private void jButtonEspecificadoAtribuirPortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspecificadoAtribuirPortaActionPerformed
        String codigo_voo = jComboBoxEspecificados.getSelectedItem().toString();

        if (!codigo_voo.equalsIgnoreCase("") || !codigo_voo.equalsIgnoreCase(null)) {
            boolean temPorta = aerogestSistema.vooTemPorta(codigo_voo);
            if (!temPorta) {
                List<Porta> livres = new ArrayList<Porta>();
                livres = aerogestSistema.portasLivres();
                String opcoes = "Portas livres: \n";

                for (Porta p : livres) {
                    opcoes += p.getCodPorta() + "\n";
                }
                String escolha = JOptionPane.showInputDialog(opcoes);
                aerogestSistema.atribui_porta(escolha, codigo_voo);

                Voo v = aerogestSistema.getVoo(codigo_voo);

                if (v.getPorta() != null && v.getTripulacao() != null)
                    v.setVooEmPreparacao1(v.getAeronave(),  v.getTripulacao(), v.getPorta(), aerogestSistema.getHoraActual());
            } else {
                JOptionPane.showMessageDialog(rootPane, "O voo " + codigo_voo + " já tem uma porta associada!");
            }
        }
    }//GEN-LAST:event_jButtonEspecificadoAtribuirPortaActionPerformed

    private void jButtonPreparacao1AtribuirCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreparacao1AtribuirCargaActionPerformed
        String codigo_voo = jComboBoxPreparacao1.getSelectedItem().toString();

        VooCargas.main(codigo_voo, aerogestSistema, aerogestSistema.getHoraActual());
    }//GEN-LAST:event_jButtonPreparacao1AtribuirCargaActionPerformed

    private void jButtonPreparacao2EmbarcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreparacao2EmbarcarActionPerformed
        String codigo_voo = jComboBoxPreparacao2.getSelectedItem().toString();

        VooPassageiros.main(codigo_voo, aerogestSistema, aerogestSistema.getHoraActual());
    }//GEN-LAST:event_jButtonPreparacao2EmbarcarActionPerformed

    private void jButtonPreparacao2Embarcar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreparacao2Embarcar1ActionPerformed
        String codigo_voo = jComboBoxPreparacao2Atrasado.getSelectedItem().toString();

        VooPassageiros.main(codigo_voo, aerogestSistema, aerogestSistema.getHoraActual());
    }//GEN-LAST:event_jButtonPreparacao2Embarcar1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String codigo_voo = jComboBoxPreparacao2.getSelectedItem().toString();
        aerogestSistema.vooMudaEstado(codigo_voo, Voo.VooEmPreparacao2Atraso);

        JOptionPane.showMessageDialog(rootPane, "Voo Atrasado!");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonPreparacao2TransitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreparacao2TransitarActionPerformed
        String codigo_voo = jComboBoxPreparacao2.getSelectedItem().toString();
        Voo v = aerogestSistema.getMapaVoos().get(aerogestSistema.getHoraActual()).get(codigo_voo);
        aerogestSistema.vooMudaEstado(codigo_voo, Voo.VooPronto);
        
        String obs = JOptionPane.showInputDialog("Observações: ");
        aerogestSistema.adicionaObservacao(codigo_voo, obs);
    }//GEN-LAST:event_jButtonPreparacao2TransitarActionPerformed

    private void jButtonProntoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProntoCancelarActionPerformed
        String codigo_voo = jComboBoxPronto.getSelectedItem().toString();
        Voo v = aerogestSistema.getMapaVoos().get(aerogestSistema.getHoraActual()).get(codigo_voo);
        aerogestSistema.vooMudaEstado(codigo_voo, Voo.VooCancelado);
    }//GEN-LAST:event_jButtonProntoCancelarActionPerformed

    private void jButtonPreparacao1CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreparacao1CancelarActionPerformed
        String codigo_voo = jComboBoxPreparacao1.getSelectedItem().toString();
        Voo v = aerogestSistema.getMapaVoos().get(aerogestSistema.getHoraActual()).get(codigo_voo);
        aerogestSistema.vooMudaEstado(codigo_voo, Voo.VooCancelado);
    }//GEN-LAST:event_jButtonPreparacao1CancelarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String codigo_voo = jComboBoxPronto.getSelectedItem().toString();
        Voo v = aerogestSistema.getMapaVoos().get(aerogestSistema.getHoraActual()).get(codigo_voo);
        aerogestSistema.vooMudaEstado(codigo_voo, Voo.VooNoAr);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String codigo_voo = jComboBoxPreparacao2Atrasado.getSelectedItem().toString();
        Voo v = aerogestSistema.getMapaVoos().get(aerogestSistema.getHoraActual()).get(codigo_voo);
        aerogestSistema.vooMudaEstado(codigo_voo, Voo.VooPronto);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonPreparacao1TransitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreparacao1TransitarActionPerformed
        String codigo_voo = jComboBoxPreparacao1.getSelectedItem().toString();
        if (aerogestSistema.vooTemCarga(codigo_voo)) {
            aerogestSistema.vooMudaEstado(codigo_voo, Voo.VooEmPreparacao2);
        }
        String obs = JOptionPane.showInputDialog("Observações: ");
        aerogestSistema.adicionaObservacao(codigo_voo, obs);
}//GEN-LAST:event_jButtonPreparacao1TransitarActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAdicionarCoPiloto;
    private javax.swing.JButton jButtonAdicionarComandante;
    private javax.swing.JButton jButtonAdicionarTripulante;
    private javax.swing.JButton jButtonEspecificadoAtribuirAeronave;
    private javax.swing.JButton jButtonEspecificadoAtribuirPorta;
    private javax.swing.JButton jButtonEspecificadoAtribuirTripulacao;
    private javax.swing.JButton jButtonPreparacao1AtribuirCarga;
    private javax.swing.JButton jButtonPreparacao1Cancelar;
    private javax.swing.JButton jButtonPreparacao1Transitar;
    private javax.swing.JButton jButtonPreparacao2Embarcar;
    private javax.swing.JButton jButtonPreparacao2Embarcar1;
    private javax.swing.JButton jButtonPreparacao2Transitar;
    private javax.swing.JButton jButtonProntoCancelar;
    private javax.swing.JButton jButtonRemoveCoPiloto;
    private javax.swing.JButton jButtonRemoveComandante;
    private javax.swing.JButton jButtonRemoveTripulante;
    private javax.swing.JComboBox jComboBoxEspecificados;
    private javax.swing.JComboBox jComboBoxNoAr;
    private javax.swing.JComboBox jComboBoxPreparacao1;
    private javax.swing.JComboBox jComboBoxPreparacao2;
    private javax.swing.JComboBox jComboBoxPreparacao2Atrasado;
    private javax.swing.JComboBox jComboBoxPronto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelData1;
    private javax.swing.JLabel jLabelData10;
    private javax.swing.JLabel jLabelData12;
    private javax.swing.JLabel jLabelData18;
    private javax.swing.JLabel jLabelData2;
    private javax.swing.JLabel jLabelData20;
    private javax.swing.JLabel jLabelData22;
    private javax.swing.JLabel jLabelData24;
    private javax.swing.JLabel jLabelData26;
    private javax.swing.JLabel jLabelData28;
    private javax.swing.JLabel jLabelData30;
    private javax.swing.JLabel jLabelData32;
    private javax.swing.JLabel jLabelData34;
    private javax.swing.JLabel jLabelData36;
    private javax.swing.JLabel jLabelData38;
    private javax.swing.JLabel jLabelData4;
    private javax.swing.JLabel jLabelData40;
    private javax.swing.JLabel jLabelData44;
    private javax.swing.JLabel jLabelData45;
    private javax.swing.JLabel jLabelData49;
    private javax.swing.JLabel jLabelData6;
    private javax.swing.JLabel jLabelData8;
    private javax.swing.JLabel jLabelPlacard;
    private javax.swing.JLabel jLabelPlacardDia;
    private javax.swing.JLabel jLabelPlacardHora;
    private javax.swing.JLabel jLabel_Cargas_Peso_emb;
    private javax.swing.JLabel jLabel_Cargas_Peso_nemb;
    private javax.swing.JLabel jLabel_Cargas_Peso_total;
    private javax.swing.JLabel jLabel_Cargas_emb;
    private javax.swing.JLabel jLabel_Cargas_nemb;
    private javax.swing.JLabel jLabel_Cargas_total;
    private javax.swing.JLabel jLabel_Pass_Com_emb;
    private javax.swing.JLabel jLabel_Pass_Com_nemb;
    private javax.swing.JLabel jLabel_Pass_Com_total;
    private javax.swing.JLabel jLabel_Pass_emb;
    private javax.swing.JLabel jLabel_Pass_nemb;
    private javax.swing.JLabel jLabel_Pass_total;
    private javax.swing.JLabel jLabel_Voos_Atr;
    private javax.swing.JLabel jLabel_Voos_Can;
    private javax.swing.JLabel jLabel_Voos_Conc;
    private javax.swing.JLabel jLabel_Voos_Especificados;
    private javax.swing.JLabel jLabel_Voos_P1;
    private javax.swing.JLabel jLabel_Voos_P2;
    private javax.swing.JLabel jLabel_Voos_Previstos;
    private javax.swing.JLabel jLabel_Voos_Ptr;
    private javax.swing.JLabel jLabel_Voos_ar;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFicheiro;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemAbrirComo;
    private javax.swing.JMenuItem jMenuItemAcerca;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenuItem jMenuItemGuardarComo;
    private javax.swing.JMenuItem jMenuItemGuardarTexto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
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
    private javax.swing.JTextField jTextField_HORA;
    private javax.swing.JTextField jTextField_MINUTOS;
    // End of variables declaration//GEN-END:variables
}
