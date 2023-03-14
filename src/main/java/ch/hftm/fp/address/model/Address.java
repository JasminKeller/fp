package ch.hftm.fp.address.model;
import ch.hftm.fp.location.model.Locality;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address
{
    private String uuid;
    private String street;
    private Locality locality;
}


