package gr.hua.dit.ergasia.omada33.Controller;

import java.util.List;


import gr.hua.dit.ergasia.omada33.DAO.BuyerDao;
import gr.hua.dit.ergasia.omada33.DAO.ContractDao;
import gr.hua.dit.ergasia.omada33.Entity.Buyer;
import gr.hua.dit.ergasia.omada33.Entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private BuyerDao buyerDao;

    @Autowired
    private ContractDao contractDao;



    @GetMapping("")
    public List<Buyer> getallBuyers(){
        return buyerDao.findAll();

    }

    @GetMapping("/{id}")
    public Buyer getById(@PathVariable int id){
        return buyerDao.findById(id);
    }


    @GetMapping("/{id}/contract")
    public Contract getContractByBuyerId(@PathVariable int id){
        Buyer buyer = buyerDao.findById(id);
        return buyer.getContract();
    }

    @PostMapping("/{id}/contract/agree/{choice}")
    public Contract buyerChoice(@PathVariable("id") int id, @PathVariable("choice") int choice){
        Buyer buyer = buyerDao.findById(id);

        if(buyer == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        Contract contract = buyer.getContract();

        if(contract == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }


        if (choice == 0){
            contract.setBuyer_agree("no");
            contractDao.save(contract);
            return contract;

        } else if (choice == 1){
            contract.setBuyer_agree("yes");
            contractDao.save(contract);
            return contract;
        }else{
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Please enter a valid choice"
            );
        }


    }

    @PostMapping("/contract/pay/{id}")
    public Contract buyerPay(@PathVariable("id") int id) {
        Buyer buyer = buyerDao.findById(id);

        if (buyer == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        Contract contract = buyer.getContract();

        if (contract == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        contract.setIs_paid("yes");
        contractDao.save(contract);
        return contract;
    }

    @PostMapping("/contract/agree/{id}")
    public Contract buyerAgree(@PathVariable("id") int id) {
        Buyer buyer = buyerDao.findById(id);

        if (buyer == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        Contract contract = buyer.getContract();

        if (contract == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        contract.setBuyer_agree("yes");
        contractDao.save(contract);
        return contract;
    }
    @PostMapping("/contract/disagree/{id}")
    public Contract buyerDisagree(@PathVariable("id") int id) {
        Buyer buyer = buyerDao.findById(id);

        if (buyer == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        Contract contract = buyer.getContract();

        if (contract == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        contract.setBuyer_agree("no");
        contractDao.save(contract);
        return contract;
    }


    @PostMapping("")
    public Buyer save(@RequestBody Buyer buyer){
        buyer.setId(buyer.getId());
        buyerDao.save(buyer);
        return buyer;
    }

}