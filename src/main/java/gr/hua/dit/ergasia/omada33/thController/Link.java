package gr.hua.dit.ergasia.omada33.thController;

public class Link {

    private int buyerId;

    private int sellerId;

    private int contractorId;

    private String propertyName;

    public Link() {
    }

    public Link(int buyerId, int sellerId, int contractorId, String propertyName) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.contractorId = contractorId;
        this.propertyName = propertyName;
    }


    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getContractorId() {
        return contractorId;
    }

    public void setContractorId(int contractorId) {
        this.contractorId = contractorId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

}