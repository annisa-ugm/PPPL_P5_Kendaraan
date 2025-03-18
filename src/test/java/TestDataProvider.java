import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class TestDataProvider {
    static Stream<Arguments> provideAdditionData(){
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 3, 5),
                Arguments.of(10, 20, 30)
        );
    }
}