package gr.hua.dit.ergasia.omada33.DAO;

import java.util.List;
import gr.hua.dit.ergasia.omada33.Entity.Buyer;

public interface BuyerDao {

    public List<Buyer> findAll();

    public void save(Buyer buyer);

    public Buyer findById(int id);
}