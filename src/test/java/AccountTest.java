import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.Account;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String nameTest;
    private final boolean expected;

    public AccountTest(String name, boolean expected) {
        this.nameTest = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] CreateAccountTest() {
        return new Object[][] {

                {"Alexey Rumyantsev", true},
                {"Алексей Румянцев", true},
                {"A L", true},
                {"Alexey Rumyantsev12", true},
                {"AlexeyAlexey RumuantsevRumyantsev", false},
                {" Alexey Rumyantsev", false},
                {"Alexey Rumyantsev ", false},
                {"AlexeyRumyantsev", false},
                {"Алексей Иванович Румянцев", false},
                {"ДваждыАлексейИвановичРумянцевПерерумянцев", false},
                {"A", false},
                {"", false},
                {"Al", false}
        };
    }

    @Test
    @DisplayName("Проверка имени")
    @Description("Проверям подходит ли введенное имя под все условия")
    public void createAccount() {
        Account account = new Account(nameTest);
        boolean actual = account.checkNameToEmboss();
        assertEquals("Данные не совпадают", expected, actual);
    }
}
