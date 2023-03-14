package ch.hftm.fp.address;

import ch.hftm.fp.address.model.Address;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AddressService {
    public List<Address> getAddresses()
    {
        List<Address> addresses = new ArrayList<>();

        File dir = new File("data/");

        if( dir.isDirectory() && dir.listFiles() != null )
        {
            for( File file : dir.listFiles() )
            {
                Address address = readAddress( file );

                if( address != null )
                {
                    addresses.add(address);
                }
            }
        }

        return addresses;
    }

    public Address getAddress( String uuid )
    {
        File file = new File("data/address" + uuid + ".json");

        return readAddress(file);
    }

    private Address readAddress(File file)
    {
        Address address = null;

        if( file.isFile() ) {
            try {
                String addressJson = Files.readString(Path.of(file.getPath()));
                address = new ObjectMapper().readValue(addressJson, Address.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return address;
    }

    public void saveAddress( Address address )
    {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            UUID uuid = UUID.randomUUID();

            address.setUuid( uuid.toString() );

            mapper.writeValue( new File( "data/address" + uuid + " .json" ), address );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean deleteAddress(String uuid)
    {
        File addressFile = new File( "data/address" + uuid + ".json" );

        if( addressFile.exists() )
        {
            return addressFile.delete();
        }

        return false;
    }
}
