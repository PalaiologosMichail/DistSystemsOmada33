package gr.hua.dit.ergasia.omada33.DAO;

import java.util.List;
import gr.hua.dit.ergasia.omada33.Entity.Contractor;

public interface ContractorDao {

    public List<Contractor> findall();

    public void save(Contractor contractor);

    public Contractor findById(int id);
}