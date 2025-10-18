
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setup() {
        // Definindo data de nascimento: 2000-01-01
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.JANUARY, 1);
        Date birthDate = cal.getTime();

        person = new Person(
                "Paul",
                "McCartney",
                birthDate,
                true,  // anotherCompanyOwner
                true,  // pensioner
                true,  // publicServer
                0      // salary inicial
        );
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200f);
        assertEquals(14400f, person.calculateYearlySalary(), 0.001);
    }

    @Test
    public void person_is_MEI() {
        // Alterando dados para atender critérios de MEI
        person.setSalary(1000f);
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);

        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        // Dados iniciais do setup já violam critérios de MEI
        person.setSalary(20000f); // salário alto
        person.setAnotherCompanyOwner(true);
        person.setPensioner(true);
        person.setPublicServer(true);

        assertFalse(person.isMEI());
    }
}
