import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
//import static org.junit.Assert.*;
//import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {
    private static Model model;
    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;
    private static int nrTest = 0;


    @BeforeAll
    static void setUpBeforeAll(){
        model = new Model();
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("S-au executate " + nrTesteExecutate +" teste din care " + nrTesteCuSucces + " au avut avut succes");
    }

    @BeforeEach
    void setUp(){
        nrTesteExecutate++;
    }
    @AfterEach
    public void tearDown() {
        System.out.println("S-a terminat testul "+ nrTest+ " !");
        nrTest++;
    }
    @ParameterizedTest
    @MethodSource("provideInput1")
    void testAdd(String P, String Q, String expectedResult) {
        assertEquals(expectedResult, model.getResult(P,Q,"Add"));
        nrTesteCuSucces++;
    }

    @ParameterizedTest
    @MethodSource("provideInput2")
    void subtract(String P, String Q, String expectedResult) {
        assertEquals(expectedResult, model.getResult(P,Q,"Subtract"));
        nrTesteCuSucces++;
    }

    @ParameterizedTest
    @MethodSource("provideInput3")
    void multiply(String P, String Q, String expectedResult) {
        assertEquals(expectedResult, model.getResult(P,Q,"Multiply"));
        nrTesteCuSucces++;
    }
    @ParameterizedTest
    @MethodSource("provideInput4")
    void derivate(String P, String Q, String expectedResult) {
        assertEquals(expectedResult, model.getResult(P,Q,"Derive"));
        nrTesteCuSucces++;
    }

    @ParameterizedTest
    @MethodSource("provideInput5")
    void integrate(String P, String Q, String expectedResult) {
        assertEquals(expectedResult, model.getResult(P,Q,"Integrate"));
        nrTesteCuSucces++;
    }

    @ParameterizedTest
    @MethodSource("provideInput6")
    void division(String P, String Q, String expectedResult) {
        assertEquals(expectedResult, model.getResult(P,Q,"Divide"));
        nrTesteCuSucces++;
    }

    private static List<Arguments> provideInput1(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("X","-X",""));
        argumentsList.add(Arguments.of("X^2+4X+2","X^10+5","+X^10+X^2+4.0*X^1+7.0"));
        argumentsList.add(Arguments.of("X^4+4X+9.56","X^4-4X","+2.0*X^4+9.56"));
        return argumentsList;
    }

    private static List<Arguments> provideInput2(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("X^3","X","+X^3-1.0*X^1"));
        argumentsList.add(Arguments.of("1","X","-1.0*X^1+1.0"));
        argumentsList.add(Arguments.of("X^4+4X","X^4-4X","+8.0*X^1"));
        return argumentsList;
    }

    private static List<Arguments> provideInput3(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("3.5X","X","+3.5*X^2"));
        argumentsList.add(Arguments.of("X^2+4X+2","X^10+5","+X^12+4.0*X^11+2.0*X^10+5.0*X^2+20.0*X^1+10.0"));
        argumentsList.add(Arguments.of("X^4+4X","1","+X^4+4.0*X^1"));
        return argumentsList;
    }
    private static List<Arguments> provideInput4(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("X","","+1.0"));
        argumentsList.add(Arguments.of("X^2+4X+2","","+2.0*X^1+4.0"));
        argumentsList.add(Arguments.of("X^10-X^7+5.43X","","+10.0*X^9-7.0*X^6+5.43"));
        return argumentsList;
    }

    private static List<Arguments> provideInput5(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("X","","+0.5*X^2"));
        argumentsList.add(Arguments.of("X^2+4X+2","","+0.3333333333333333*X^3+2.0*X^2+2.0*X^1"));
        argumentsList.add(Arguments.of("10","","+10.0*X^1"));
        return argumentsList;
    }

    private static List<Arguments> provideInput6(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("X^3-2X^2+6X-5","X^2-1","+X-2.0  Rest: +7.0*X^1-7.0"));
        argumentsList.add(Arguments.of("X^2+4X+2","X^1+3","+X+1.0  Rest: -1.0"));
        argumentsList.add(Arguments.of("X^2+X^4+4X","X^5-3","  Rest: +X^5-3.0"));
        return argumentsList;
    }




}