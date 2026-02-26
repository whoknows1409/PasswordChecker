import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordCheckerTest {

    @Test
    void testWeakPassword(){
        assertEquals("WEAK", PasswordChecker.checkStrength("abc"));
    }

    @Test
    void testStrongPassword(){
        assertEquals("STRONG", PasswordChecker.checkStrength("Abc@1234"));
    }
}
