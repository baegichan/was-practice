import org.example.QueryStrings;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {
    @Test
    void createTest(){
        QueryStrings queryString = new QueryStrings("/calculate?operand1=11&operator=*&operand2=55");
        assertThat(queryString).isNotNull();
    }

}
