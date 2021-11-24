package gmail.salokin1991;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;

public class StaticTestData {

    public static final String CREATED = "Created";
    public static final String NO_CONTENT = "No Content";
    public static final String MOVED = "Moved";

    public static final SelenideElement RESPONSE = $("#linkResponse");

    public static final String COMMON_EXPECTED_VALUE = "Link has responded with staus";
    public static final String TEXT_CREATED = "Link has responded with staus 201 and status text Created";
    public static final String TEXT_NO_CONTENT = "Link has responded with staus 204 and status text No Content";
    public static final String TEXT_MOVED = "Link has responded with staus 301 and status text Moved Permanently";

}
