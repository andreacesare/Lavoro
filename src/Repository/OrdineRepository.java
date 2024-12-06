package Repository;

import Config.DbConnection;
import Entity.Impiegato;
import Entity.Ordine;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdineRepository {
    private static final Logger logger=Logger.getLogger(OrdineRepository.class.getName());

    public void createOrdine(Ordine ordine){
        String sql="insert into ordini(cliente,data,importo,idimpiegato) values(?,?,?,?)";
        try{
            Connection c= DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1, ordine.getCliente());
            ps.setDate(2, Date.valueOf(ordine.getData()));
            ps.setInt(3, ordine.getImporto());
            ps.setInt(4, ordine.getIdimpiegato());
            int result=ps.executeUpdate();
            if(result>0){
                System.out.println("Ordine creato con successo");
            }


        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }

    public ArrayList<Ordine> readOrdine(){
        ArrayList<Ordine> ordini=new ArrayList<>();
        String sql="select o.id,o.cliente,o.data,o.importo,o.idimpiegato,i.id as idi,i.nome,i.cognome,i.livello from ordini o full join impiegati i on o.idimpiegato=i.id";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Ordine o=new Ordine();
                Impiegato i=new Impiegato();
                o.setId(rs.getInt("id"));
                o.setCliente(rs.getString("cliente"));
                o.setData(rs.getDate("data")!=null?rs.getDate("data").toLocalDate():null);
                o.setImporto(rs.getInt("importo"));
                o.setIdimpiegato(rs.getInt("idimpiegato"));
                i.setId(rs.getInt("idi"));
                i.setNome(rs.getString("nome"));
                i.setCognome(rs.getString("cognome"));
                i.setLivello(rs.getInt("livello"));
                o.setImpiegato(i);
                ordini.add(o);
            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
        return ordini;

    }

    public void deleteOrdine(Ordine ordine){
        String sql="delete from ordini where id=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setInt(1, ordine.getId());
            int result=ps.executeUpdate();
            if(result>0){
                System.out.println("Ordine eliminato");
            }

        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }

    public void updateOrdine(Ordine ordine){
        String sql="update ordini set cliente=?,data=?,importo=?,idimpiegato=? where id=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1, ordine.getCliente());
            ps.setDate(2, Date.valueOf(ordine.getData()));
            ps.setInt(3, ordine.getImporto());
            ps.setInt(4, ordine.getIdimpiegato());
            ps.setInt(5, ordine.getId());
            int result=ps.executeUpdate();
            if(result>0){
                System.out.println("Ordine modificato");
            }

        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }
}
