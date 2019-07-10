package BpartSingleTable;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class BC_Book extends BC_Product {
    private String title;

    public BC_Book(String name, String title) {
        super(name);
        this.title = title;
    }
}
