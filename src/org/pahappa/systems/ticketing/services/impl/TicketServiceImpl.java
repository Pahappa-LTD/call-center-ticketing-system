
package org.pahappa.systems.ticketing.services.impl;

import org.pahappa.systems.ticketing.services.TicketService;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.constants.PriorityLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketServiceImpl implements TicketService {
   List<Ticket> ticketList = new ArrayList<>();
    @Override
    public void createTicket(Ticket ticket) {
       

        ticketList.add(ticket);
      
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketList;
    }

    @Override
    public List<Ticket> getTicketsOfStatus(TicketStatus ticketStatus) {
    List <Ticket> result = new java.util.ArrayList<>();
    for(Ticket ticket : ticketList){
        if(ticket.getStatus().equals(ticketStatus.name())){
            result.add(ticket);
        }
    }
    if(result.isEmpty()){
        System.out.println("No tickets with that status");

    }
    
        return result;
    
    }

    @Override
    public void updateTicket(Ticket updatedTicket) {
        System.out.println("What would you like to update;status or priority level");
        Scanner input = new Scanner(System.in);
   
        String userInput = input.next();
        if(userInput.equals("status")){
           System.out.println("Enter status update based on the following:");
           for(TicketStatus status : TicketStatus.values()){
           System.out.println(status.name());
        }
           updatedTicket.setStatus(input.next());
        }
        
        else{
           System.out.println("Enter prority Level update based on the following:");
            for(PriorityLevel priority : PriorityLevel.values()){
           System.out.println(priority.name());
        }
           updatedTicket.setPriorityLevel(input.next());
        }
        System.out.println("The ticket has been updated");
        System.out.printf("==================");
   
    }

    @Override
    public void deleteTicket(int index) {
        ticketList.remove(index);
        System.out.println("The ticket has been deleted");
        System.out.printf("==================");
       } 

       } 
    
