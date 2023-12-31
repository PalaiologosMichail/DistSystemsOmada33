package gr.hua.dit.ergasia.omada33.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contract")
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "property_name")
    //@NotBlank(message = "Please enter the property name")
    //@Size(max = 30)
    private String propertyname;

    @Column(name = "buyer_agree")
    private String buyer_agree;

    @Column(name = "seller_agree")
    private String seller_agree;

    @Column(name = "contractor_publish")
    private String contractor_publish;

    @Column(name = "is_paid")
    private String is_paid;


    @OneToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, /*CascadeType.MERGE,*/
            CascadeType.DETACH, CascadeType.REFRESH})

    @JoinColumn(name="buyer_id")
    //@JsonIgnore
    private Buyer buyer;

    @OneToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, /*CascadeType.MERGE,*/
            CascadeType.DETACH, CascadeType.REFRESH})

    @JoinColumn(name="seller_id")
    //@JsonIgnore
    private Seller seller;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, /*CascadeType.MERGE,*/
            CascadeType.DETACH, CascadeType.REFRESH})

    @JoinColumn(name = "contractor_id")
    //@JsonIgnore
    private Contractor contractor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract(){

    }

    public Contract(int id, String propertyname, String buyer_agree, String seller_agree, String contractor_publish, String is_paid, Buyer buyer, Seller seller, Contractor contractor) {
        this.id = id;
        this.propertyname = propertyname;
        this.buyer_agree = buyer_agree;
        this.seller_agree = seller_agree;
        this.contractor_publish = contractor_publish;
        this.is_paid = is_paid;
        this.buyer = buyer;
        this.seller = seller;
        this.contractor = contractor;
    }

    public String getBuyer_agree() {
        return buyer_agree;
    }

    public void setBuyer_agree(String buyer_agree) {
        this.buyer_agree = buyer_agree;
    }

    public String getSeller_agree() {
        return seller_agree;
    }

    public void setSeller_agree(String seller_agree) {
        this.seller_agree = seller_agree;
    }

    public String getContractor_publish() {
        return contractor_publish;
    }

    public void setContractor_publish(String contractor_publish) {
        this.contractor_publish = contractor_publish;
    }

    public String getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(String is_paid) {
        this.is_paid = is_paid;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }


    @JsonIgnore
    private String buyerEmail;

    @JsonIgnore
    private String sellerEmail;

    @JsonIgnore
    private String contractorEmail;


    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getContractorEmail() {
        return contractorEmail;
    }

    public void setContractorEmail(String contractorEmail) {
        this.contractorEmail = contractorEmail;
    }
}