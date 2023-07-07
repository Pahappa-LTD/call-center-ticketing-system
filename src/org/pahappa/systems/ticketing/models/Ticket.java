package org.pahappa.systems.ticketing.models;

/**
 * A ticket refers to a unit of work or a request that is submitted
 * by a user or customer to seek assistance, report an issue, or request a service.
 * It serves as a record or a container that captures all the relevant information
 * related to the user's request or issue.
 */
public class Ticket {
    private String ticketNo;
    private String customerID;
    private String categoryID;
    private String descriptionOfIsuue;
    private String additionalComments;
    private String status;
    private String priorityLevel;
    private String agentID;
 
    public String getTicketNo() {
       return ticketNo;
    }
 
    public void setTicketNo(String ticketNo) {
       this.ticketNo = ticketNo;
    }
 
    public String getCustomerID() {
       return customerID;
    }
 
    public void setCustomerID(String customerID) {
       this.customerID = customerID;
    }
    
    
    public String getCategoryID() {
       return categoryID;
    }
 
    public void setCategoryID(String categoryID) {
       this.categoryID = categoryID;
    }
    
    public String getDescriptionOfIsuue() {
       return descriptionOfIsuue;
    }
 
    public void setDescriptionOfIsuue(String descriptionOfIsuue) {
       this.descriptionOfIsuue = descriptionOfIsuue;
    }
    
    
    public String getPriorityLevel() {
       return priorityLevel;
    }
 
    public void setPriorityLevel(String priorityLevel) {
       this.priorityLevel = priorityLevel;
    }
    
    public String getAgentID() {
       return agentID;
    }
 
    public void setAgentID(String agentID) {
       this.agentID = agentID;
    }
 
    public String getAdditionalComments() {
       return additionalComments;
    }
 
    public void setAdditionalComments(String additionalComments) {
       this.additionalComments = additionalComments;
    }
    
    public String getStatus() {
       return status;
    }
    
    public void setStatus(String status) {
       this.status = status;
    }
 
    
 
 
}
