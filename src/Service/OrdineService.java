package Service;

import Entity.Impiegato;
import Entity.Ordine;
import Repository.ImpiegatoRepository;
import Repository.OrdineRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrdineService {
    OrdineRepository ordineRepository = new OrdineRepository();

    public void createOrdine(String cliente, LocalDate data,int importo,int idi) {
        Ordine ordine = new Ordine();
        ordine.setCliente(cliente);
        ordine.setData(data);
        ordine.setImporto(importo);
        ordine.setIdimpiegato(idi);
        ordineRepository.createOrdine(ordine);

    }

    public ArrayList<Ordine> readOrdine() {
        return ordineRepository.readOrdine();

    }

    public void deleteOrdine(int idi) {
        Ordine ordine=new Ordine();
        ordine.setId(idi);
        ordineRepository.deleteOrdine(ordine);
    }

    public void updateOrdine(int id,String cliente, LocalDate data,int importo,int idi) {
        Ordine ordine=new Ordine();
        ordine.setId(id);
        ordine.setCliente(cliente);
        ordine.setData(data);
        ordine.setImporto(importo);
        ordine.setIdimpiegato(idi);
        ordineRepository.updateOrdine(ordine);

    }

    public List<Impiegato> impiegatixCliente(String cliente) {
        List<Ordine> ordini=ordineRepository.readOrdine();
        List<Impiegato> lista=ordini.stream().filter(o->o.getCliente()!=null && o.getCliente().equalsIgnoreCase(cliente)).map(Ordine::getImpiegato).distinct().collect(Collectors.toList());
        return lista;

    }

    public List<Ordine> ordinixImpiegato(int idi) {
        List<Ordine> ordini=ordineRepository.readOrdine();
        List<Ordine> lista=ordini.stream().filter(o->o.getImpiegato()!=null && o.getImpiegato().getId()==idi).collect(Collectors.toList());
        return lista;
    }

    public List<Ordine> ordiniFebbraio(){
        List<Ordine> ordini=ordineRepository.readOrdine();
        List<Ordine> lista=ordini.stream().filter(o->o.getData()!=null&&o.getData().getMonthValue()==2).collect(Collectors.toList());
        return lista;
    }

    public List<Map.Entry<String,Double>> ClientiSpesa(){
        List<Ordine> ordini=ordineRepository.readOrdine();
        Map<String,Double> clienti=ordini.stream().filter(o->o.getCliente()!=null).collect(Collectors.groupingBy(Ordine::getCliente,Collectors.summingDouble(Ordine::getImporto)));
        return clienti.entrySet().stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())).collect(Collectors.toList());
    }

    public List<Map.Entry<Integer,Long>> livelliOrdini(){
        ImpiegatoService impiegatoService=new ImpiegatoService();
        List<Ordine> ordini=ordineRepository.readOrdine();

        Map<Integer,Long> lista=ordini.stream().filter(o->o.getId()!=0).collect(Collectors.groupingBy(o->o.getImpiegato().getLivello(),Collectors.counting()));

        List<Impiegato> impiegati = impiegatoService.readImpiegato();

        Map<Integer, Long> lista2 = impiegati.stream()
                .map(Impiegato::getLivello)
                .distinct()
                .collect(Collectors.toMap(
                        livello -> livello,
                        livello -> lista.getOrDefault(livello, 0L)
                ));
        return lista2.entrySet().stream().collect(Collectors.toList());
    }

    public List<Map.Entry<Impiegato,Double>> impiegatiSoldiTot(){
        List<Ordine> ordini=ordineRepository.readOrdine();
        Map<Impiegato,Double> lista=ordini.stream().collect(Collectors.groupingBy(Ordine::getImpiegato,Collectors.summingDouble(Ordine::getImporto)));
        return lista.entrySet().stream().collect(Collectors.toList());
    }
    public List<Map.Entry<Integer,Double>> livelliSoldiTot(){
        List<Ordine> ordini=ordineRepository.readOrdine();
        Map<Integer,Double> lista=ordini.stream().collect(Collectors.groupingBy(o->o.getImpiegato().getLivello(),Collectors.summingDouble(Ordine::getImporto)));
        return lista.entrySet().stream().collect(Collectors.toList());
    }

    public List<Map.Entry<Impiegato,Long>> impiegatiOrdini(){
        ImpiegatoService impiegatoService=new ImpiegatoService();
        List<Ordine> ordini=ordineRepository.readOrdine();
        Map<Impiegato,Long> lista=ordini.stream().filter(o->o.getId()!=0).collect(Collectors.groupingBy(Ordine::getImpiegato,Collectors.counting()));
        List<Impiegato> impiegati=impiegatoService.readImpiegato();
        Map<Impiegato,Long> lista2=impiegati.stream()
                .collect(Collectors.toMap(impiegato->impiegato,impiegato->lista.getOrDefault(impiegato,0L)));
                return lista2.entrySet().stream().collect(Collectors.toList());

    }

}
