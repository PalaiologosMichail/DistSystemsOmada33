package gr.hua.dit.ergasia.omada33.thController;


import gr.hua.dit.ergasia.omada33.DAO.BuyerDao;
import gr.hua.dit.ergasia.omada33.DAO.ContractDao;
import gr.hua.dit.ergasia.omada33.DAO.ContractorDao;
import gr.hua.dit.ergasia.omada33.DAO.SellerDao;
import gr.hua.dit.ergasia.omada33.Entity.Buyer;
import gr.hua.dit.ergasia.omada33.Entity.Contract;
import gr.hua.dit.ergasia.omada33.Entity.Contractor;
import gr.hua.dit.ergasia.omada33.Entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class FormController {

    @Autowired
    private BuyerDao buyerDao;

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private ContractorDao contractorDao;


    @GetMapping("/")
    public String index(){
        return "index";
    }


    //BUYER CONTROLLERS

    @GetMapping("/buyerform")
    public String showBuyerForm(Model model){
        Buyer buyer = new Buyer();
        model.addAttribute("buyer", buyer);
        return "add-buyer";
    }

    @PostMapping(path = "/buyerform")
    public String saveBuyer(@ModelAttribute("buyer") Buyer buyer){
        buyerDao.save(buyer);
        return "redirect:/buyerlist";
    }


    @GetMapping("/buyerlist")
    public String showBuyerList(Model model){
        List<Buyer> buyers = buyerDao.findAll();

        String name;
        Contract contract;

        for(int i = 0; i < buyers.size() ; i++){
            contract = buyers.get(i).getContract();
            if(contract != null) {
                name = contract.getPropertyname();
                buyers.get(i).setPropertyName(name);
            }
        }

        model.addAttribute("buyers", buyers);
        return "list-buyers";
    }


    //SELLER CONTROLLERS

    @GetMapping("/sellerform")
    public String showSellerForm(Model model){
        Seller seller = new Seller();
        model.addAttribute("seller", seller);
        return "add-seller";
    }

    @PostMapping(path = "/sellerform")
    public String saveSeller(@ModelAttribute("seller") Seller seller){
        sellerDao.save(seller);
        return "redirect:/sellerlist";
    }


    @GetMapping("/sellerlist")
    public String showSellerList(Model model){
        List<Seller> sellers = sellerDao.findall();

        String name;
        Contract contract;

        for(int i = 0; i < sellers.size() ; i++){
            contract = sellers.get(i).getContract();
            if(contract != null) {
                name = contract.getPropertyname();
                sellers.get(i).setPropertyName(name);
            }
        }

        model.addAttribute("sellers", sellers);
        return "list-sellers";
    }


    //CONTRACTOR CONTROLLERS

    @GetMapping("/contractorform")
    public String showContractorForm(Model model){
        Contractor contractor = new Contractor();
        model.addAttribute("contractor", contractor);
        return "add-contractor";
    }

    @PostMapping(path = "/contractorform")
    public String saveContractor(@ModelAttribute("contractor") Contractor contractor){
        contractorDao.save(contractor);
        return "redirect:/contractorlist";
    }


    @GetMapping("/contractorlist")
    public String showContractorList(Model model){
        List<Contractor> contractors = contractorDao.findall();

        String name;
        Contract contract;

        for(int i = 0; i < contractors.size() ; i++){
            contract = contractors.get(i).getContract();
            if(contract != null) {
                name = contract.getPropertyname();
                contractors.get(i).setPropertyName(name);
            }
        }

        model.addAttribute("contractors", contractors);
        return "list-contractors";
    }


    //CONTRACT CONTROLLERS

    @GetMapping("/contractform")
    public String showContractForm(Model model){
        Contract contract = new Contract();
        model.addAttribute("contract", contract);
        return "add-contract";
    }

    @PostMapping(path = "/contractform")
    public String saveContract(@ModelAttribute("contract") Contract contract){
        contractDao.save(contract);
        return "redirect:/contractlist";
    }


    @GetMapping("/contractlist")
    public String showContractList(Model model){
        List<Contract> contracts = contractDao.findAll();

        String buyerEmail;
        String sellerEmail;
        String contractorEmail;

        Buyer buyer;
        Seller seller;
        Contractor contractor;

        for(int i = 0; i < contracts.size(); i++){
            buyer = contracts.get(i).getBuyer();
            seller = contracts.get(i).getSeller();
            contractor = contracts.get(i).getContractor();

            if(buyer != null){
                buyerEmail = buyer.getEmail();
                contracts.get(i).setBuyerEmail(buyerEmail);
            }
            if(seller != null){
                sellerEmail = seller.getEmail();
                contracts.get(i).setSellerEmail(sellerEmail);
            }
            if(contractor != null){
                contractorEmail = contractor.getEmail();
                contracts.get(i).setContractorEmail(contractorEmail);
            }

        }
        model.addAttribute("contracts", contracts);
        return "list-contracts";
    }


    //LINK CONTROLLERS

    @GetMapping("/link")
    public String showLink(Model model){
        Link link = new Link();
        model.addAttribute("link", link);
        return "set-link";
    }


    @PostMapping(path = "/link")
    public String saveLink(@ModelAttribute("link") Link link){
        int buyerId;
        int sellerId;
        int contractorId;
        String propertyName;

        buyerId = link.getBuyerId();
        sellerId = link.getSellerId();
        contractorId = link.getContractorId();
        propertyName = link.getPropertyName();

        Buyer buyer = buyerDao.findById(buyerId);
        Seller seller = sellerDao.findById(sellerId);
        Contractor contractor = contractorDao.findById(contractorId);
        Contract contract = new Contract();

        contract.setPropertyname(propertyName);

        if(buyer != null){
            contract.setBuyer(buyer);
        }

        if(seller != null){
            contract.setSeller(seller);
        }

        if(contractor != null){
            contract.setContractor(contractor);
        }

        contractDao.save(contract);
        return "redirect:/contractlist";
    }

}
