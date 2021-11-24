package gmail.salokin1991;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static gmail.salokin1991.StaticTestData.*;

@DisplayName("DemoQA link tests")
public class ParamTests extends TestBase {

    @Disabled
    @DisplayName("Click link Created, than check text")
    @Tag("BLOCKER")
    @Test
    void clickCreatedTest() {
        $(byText(CREATED)).click();
        RESPONSE.shouldHave(Condition.text(TEXT_CREATED));
    }

    @Disabled
    @ValueSource(strings = {CREATED, NO_CONTENT, MOVED})
    @Tag("BLOCKER")
    @ParameterizedTest(name = "Click link {0}, than check text")
    void commonResponseValueTest(String linkName) {
        $(byText(linkName)).click();
        RESPONSE.shouldHave(Condition.text(COMMON_EXPECTED_VALUE));
    }

    @Disabled
    @CsvSource(value = {
            CREATED + "|" + TEXT_CREATED,
            NO_CONTENT + "|" + TEXT_NO_CONTENT,
            MOVED + "|" + TEXT_MOVED
    },
            delimiter = '|')
    @Tag("BLOCKER")
    @ParameterizedTest(name = "Click link {0}, than check response text {1}")
    void csvStringValuesTest(String linkName, String expectedResult) {
        $(byText(linkName)).click();
        RESPONSE.shouldHave(Condition.text(expectedResult));
    }


    static Stream<Arguments> methodSourceValues() {
        return Stream.of(
                Arguments.of(CREATED, Arrays.asList(TEXT_CREATED)),
                Arguments.of(NO_CONTENT, Arrays.asList(TEXT_NO_CONTENT)),
                Arguments.of(MOVED, Arrays.asList(TEXT_MOVED))
        );
    }

    @Disabled
    @MethodSource("methodSourceValues") // или оставить пустым при совпадении названий "methodSourceValuesTest"
    @Tag("BLOCKER")
    @ParameterizedTest(name = "Click link {0}, than check response text {1}")
    void methodSourceValuesTest(String linkName, List<String> expectedResult) {
        $(byText(linkName)).click();
        RESPONSE.shouldHave(Condition.text(expectedResult.get(0)));
    }


    @EnumSource(SimpleEnumData.class)
    @Tag("BLOCKER")
    @ParameterizedTest(name = "Click link {0}, than check text")
    void enumValuesTest(SimpleEnumData linkName) {

        $(byText(linkName.name().toUpperCase().substring(0, 1) + linkName.name().toLowerCase().substring(1)))
                .scrollTo().click();
        RESPONSE.shouldHave(Condition.text(COMMON_EXPECTED_VALUE));
    }
}
