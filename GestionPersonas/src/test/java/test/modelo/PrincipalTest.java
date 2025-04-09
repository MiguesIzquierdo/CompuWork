package test.modelo;

import aplicacion.Principal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrincipalTest {

    @Test
    public void testMain() {
        try {
            Principal.main(new String[]{});
        } catch (Exception e) {
            fail("El método main lanzó una excepción: " + e.getMessage());
        }
    }
}
