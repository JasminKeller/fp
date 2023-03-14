package ch.hftm.fp.location;

import ch.hftm.fp.location.model.Locality;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.UUID;

public class LocalityService {
    

    public List<Locality> getLocalities()
    {
        List<Locality> localities = new ArrayList<>();

        File dir = new File("data/localities/");

        if( dir.isDirectory() && dir.listFiles() != null )
        {
            for( File file : dir.listFiles() )
            {
                Locality locality = readLocality( file );

                if( locality != null )
                {
                    localities.add(locality);
                }
            }
        }

        return localities;
    }


    public Locality getLocality( String uuid )
    {
        File file = new File("data/localities/locality" + uuid + ".json");

        return readLocality(file);
    }


    private Locality readLocality(File file)
    {
        Locality locality = null;

        if( file.isFile() ) {
            try {
                String localityJson = Files.readString(Path.of(file.getPath()));
                locality = new ObjectMapper().readValue(localityJson, Locality.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return locality;
    }

    public void saveLocality( Locality locality )
    {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            UUID uuid = UUID.randomUUID();

            locality.setUuid( uuid.toString() );

            mapper.writeValue( new File( "data/localities/locality" + uuid + " .json" ), locality );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean deleteLocality( String uuid )
    {
        File localityFile = new File( "data/localities/locality" + uuid + ".json" );

        if( localityFile.exists() )
        {
            return localityFile.delete();
        }

        return false;
    }
}
