package ch.hftm.fp.person;

import ch.hftm.fp.person.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonService
{
    public List<Person> getPersons()
    {
        List<Person> persons = new ArrayList<>();

        File dir = new File("data/");

        if( dir.isDirectory() && dir.listFiles() != null )
        {
            for( File file : dir.listFiles() )
            {
                try
                {
                    if ( file.isFile() )
                    {
                        String personJson = Files.readString( Path.of( file.getPath() ) );
                        Person personData = new ObjectMapper().readValue( personJson, Person.class );

                        persons.add( personData );
                    }
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
            }
        }

        return persons;
    }

    public Person getPerson( String uuid )
    {

        return null;
    }

    public void savePerson( Person person )
    {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            UUID uuid = UUID.randomUUID();

            person.setUuid( uuid.toString() );

            mapper.writeValue( new File( "data/person" + uuid + " .json" ), person );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean deletePerson()
    {
        return false;
    }
}
