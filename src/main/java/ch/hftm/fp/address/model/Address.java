package ch.hftm.fp.address.model;
import ch.hftm.fp.location.model.Locality;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Address
{
    private String uuid;
    private String street;
    private List<Locality> localities;
}


