package BpartSingleTable;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class BC_DVD extends BC_Product {
    private String genre;

    public BC_DVD(String name, String genre) {
        super(name);
        this.genre = genre;
    }
}
