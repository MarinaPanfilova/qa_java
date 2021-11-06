package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

//только LionTest будет с моками, но можно было бы так делать и в Cat
@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test(expected = Exception.class)
    public void lionSexHaveException() throws Exception {
        Lion lion = new Lion(" ", feline);
        lion.doesHaveMane();
    }

    @Test
    public void isLionHaveManeTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedHasMane = true;
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(expectedHasMane, actualHasMane);
    }

    @Test
    public void getLionDoNotHaveKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedGetKittens = 0;
        int actualGetKittens = lion.getKittens();
        assertEquals(expectedGetKittens, actualGetKittens);
    }

    @Test
    public void getLionEatMeat() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(lion.getFood()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedEatMeat = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualEatMeat = lion.getFood();
        assertEquals(expectedEatMeat, actualEatMeat);
    }
}