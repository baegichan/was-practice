import org.example.Requestline;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {

    @Test
    void create(){
        Requestline requestline = new Requestline("GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1");
        assertThat(requestline).isNotNull();
        assertThat(requestline).isEqualTo(new Requestline("GET", "/calculate","operand1=11&operator=*&operand2=55"));
    }





}
