import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class KendaraanTest {

    @BeforeAll
    static void setupClass() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    void setupMethod() {
        System.out.println("Before each test");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all tests");
    }

    @Order(1)
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void testJumlahRoda(int jumlahRoda) {
        Kendaraan kendaraan = new Kendaraan("Mobil", "Bensin", jumlahRoda);
        assertTrue(kendaraan.getJumlahRoda() % 2 == 0);
    }

    @Order(2)
    @ParameterizedTest
    @CsvSource({
            "Mobil, Bensin, 4, false",
            "Motor, Listrik, 2, true",
            "Bus, Diesel, 6, false",
            "Sepeda, -, 2, true",
            "Mobil, Listrik, 4, true"
    })
    void testRamahLingkungan(String jenis, String bahanBakar, int jumlahRoda, boolean expected) {
        Kendaraan kendaraan = new Kendaraan(jenis, bahanBakar, jumlahRoda);
        assertEquals(expected, kendaraan.isRamahLingkungan());
    }

    enum JenisKendaraan {
        SEPEDA, MOBIL, MOTOR, BUS, TRUK
    }

    //    @Order(3)
    @ParameterizedTest
    @EnumSource(JenisKendaraan.class)
    void testJenisKendaraan(JenisKendaraan jenis) {
        assertNotNull(jenis);
    }

    static Stream<Arguments> provideKendaraanData() {
        return Stream.of(
                Arguments.of(new Kendaraan("Mobil", "Bensin", 4), 4),
                Arguments.of(new Kendaraan("Motor", "Listrik", 2), 2),
                Arguments.of(new Kendaraan("Truk", "Solar", 6), 6)
        );
    }

    //    @Order(4)
    @ParameterizedTest
    @MethodSource("provideKendaraanData")
    void testKendaraanCustom(Kendaraan kendaraan, int expectedRoda) {
        assertEquals(expectedRoda, kendaraan.getJumlahRoda());
    }

    //    @Order(5)
    @ParameterizedTest
    @CsvSource({
            "Sepeda, -, 2, true",
            "Sepeda, -, 3, false",
            "Mobil, Bensin, 4, false"
    })
    void testIsSepeda(String jenis, String bahanBakar, int jumlahRoda, boolean expected) {
        Kendaraan kendaraan = new Kendaraan(jenis, bahanBakar, jumlahRoda);
        assertEquals(expected, kendaraan.isSepeda());
    }

    @Test
//    @Order(6)
    void testGetJenis() {
        Kendaraan kendaraan = new Kendaraan("Motor", "Bensin", 2);
        assertEquals("Motor", kendaraan.getJenis());
    }

    @Test
//    @Order(7)
    void testGetBahanBakar() {
        Kendaraan kendaraan = new Kendaraan("Mobil", "Diesel", 4);
        assertEquals("Diesel", kendaraan.getBahanBakar());
    }

    @Order(8)
    @ParameterizedTest
    @CsvSource({
            "Mobil, Bensin, 4, true",
            "Motor, Listrik, 2, true",
            "Bus, Diesel, 6, true",
            "Sepeda, -, 2, false"
    })
    void testIsBermotor(String jenis, String bahanBakar, int jumlahRoda, boolean expected) {
        Kendaraan kendaraan = new Kendaraan(jenis, bahanBakar, jumlahRoda);
        assertEquals(expected, kendaraan.isBermotor());
    }

    //    @Order(9)
    @ParameterizedTest
    @CsvSource({
            "Mobil, Bensin, 4, false",
            "Motor, Listrik, 2, false",
            "Bus, Diesel, 6, true",
            "Sepeda, -, 2, false",
            "Angkot, Bensin, 4, true",
            "Kereta, Listrik, 8, true"
    })
    void testIsTransportasiUmum(String jenis, String bahanBakar, int jumlahRoda, boolean expected) {
        Kendaraan kendaraan = new Kendaraan(jenis, bahanBakar, jumlahRoda);
        assertEquals(expected, kendaraan.isTransportasiUmum());
    }

    @Test
//    @Order(10)
    void testComplete() {
        Kendaraan kendaraan = new Kendaraan("Mobil", "Bensin", 4);

        assertAll(
                () -> assertEquals("Mobil", kendaraan.getJenis()),
                () -> assertEquals("Bensin", kendaraan.getBahanBakar()),
                () -> assertEquals(4, kendaraan.getJumlahRoda()),
                () -> assertFalse(kendaraan.isRamahLingkungan())
        );
    }
}
