package Repository;

import Config.DbConnection;
import Entity.Impiegato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImpiegatoRepository {
    private static final Logger logger=Logger.getLogger(ImpiegatoRepository.class.getName());

    public void createImpiegato(Impiegato impiegato) {
        String sql="insert into impiegati(nome,cognome,livello) values(?,?,?)";
        try{
            Connection c= DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1, impiegato.getNome());
            ps.setString(2, impiegato.getCognome());
            ps.setInt(3, impiegato.getLivello());
            int result=ps.executeUpdate();
            if(result>0){
                logger.log(Level.INFO,"Impiegato creato con successo");
            }

        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);

        }
    }

    public ArrayList<Impiegato> readImpiegato(){
        ArrayList<Impiegato> impiegati=new ArrayList<>();
        String sql="select * from impiegati";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Impiegato i=new Impiegato();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setCognome(rs.getString("cognome"));
                i.setLivello(rs.getInt("livello"));
                impiegati.add(i);
            }

        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
        return impiegati;
    }

    public void deleteImpiegato(Impiegato impiegato){
        String sql="delete from impiegati where id=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setInt(1, impiegato.getId());
            int result=ps.executeUpdate();
            if(result>0){
                logger.log(Level.INFO,"Impiegato eliminato con successo");
            }

        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }

    public void updateImpiegato(Impiegato impiegato){
        String sql="update impiegati set nome=?,cognome=?,livello=? where id=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1, impiegato.getNome());
            ps.setString(2, impiegato.getCognome());
            ps.setInt(3, impiegato.getLivello());
            ps.setInt(4, impiegato.getId());
            int result=ps.executeUpdate();
            if(result>0){
                logger.log(Level.INFO,"Impiegato modificato com sucesso");
            }

        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }

}
