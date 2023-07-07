package org.pahappa.systems.ticketing.views;

import org.pahappa.systems.ticketing.constants.PriorityLevel;
import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.services.TicketService;
import org.pahappa.systems.ticketing.services.impl.TicketServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketView implements BaseTicketView {

    private final TicketService ticketService;
    private final Scanner scanner;

    public TicketView() {
        this.ticketService = new TicketServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("********* Call Center Ticket System *********\n\n");
        boolean running = true;
        while (running) {
            System.out.println("Choose an operation:");
            System.out.println("1. Create Ticket");
            System.out.println("2. Get All Tickets");
            System.out.println("3. Get Tickets of Status");
            System.out.println("4. Update Ticket");
            System.out.println("5. Delete Ticket");
            System.out.println("6. Exit");
            System.out.println();

            
           System.out.println("Choose a number");
           if(scanner.hasNextInt()){
            int choice = scanner.nextInt();
            scanner.nextLine();
          
            switch (choice) {
                case 1:
                    createTicket();
                    break;
                case 2:
                    getAllTickets();
                    break;
                case 3:
                    getTicketsOfStatus();
                    break;
                case 4:
                    updateTicket();
                    break;
                case 5:
                    deleteTicket();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
        else{
            String invalid = scanner.nextLine();
            System.out.println("Invalid choice.Please try again");
        }
    }

    }

    @Override
    public void createTicket() {
    Ticket ticket = new Ticket();//creating an object to access the attributes in the Ticket class
    List<Ticket> result =ticketService.getAllTickets();
    int lastTicketNumber =result.size(); 
    int nextTicketNumber = lastTicketNumber + 1;
    String ticketNumber = String.format("%04d", nextTicketNumber); // Formatting the ticket number with leading zeros if necessary
    ticket.setTicketNo(ticketNumber);

     System.out.println("Enter the your agent ID:");
     ticket.setAgentID(scanner.nextLine());

     System.out.println("Enter the customer ID:");
      ticket.setCustomerID(scanner.nextLine());

     System.out.println("Enter the ticket category number:");
      ticket.setCategoryID(scanner.nextLine());

     boolean validInput = false;
     while(!validInput){
     System.out.println("Enter the status of the ticket based on these options:");
     for(TicketStatus status : TicketStatus.values()){
        System.out.println(status.name());
     }
      String userInput = scanner.nextLine();
       for(TicketStatus status : TicketStatus.values()){
        if(status.name().equals(userInput)){
            validInput = true;
          ticket.setStatus(userInput);
          break;
          
        }
    }
    if(!validInput){
        System.out.println("Enter the right option");
    }
      
    }

    boolean valid = false;
     while(!valid){
     System.out.println("Enter the priority of the ticket based on these options:");
     for(PriorityLevel priority : PriorityLevel.values()){
        System.out.println(priority.name());
     }
      String userInput = scanner.nextLine();
       for(PriorityLevel priority : PriorityLevel.values()){
        if(priority.name().equals(userInput)){
            valid = true;
          ticket.setPriorityLevel(userInput);
          break;
        }
    }
    if(!valid){
        System.out.println("Enter the right option");
    }
      
    }


     

     System.out.println("Enter the description of the issue:");
      ticket.setDescriptionOfIsuue(scanner.nextLine());

     System.out.println("Enter the any other additional comments:");
      ticket.setAdditionalComments(scanner.nextLine());

     ticketService.createTicket(ticket); 


    }

    @Override
    public void getAllTickets() {
     
        List<Ticket> result =ticketService.getAllTickets();
        
        for(Ticket ticket:result){
            System.out.println("AgentID:"+ticket.getAgentID());
            System.out.println("TicketNo:"+ticket.getTicketNo());
            System.out.println("CustomerNo:"+ticket.getCustomerID());
            System.out.println("CategoryID:"+ticket.getCategoryID());
            System.out.println("Status:"+ticket.getStatus());
            System.out.println("Priority Level:"+ticket.getPriorityLevel());
            System.out.println("Issue:"+ticket.getDescriptionOfIsuue());
            System.out.println("Additional Comments:"+ticket.getAdditionalComments());
            System.out.printf("==================");




        }
      

      
    }

    @Override
    public void getTicketsOfStatus() {
        boolean validInput = false;
        while(!validInput){
        System.out.println("Enter the number of the status of the tickets you want to view based on the following:");
        for(TicketStatus status : TicketStatus.values()){
        System.out.println(status.name());
     }
     String userInput = scanner.next();
     for(TicketStatus status : TicketStatus.values()){
        if(status.name().equals(userInput)){
          validInput=true;
          break;
        }
    }
    if(!validInput){
        System.out.println("You entered an invalid option. Please trya again");
    }
         if(validInput){

        List<Ticket> result = ticketService.getTicketsOfStatus(TicketStatus.valueOf(userInput));
        if(!result.isEmpty()){
          
            for(Ticket ticket:result){
           System.out.println("AgentID:"+ticket.getAgentID());
            System.out.println("TicketNo:"+ticket.getTicketNo());
            System.out.println("CustomerNo:"+ticket.getCustomerID());
            System.out.println("CategoryID:"+ticket.getCategoryID());
            System.out.println("Status:"+ticket.getStatus());
            System.out.println("Priority Level:"+ticket.getPriorityLevel());
            System.out.println("Issue:"+ticket.getDescriptionOfIsuue());
            System.out.println("Additional Comments:"+ticket.getAdditionalComments());
            System.out.printf("==================");
            }
            

        }
        else{
            System.out.println("There are no tickets with that status");
            System.out.printf("==================");
        }
    }
}
      

              
    }

    

        
    

    @Override
    public void updateTicket() {
        System.out.println("Enter the ticket Number of the ticket to be updated:");
        String ticketNumber = scanner.next();
        List<Ticket> result = ticketService.getAllTickets();
        List<Ticket> update = new ArrayList<>();
        for(Ticket ticket:result){
         if(ticket.getTicketNo().equals(ticketNumber)){
             update.add(ticket);
           ticketService.updateTicket(ticket);
             
         }
     
        }
        if(update.isEmpty()){
          System.out.println("The ticket number entered does not exist");
          System.out.printf("==================");
        }
     
    }

    @Override
   public void deleteTicket() {
    System.out.println("Enter the ticket Number of the ticket to be deleted:");
    String ticketNumber = scanner.next(); 
    List<Ticket> result = ticketService.getAllTickets();
    List<Ticket> ticketsToDelete = new ArrayList<>();
 
   
    for(Ticket ticket:result){
     if(ticket.getTicketNo().equals(ticketNumber)){
      
    ticketsToDelete.add(ticket) ;
     }
 
    
 }
 
  if(ticketsToDelete.isEmpty()){
     System.out.println("The ticket does not exist");
  }
 else{
     for (Ticket ticket : ticketsToDelete) {
         int index = result.indexOf(ticket);
         ticketService.deleteTicket(index);
     }
 }
 
     }
 

   


}

