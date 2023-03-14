package ch.hftm.fp.location.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Locality {
    
    private String uuid;
    private String plz;
    private String location;


    
}
