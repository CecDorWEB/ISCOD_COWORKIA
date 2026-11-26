package com.iscod.coworkia.config;

import com.iscod.coworkia.services.ReservationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.iscod.coworkia.controllers.InternalUserController;
import com.iscod.coworkia.controllers.PostController;
import com.iscod.coworkia.controllers.ZoneController;
import com.iscod.coworkia.entities.InternalUser;
import com.iscod.coworkia.entities.Post;
import com.iscod.coworkia.entities.Reservation;
import com.iscod.coworkia.entities.Zone;
import com.iscod.coworkia.services.PostService;

@Component 
public class DataInitializer implements CommandLineRunner {

	private final ReservationService reservationService;

	@Autowired
    private PostService postService;
	
	@Autowired
	private ZoneController zoneController;
	
	@Autowired
	private PostController postController;
	
	@Autowired
	private InternalUserController userController;

	DataInitializer(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

    @Override
    public void run(String... args) {

    	//Création des postes par zone
    	List<Zone> zones = zoneController.getAll();
    	int [] nbPost = {20,20,15,15,10,10,5,5};
    	
        for (int i = 0; i < zones.size(); i++) {
        	
        	int nbPostAcréer = nbPost[i];
        			
        	for (int j=1; j<= nbPostAcréer ;j++) {
        		 Post post = new Post();
        		 
                 post.setCode(zones.get(i).getAcronyme()+'-'+ String.format("%02d", j));
                 post.setZone(zones.get(i));

                 postService.save(post);
        	}
        }
        
        //Création des réservations par défaut
        List<Post> posts = postController.getAll();
        List<InternalUser> users = userController.getAll();
        
     // Réservation 1
        Reservation reservation1 = new Reservation();
        reservation1.setStartingDateTime(LocalDateTime.of(2026, 11, 26, 8, 0));
        reservation1.setEndingDateTime(LocalDateTime.of(2026, 11, 27, 18, 0));
        reservation1.setPost(posts.get(0));   
        reservation1.setUser(users.get(2));      
        reservationService.save(reservation1);

        // Réservation 2
        Reservation reservation2 = new Reservation();
        reservation2.setStartingDateTime(LocalDateTime.of(2026, 12, 15, 8, 0));
        reservation2.setEndingDateTime(LocalDateTime.of(2026, 12, 15, 18, 0));
        reservation2.setPost(posts.get(0));      
        reservation2.setUser(users.get(2));     
        reservationService.save(reservation2);

        // Réservation 3
        Reservation reservation3 = new Reservation();
        reservation3.setStartingDateTime(LocalDateTime.of(2026, 11, 26, 8, 0));
        reservation3.setEndingDateTime(LocalDateTime.of(2026, 11, 26, 18, 0));
        reservation3.setPost(posts.get(14));    
        reservation3.setUser(users.get(2));      
        reservationService.save(reservation3);

        // Réservation 4
        Reservation reservation4 = new Reservation();
        reservation4.setStartingDateTime(LocalDateTime.of(2027, 1, 8, 8, 0));
        reservation4.setEndingDateTime(LocalDateTime.of(2027, 1, 8, 18, 0));
        reservation4.setPost(posts.get(20));     
        reservation4.setUser(users.get(3));      
        reservationService.save(reservation4);

        // Réservation 5
        Reservation reservation5 = new Reservation();
        reservation5.setStartingDateTime(LocalDateTime.of(2026, 11, 30, 8, 0));
        reservation5.setEndingDateTime(LocalDateTime.of(2026, 12, 4, 18, 0));
        reservation5.setPost(posts.get(7));      
        reservation5.setUser(users.get(3));      
        reservationService.save(reservation5);
    }
}