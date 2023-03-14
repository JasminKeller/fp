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
                Person person = readPerson( file );

                if( person != null )
                {
                    persons.add(person);
                }
            }
        }

        return persons;
    }

    public Person getPerson( String uuid )
    {
        File file = new File("data/person" + uuid + ".json");

        return readPerson(file);
    }

    private Person readPerson(File file)
    {
        Person person = null;

        if( file.isFile() ) {
            try {
                String personJson = Files.readString(Path.of(file.getPath()));
                person = new ObjectMapper().readValue(personJson, Person.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return person;
    }

    public void savePerson( Person person )
    {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            UUID uuid = UUID.randomUUID();

            person.setUuid( uuid.toString() );

            mapper.writeValue( new File( "data/person" + uuid + ".json" ), person );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean deletePerson( String uuid )
    {
        File personFile = new File( "data/person" + uuid + ".json" );

        if( personFile.exists() )
        {
            return personFile.delete();
        }

        return false;
    }
}
