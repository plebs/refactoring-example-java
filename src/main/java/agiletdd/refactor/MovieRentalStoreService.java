package agiletdd.refactor;

import java.util.ArrayList;
import java.util.List;

public class MovieRentalStoreService {

    public RentalTicket rentMovies(Customer auxCus, List<String> mo, int d) {
        RentalTicket auxti = new RentalTicket();
        int auxTotal = 0;
        int auxBonus = 0;
        List<String> auxMovies = new ArrayList<>();

        int extra = 0;
        System.out.println("paso 1");
        for (int i = 0; i < auxCus.getMovies().size(); i++) {
            extra += 15;
        }

        System.out.println("paso 2");
        // Suma el precio de cada pelicula multiplicado por los dias
        // y lo suma al precio total
        if (auxCus.getPremium() == 0) {
            System.out.println("el usuario es No es premium");
            // Si el cliente no es premium no se aplica descuento
            for (int i = 0; i < mo.size(); i++) {
                System.out.println("paso 3.1: " + i);

                if (mo.get(i) == "Titanic") {
                    auxTotal += 10 * d;   // el precio de las peliculas normales es de 10 al dia.
                } else if (mo.get(i) == "Gladiator") {
                    auxTotal += 10 * d;
                } else if (mo.get(i) == "La La Land") {
                    auxTotal += 20 * d; // el precio de las peliculas nuevas es de 20 al dia.
                } else if (mo.get(i) == "Moonlight") {
                    auxTotal += 20 * d;
                } else if (mo.get(i) == "Frozen") {
                    auxTotal += 5 * d; // el precio de las peliculas para niños es de 5 al dia.
                } else if (mo.get(i) == "Toy Story") {
                    auxTotal += 5 * d;
                }
                System.out.println("paso 3.1: " + auxTotal + ", " + auxBonus);
            }
        } else {
            System.out.println("el usuario es si es premium");
            // Si el cliente SI es premium  se aplica descuento y se le da bonus
            for (int i = 0; i < mo.size(); i++) {

                if (mo.get(i) == "Titanic") {
                    auxTotal += 8 * d;   // 2€ de descuento si es premium en peliculas normales
                    auxBonus += 1;
                } else if (mo.get(i) == "Gladiator") {
                    auxTotal += 8 * d;
                    auxBonus += 1;
                } else if (mo.get(i) == "La La Land") {
                    auxTotal += 15 * d; // 5€ de descuento si es premium en peliculas nuevas
                    auxBonus += 5;
                } else if (mo.get(i) == "Moonlight") {
                    auxTotal += 15 * d;
                    auxBonus += 5;
                } else if (mo.get(i) == "Frozen") {
                    auxTotal += 4 * d; // 5€ de descuento si es premium en peliculas para niños
                    auxBonus += 2;
                } else if (mo.get(i) == "Toy Story") {
                    auxTotal += 4 * d;
                    auxBonus += 5;
                }
                System.out.println("paso 3.2: " + auxTotal + ", " + auxBonus);
            }
        }

        // Añado un extra si el cliente tenia peliculas sin devolver y le quito el bonus si es premium
        auxTotal += extra;
        if (auxCus.getPremium() == 1) {
            System.out.println("le quito el bonus");
            auxBonus = 0;
        }

        // defino el cliente
        auxti.setCustomer(auxCus);
        // defino las peliculas
        auxti.setMovies(mo);
        // defino el precio total
        int auxTotal2 = auxBonus + auxCus.getTotal();
        auxti.setTotal(auxTotal);
        // defino el bonus total del cliente
        int auxBonus2 = auxBonus + auxCus.getBonus();
        auxCus.setBonus(auxBonus);
        // defino las peliculas del cliente
        for (int i = 0; i < mo.size(); i++) {
            auxCus.getMovies().add(mo.get(i));
        }

        return auxti;
    }

}
