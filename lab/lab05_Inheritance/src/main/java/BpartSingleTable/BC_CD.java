package BpartSingleTable;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class BC_CD extends BC_Product {
    private String artist;

    public BC_CD(String name, String artist) {
        super(name);
        this.artist = artist;
    }
}
