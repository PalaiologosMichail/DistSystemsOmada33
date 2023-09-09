package gr.hua.dit.ergasia.omada33.DAO;

import java.util.List;
import gr.hua.dit.ergasia.omada33.Entity.Seller;

public interface SellerDao {

    public List<Seller> findall();

    public void save(Seller seller);

    public Seller findById(int id);
}