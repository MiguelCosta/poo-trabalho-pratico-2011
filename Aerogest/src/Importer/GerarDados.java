/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Importer;

import Classes.Aeronave;
import Classes.Carga;
import Classes.CargaAlimentar;
import Classes.CargaAnimal;
import Classes.CargaNormal;
import Classes.CargaQuimica;
import Classes.CargaVeiculo;
import Classes.CoPiloto;
import Classes.Comandante;
import Classes.MembroGoverno;
import Classes.Passageiro;
import Classes.Porta;
import Classes.Tripulante;
import Classes.Voo;
import Classes.VooComercial;
import Classes.VooGovernamental;
import Classes.VooMilitar;
import aerogest.AerogestSistema;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeMap;

/**
 * Possui todos os métodos necessários para gerar os dados
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class GerarDados {

    private ArrayList<Passageiro> passageiros;
    private ArrayList<MembroGoverno> membrosGoverno;
    private ArrayList<CargaAlimentar> cargaAlimentar;
    private ArrayList<CargaAnimal> cargaAnimal;
    private ArrayList<CargaNormal> cargaNormal;
    private ArrayList<CargaQuimica> cargaQuimica;
    private ArrayList<CargaVeiculo> cargaVeiculo;
    private ArrayList<Comandante> comandantes;
    private ArrayList<CoPiloto> coPilotos;
    private ArrayList<Tripulante> tripulantes;
    private ArrayList<Porta> portas;
    private ArrayList<Aeronave> aeronaves;
    private ArrayList<VooComercial> voosComererciais;
    private ArrayList<VooGovernamental> voosGovernamentais;
    private ArrayList<VooMilitar> voosMilitares;
    
    private TreeMap<GregorianCalendar, TreeMap<String, Voo>> mapaVoos_;
    private ArrayList<Comandante> comandantes_;
    private ArrayList<CoPiloto> coPilotos_;
    private ArrayList<Tripulante> tribulantesAdicionais_;
    private TreeMap<String, Aeronave> aeronaves_;
    private TreeMap<String, Porta> portas_;
    private ArrayList<String> funcoesValidas_;
    private GregorianCalendar dataActual_;
    private AerogestSistema aerogestSistema;

    private void init() {
        passageiros = new ArrayList<Passageiro>();
        membrosGoverno = new ArrayList<MembroGoverno>();
        cargaAlimentar = new ArrayList<CargaAlimentar>();
        cargaAnimal = new ArrayList<CargaAnimal>();
        cargaNormal = new ArrayList<CargaNormal>();
        cargaQuimica = new ArrayList<CargaQuimica>();
        cargaVeiculo = new ArrayList<CargaVeiculo>();
        comandantes = new ArrayList<Comandante>();
        coPilotos = new ArrayList<CoPiloto>();
        tripulantes = new ArrayList<Tripulante>();
        portas = new ArrayList<Porta>();
        aeronaves = new ArrayList<Aeronave>();
        voosComererciais = new ArrayList<VooComercial>();
        voosGovernamentais = new ArrayList<VooGovernamental>();
        voosMilitares = new ArrayList<VooMilitar>();

        geraPassageiros();
        geraMembrosGoverno();
        geraAeronaves();
        geraCargaAlimentar();
        geraCargaAnimal();
        geraCargaNormal();
        geraCargaQuimica();
        geraCargaVeiculo();
        geraCoPilotos();
        geraComandantes();
        geraPortas();
        geraTripulantes();
        geraVoosComerciais();
        geraVoosGovernamentais();
        geraVoosMilitares();
        geraMapaAeronaves();
        geraMapaPortas();
        geraMapaVoos();
        geraMembrosGoverno();
        gereFuncoesValidas();
        gereHoraSistema();
        geraAerogestSistema();
    }

    private void geraPassageiros() {
        passageiros.add(new Passageiro("p001", "António Almeida", "Portugal", "910000001"));
        passageiros.add(new Passageiro("p002", "Bernado Borgues", "Portugal", "910000002"));
        passageiros.add(new Passageiro("p003", "Carlos Cunha", "Portugal", "910000003"));
        passageiros.add(new Passageiro("p004", "Duarte Durão", "Portugal", "910000004"));
        passageiros.add(new Passageiro("p005", "Elias Esteves", "Portugal", "910000005"));
        passageiros.add(new Passageiro("p006", "Fábio Faria", "Portugal", "910000006"));
        passageiros.add(new Passageiro("p007", "Guilherme Guimarães", "Portugal", "910000007"));
        passageiros.add(new Passageiro("p008", "Hugo Horta", "Portugal", "910000008"));
        passageiros.add(new Passageiro("p009", "Isabel Infante", "Portugal", "910000009"));
        passageiros.add(new Passageiro("p010", "Joana Jardim", "Portugal", "910000010"));
        passageiros.add(new Passageiro("p011", "Kelly Ketchup", "Chile", "910000011"));
        passageiros.add(new Passageiro("p012", "Luciana Lameira", "Portugal", "910000012"));
        passageiros.add(new Passageiro("p013", "Mário Martins", "Portugal", "910000013"));
        passageiros.add(new Passageiro("p014", "Nuno Nobre", "Portugal", "910000014"));
        passageiros.add(new Passageiro("p015", "Óscar Oliveira", "Portugal", "910000015"));
        passageiros.add(new Passageiro("p016", "Paula Pacheco", "Portugal", "910000016"));
        passageiros.add(new Passageiro("p017", "Quim Queirós", "Portugal", "910000017"));
        passageiros.add(new Passageiro("p018", "Rita Ramalho", "Portugal", "910000018"));
        passageiros.add(new Passageiro("p019", "Sara Santos", "Portugal", "910000019"));
        passageiros.add(new Passageiro("p020", "Tiago Taveira", "Portugal", "910000020"));
        passageiros.add(new Passageiro("p021", "Ulisses Uchoa", "Grécia", "910000021"));
        passageiros.add(new Passageiro("p022", "Vania Valentim", "Portugal", "910000022"));
        passageiros.add(new Passageiro("p023", "Wilson Wolf", "Inglaterra", "910000023"));
        passageiros.add(new Passageiro("p024", "Xavier Ximenes", "Portugal", "910000024"));
        passageiros.add(new Passageiro("p025", "Yuri Yasmin", "Rússia", "910000025"));
        passageiros.add(new Passageiro("p026", "Zé Zambujal", "Portugal", "910000026"));
    }

    private void geraMembrosGoverno() {
        membrosGoverno.add(new MembroGoverno("mg001", "José Sócrates", "Portual",
                "910000027", MembroGoverno.Presidencia));
        membrosGoverno.add(new MembroGoverno("mg002", "Carlos Cascais", "Portual",
                "910000028", MembroGoverno.Presidencia));
        membrosGoverno.add(new MembroGoverno("mg003", "Pedro Almeida", "Portual",
                "910000029", MembroGoverno.Ministerio));
        membrosGoverno.add(new MembroGoverno("mg004", "Carina Campos", "Portual",
                "910000030", MembroGoverno.Presidencia));
        membrosGoverno.add(new MembroGoverno("mg005", "Catarina Salsa", "Espanha",
                "910000031", MembroGoverno.Ministerio));
    }

    private void geraCargaAlimentar() {
        cargaAlimentar.add(new CargaAlimentar("cargaAlim01", 100.1, "Alimento 1", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim02", 101.1, "Alimento 2", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim03", 102.1, "Alimento 3", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim04", 103.1, "Alimento 4", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim05", 104.1, "Alimento 5", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim06", 105.1, "Alimento 6", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim07", 106.1, "Alimento 7", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim08", 107.1, "Alimento 8", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim09", 108.1, "Alimento 9", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim10", 109.1, "Alimento 10", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim11", 100.1, "Alimento 11", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim12", 111.1, "Alimento 12", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim13", 112.1, "Alimento 13", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim14", 113.1, "Alimento 14", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim15", 114.1, "Alimento 15", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim16", 115.1, "Alimento 16", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim17", 116.1, "Alimento 17", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim18", 117.1, "Alimento 18", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim19", 118.1, "Alimento 19", 14, new GregorianCalendar()));
        cargaAlimentar.add(new CargaAlimentar("cargaAlim20", 119.1, "Alimento 20", 14, new GregorianCalendar()));
    }

    private void geraCargaAnimal() {
        cargaAnimal.add(new CargaAnimal("carAnimal01", 20, "Animal 1", 1, 10));
        cargaAnimal.add(new CargaAnimal("carAnimal02", 21, "Animal 2", 2, 11));
        cargaAnimal.add(new CargaAnimal("carAnimal03", 22, "Animal 3", 3, 12));
        cargaAnimal.add(new CargaAnimal("carAnimal04", 23, "Animal 4", 4, 13));
        cargaAnimal.add(new CargaAnimal("carAnimal05", 24, "Animal 5", 5, 14));
        cargaAnimal.add(new CargaAnimal("carAnimal06", 25, "Animal 6", 6, 15));
        cargaAnimal.add(new CargaAnimal("carAnimal07", 26, "Animal 7", 7, 16));
        cargaAnimal.add(new CargaAnimal("carAnimal08", 27, "Animal 8", 8, 17));
        cargaAnimal.add(new CargaAnimal("carAnimal09", 28, "Animal 9", 9, 18));
        cargaAnimal.add(new CargaAnimal("carAnimal10", 29, "Animal 10", 10, 19));
        cargaAnimal.add(new CargaAnimal("carAnimal11", 30, "Animal 11", 11, 20));
        cargaAnimal.add(new CargaAnimal("carAnimal12", 31, "Animal 12", 12, 21));
        cargaAnimal.add(new CargaAnimal("carAnimal13", 32, "Animal 13", 13, 22));
        cargaAnimal.add(new CargaAnimal("carAnimal14", 33, "Animal 14", 14, 23));
        cargaAnimal.add(new CargaAnimal("carAnimal15", 34, "Animal 15", 15, 24));
        cargaAnimal.add(new CargaAnimal("carAnimal16", 35, "Animal 16", 16, 25));
        cargaAnimal.add(new CargaAnimal("carAnimal17", 36, "Animal 17", 17, 26));
        cargaAnimal.add(new CargaAnimal("carAnimal18", 37, "Animal 18", 18, 27));
        cargaAnimal.add(new CargaAnimal("carAnimal19", 38, "Animal 19", 19, 28));
        cargaAnimal.add(new CargaAnimal("carAnimal20", 39, "Animal 20", 20, 29));
    }

    private void geraCargaNormal() {
        cargaNormal.add(new CargaNormal("cargaNormal", 20, "Carga 1", 12));
        cargaNormal.add(new CargaNormal("cargaNorma2", 21, "Carga 2", 13));
        cargaNormal.add(new CargaNormal("cargaNorma3", 22, "Carga 3", 14));
        cargaNormal.add(new CargaNormal("cargaNorma4", 23, "Carga 4", 15));
        cargaNormal.add(new CargaNormal("cargaNorma5", 24, "Carga 5", 16));
        cargaNormal.add(new CargaNormal("cargaNorma6", 25, "Carga 6", 17));
        cargaNormal.add(new CargaNormal("cargaNorma7", 26, "Carga 7", 18));
        cargaNormal.add(new CargaNormal("cargaNorma8", 27, "Carga 8", 19));
        cargaNormal.add(new CargaNormal("cargaNorma9", 28, "Carga 9", 20));
        cargaNormal.add(new CargaNormal("cargaNormal0", 29, "Carga 10", 21));
        cargaNormal.add(new CargaNormal("cargaNormal1", 30, "Carga 11", 22));
        cargaNormal.add(new CargaNormal("cargaNormal2", 31, "Carga 12", 23));
        cargaNormal.add(new CargaNormal("cargaNormal3", 32, "Carga 13", 24));
        cargaNormal.add(new CargaNormal("cargaNormal4", 33, "Carga 14", 25));
        cargaNormal.add(new CargaNormal("cargaNormal5", 34, "Carga 15", 26));
        cargaNormal.add(new CargaNormal("cargaNormal6", 35, "Carga 16", 27));
        cargaNormal.add(new CargaNormal("cargaNormal7", 36, "Carga 17", 28));
        cargaNormal.add(new CargaNormal("cargaNormal8", 37, "Carga 18", 29));
        cargaNormal.add(new CargaNormal("cargaNormal9", 38, "Carga 19", 30));
        cargaNormal.add(new CargaNormal("cargaNorma20", 39, "Carga 20", 31));
    }

    private void geraCargaQuimica() {
        cargaQuimica.add(new CargaQuimica("cargaQuimica1", 12, "Quimico 1", 13, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica2", 13, "Quimico 2", 14, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica3", 14, "Quimico 3", 15, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica4", 15, "Quimico 4", 16, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica5", 16, "Quimico 5", 17, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica6", 17, "Quimico 6", 18, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica7", 18, "Quimico 7", 19, "", "nada toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica8", 19, "Quimico 8", 20, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica9", 20, "Quimico 9", 21, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica10", 21, "Quimico 10", 22, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica11", 22, "Quimico 11", 23, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica12", 23, "Quimico 12", 24, "", "pouco toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica13", 24, "Quimico 13", 25, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica14", 25, "Quimico 14", 26, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica15", 26, "Quimico 15", 27, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica16", 27, "Quimico 16", 28, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica17", 28, "Quimico 17", 29, "", "pouco toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica18", 29, "Quimico 18", 30, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica19", 30, "Quimico 19", 31, "", "muito toxico"));
        cargaQuimica.add(new CargaQuimica("cargaQuimica20", 31, "Quimico 20", 32, "", "toxico"));
    }

    private void geraCargaVeiculo() {
        cargaVeiculo.add(new CargaVeiculo("cargaVeiculo1", 10, "veiculo 1", 12, "ligeiro"));
        cargaVeiculo.add(new CargaVeiculo("cargaVeiculo2", 11, "veiculo 2", 13, "ligeiro"));
        cargaVeiculo.add(new CargaVeiculo("cargaVeiculo3", 12, "veiculo 3", 14, "ligeiro"));
        cargaVeiculo.add(new CargaVeiculo("cargaVeiculo4", 13, "veiculo 4", 15, "ligeiro"));
        cargaVeiculo.add(new CargaVeiculo("cargaVeiculo5", 14, "veiculo 5", 16, "ligeiro"));
        cargaVeiculo.add(new CargaVeiculo("cargaVeiculo6", 15, "veiculo 6", 17, "pesado"));
        cargaVeiculo.add(new CargaVeiculo("cargaVeiculo7", 16, "veiculo 7", 18, "pesado"));
        cargaVeiculo.add(new CargaVeiculo("cargaVeiculo8", 17, "veiculo 8", 19, "pesado"));
        cargaVeiculo.add(new CargaVeiculo("cargaVeiculo9", 18, "veiculo 9", 20, "pesado"));
        cargaVeiculo.add(new CargaVeiculo("cargaVeiculo10", 19, "veiculo 10", 21, "pesado"));
    }

    private void geraComandantes() {
        comandantes.add(new Comandante("Mike", "Inglesa"));
        comandantes.add(new Comandante("John", "Inglesa"));
        comandantes.add(new Comandante("Alexandre", "Portuguesa"));
        comandantes.add(new Comandante("Fábio", "Portuguesa"));
        comandantes.add(new Comandante("Miguel", "Portuguesa"));


        comandantes_.add(new Comandante("Mike", "Inglesa"));
        comandantes_.add(new Comandante("John", "Inglesa"));
        comandantes_.add(new Comandante("Alexandre", "Portuguesa"));
        comandantes_.add(new Comandante("Fábio", "Portuguesa"));
        comandantes_.add(new Comandante("Miguel", "Portuguesa"));
    }

    private void geraCoPilotos() {
        coPilotos.add(new CoPiloto("Pedro", "Espanhol"));
        coPilotos.add(new CoPiloto("Sofia", "portuguesa"));
        coPilotos.add(new CoPiloto("Joaquim", "Espanhol"));
        coPilotos.add(new CoPiloto("Sara", "Francesa"));
        coPilotos.add(new CoPiloto("Abel", "Norte Americano"));

        coPilotos_.add(new CoPiloto("Pedro", "Espanhol"));
        coPilotos_.add(new CoPiloto("Sofia", "portuguesa"));
        coPilotos_.add(new CoPiloto("Joaquim", "Espanhol"));
        coPilotos_.add(new CoPiloto("Sara", "Francesa"));
        coPilotos_.add(new CoPiloto("Abel", "Norte Americano"));
    }

    private void geraTripulantes() {
        tripulantes.add(new Tripulante(funcoesValidas_.get(0), "Maria", "Portuguesa"));
        tripulantes.add(new Tripulante(funcoesValidas_.get(1), "Duarte", "Portuguesa"));
        tripulantes.add(new Tripulante(funcoesValidas_.get(2), "Vitor", "Portuguesa"));
        tripulantes.add(new Tripulante(funcoesValidas_.get(3), "Mario", "Portuguesa"));
        tripulantes.add(new Tripulante(funcoesValidas_.get(4), "Antonio", "Portuguesa"));
    }

    private void geraPortas() {
        portas.add(new Porta("porta1", true));
        portas.add(new Porta("porta2", true));
        portas.add(new Porta("porta3", true));
        portas.add(new Porta("porta4", true));
        portas.add(new Porta("porta5", true));
        portas.add(new Porta("porta6", true));
        portas.add(new Porta("porta7", true));
        portas.add(new Porta("porta8", true));
        portas.add(new Porta("porta9", true));
        portas.add(new Porta("porta10", true));
    }

    private void geraAeronaves() {
        aeronaves.add(new Aeronave("00-00-00", "Aviao", 150, 200, 700));
        aeronaves.add(new Aeronave("01-01-01", "Aviao pequeno", 20, 15, 900));
        aeronaves.add(new Aeronave("02-02-02", "Jacto", 100, 50, 1300));
        aeronaves.add(new Aeronave("03-04-05", "Aviao", 150, 200, 700));
        aeronaves.add(new Aeronave("06-07-08", "Helicopetro", 8, 10, 90));
        aeronaves.add(new Aeronave("09-10-11", "Aviao", 150, 200, 700));
        aeronaves.add(new Aeronave("14-13-12", "Aviao", 250, 400, 700));
        aeronaves.add(new Aeronave("15-19-17", "Aviao", 140, 40, 700));
    }

    private void geraVoosComerciais() {
        ArrayList<Passageiro> passag = new ArrayList<Passageiro>();
        passag.add(passageiros.get(0));
        passag.add(passageiros.get(1));
        passag.add(passageiros.get(2));
        ArrayList<Carga> carga = new ArrayList<Carga>();
        carga.add(cargaAlimentar.get(0));

        voosComererciais.add(new VooComercial("vComercial1", "Paris", new GregorianCalendar(), "TAP", passag, carga));

        carga.add(cargaAlimentar.get(1));
        passag.add(passageiros.get(3));

        voosComererciais.add(new VooComercial("vComercial1", "Porto", new GregorianCalendar(), "TAP", passag, carga));

    }

    private void geraVoosGovernamentais() {
        ArrayList<Carga> carga = new ArrayList<Carga>();
        carga.add(cargaQuimica.get(0));

        ArrayList<Passageiro> jorn = new ArrayList<Passageiro>();
        jorn.add(passageiros.get(10));

        ArrayList<MembroGoverno> mGov = new ArrayList<MembroGoverno>();
        mGov.add(membrosGoverno.get(0));
        mGov.add(membrosGoverno.get(1));

        ArrayList<Passageiro> convi = new ArrayList<Passageiro>();
        convi.add(passageiros.get(12));

        voosGovernamentais.add(new VooGovernamental("vGovern", "Londres", new GregorianCalendar(), "TAP", carga, mGov, jorn, convi));
    }

    private void geraVoosMilitares() {
        ArrayList<Passageiro> passag = new ArrayList<Passageiro>();
        passag.add(passageiros.get(9));
        passag.add(passageiros.get(10));

        ArrayList<Carga> carga = new ArrayList<Carga>();
        carga.add(cargaNormal.get(0));

        voosMilitares.add(new VooMilitar("vMilitar1", "Libia", new GregorianCalendar(), "Forças Armadas", passag, carga, 150, "Exercito", "codComu1"));
    }

    private void geraMapaVoos() {
        TreeMap<String, Voo> v = new TreeMap<String, Voo>();

        for (Voo x : voosComererciais) {
            v.put(x.getCodigoVoo(), x);
        }


        for (Voo x : voosGovernamentais) {
            v.put(x.getCodigoVoo(), x);
        }


        for (Voo x : voosMilitares) {
            v.put(x.getCodigoVoo(), x);
        }


        mapaVoos_.put(new GregorianCalendar(), v);
    }

    private void geraMapaAeronaves() {
        for (Aeronave a : aeronaves) {
            aeronaves_.put(a.getMatricula(), a);
        }

    }

    private void geraMapaPortas() {
        for (Porta p : portas) {
            portas_.put(p.getCodPorta(), p);
        }

    }

    private void gereFuncoesValidas() {
        funcoesValidas_.add("assistente");
        funcoesValidas_.add("aeronauta");
        funcoesValidas_.add("mecanico de voo");
        funcoesValidas_.add("navegador");
        funcoesValidas_.add("radioperador de voo");
        funcoesValidas_.add("Comissario");
    }

    private void gereHoraSistema() {
        dataActual_ = new GregorianCalendar();
    }

    private void geraAerogestSistema() {
        aerogestSistema = new AerogestSistema();
        aerogestSistema.adicionaComandateArray(comandantes);
        aerogestSistema.adicionaCoPilotoArray(coPilotos);
        aerogestSistema.adicionaAeronaveMap(aeronaves_);
        aerogestSistema.adicionaPortaMap(portas_);
        aerogestSistema.setHoraActual(dataActual_);
        aerogestSistema.adicionaFuncaoValidaList(funcoesValidas_);
        
        // qual destes dois é??
        aerogestSistema.adicionaTripulanteArray(tripulantes);
        aerogestSistema.adicionaTripulanteArray(tribulantesAdicionais_);
        
        
    }

    public void main() {
        init();
        SaveLoadDB.saveDB(aerogestSistema, SaveLoadDB.DefualtObjectFileName);
    }
}
