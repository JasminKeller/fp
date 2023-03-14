package ch.hftm.fp.location.model;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Locality {
    
    private String uuid;
    private String plz;
    private String location;

    public String getPLZLocationName(){
        return plz + " / " + location;
    }


    
}
