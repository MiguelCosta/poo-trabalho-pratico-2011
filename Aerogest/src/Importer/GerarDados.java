/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Importer;

import Classes.Aeronave;
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
 *
 * @author goku
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

    private TreeMap<GregorianCalendar,TreeMap<String,Voo>> mapaVoos_;
    private ArrayList<Comandante> comandantes_;
    private ArrayList<CoPiloto> coPilotos_;
    private ArrayList<Tripulante> tribulantesAdicionais_;
    private TreeMap<String,Aeronave> aeronaves_;
    private TreeMap<String,Porta> portas_;
    private ArrayList<String> funcoesValidas_;
    private GregorianCalendar dataActual_;

    private AerogestSistema aerogestSistema;

    private void init(){
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
    }

    private void geraPassageiros(){
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

    private void geraMembrosGoverno(){
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

    private void geraCargaAlimentar(){

    }

    private void geraCargaAnimal(){

    }

    private void geraCargaNormal(){

    }

    private void geraCargaQuimica(){

    }

    private void geraCargaVeiculo(){

    }

    private void geraComandantes(){

    }

    private void geraCoPilotos(){

    }

    private void geraTripulantes(){

    }

    private void geraPortas(){

    }

    private void geraAeronaves(){

    }

    private void geraVoosComerciais(){

    }

    private void geraVoosGovernamentais(){

    }

    private void geraVoosMilitares(){

    }

    private void geraMapaVoos(){

    }

    private void geraMapaAeronaves(){

    }

    private void geraMapaPortas(){
        
    }

    private void gereFuncoesValidas(){

    }

    private void gereHoraSistema(){

    }

    private void geraAerogestSistema(){

    }

    public void main(){
        init();
        SaveLoadDB.saveDB(aerogestSistema,SaveLoadDB.DefualtObjectFileName);
    }
}
