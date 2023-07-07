
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
     
    }

    @Override
    public void deleteTicket(int index) {
        
       } 
    }
