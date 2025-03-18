import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class KalkulatorTest {
    @Order(1)
    @ParameterizedTest
    @MethodSource("TestDataProvider#provideAdditionData")
    void testAdditionData(int a, int b, int expected){
        Kalkulator calc = new Kalkulator();
        assertEquals(expected, calc.add(a, b));
    }

    static List<String> provideArrayArguments(){
        List<String> lists = new ArrayList<>();
        lists.add("abc");
        lists.add("dfg");
        lists.add("rgh");

        return lists;
    }

    static Stream<List<String>> provideArrayData(){
        return Stream.of(
                Arrays.asList("abc", "def", "ghj"),
                Arrays.asList("wje", "awo", "euo")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArrayArguments")


    @BeforeAll
    static void setupClass(){
        System.out.println("before all");
    }
    @BeforeEach
    void setupMethod(){
        System.out.println("before Each");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }
    @AfterEach
    void afterEach(){
        System.out.println("after each");
    }

    @Test
    void testTambah() {
        Kalkulator calc = new Kalkulator(5, 10);
        Assertions.assertEquals(15, calc.tambah(),
                "tidak sama");
    }

    @Test
    void testKurang() {
        Kalkulator calc = new Kalkulator(8, 4);
        Assertions.assertEquals(4, calc.kurang(),
                "tidak sama");
    }

    @Test
    void testBagi() {
        Kalkulator calc = new Kalkulator(8, 4);
        Assertions.assertEquals(2, calc.bagi());
    }

    @Test
    void testKali() {
        Kalkulator calc = new Kalkulator(3, 5);
        Assertions.assertEquals(15, calc.kali());
    }

    @Test
    void testComplete(){
        Kalkulator calc = new Kalkulator(5, 10);
        assertAll(
                ()->assertEquals(5, calc.a),
                ()->assertEquals(10, calc.b),
                ()->assertEquals(15, calc.tambah())
        );
    }

    @Test
    void testAdd(){
        Kalkulator calc = new Kalkulator();
        assertEquals(5, calc.add(2, 3));
        assertEquals(25, calc.add(10, 15));
        assertEquals(10, calc.add(5, 5));
    }


    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5",
            "-1, 0, -1",
            "10, 20, 30"
    })
    void testAddition(int a, int b, int expected){
        Kalkulator calc = new Kalkulator();
        assertEquals(expected, calc.add(a, b));
    }


    @ParameterizedTest
    @ValueSource(ints = {2, 4, 5, 7, 8, 13})
    void testEven(int num){
        Kalkulator calc = new Kalkulator();
        assertTrue(calc.isEven(num));
    }

    @Order(2 )
    @ParameterizedTest
    @ValueSource(strings = {"abc", "cde", "agh"})
    void testContainsA(String word){
        Kalkulator calc = new Kalkulator();
        assertTrue(calc.containsA(word));
    }


}